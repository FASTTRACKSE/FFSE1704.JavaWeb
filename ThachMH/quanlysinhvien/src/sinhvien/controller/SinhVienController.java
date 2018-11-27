package sinhvien.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import sinhvien.bean.SinhVien;
import sinhvien.dao.*;

public class SinhVienController {
	@Autowired
	SinhVienDao dao;// will inject dao from xml file
	/*
	 * It displays a form to input data, here "command" is a reserved request
	 * attribute which is used to display object data into form
	 */

	@RequestMapping("/sinhvienform")
	public ModelAndView showform() {
		return new ModelAndView("sinhvienform", "command", new SinhVien());
	}

	/*
	 * It saves object into database. The @ModelAttribute puts request data into
	 * model object. You need to mention RequestMethod.POST method because default
	 * request is GET
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("sinhvien") SinhVien sinhvien) {
		dao.add(sinhvien);
		return null;

	}

	@RequestMapping("/viewsinhvien")
	public ModelAndView viewsinhvien() {
		List<SinhVien> list = dao.getSinhVien();
		return new ModelAndView("viewsinhvien", "list", list);
	}

	/*
	 * It displays object data into form for the given id. The @PathVariable puts
	 * URL data into variable.
	 */
	@RequestMapping(value = "/editsv/{id}")
	public ModelAndView edit(@PathVariable int id) {
		SinhVien sv = dao.getSVById(id);
		return new ModelAndView("sinhvienedit", "command", sv);
	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("sv") SinhVien sv) {
		dao.update(sv);
		return new ModelAndView("redirect:/viewsinhvien");
	}

	@RequestMapping(value = "/deletesv/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		dao.delete(id);
		return new ModelAndView("redirect:/viewsinhvien");
	}
}
