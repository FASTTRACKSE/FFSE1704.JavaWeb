package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.entity.*;
import com.dao.SinhVienDAO;

@Controller
public class SinhVienController {
	@Autowired
	SinhVienDAO dao;// will inject dao from xml file

	/*
	 * It displays a form to input data, here "command" is a reserved request
	 * attribute which is used to display object data into form
	 */
	@RequestMapping("/sinhvienfrom")
	public ModelAndView showform() {
		return new ModelAndView("sinhvienfrom", "command", new SinhVien());
	}

	/*
	 * It saves object into database. The @ModelAttribute puts request data into
	 * model object. You need to mention RequestMethod.POST method because default
	 * request is GET
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("emp") SinhVien emp) {
		dao.save(emp);
		return new ModelAndView("redirect:/viewsinhvien");// will redirect to viewemp request mapping
	}

	/* It provides list of employees in model object */
	@RequestMapping("/viewsinhvien")
	public ModelAndView viewemp() {
		List<SinhVien> list = dao.getEmployees();
		return new ModelAndView("viewsinhvien", "list", list);
	}
	
	//ADD sinh vien
	@ModelAttribute("list")
	public List<TinhThanhPho> listTinhThanh() {
		List<TinhThanhPho> list = dao.getListTinhThanh();
		return list;
	}

	/*
	 * It displays object data into form for the given id. The @PathVariable puts
	 * URL data into variable.
	 */
	@RequestMapping(value = "/editemp/{id}")
	public ModelAndView edit(@PathVariable int id) {
		SinhVien emp = dao.getsinhvienById(id);
		return new ModelAndView("sinhvieneditfrom", "command", emp);
	}

	/* It updates model object. */
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("emp") SinhVien emp) {
		dao.update(emp);
		return new ModelAndView("redirect:/viewsinhvien");
	}

	/* It deletes record for the given id in URL and redirects to /viewemp */
	@RequestMapping(value = "/deleteemp/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		dao.delete(id);
		return new ModelAndView("redirect:/viewsinhvien");
	}

}
