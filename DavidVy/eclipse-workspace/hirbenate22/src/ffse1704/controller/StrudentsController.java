package ffse1704.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import ffse1704.entity.SinhVien;
import ffse1704.service.SinhVienService;

@Controller
public class StrudentsController {
	@Autowired
	SinhVienService sinhVienService;

	/*public SinhVienService getSinhVienService() {
		return sinhVienService;
	}*/

	public void setSinhVienService(SinhVienService sinhVienService) {
		this.sinhVienService = sinhVienService;
	}
	
	//view
	@RequestMapping("/view")
	public String showForm(Model model) {
	List<SinhVien> sinhvien = sinhVienService.getAllSinhVien();
		model.addAttribute("sinhvien", sinhvien);
		return "view";
	}

}
