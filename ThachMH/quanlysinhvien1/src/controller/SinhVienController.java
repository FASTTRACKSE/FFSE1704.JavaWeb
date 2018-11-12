package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.SinhVienDao;
import entity.SinhVien;

@Controller
public class SinhVienController {
	@Autowired
	SinhVienDao dao;// will inject dao from xml file

	/*
	 * It displays a form to input data, here "command" is a reserved request
	 * attribute which is used to display object data into form
	 */
	@RequestMapping("/view")
	public ModelAndView view() {
		List<SinhVien> list = dao.getList();
		return new ModelAndView("view", "list", list);
	}

	@RequestMapping(value = "/editSV/{id}")
	public ModelAndView edit(@PathVariable int id) {
		SinhVien sv = dao.getSVById(id);
		return new ModelAndView("editSV", "command", sv);
	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("sv") SinhVien sv) {
		dao.update(sv);
		return new ModelAndView("redirect:/view");
	}

	@RequestMapping(value = "/deletesv/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		dao.delete(id);
		return new ModelAndView("redirect:/view");
	}

	@RequestMapping("/addSV")
	public ModelAndView showform() {
		return new ModelAndView("addSV", "command", new SinhVien());
	}

	/*
	 * It saves object into database. The @ModelAttribute puts request data into
	 * model object. You need to mention RequestMethod.POST method because default
	 * request is GET
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("sv") SinhVien sv) {
		dao.add(sv);
		return new ModelAndView("redirect:/view");// will redirect to viewemp request mapping
	}
}
