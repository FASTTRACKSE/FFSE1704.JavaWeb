package springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import springmvc.entity.SinhVien;

@Controller
public class SvController {
	List<SinhVien> list = new ArrayList<SinhVien>();

	@RequestMapping("/SinhVienForm")
	public ModelAndView showForm() {

		return new ModelAndView("SinhVienForm", "command", new SinhVien());

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("SinhVien") SinhVien SinhVien) {

		list.add(new SinhVien(SinhVien.getId(), SinhVien.getName(), SinhVien.getYear(), SinhVien.getGender()));
		return new ModelAndView("redirect:/ViewSinhVien");
	}

	@RequestMapping(value = "/EditSinhVien/{id}")
	public ModelAndView EditSinhVien(@PathVariable int id) {
		for (int i = 0; i < list.size(); i++) {
			id = i;
			list.get(i);
		}
		return new ModelAndView("redirect:/EditSinhVien");
	}

	@RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.GET)
	public ModelAndView deluser(@PathVariable int id) {
		for (int i = 1; i < list.size(); i++) {
			id = i;
			list.remove(i);
		}
		return new ModelAndView("redirect:/ViewSinhVien");
	}

	@RequestMapping("/ViewSinhVien")
	public ModelAndView ViewSinhVien() {
		return new ModelAndView("ViewSinhVien", "list", list);
	}

}
