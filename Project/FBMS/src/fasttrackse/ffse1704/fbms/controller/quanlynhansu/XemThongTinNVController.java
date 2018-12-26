package fasttrackse.ffse1704.fbms.controller.quanlynhansu;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import fasttrackse.ffse1704.fbms.dao.quanlynhansu.ExcelBuilder;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.DanhSachCongViec;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.DanhSachNgayNghi;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.NhanSu;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.QuanHuyen;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.XaPhuong;
import fasttrackse.ffse1704.fbms.entity.security.PhongBan;
import fasttrackse.ffse1704.fbms.service.quanlynhansu.HopDongService;
import fasttrackse.ffse1704.fbms.service.quanlynhansu.XemThongTinNVService;

@Controller
public class XemThongTinNVController {
	@Autowired
	XemThongTinNVService xemThongTinNVService;

	public void setXemThongTinNVService(XemThongTinNVService xemThongTinNVService) {
		this.xemThongTinNVService = xemThongTinNVService;
	}
	
	@Autowired
	HopDongService hopDongService;

	public HopDongService getHopDongService() {
		return hopDongService;
	}

	public void setHopDongService(HopDongService hopDongService) {
		this.hopDongService = hopDongService;
	}

//	@RequestMapping("/dsphongban")
//	public String ShowPhongBan(Model model) {
//
//		List<PhongBan> allPhongBan = xemThongTinNVService.listPhongBan();
//		model.addAttribute("phongban", allPhongBan);
//		return "QuanTriNhanSu/xemThongTinHoSo/dsphongban";
//
//	}
	@RequestMapping("/dsphongban")
	public ModelAndView ShowPhongBan(HttpServletRequest req, HttpServletResponse res){
		String typeReport = req.getParameter("type");
		List<PhongBan> allPhongBan = xemThongTinNVService.listPhongBan();
		if(typeReport != null && typeReport.equals("xls")){
			   return new ModelAndView(new ExcelBuilder(), "userList", allPhongBan);
			  } else if(typeReport != null && typeReport.equals("pdf")){
				  return new ModelAndView(new ExcelBuilder(), "userList", allPhongBan);
			  }
		return new ModelAndView("QuanTriNhanSu/xemThongTinHoSo/dsphongban", "phongban", allPhongBan);
	}
	
	

	@RequestMapping(value = "/listThongTin/{maPhongBan}", method = RequestMethod.GET)
	public String listNhanVienofPhongBan(@PathVariable("maPhongBan") String maPhongBan, Model model, @RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
		int totalRecords = xemThongTinNVService.findByPhongBan(maPhongBan).size();
		int recordsPerPage = 2;
		int totalPages = 0;
		if ((totalRecords / recordsPerPage) % 2 == 0) {
			totalPages = totalRecords / recordsPerPage;
		} else {
			totalPages = totalRecords / recordsPerPage + 1;
		}
		int startPosition = recordsPerPage * (currentPage - 1);
		
		model.addAttribute("listThongTin", xemThongTinNVService.findAllForPaging(maPhongBan, startPosition, recordsPerPage));
		model.addAttribute("listPhongBan", xemThongTinNVService.findTenPhongBanByMaPhongBan(maPhongBan));
		model.addAttribute("lastPage", totalPages);
		model.addAttribute("currentPage", currentPage);
		return "QuanTriNhanSu/xemThongTinHoSo/dsnhanvien";
	}

	@RequestMapping(value = "/thongTinNhanVien/{maNhanVien}", method = RequestMethod.GET)
	public String thongTinNhanVien(@PathVariable("maNhanVien") String maNhanVien, Model model) {
		model.addAttribute("thongTinNhanVien", xemThongTinNVService.findByMaNhanVien(maNhanVien));
		return "QuanTriNhanSu/xemThongTinHoSo/listthongtin";
	}
	
	@RequestMapping(value = "/excelfile/{maNhanVien}", method = RequestMethod.GET)
	public ModelAndView exportExcelFile(@PathVariable("maNhanVien") String maNhanVien) {
		ModelAndView model = new ModelAndView("ExcelBuilder");
		model.addObject("thongTinNhanVien", xemThongTinNVService.findByMaNhanVien(maNhanVien));
		return model;
	}
	
