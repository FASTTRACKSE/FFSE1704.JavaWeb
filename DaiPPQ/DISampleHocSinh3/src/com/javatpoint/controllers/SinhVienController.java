package com.javatpoint.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.javatpoint.dao.SinhVienDAO;
import com.javatpoint.entity.SinhVien;

@Controller
public class SinhVienController {
	@Autowired
	SinhVienDAO dao;// will inject dao from xml file

	/*
	 * //Phan trang cung
	 * 
	 * @RequestMapping(value = "/viewemp/{pageid}") public ModelAndView
	 * edit(@PathVariable int pageid) { int total = 5; if (pageid == 1) { } else {
	 * pageid = (pageid - 1) * total + 1; } List<SinhVien> list =
	 * dao.getSinhVienloyeesByPage(pageid, total);
	 * 
	 * return new ModelAndView("viewemp", "list", list); }
	 */

	// Phan trang dong
	@RequestMapping(value = "/viewemp/{page}")
	public ModelAndView viewSinhVien(@PathVariable int page, Model model) {
		int record = dao.countSV();

		int perpage = 4;
		int totalPage = (int) Math.ceil(record * 1.0 / perpage);

		if (page <= 0) {
			page = 1;
		} else if (page > totalPage) {
			page = totalPage;
		}
		int start = (page - 1) * perpage;

		List<SinhVien> list = dao.getSinhVienloyeesByPage(start, perpage);
		model.addAttribute("page", page);
		model.addAttribute("totalPage", totalPage);
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
	/*
	 * @RequestMapping(value = "/save", method = RequestMethod.POST, produces =
	 * "application/x-www-form-rulencoded;charset=UTF-8") public ModelAndView
	 * save(@ModelAttribute("emp") SinhVien emp) { dao.save(emp); return new
	 * ModelAndView("redirect:/viewemp/1");// will redirect to viewemp request
	 * mapping }
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/x-www-form-rulencoded;charset=UTF-8")
	public ModelAndView save(@ModelAttribute("command") @Valid SinhVien emp, BindingResult result,
			@RequestParam("file") MultipartFile file, HttpSession session) throws IllegalStateException, IOException {
		if (result.hasErrors()) {
			return new ModelAndView("empform");
		}
		dao.save(emp);
		return new ModelAndView("redirect:/viewemp/1");
	}

	/*
	 * It provides list of SinhVienloyees in model object
	 * 
	 * @RequestMapping("/viewemp") public ModelAndView viewemp() { List<SinhVien>
	 * list = dao.getSinhVienloyees(); return new ModelAndView("viewemp", "list",
	 * list); }
	 */
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
	public ModelAndView editsave(@ModelAttribute("emp") SinhVien emp, @RequestParam("file") MultipartFile file,
			HttpSession session) throws IllegalStateException, IOException {
		dao.update(emp);
		return new ModelAndView("redirect:/viewemp/1");
	}

	/* It deletes record for the given id in URL and redirects to /viewemp */
	@RequestMapping(value = "/deleteemp/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		dao.delete(id);
		return new ModelAndView("redirect:/viewemp/1");
	}

	public String uploadFile(@RequestParam CommonsMultipartFile file, HttpServletRequest request)
			throws IllegalStateException, IOException {

		String fileName = file.getOriginalFilename();

		String path = "D:\\Images";
		byte[] bytes = file.getBytes();
		BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(new File(path + File.separator + fileName)));

		stream.write(bytes);
		stream.flush();
		stream.close();
		return fileName;

	}
}