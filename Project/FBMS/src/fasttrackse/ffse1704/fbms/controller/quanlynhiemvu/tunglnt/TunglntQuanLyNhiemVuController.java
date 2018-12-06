package fasttrackse.ffse1704.fbms.controller.quanlynhiemvu.tunglnt;

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

import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn.CongViecKhanhCN;
import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.tunglnt.TunglntCongViec;
import fasttrackse.ffse1704.fbms.service.quanlynhiemvu.tunglnt.TunglntCongViecService;

@Controller
@RequestMapping("/TunglntQuanLyNhiemVu/CongViec")
public class TunglntQuanLyNhiemVuController {
	
	TunglntCongViecService tunglntCongViecService;
	
	@Autowired
	public void setTunglntCongViecService(TunglntCongViecService tunglntCongViecService) {
		this.tunglntCongViecService = tunglntCongViecService;
	}

	@RequestMapping(value =  "/ListCongViec" , method = RequestMethod.GET)
	public String listCV(Model model) {
		List<TunglntCongViec> listCV = tunglntCongViecService.AllCV();
		model.addAttribute("list", listCV);
		return "QuanLyNhiemVu/Tunglnt/congviec/listCV";
	
	}
	
	@RequestMapping(value = "/AddCongViec", method = RequestMethod.GET)
	public String addForm(Model model) {
		model.addAttribute("congviec", new TunglntCongViec());
		model.addAttribute("trangthai", tunglntCongViecService.trangThai());
		model.addAttribute("loaicongviec", tunglntCongViecService.loaiCongViec());
		model.addAttribute("duan", tunglntCongViecService.duAn());
		model.addAttribute("nhanvien", tunglntCongViecService.nhanVien());
		return "QuanLyNhiemVu/Tunglnt/congviec/add";
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String doAdd(Model model, @ModelAttribute("CongViec") TunglntCongViec cv,
			final RedirectAttributes redirectAttributes) {
		try {
			tunglntCongViecService.addCongViec(cv);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thêm mới thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:QuanLyNhiemVu/Tunglnt/congviec/listCV";
	}
}