package fasttrackse.ffse1704.fbms.controller.quanlyvangnghi.khoann;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.khoann.DonNghiPhep;
import fasttrackse.ffse1704.fbms.service.quanlyvangnghi.khoann.DonNghiPhepService;

@Controller

public class QuanLyVangNghi {

	@Autowired
	private DonNghiPhepService donNghiPhepService;

	public void setDonNghiPhepService(DonNghiPhepService donNghiPhepService) {
		this.donNghiPhepService = donNghiPhepService;
	}

	@RequestMapping(value =  "/list" , method = RequestMethod.GET)
	public String DanhSachNghiPhep(Model model) {
		List<DonNghiPhep> list = donNghiPhepService.listDonNghiPhep();
		model.addAttribute("list", list);
		return "QuanLyVangNghi/khoann/donnghiphep/list";
	}

}
