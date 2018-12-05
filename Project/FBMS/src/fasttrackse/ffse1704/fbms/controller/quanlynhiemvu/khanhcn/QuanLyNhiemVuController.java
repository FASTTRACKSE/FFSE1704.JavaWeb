package fasttrackse.ffse1704.fbms.controller.quanlynhiemvu.khanhcn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn.CongViecKhanhCN;
import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn.DuAnKhanhCN;
import fasttrackse.ffse1704.fbms.entity.security.ChucDanh;
import fasttrackse.ffse1704.fbms.entity.security.ChucNang;
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

		model.addAttribute("DuAn", quanLyNhiemVuService.duAn());
		model.addAttribute("LoaiCongViec", quanLyNhiemVuService.loaiCongViec());
		model.addAttribute("NhanVien", quanLyNhiemVuService.nhanVien());
		model.addAttribute("TrangThai", quanLyNhiemVuService.trangThai());

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

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editForm(@PathVariable("id") int id, Model model) {
		model.addAttribute("congViec", quanLyNhiemVuService.findByID(id));
		return "QuanLyNhiemVu/congviec/edit_form";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String doEdit(Model model, @ModelAttribute("congViec") CongViecKhanhCN cv,
			final RedirectAttributes redirectAttributes) {
		try {
			quanLyNhiemVuService.updateCongViec(cv);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:/QuanLyNhiemVu/cong_viec/danhsachcongviec";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {
		try {
			quanLyNhiemVuService.deleteCongViec(id);
			;
			redirectAttributes.addFlashAttribute("messageSuccess", "Xóa thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại");
		}
		return "redirect:/QuanLyNhiemVu/cong_viec/danhsachcongviec";
	}

}
