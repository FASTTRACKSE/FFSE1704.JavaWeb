package fasttrackse.ffse1704.fbms.controller.quanlynhansu;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ChungChi;
import fasttrackse.ffse1704.fbms.service.quanlynhansu.ChungChiService;

@Controller
public class ChungChiController {
	@Autowired
	ChungChiService chungChiService;

	@RequestMapping("/allChungChi")
	public String ShowList() {
		return "redirect:/1";

	}

	@RequestMapping("/addCC")
	public ModelAndView chungchi() {
		return new ModelAndView("QuanTriNhanSu/chungChi/addCC", "chungChi", new ChungChi());
	}

	@RequestMapping("/{page}")
	public ModelAndView ShowList(@PathVariable int page, Model model) {
		long record = chungChiService.countSV();

		int perpage = 1;
		int totalPage = (int) Math.ceil(record * 1.0 / perpage);

		if (page == 0) {
			page = 1;
		}
		int start = (page - 1) * perpage;

		List<ChungChi> list = chungChiService.getEmployeesByPage(start, perpage);
		model.addAttribute("page", page);
		model.addAttribute("totalPage", totalPage);
		return new ModelAndView("QuanTriNhanSu/chungChi/allchungchi", "chungchi", list);
	}

	@RequestMapping(value = "/addCC", method = RequestMethod.POST)
	public ModelAndView addCC(@ModelAttribute("chungChi") ChungChi chungChi) throws IllegalStateException, IOException {
		chungChiService.addCC(chungChi);
		return new ModelAndView("redirect:/allChungChi");
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
	}

	@RequestMapping(value = "/updateCC/{id}")
	public String update(@PathVariable int id, Model model) {
		ChungChi chungChi = chungChiService.getChungChiById(id);
		model.addAttribute("chungchi", chungChi);
		return "QuanTriNhanSu/chungChi/updateCC";
	}

	@RequestMapping(value = "/updateCC", method = RequestMethod.POST)
	public ModelAndView updateCC(@ModelAttribute("chungChi") ChungChi chungChi)
			throws IllegalStateException, IOException {
		chungChiService.updateCC(chungChi);
		return new ModelAndView("redirect:/allChungChi");
	}

	@RequestMapping(value = "/deleteCC/{id}")
	public String delete(@PathVariable int id, Model model) {
		ChungChi chungChi = chungChiService.getChungChiById(id);
		model.addAttribute("chungchi", chungChi);
		return "QuanTriNhanSu/chungChi/deleteCC";
	}

	@RequestMapping(value = "/deleteCC", method = RequestMethod.POST)
	public ModelAndView deleteCC(@ModelAttribute("chungChi") ChungChi chungChi)
			throws IllegalStateException, IOException {
		chungChiService.deleteCC(chungChi);
		return new ModelAndView("redirect:/allChungChi");
	}

}
