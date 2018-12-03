package fasttrackse.ffse1704.fbms.controller.quanlynhiemvu.khanhcn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn.CongViecKhanhCN;
import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn.DuAnKhanhCN;
import fasttrackse.ffse1704.fbms.entity.security.ChucDanh;
import fasttrackse.ffse1704.fbms.service.quanlynhiemvu.khanhcn.QuanLyNhiemVuService;

@Controller
@RequestMapping("/QuanLyNhiemVu/cong_viec")
public class QuanLyNhiemVuController {

	@Autowired
	QuanLyNhiemVuService quanLyNhiemVuService;

	public void setQuanLyNhiemVuService(QuanLyNhiemVuService quanLyNhiemVuService) {
		this.quanLyNhiemVuService = quanLyNhiemVuService;
	}

	
	@RequestMapping(value = "/danhsachcongviec", method = RequestMethod.GET)
	public String cv(Model model) {

		List<CongViecKhanhCN> danhSachCongViec = quanLyNhiemVuService.congViec();
		model.addAttribute("list", danhSachCongViec);
		return "QuanLyNhiemVu/congviec/ListCongViec";

	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Model model, final RedirectAttributes redirectAttributes) {
		model.addAttribute("congViec", new CongViecKhanhCN());
		return "QuanLyNhiemVu/congviec/add_form";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String doAdd(Model model, @ModelAttribute("congViec") CongViecKhanhCN cv,
			final RedirectAttributes redirectAttributes) {
		try {
			quanLyNhiemVuService.addCongViec(cv);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thêm mới thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:/QuanLyNhiemVu/cong_viec/danhsachcongviec";
	}

}
