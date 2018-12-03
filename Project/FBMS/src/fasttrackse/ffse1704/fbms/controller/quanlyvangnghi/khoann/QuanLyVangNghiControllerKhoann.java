package fasttrackse.ffse1704.fbms.controller.quanlyvangnghi.khoann;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.khoann.DonNghiPhepKhoann;
import fasttrackse.ffse1704.fbms.service.quanlyvangnghi.khoann.DonNghiPhepServiceKhoann;

@Controller
@RequestMapping("quanlyvangnghi/khoann")
public class QuanLyVangNghiControllerKhoann {

	@Autowired
	private DonNghiPhepServiceKhoann donNghiPhepService;

	public void setDonNghiPhepService(DonNghiPhepServiceKhoann donNghiPhepService) {
		this.donNghiPhepService = donNghiPhepService;
	}

	@RequestMapping(value =  "/list" , method = RequestMethod.GET)
	public String DanhSachNghiPhep(Model model) {
		List<DonNghiPhepKhoann> list = donNghiPhepService.listDonNghiPhep();
		model.addAttribute("list", list);
		return "QuanLyVangNghi/khoann/donnghiphep/list";
	}

}
