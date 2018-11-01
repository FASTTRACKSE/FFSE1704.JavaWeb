package springmvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.dao.SinhVienDAO;
import springmvc.entity.SinhVien;

@Controller
public class SvController {
	List<SinhVien> list;
	SinhVienDAO sinhvienDAO = new SinhVienDAO();

	@RequestMapping("/sinhvienform")
	public ModelAndView showForm() {

		return new ModelAndView("sinhvienform", "command", new SinhVien());

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("sinhvien") SinhVien sinhvien) {

		sinhvienDAO.addSinhVien(sinhvien);
		return new ModelAndView("redirect:/viewsinhvien");
	}

	@RequestMapping(value = "/editsinhvien/{id}")
	public ModelAndView edituser(@PathVariable String id) {
		SinhVien sinhvien = sinhvienDAO.getSinhVienById(id);
		return new ModelAndView("editsinhvien", "command", sinhvien);
	}

	@RequestMapping(value = "/EditSave", method = RequestMethod.POST)
	public ModelAndView edit(@ModelAttribute("sinhvien") SinhVien sinhvien) {
		sinhvienDAO.editSinhVien(sinhvien);
		return new ModelAndView("redirect:/viewsinhvien");
	}

	@RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.GET)
	public ModelAndView deluser(@PathVariable String id) {
		sinhvienDAO.deleteSinhVien(id);
		return new ModelAndView("redirect:/viewsinhvien");
	}

	@RequestMapping("/viewsinhvien")
	public ModelAndView viewUser() {
		List<SinhVien> list = sinhvienDAO.getAllUser();

		return new ModelAndView("viewsinhvien", "list", list);
	}
}
