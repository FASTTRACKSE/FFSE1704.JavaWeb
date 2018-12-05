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
import org.springframework.web.servlet.ModelAndView;

import fasttrackse.ffse1704.fbms.dao.quanlynhansu.ExcelBuilder;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.NhanSu;
import fasttrackse.ffse1704.fbms.entity.security.PhongBan;
import fasttrackse.ffse1704.fbms.service.quanlynhansu.XemThongTinNVService;

@Controller
public class XemThongTinNVController {
	@Autowired
	XemThongTinNVService xemThongTinNVService;

	public void setXemThongTinNVService(XemThongTinNVService xemThongTinNVService) {
		this.xemThongTinNVService = xemThongTinNVService;
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
	public String listThongTin(@PathVariable("maPhongBan") String maPhongBan, Model model) {
		model.addAttribute("listThongTin", xemThongTinNVService.findByPhongBan(maPhongBan));
		return "QuanTriNhanSu/xemThongTinHoSo/dsnhanvien";
	}

	@RequestMapping(value = "/thongTinNhanVien/{maNhanVien}", method = RequestMethod.GET)
	public String thongTinNhanVien(@PathVariable("maNhanVien") String maNhanVien, Model model) {
		model.addAttribute("thongTinNhanVien", xemThongTinNVService.findByMaNhanVien(maNhanVien));
		return "QuanTriNhanSu/xemThongTinHoSo/listthongtin";
	}
	
}
