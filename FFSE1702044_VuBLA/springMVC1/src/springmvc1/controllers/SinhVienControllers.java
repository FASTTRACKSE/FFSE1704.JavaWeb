package springmvc1.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import springmvc1.dao.SinhVienDao;
import springmvc1.entity.SinhVien;

@Controller
public class SinhVienControllers {
	SinhVienDao sinhVienDAO;

	@RequestMapping("/addSinhVien")
	public ModelAndView addSinhVien() {

		return new ModelAndView("addSinhVien", "command", new SinhVien());
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("user") SinhVien sv) {

		sinhVienDAO.add(sv);
		return new ModelAndView("redirect:/viewuser");
	}

	@RequestMapping("/viewsinhvien")
	public ModelAndView listSinhVien() {
		List<SinhVien> sv = sinhVienDAO.getAllSV();
		return new ModelAndView("viewsinhvien", "list", sv);
	}
}
