package fasttrack.controller;

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

import fasttrack.dao.SinhVienDAO;
import fasttrack.entity.SinhVien;
import fasttrack.entity.TinhThanh;

@Controller
public class SinhVienController {
	@Autowired
	SinhVienDAO dao;
	List<SinhVien> list;

	@RequestMapping("/addsinhvien")
	public ModelAndView showForm() {

		return new ModelAndView("addsinhvien", "command", new SinhVien());

	}

	@RequestMapping("/listsinhvien/{pageid}")
	public ModelAndView viewUser(@PathVariable int pageid, Model model) throws SQLException {
		double perPage = 5;
		double pageTotal = (int) Math.ceil(dao.countSV() / perPage);
		int start = (pageid - 1) * (int) perPage;
		List<SinhVien> list = dao.getSinhVienByPage(start, (int) perPage);
		model.addAttribute("pageid", pageid);
		model.addAttribute("pagetotal", pageTotal);

		return new ModelAndView("listsinhvien", "list", list);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("sinhvien") SinhVien sv, @RequestParam CommonsMultipartFile file,
			HttpSession session) {
		

		File fileImage = new File("D:\\img");

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

		sv.setImage(filename);

		dao.save(sv);
		return new ModelAndView("redirect:/listsinhvien/1");// will redirect to viewemp request mapping

	}

	@RequestMapping(value = "/editsinhvien/{id}")
	public ModelAndView edit(@PathVariable int id) {
		SinhVien sv = dao.getSinhVienById(id);
		return new ModelAndView("editsinhvien", "command", sv);
	}

	/* It updates model object. */
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("sinhvien") SinhVien sv,@RequestParam CommonsMultipartFile file,
			HttpSession session) {
		File fileImage = new File("D:\\img");

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

		sv.setImage(filename);

		dao.update(sv);
		return new ModelAndView("redirect:/listsinhvien/1");
	}

	@RequestMapping(value = "/deletesinhvien/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		dao.delete(id);
		return new ModelAndView("redirect:/listsinhvien/1");
	}

	@ModelAttribute("countryList")
	public List<TinhThanh> getCountryList() {
		List<TinhThanh> countryList = dao.getListThanhPho();
		return countryList;
	}

}
