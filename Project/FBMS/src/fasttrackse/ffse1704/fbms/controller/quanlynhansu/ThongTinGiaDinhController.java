package fasttrackse.ffse1704.fbms.controller.quanlynhansu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
		return "redirect:/QuanTriNhanSu/danhsach_ttgiadinh/1";

	}

	@RequestMapping("/QuanTriNhanSu/danhsach_ttgiadinh/{page}")
	public ModelAndView ShowList(@PathVariable int page, Model model) {
		long record = thongTinGiaDinhService.countTT();

		int perpage = 1;
		int totalPage = (int) Math.ceil(record * 1.0 / perpage);

		if (page == 0) {
			page = 1;
		}
		int start = (page - 1) * perpage;

		List<ThongTinGiaDinh> list = thongTinGiaDinhService.getThongTinByPage(start, perpage);
		model.addAttribute("page", page);
		model.addAttribute("totalPage", totalPage);
		return new ModelAndView("QuanTriNhanSu/thongTinGiaDinh/allthongtin", "thongtin", list);
	}
}
