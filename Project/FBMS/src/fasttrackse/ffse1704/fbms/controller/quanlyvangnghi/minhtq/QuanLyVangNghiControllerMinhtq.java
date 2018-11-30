package fasttrackse.ffse1704.fbms.controller.quanlyvangnghi.minhtq;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.DonNghiPhepMinhtq;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.LoaiNgayNghiMinhtq;
import fasttrackse.ffse1704.fbms.service.quanlyvangnghi.minhtq.DonNghiPhepServiceMinhtq;

@Controller
@RequestMapping("quanlyvangnghi/minhtq/donnghiphepnhap")
public class QuanLyVangNghiControllerMinhtq {

	@Autowired
	private DonNghiPhepServiceMinhtq donNghiPhepService;

	public DonNghiPhepServiceMinhtq getDonNghiPhepService() {
		return donNghiPhepService;
	}

	public void setDonNghiPhepService(DonNghiPhepServiceMinhtq donNghiPhepService) {
		this.donNghiPhepService = donNghiPhepService;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String index(Model model) {
		List<DonNghiPhepMinhtq> list = donNghiPhepService.listDonNghiPhep();
		model.addAttribute("list", list);

		return "QuanLyVangNghi/minhtq/donnghiphepnhap/list";
	}

	@ModelAttribute("countryList")
	public List<LoaiNgayNghiMinhtq> getCountryList() {
		List<LoaiNgayNghiMinhtq> countryList = donNghiPhepService.listLoaiNgayNghi();
		return countryList;
	}
	
	@RequestMapping(value = "/addDonNghiPhep", method = RequestMethod.GET)
	public String showForm(Model model) {
		model.addAttribute("command", new DonNghiPhepMinhtq());
		model.addAttribute("listDonNghiPhep", donNghiPhepService.listDonNghiPhep());
		return "/QuanLyVangNghi/minhtq/donnghiphepnhap/add_form";
	}

	@RequestMapping(value = "/addDonNghiPhep", method = RequestMethod.POST)
	public String createStudent(Model model, @ModelAttribute("command") @Valid DonNghiPhepMinhtq donnghiphep,
			BindingResult bindingResult,final RedirectAttributes redirectAttributes) throws IllegalStateException, IOException {

		if (bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
			return "/QuanLyVangNghi/minhtq/donnghiphepnhap/add_form";
		}
		
		donNghiPhepService.addDonNghiPhep(donnghiphep);
		redirectAttributes.addFlashAttribute("messageSuccess", "Sửa thành công!");
		return "redirect:/list";
	}
}
