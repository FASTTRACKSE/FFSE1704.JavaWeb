package fasttrackse.ffse1704.fbms.controller.quanlyvangnghi.minhtq;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.DonNghiPhepMinhtq;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.LoaiNgayNghiMinhtq;
import fasttrackse.ffse1704.fbms.service.quanlyvangnghi.minhtq.DonNghiPhepServiceMinhtq;

@Controller
@RequestMapping("/QuanLyVangNghi/minhtq")
public class QuanLyVangNghiControllerMinhtq {

	@Autowired
	private DonNghiPhepServiceMinhtq donNghiPhepService;

	public DonNghiPhepServiceMinhtq getDonNghiPhepService() {
		return donNghiPhepService;
	}

	public void setDonNghiPhepService(DonNghiPhepServiceMinhtq donNghiPhepService) {
		this.donNghiPhepService = donNghiPhepService;
	}

	// list toàn bộ đơn nghỉ phép nháp
	@RequestMapping(value = "/listDonNghiPhepNhap", method = RequestMethod.GET)
	public String index(Model model) {
		List<DonNghiPhepMinhtq> list = donNghiPhepService.listDonNghiPhepNhap();
		model.addAttribute("list", list);

		return "QuanLyVangNghi/minhtq/donnghiphepnhap/list";
	}

	// list danh sách loại ngày nghỉ
	@ModelAttribute("listLoaiNgayNghi")
	public List<LoaiNgayNghiMinhtq> getCountryList() {
		List<LoaiNgayNghiMinhtq> countryList = donNghiPhepService.listLoaiNgayNghi();
		return countryList;
	}

	// thêm một đơn nghỉ phép nháp
	@RequestMapping(value = "/taodonnghiphep/addDonNghiPhepNhap", method = RequestMethod.GET)
	public String showForm(Model model) {
		model.addAttribute("themdonnhap", new DonNghiPhepMinhtq());
		return "/QuanLyVangNghi/minhtq/donnghiphepnhap/add_form";
	}

	@RequestMapping(value = "/taodonnghiphep/addDonNghiPhepNhap", method = RequestMethod.POST)
	public String createDonNhap(Model model, @ModelAttribute("themdonnhap") @Valid DonNghiPhepMinhtq donnghiphepnhap,
			BindingResult bindingResult, final RedirectAttributes redirectAttributes)
			throws IllegalStateException, IOException {

		if (bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("messageError", "mời nhập lại!");
			return "/QuanLyVangNghi/minhtq/donnghiphepnhap/add_form";
		}

		donNghiPhepService.addDonNghiPhepNhap(donnghiphepnhap);
		redirectAttributes.addFlashAttribute("messageSuccess", "thêm thành công !");
		return "redirect:/listDonNghiPhepNhap";
	}

	// thêm một đơn nghỉ phép chờ phê duyệt
	@RequestMapping(value = "/taodonmoi/addDonNghiPhepChoPheDuyet", method = RequestMethod.POST)
	public String listDonChoDuyet(@Valid @ModelAttribute("taodonmoi") DonNghiPhepMinhtq donnghiphepduyet,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("messageError", "mời nhập lại!");
			return "/QuanLyVangNghi/minhtq/donnghiphepnhap/add_form";
		}
		donNghiPhepService.addDonNghiPhepNhap(donnghiphepduyet);;
		redirectAttributes.addFlashAttribute("messageSuccess", "thêm thành công!");
		return "redirect:/listDonNghiPhepNhap";
	}

	// tìm view đơn nghỉ phép nháp theo id
	@RequestMapping(value = "/suaDonNghiPhepNhapView/{id}", method = RequestMethod.GET)
	public String edit_ById(@PathVariable("id") int id, Model model) {
		model.addAttribute("suadonnghiphepnhap", donNghiPhepService.getByIdDonNghiPhepNhap(id));
		return "/QuanLyVangNghi/minhtq/donnghiphepnhap/edit_form";
	}

	// sửa đơn nghỉ phép nháp
	@RequestMapping(value = "/suaDonNghiPhepNhap", method = RequestMethod.POST)
	public String editDonNghiPhep(Model model, @ModelAttribute("suadonnghiphepnhap") @Valid DonNghiPhepMinhtq donnghiphep,
			BindingResult bindingResult,final RedirectAttributes redirectAttributes)
			throws SQLException, IllegalStateException, IOException {

		if (bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("messageError", "mời nhập lại!");
			return "/QuanLyVangNghi/minhtq/donnghiphepnhap/edit_form";
		}

		redirectAttributes.addFlashAttribute("messageSuccess", "sửa thành công!");
		donNghiPhepService.editDonNghiPhepNhap(donnghiphep);
		return "redirect:/listDonNghiPhepNhap";
	}

	
}
