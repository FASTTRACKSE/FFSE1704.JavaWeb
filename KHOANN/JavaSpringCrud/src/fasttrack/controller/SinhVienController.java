package fasttrack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fasttrack.dao.SinhVienDAO;
import fasttrack.entity.SinhVien;

@Controller
public class SinhVienController {
	@Autowired
	SinhVienDAO dao;
	List<SinhVien> list;

	@RequestMapping("/addsinhvien")
	public ModelAndView showForm() {

		return new ModelAndView("addsinhvien", "command", new SinhVien());

	}

	@RequestMapping("/listsinhvien")
	public ModelAndView viewUser() {
		List<SinhVien> list = dao.getAllSinhVien();

		return new ModelAndView("listsinhvien", "list", list);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("sinhvien") SinhVien sv) {
		dao.save(sv);
		return new ModelAndView("redirect:/listsinhvien");// will redirect to viewemp request mapping

	}

	@RequestMapping(value = "/editsinhvien/{id}")
	public ModelAndView edit(@PathVariable int id) {
		SinhVien sv = dao.getSinhVienById(id);
		return new ModelAndView("editsinhvien", "command", sv);
	}

	/* It updates model object. */
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("sinhvien") SinhVien sv) {
		dao.update(sv);
		return new ModelAndView("redirect:/listsinhvien");
	}

	@RequestMapping(value = "/deletesinhvien/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		dao.delete(id);
		return new ModelAndView("redirect:/listsinhvien");
	}
}
