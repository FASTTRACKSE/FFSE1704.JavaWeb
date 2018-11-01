package com.javatpoint.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javatpoint.dao.SinhVienDAO;
import com.javatpoint.entity.SinhVien;

@Controller
public class SinhVienController {
	@Autowired
	SinhVienDAO dao;// will inject dao from xml file

	@RequestMapping(value = "/viewemp/{pageid}")
	public ModelAndView edit(@PathVariable int pageid) {
		int total = 5;
		if (pageid == 1) {
		} else {
			pageid = (pageid - 1) * total + 1;
		}
		List<SinhVien> list = dao.getSinhVienloyeesByPage(pageid, total);

		return new ModelAndView("viewemp", "list", list);
	}

	/*
	 * It displays a form to input data, here "command" is a reserved request
	 * attribute which is used to display object data into form
	 */
	@RequestMapping("/empform")
	public ModelAndView showform() {
		return new ModelAndView("empform", "command", new SinhVien());
	}

	/*
	 * It saves object into database. The @ModelAttribute puts request data into
	 * model object. You need to mention RequestMethod.POST method because default
	 * request is GET
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/x-www-form-rulencoded;charset=UTF-8")
	public ModelAndView save(@ModelAttribute("emp") SinhVien emp) {
		dao.save(emp);
		return new ModelAndView("redirect:/viewemp/1");// will redirect to viewemp request mapping
	}

	/* It provides list of SinhVienloyees in model object */
	@RequestMapping("/viewemp")
	public ModelAndView viewemp() {
		List<SinhVien> list = dao.getSinhVienloyees();
		return new ModelAndView("viewemp", "list", list);
	}

	/*
	 * It displays object data into form for the given id. The @PathVariable puts
	 * URL data into variable.
	 */
	@RequestMapping(value = "/editemp/{id}")
	public ModelAndView editemp(@PathVariable int id) {
		SinhVien emp = dao.getSinhVienById(id);
		return new ModelAndView("empeditform", "command", emp);
	}

	/* It updates model object. */
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("emp") SinhVien emp) {
		dao.update(emp);
		return new ModelAndView("redirect:/viewemp/1");
	}

	/* It deletes record for the given id in URL and redirects to /viewemp */
	@RequestMapping(value = "/deleteemp/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		dao.delete(id);
		return new ModelAndView("redirect:/viewemp/1");
	}

}