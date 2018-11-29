package fasttrackse.ffse1704.fbms.controller.quanlynhansu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.NhanSu;
import fasttrackse.ffse1704.fbms.service.quanlynhansu.NhanSuService;

@Controller
public class NhanSuController {
	@Autowired
	NhanSuService nhanSuService;
	
	

	public void setNhanSuService(NhanSuService nhanSuService) {
		this.nhanSuService = nhanSuService;
	}

	@RequestMapping("/allNhanSu")
	public String ShowList(Model model) {
		
		List<NhanSu> allNS = nhanSuService.allNS();
		model.addAttribute("nhansu", allNS);
		return "QuanTriNhanSu/nhanSu/allnhansu";

	}
}
