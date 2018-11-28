package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.SinhVienService;

@Controller
public class SinhVienController {
	@Autowired
	SinhVienService sinhVienService;

	@RequestMapping("/list")
	public String listOfSinhVien(Model model) {
		model.addAttribute("sinhVienList", sinhVienService.getAllSinhVien());
		return "list";
	}
}