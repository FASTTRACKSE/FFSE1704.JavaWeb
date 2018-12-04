package fasttrackse.ffse1704.fbms.controller.quanlyvangnghi.tuanpt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fasttrackse.ffse1704.fbms.service.quanlyvangnghi.tuanpt.DonNghiService;;
@Controller
public class QuanLyVangNghiController {

	@Autowired
	private DonNghiService donNghiService;
	
	@RequestMapping(value = "/list")
	public String view(Model model) {

		model.addAttribute("list", donNghiService.getAllDonNghi());

		return "QuanLyVangNghi/TuanPT/donnghi/list";
	}
}