	@RequestMapping(value = "/thongTinHopDong/{maNhanVien}", method = RequestMethod.GET)
	public String thongTinHopDong(@PathVariable("maNhanVien") String maNhanVien, Model model) {
		model.addAttribute("thongTinNhanVien", xemThongTinNVService.findByMaNhanVien(maNhanVien));
		return "QuanTriNhanSu/xemThongTinHoSo/listthongtinHopDong";
	}
	
	@RequestMapping(value = "/thongTinChiTietHopDong/{maNhanVien}&{id}", method = RequestMethod.GET)
	public String thongTinChiTietHopDong(@PathVariable("maNhanVien") String maNhanVien,@PathVariable("id") int id, Model model) {
		model.addAttribute("thongTinNhanVien", xemThongTinNVService.findByMaNhanVien(maNhanVien));
		model.addAttribute("ngaynghiconlai", hopDongService.findNgayNghiConLaibyMaNV(maNhanVien));
		List<DanhSachNgayNghi> listDSNN = hopDongService.listDanhSachNgayNghi();
		model.addAttribute("dsnn", listDSNN);
		model.addAttribute("hopDong", hopDongService.findById(id));
		return "QuanTriNhanSu/xemThongTinHoSo/chitietHopDong";
	}
	
	@RequestMapping(value = "/thongTinKinhNghiem/{maNhanVien}", method = RequestMethod.GET)
	public String thongTingKinhNghiem(@PathVariable("maNhanVien") String maNhanVien, Model model) {
		model.addAttribute("thongTinNhanVien", xemThongTinNVService.findByMaNhanVien(maNhanVien));
		return "QuanTriNhanSu/xemThongTinHoSo/listthongtinKinhNghiem";
	}
	
	
	@RequestMapping(value= "selectQuanHuyen/{matp}", method= RequestMethod.GET, produces= "text/plain;charset=UTF-8")
	@ResponseBody //return ko tra ve trang jsp ma tra ve trang html
	public String selectQuan(@PathVariable("matp") String maThanhPho, HttpServletResponse res) {
		List<QuanHuyen> listQuanHuyen =  xemThongTinNVService.findQuanHuyenByIdThanhPho(maThanhPho);
		
		String json = "[";
		
		for(int i =0; i < listQuanHuyen.size(); i++) {
			
			if (i == listQuanHuyen.size() - 1) {
				json += "{\"maQuanHuyen\":" + "\"" + listQuanHuyen.get(i).getMaqh() + "\"" + ", \"tenQuanHuyen\" :" + "\"" + listQuanHuyen.get(i).getName() + "\"" + "}";
			} else {
				json += "{\"maQuanHuyen\":" + "\"" + listQuanHuyen.get(i).getMaqh() + "\"" + ", \"tenQuanHuyen\" :" + "\"" + listQuanHuyen.get(i).getName() + "\"" + "},";
			}
		}
		json += "]";
				
		return json;
		
	}
	
	@RequestMapping(value= "selectXaPhuong/{maqh}", method= RequestMethod.GET, produces= "text/plain;charset=UTF-8")
	@ResponseBody 
	public String selectXaPhuong(@PathVariable("maqh") String maQuanHuyen) {
		List<XaPhuong> listXaPhuong =  xemThongTinNVService.findXaPhuongByIdQuanHuyen(maQuanHuyen);
		
		String json = "[";
		
		for(int i =0; i < listXaPhuong.size(); i++) {
			
			if (i == listXaPhuong.size() - 1) {
				json += "{\"maXaPhuong\":" + "\"" + listXaPhuong.get(i).getXaid() + "\"" + ", \"tenXaPhuong\" :" + "\"" + listXaPhuong.get(i).getName() + "\"" + "}";
			} else {
				json += "{\"maXaPhuong\":" + "\"" + listXaPhuong.get(i).getXaid() + "\"" + ", \"tenXaPhuong\" :" + "\"" + listXaPhuong.get(i).getName() + "\"" + "},";
			}
		}
		json += "]";
		
		return json;
		
	}
	
	
}
