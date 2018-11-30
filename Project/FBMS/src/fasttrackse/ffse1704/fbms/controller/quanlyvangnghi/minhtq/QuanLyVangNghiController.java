package fasttrackse.ffse1704.fbms.controller.quanlyvangnghi.minhtq;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.DonNghiPhep;
import fasttrackse.ffse1704.fbms.service.quanlyvangnghi.minhtq.DonNghiPhepService;

@Controller
@RequestMapping("quanlyvangnghi/minhtq/QuanLyVangNghi")
public class QuanLyVangNghiController {

	@Autowired
	private DonNghiPhepService donNghiPhepService;

	public void setSinhVientService(DonNghiPhepService donNghiPhepService) {
		this.donNghiPhepService = donNghiPhepService;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String index(Model model) {

		List<DonNghiPhep> list = donNghiPhepService.listDonNghiPhep();
		model.addAttribute("list", list);

		return "QuanLyVangNghi/minhtq/donnghiphep/list";
	}

}
