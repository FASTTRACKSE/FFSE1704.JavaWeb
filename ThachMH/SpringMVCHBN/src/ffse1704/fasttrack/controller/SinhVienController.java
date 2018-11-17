package ffse1704.fasttrack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ffse1704.fasttrack.entity.SinhVien;
import ffse1704.fasttrack.service.SinhVienService;

@Controller
@RequestMapping(value = "/sinhvien")
public class SinhVienController {
	@Autowired
	SinhVienService sinhVienService;

	@RequestMapping("/list")
	public String listOfSinhVien(Model model) {
		model.addAttribute("sinhVienList", sinhVienService.getAllSinhViens());
		return "list-sinhvien";
	}

	@RequestMapping("/showAdd")
	public String showForm(Model model) {
		model.addAttribute("sinhvien", new SinhVien());
		return "add-sinhvien";
	}

	@RequestMapping("/saveProcess")
	public String saveSV(@ModelAttribute("sinhvien") SinhVien v) {
			sinhVienService.saveSV(v);
		return "redirect:/sinhvien/list";
	}

	@RequestMapping("/displayUpdateForm")
	public String showUpdateForm(@RequestParam("sinhVienID") int theId, Model model) {
		model.addAttribute("sinhvien", sinhVienService.getSinhVien(theId));
		return "add-sinhvien";
	}

	@RequestMapping("/displayDeleteForm")
	public String deleteSV(@RequestParam("sinhVienID") int theId, Model model) {
		sinhVienService.deleteSV(theId);;
		return "redirect:/sinhvien/list";
	}
}
