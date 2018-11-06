package quanlysinhvien.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import quanlysinhvien.entity.SinhVien;
import quanlysinhvien.entity.TinhThanh;
import quanlysinhvien.model.SinhVienDAO;

@Controller
public class SinhVienController {
	@Autowired
	SinhVienDAO dao;// will inject dao from xml file

	@ModelAttribute("countryList")
	public List<TinhThanh> getCountryList() {
		List<TinhThanh> countryList = dao.getListThanhPho();
		return countryList;
	}

	/*
	 * It displays a form to input data, here "command" is a reserved request
	 * attribute which is used to display object data into form
	 */
	@RequestMapping("/addsinhvien")
	public ModelAndView showform() {
		return new ModelAndView("addsinhvien", "command", new SinhVien());
	}

	/*
	 * It saves object into database. The @ModelAttribute puts request data into
	 * model object. You need to mention RequestMethod.POST method because default
	 * request is GET
	 */
	@RequestMapping(value = "/themsinhvien", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("sinhvien") SinhVien sinhvien, @RequestParam CommonsMultipartFile file,
			HttpSession session) {

		File fileImage = new File("D:\\Image");
		if (!fileImage.exists()) {
			fileImage.mkdirs();
		}

		String filename = file.getOriginalFilename();
		try {
			byte barr[] = file.getBytes();

			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(fileImage + "/" + filename));
			bout.write(barr);
			bout.flush();
			bout.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		sinhvien.setAvatar(filename);
		dao.add(sinhvien);

		return new ModelAndView("redirect:/sinhvien/1");// will redirect to viewemp request mapping;

	}

	/* It provides list of employees in model object */
	@RequestMapping("/sinhvien/{pageid}")
	public ModelAndView viewSinhVien(@PathVariable int pageid, Model model) throws SQLException {
		double perPage = 1;
		double pageTotal = (int) Math.ceil(dao.count() / perPage);
		int start = (pageid - 1) * (int) perPage;
		List<SinhVien> list = dao.getSinhVien(start, (int) perPage);
		model.addAttribute("pageid", pageid);
		model.addAttribute("pagetotal", pageTotal);
		return new ModelAndView("sinhvien", "list", list);
	}

	/*
	 * It displays object data into form for the given id. The @PathVariable puts
	 * URL data into variable.
	 */
	@RequestMapping(value = "/editview/{id}")
	public ModelAndView edit(@PathVariable int id) {
		SinhVien sinhvien = dao.getSVById(id);
		return new ModelAndView("editsinhvien", "command", sinhvien);
	} 

	/* It updates model object. */
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("sinhvien") SinhVien sinhvien, @RequestParam CommonsMultipartFile file,
			HttpSession session) {
		File fileImage = new File("D:\\Image");
		if (!fileImage.exists()) {
			fileImage.mkdirs();
		}

		String filename = file.getOriginalFilename();
		try {
			byte barr[] = file.getBytes();

			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(fileImage + "/" + filename));
			bout.write(barr);
			bout.flush();
			bout.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		sinhvien.setAvatar(filename);
		
		
		dao.update(sinhvien);
		return new ModelAndView("editsinhvien", "command", sinhvien);
	}

	// * It deletes record for the given id in URL and redirects to /viewemp */
	@RequestMapping(value = "/deletesinhvien/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		dao.delete(id);
		return new ModelAndView("redirect:/sinhvien/1");
	}

}