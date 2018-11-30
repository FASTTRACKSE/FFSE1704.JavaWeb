package fasttrackse.ffse1704.fbms.controller.quanlyvangnghi.thachmh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.thachmh.DonXinNghiPhep;
import fasttrackse.ffse1704.fbms.service.quanlyvangnghi.thachmh.DonXinNghiPhepService;

@Controller
@RequestMapping("/QuanLyVangNghi512")
public class DonXinNghiPhepController {
	@Autowired
	private DonXinNghiPhepService donXinNghiPhepService;
	

	@RequestMapping(value = "/list")
	public String view(Model model) {

		model.addAttribute("list", donXinNghiPhepService.getAllDonXinNghiPhep());

		return "QuanLyVangNghiThachMH/listvangnghi";
	}

	@RequestMapping(value = "/add")
	public String add(Model model) {
		model.addAttribute("donXinNghiPhep", new DonXinNghiPhep());
		return "QuanLyVangNghiThachMH/addvangnghi";
	}

}
