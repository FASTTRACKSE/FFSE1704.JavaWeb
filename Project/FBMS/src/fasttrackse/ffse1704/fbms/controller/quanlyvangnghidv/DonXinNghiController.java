package fasttrackse.ffse1704.fbms.controller.quanlyvangnghidv;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fasttrackse.ffse1704.fbms.entity.quanlyvangnghidv.DonNghi;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghidv.LoaiNghi;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghidv.TinhTrangNghi;
import fasttrackse.ffse1704.fbms.entity.security.HoSoNhanVien;
import fasttrackse.ffse1704.fbms.entity.security.UserAccount;
import fasttrackse.ffse1704.fbms.service.quanlyvangnghidv.QuanLyVangNghiService;

@Controller
@RequestMapping("/QuanLyVangNghi")
public class DonXinNghiController {
	
	@Autowired
	private QuanLyVangNghiService service;
	
	public void setService(QuanLyVangNghiService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/donxinnghi", method = RequestMethod.GET)
	public String viewChucDanh(Model model, Authentication auth) {
		UserAccount user = service.getthongtinuser(auth.getName());
		HoSoNhanVien nhanVien = user.getNhanVien();
		model.addAttribute("nhanVien",nhanVien);
		TinhTrangNghi tinhTrangNghi = service.getTinhTrang(nhanVien.getMaNhanVien());
		model.addAttribute("tinhTrangNghi", tinhTrangNghi);
		List<LoaiNghi> arrLoaiNghi = new ArrayList<LoaiNghi>();
		arrLoaiNghi = service.listLoaiNghi();
		model.addAttribute("arrLoaiNghi", arrLoaiNghi);
		model.addAttribute("donNghi", new DonNghi());
		return "QuanLyVangNghi/donxinnghi";
	}
	
	@RequestMapping(value = "/savechoduyet", method =  RequestMethod.POST)
	public String saveSaveChoDuyet(Model model, @ModelAttribute("donnghi") DonNghi dn, @RequestParam int ngaydanghi,
			@RequestParam int ngayconlai) {
		dn.setTinhtrang(1);
		dn.getTgbatdau();
		TinhTrangNghi tt = new TinhTrangNghi();
		tt.setIdnv(dn.getIdnv());
		service.addDon(dn);
		int days = (int) ((dn.getTgketthuc().getTime() - dn.getTgbatdau().getTime())/(1000 * 60 *60 *24));
		if (ngaydanghi == 0) {
			tt.setIdnv(dn.getIdnv());
			tt.setNgaydanghi((ngaydanghi + days));
			tt.setNgayconlai((12 - days));
			service.insertUpdateTinhTrang(dn.getIdnv(), tt);
		}else {
			tt.setIdnv(dn.getIdnv());
			tt.setNgaydanghi((ngaydanghi + days));
			tt.setNgayconlai((ngayconlai - days));
			TinhTrangNghi ttCu = service.getTinhTrang(dn.getIdnv());
			tt.setIdtinhtrang(ttCu.getIdtinhtrang());
			service.updateTinhTrang(tt);
		}
				return "redirect:/QuanLyVangNghi/choduyet";
	}
	
	@RequestMapping(value = "/luunhap", method = RequestMethod.GET)
	public String viewLuuNhap(Model model, Authentication auth) {
		UserAccount user = service.getthongtinuser(auth.getName());
		HoSoNhanVien nhanVien = user.getNhanVien();
		List<DonNghi> dn = new ArrayList<DonNghi>();
		System.out.println(nhanVien.getMaNhanVien());
		dn = service.listDonNghiNhap(nhanVien.getMaNhanVien());
		model.addAttribute("list", dn);
		return "QuanLyVangNghi/luunhap";	
	}
	
	@RequestMapping(value = "/savenhap", method = RequestMethod.POST)
	public String saveNhapPost(Model model, @ModelAttribute("donNghi") DonNghi dn) {
		dn.setTinhtrang(0);
		service.addDon(dn);
		return "redirect:/QuanLyVangNghi/luunhap";
	}
	
	@RequestMapping(value = "/choduyet" , method = RequestMethod.GET)
	public String viewChoDuyet(Model model, Authentication auth) {
		UserAccount user = service.getthongtinuser(auth.getName());
		HoSoNhanVien nhanVien = user.getNhanVien();
		List<DonNghi> dn = new ArrayList<DonNghi>();
		dn = service.listDonNghiChoDuyet(nhanVien.getMaNhanVien());
		model.addAttribute("list", dn);
		return "QuanLyVanNghi/choduyet";
	}
}
