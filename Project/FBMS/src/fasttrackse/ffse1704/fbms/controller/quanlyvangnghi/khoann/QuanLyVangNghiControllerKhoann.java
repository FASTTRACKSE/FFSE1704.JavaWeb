package fasttrackse.ffse1704.fbms.controller.quanlyvangnghi.khoann;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.khoann.DonNghiPhepKhoann;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.khoann.LoaiHinhNghiPhepKhoann;
import fasttrackse.ffse1704.fbms.entity.security.ChucDanh;
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
	
	
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String themDon(Model model) {
		model.addAttribute("themDon", new DonNghiPhepKhoann());
		return "QuanLyVangNghi/khoann/donnghiphep/add_form";
		
	}
	
	@RequestMapping(value = "/luunhap", method = RequestMethod.POST)
	public String doAdd(Model model, @ModelAttribute("themDon") DonNghiPhepKhoann hs,
			final RedirectAttributes redirectAttributes) {
		try {
			donNghiPhepService.themDon(hs);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thêm mới thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:quanlyvangnghi/khoann/list";
	}
	
	@RequestMapping(value = "/sua/{maNhanVien}", method = RequestMethod.GET)
	public String editForm(@PathVariable("maNhanVien") int maNhanVien, Model model) {
		model.addAttribute("suaDon", donNghiPhepService.getNhanVienByID(maNhanVien));
		return "QuanLyVangNghi/khoann/donnghiphep/edit_form";
	}

	@RequestMapping(value = "/sua/luu", method = RequestMethod.POST)
	public String doEdit(Model model, @ModelAttribute("suaDon") DonNghiPhepKhoann hs,
			final RedirectAttributes redirectAttributes) {
		try {
			donNghiPhepService.suaDon(hs);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:/quanlyvangnghi/khoann/list";
	}
	
	@ModelAttribute("lydo")
	public List<LoaiHinhNghiPhepKhoann> danhSachLyDo() {
		return this.donNghiPhepService.danhSachLyDo();
	}

}
