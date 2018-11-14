package fasttrack.com.javatpoint;

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

import fasttrack.dao.HocSinhDao;
import fasttrack.entity.HocSinh;
import fasttrack.entity.TinhThanh;

@Controller
public class HocSinhController {

	@Autowired
	HocSinhDao hsDao;

	public HocSinhDao getHsDao() {
		return hsDao;
	}

	public void setHsDao(HocSinhDao hsDao) {
		this.hsDao = hsDao;
	}

	@ModelAttribute("listTinhThanh")
	public List<TinhThanh> getListTinhThanh() {
		List<TinhThanh> listTinhThanh = hsDao.getTinhThanh();
		return listTinhThanh;
	}

	@RequestMapping("/hocsinhform")
	public ModelAndView showform() {

		return new ModelAndView("hocsinhform", "command", new HocSinh());
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("hs") HocSinh hs, @RequestParam CommonsMultipartFile file,
			HttpSession session) {
		File ava = new File("D:\\image");
		if (!ava.exists()) {
			ava.mkdirs();
		}
		String filename = file.getOriginalFilename();

		try {
			byte barr[] = file.getBytes();

			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(ava + "/" + filename));
			bout.write(barr);
			bout.flush();
			bout.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		hs.setAvatar(filename);
		hsDao.save(hs);
		return new ModelAndView("redirect:/viewhs/1");
	}

	@RequestMapping(value = "/editStudent/{id}")
	public ModelAndView edit(@PathVariable int id) {
		HocSinh hs = hsDao.getStudentById(id);
		return new ModelAndView("editForm", "command", hs);
	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("hs") HocSinh hs, @RequestParam CommonsMultipartFile file,
			HttpSession session) {

		File ava = new File("D:\\image");
		if (!ava.exists()) {
			ava.mkdirs();
		}
		String filename = file.getOriginalFilename();

		try {
			byte barr[] = file.getBytes();

			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(ava + "/" + filename));
			bout.write(barr);
			bout.flush();
			bout.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		hs.setAvatar(filename);
		hsDao.update(hs);
		return new ModelAndView("redirect:/viewhs/1");
	}

	@RequestMapping(value = "/deleteStudent/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		hsDao.delete(id);
		return new ModelAndView("redirect:/viewhs/1");
	}

	@RequestMapping("/viewhs/{pageid}")
	public ModelAndView viewhocsinh(@PathVariable int pageid, Model model) throws SQLException {
		double perPage = 3;
		double pageTotal = (int) Math.ceil(hsDao.counths() / perPage);
		int start = (pageid - 1) * (int) perPage;

		List<HocSinh> list = hsDao.getStudentByPage(start, (int) perPage);

		model.addAttribute("pageid", pageid);
		model.addAttribute("pagetotal", pageTotal);

		return new ModelAndView("viewhs", "list", list);
	}
}
