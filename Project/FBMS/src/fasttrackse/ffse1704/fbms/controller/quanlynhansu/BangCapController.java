package fasttrackse.ffse1704.fbms.controller.quanlynhansu;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.BangCap;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.NhanSu;
import fasttrackse.ffse1704.fbms.service.quanlynhansu.BangCapService;

@Controller
public class BangCapController {
	@Autowired
	BangCapService bangCapService;

	public void setBangCapService(BangCapService bangCapService) {
		this.bangCapService = bangCapService;
	}

	// mac dinh
	// @RequestMapping("/ViewBC/")
	// public String ShowList() {
	// return "redirect:/ViewBC/1";
	//
	// }
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
	}

	// danh sach bằng cấp
	@RequestMapping(value = "/ViewBC/{maNhanVien}", method = RequestMethod.GET)
	public String ViewBangCap(@PathVariable("maNhanVien") String maNhanVien, Model model) {

		model.addAttribute("bangCap", bangCapService.getBangCapByID(maNhanVien));

		return "QuanTriNhanSu/BangCap/ListBangCap";

	}

	// danh sach edit
	@RequestMapping(value = "/ViewBC/editBC/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") int id, Model model) {

		model.addAttribute("bangCap", bangCapService.getBangCapUpdate(id));

		return "QuanTriNhanSu/BangCap/editBangCap";

	}

	// UPDATE
	@RequestMapping(value = "/ViewBC/update", method = RequestMethod.POST)
	public String editSave(@ModelAttribute("bangCap") BangCap bangCap, Model model) {

		bangCapService.update(bangCap);

		return "QuanTriNhanSu/BangCap/ListBangCap";

	}
}
