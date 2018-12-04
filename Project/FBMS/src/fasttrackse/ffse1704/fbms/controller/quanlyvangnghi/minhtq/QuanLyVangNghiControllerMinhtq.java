package fasttrackse.ffse1704.fbms.controller.quanlyvangnghi.minhtq;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	@RequestMapping(value = "/listDonNghiPhep/{trangThai}", method = RequestMethod.GET)
	public String index(@PathVariable String trangThai, Model model) {
		String trangthai= "";
		if(trangThai.equals("nhap")) {
			trangthai= "1";
		}
		if(trangThai.equals("choduyet")) {
			trangthai= "2";
		}
		if(trangThai.equals("duyet")) {
			trangthai= "3";
		}
		if(trangThai.equals("tuchoi")) {
			trangthai= "4";
		}

		List<DonNghiPhepMinhtq> list = donNghiPhepService.listDonNghiPhepNhap(trangthai);
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
	@RequestMapping(value = "/addDonNghiPhepMoi", method = RequestMethod.GET)
	public String showForm(Model model) {
		model.addAttribute("taodonmoi", new DonNghiPhepMinhtq());
		return "/QuanLyVangNghi/minhtq/donnghiphepnhap/add_form";
	}

	@RequestMapping(value = "/addDonNghiPhepNhap", method = RequestMethod.POST)
	public String createDonNhap(Model model, @ModelAttribute("taodonmoi") @Valid DonNghiPhepMinhtq donnghiphepnhap,
			BindingResult bindingResult, final RedirectAttributes redirectAttributes,@RequestParam String action)
			throws IllegalStateException, IOException {

		if (bindingResult.hasErrors()) {
			
			return "/QuanLyVangNghi/minhtq/donnghiphepnhap/add_form";
		}
		String msg = "";
	    if( action.equals("nhap") ){
	    	msg = "Lưu nháp";
	    }
	    else if( action.equals("them") ){
	    	msg = "Gửi phê duyệt";
	    }
		model.addAttribute("button", msg);
		donNghiPhepService.addDonNghiPhepNhap(donnghiphepnhap);
		redirectAttributes.addFlashAttribute("messageSuccess", "Bạn vừa thêm một đơn nghỉ phép nháp!");
		return "redirect:/QuanLyVangNghi/minhtq/listDonNghiPhep/nhap";
	}

	
	// thêm một đơn nghỉ phép chờ phê duyệt
	@RequestMapping(value = "/addDonNghiPhepChoDuyet", method = RequestMethod.POST)
	public String listDonChoDuyet(@Valid @ModelAttribute("taodonmoi") DonNghiPhepMinhtq donnghiphepduyet,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			
			return "/QuanLyVangNghi/minhtq/donnghiphepnhap/add_form";
		}
		donNghiPhepService.addDonNghiPhepNhap(donnghiphepduyet);;
		redirectAttributes.addFlashAttribute("messageSuccess", "Bạn vừa thêm một đơn nghỉ phép và đang chờ duyệt!");
		return "redirect:/QuanLyVangNghi/minhtq/listDonNghiPhep";
	}

	// tìm view đơn nghỉ phép nháp theo id
	@RequestMapping(value = "/suaDonNghiPhepView/{id}", method = RequestMethod.GET)
	public String edit_ById(@PathVariable("id") int id, Model model) {
		model.addAttribute("suadonnhap", donNghiPhepService.getByIdDonNghiPhep(id));
		return "/QuanLyVangNghi/minhtq/donnghiphepnhap/edit_form";
	}

	// sửa đơn nghỉ phép nháp
	@RequestMapping(value = "/suaDonNghiPhepNhap", method = RequestMethod.POST)
	public String editDonNghiPhepnhap(Model model, @ModelAttribute("suadonnhap") @Valid DonNghiPhepMinhtq donnghiphep,
			BindingResult bindingResult,final RedirectAttributes redirectAttributes)
			throws SQLException, IllegalStateException, IOException {

		if (bindingResult.hasErrors()) {
			
			return "/QuanLyVangNghi/minhtq/donnghiphepnhap/edit_form";
		}

		redirectAttributes.addFlashAttribute("messageSuccess", "Bạn vừa sửa thành công một đơn nghỉ phép nháp!");
		donNghiPhepService.editDonNghiPhepNhap(donnghiphep);
		return "redirect:/QuanLyVangNghi/minhtq/listDonNghiPhep/nhap";
	}

	
	@RequestMapping("/deleteDonNghiPhepNhap/{id}")
	public String deleteDonNghiPhepNhap(@PathVariable int id, HttpSession session, Model model) {
		donNghiPhepService.deleteDonNghiPhepNhap(id);
		return "redirect:/QuanLyVangNghi/minhtq/listDonNghiPhep/nhap";
	}
	
}
