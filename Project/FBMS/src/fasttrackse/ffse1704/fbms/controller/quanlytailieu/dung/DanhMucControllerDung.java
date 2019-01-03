package fasttrackse.ffse1704.fbms.controller.quanlytailieu.dung;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung.DanhMucDung;
import fasttrackse.ffse1704.fbms.service.quanlytailieu.dung.DanhMucServiceDung;

@Controller
@RequestMapping("/quanlytailieu")

public class DanhMucControllerDung {
	@Autowired
	DanhMucServiceDung danhMucService;

	public DanhMucServiceDung getDanhMucService() {
		return danhMucService;
	}

	public void setDanhMucService(DanhMucServiceDung danhMucService) {
		this.danhMucService = danhMucService;
	}

	@RequestMapping(value = "/danhmuc", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("listDanhMuc", danhMucService.getAll());
		return "quanlytailieu/dung/danhmucDung";
	}
	
	@RequestMapping(value = "/addDanhMucView", method = RequestMethod.GET)
	public String addDanhMucView(Model model) {
		model.addAttribute("danhmuc", new DanhMucDung());
		model.addAttribute("listQuyen", danhMucService.listQuyen());
		return "quanlytailieu/dung/AddDanhMuc";
	}
	@RequestMapping(value = "/addDanhMuc", method = RequestMethod.POST)
	public String addDanhMuc(@ModelAttribute("danhmuc") DanhMucDung danhmuc ) {
		danhMucService.addDanhMuc(danhmuc);
		return "redirect:/quanlytailieu/danhmuc";
	}
	@RequestMapping(value = "/danhMucDelete/{id}", method = RequestMethod.GET)
	public String documentDelete(@PathVariable int id, Model model) {
		danhMucService.deleteDanhMuc(id);
		return "redirect:/quanlytailieu/danhmuc";
	}
	
	
	@RequestMapping(value = "/updateDanhMucView/{id}", method = RequestMethod.GET)
	public String updateDanhMucView(@PathVariable int id, Model model) {
		model.addAttribute("danhmucUpdate", danhMucService.findById(id));
		model.addAttribute("listQuyen", danhMucService.listQuyen());

		return "quanlytailieu/dung/UpdateDanhMuc";
	}
	@RequestMapping(value = "/updateDanhMuc", method = RequestMethod.POST)
	public String updateDanhMuc(@ModelAttribute("danhmuc") DanhMucDung danhmuc ) {
		danhMucService.updateDanhMuc(danhmuc);
		return "quanlytailieu/dung/danhmuc";
	}
}
