package controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sun.org.apache.bcel.internal.generic.NEW;

import dao.SinhVienDao;
import sinhvien.entity.SinhVien;
import sinhvien.entity.TinhThanh;

@Controller
public class SinhVienController {
	@Autowired
	SinhVienDao dao;

	// view SinhVien
	@RequestMapping("/view")
	public ModelAndView viewemp() {
		List<SinhVien> list = dao.getSinhVien();
		return new ModelAndView("view", "list", list);
	}

	// add SinhVien
	@ModelAttribute("countryList")
	public List<TinhThanh> getCountryList() {
		List<TinhThanh> countryList = dao.getListTinhThanh();
		return countryList;
	}

	@RequestMapping("/svform")
	public ModelAndView showform() {
		return new ModelAndView("svform", "command", new SinhVien());
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("sv") SinhVien sv) {
		dao.addSV(sv);
		return new ModelAndView("redirect:/view");// will redirect to viewemp request mapping
	}

	// editSinhVien
	@RequestMapping(value = "/editsv/{id}")
	public ModelAndView edit(@PathVariable int id) {
		SinhVien sv = dao.getSVById(id);
		return new ModelAndView("sveditform", "command", sv);
	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("sv") SinhVien sv) {
		dao.update(sv);
		return new ModelAndView("redirect:/view");
	}

	// delete SinhVien
	@RequestMapping(value = "/deletesv/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		dao.delete(id);
		return new ModelAndView("redirect:/view");
	}
	// upload file
}
