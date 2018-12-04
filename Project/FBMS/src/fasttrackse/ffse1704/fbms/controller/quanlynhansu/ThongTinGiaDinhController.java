package fasttrackse.ffse1704.fbms.controller.quanlynhansu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ThongTinGiaDinh;
import fasttrackse.ffse1704.fbms.service.quanlynhansu.ThongTinGiaDinhService;

@Controller
public class ThongTinGiaDinhController {
	@Autowired
	ThongTinGiaDinhService thongTinGiaDinhService;

	@RequestMapping("/QuanTriNhanSu/danhsach_ttgiadinh")
	public String ShowList() {
		return "redirect:/QuanTriNhanSu/danhsach_ttgiadinh";

	}

	@RequestMapping("/QuanTriNhanSu/danhsach_ttgiadinh/")
	public ModelAndView ShowList(Model model) {
		List<ThongTinGiaDinh> list = thongTinGiaDinhService.dsThongTin();
		return new ModelAndView("QuanTriNhanSu/thongTinGiaDinh/allthongtin", "thongtin", list);
	}
}
