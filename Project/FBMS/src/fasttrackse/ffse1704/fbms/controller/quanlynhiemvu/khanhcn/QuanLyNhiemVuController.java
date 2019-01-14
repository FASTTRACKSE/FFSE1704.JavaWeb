package fasttrackse.ffse1704.fbms.controller.quanlynhiemvu.khanhcn;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn.CongViecKhanhCN;
import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn.DuAnKhanhCN;
import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn.LoaiCongViec;
import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn.NhanVienDuAn;
import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn.TrangThaiKhanhCN;
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
		model.addAttribute("DuAn", quanLyNhiemVuService.duAn());
		model.addAttribute("NhanVien", quanLyNhiemVuService.nhanVien());
		model.addAttribute("TrangThai", quanLyNhiemVuService.trangThai());

		return "QuanLyNhiemVu/congviec/ListCongViec";

	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Model model, final RedirectAttributes redirectAttributes) {
		model.addAttribute("congViec", new CongViecKhanhCN());
		model.addAttribute("DuAn", quanLyNhiemVuService.duAn());
		model.addAttribute("LoaiCongViec", quanLyNhiemVuService.loaiCongViec());
		model.addAttribute("NhanVienDuAn", quanLyNhiemVuService.nhanVienDuAn());
		model.addAttribute("NhanVien", quanLyNhiemVuService.nhanVien());
		model.addAttribute("TrangThai", quanLyNhiemVuService.trangThai());

		return "QuanLyNhiemVu/congviec/add_form";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String doAdd(Model model, @ModelAttribute("congViec") CongViecKhanhCN cv,
			final RedirectAttributes redirectAttributes) {

		quanLyNhiemVuService.addCongViec(cv);

		try {

			redirectAttributes.addFlashAttribute("messageSuccess", "Thêm mới thành công.");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}

		return "redirect:/QuanLyNhiemVu/cong_viec/danhsachcongviec";
	}

	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public String view(@PathVariable("id") int id, Model model) {
		List<DuAnKhanhCN> duAnKhanhCNs = quanLyNhiemVuService.duAn();
		List<LoaiCongViec> loaiCongViecs = quanLyNhiemVuService.loaiCongViec();
		List<NhanVienDuAn> nhanVienDuAns = quanLyNhiemVuService.nhanVienDuAn();
		List<TrangThaiKhanhCN> trangThaiKhanhCNs = quanLyNhiemVuService.trangThai();
		model.addAttribute("congViec", quanLyNhiemVuService.findByID(id));
		model.addAttribute("maDuAn", duAnKhanhCNs);
		model.addAttribute("maLoaiCongViec", loaiCongViecs);
		model.addAttribute("nhanVienDuAn", nhanVienDuAns);
		model.addAttribute("NhanVien", quanLyNhiemVuService.nhanVien());
		model.addAttribute("trangThai", trangThaiKhanhCNs);
		return "QuanLyNhiemVu/congviec/viewOne";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editForm(@PathVariable("id") int id, Model model) {
		List<DuAnKhanhCN> duAnKhanhCNs = quanLyNhiemVuService.duAn();
		List<LoaiCongViec> loaiCongViecs = quanLyNhiemVuService.loaiCongViec();
		List<NhanVienDuAn> nhanVienDuAns = quanLyNhiemVuService.nhanVienDuAn();
		List<TrangThaiKhanhCN> trangThaiKhanhCNs = quanLyNhiemVuService.trangThai();
		model.addAttribute("congViec", quanLyNhiemVuService.findByID(id));
		model.addAttribute("maDuAn", duAnKhanhCNs);
		model.addAttribute("maLoaiCongViec", loaiCongViecs);
		model.addAttribute("nhanVienDuAn", nhanVienDuAns);
		model.addAttribute("NhanVien", quanLyNhiemVuService.nhanVien());
		model.addAttribute("trangThai", trangThaiKhanhCNs);
		return "QuanLyNhiemVu/congviec/edit_form";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String doEdit(Model model, @ModelAttribute("congViec") CongViecKhanhCN cv,
			final RedirectAttributes redirectAttributes) {
		try {
			quanLyNhiemVuService.updateCongViec(cv);
			redirectAttributes.addFlashAttribute("messageSuccess", "Update thành công");
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

	@RequestMapping(value = "/xemds", method = RequestMethod.GET)
	public String submit(@RequestParam("maDuAn") String maDuAn, @RequestParam("maNV") String maNhanVien,
			@RequestParam("maTrangThai") String TT, Model model) {
		model.addAttribute("DuAn", quanLyNhiemVuService.duAn());
		model.addAttribute("NhanVien", quanLyNhiemVuService.nhanVien());
		model.addAttribute("TrangThai", quanLyNhiemVuService.trangThai());
		int maTrangThai = Integer.parseInt(TT);

		if (maNhanVien.equals("KO") && maTrangThai == 0) {
			model.addAttribute("danhsach", quanLyNhiemVuService.timTheoMaDuAn(maDuAn));
		} else if (maDuAn.equals("KO") && maTrangThai == 0) {
			model.addAttribute("danhsach", quanLyNhiemVuService.timtheoMaNhanVien(maNhanVien));
		} else if (maDuAn.equals("KO") && maNhanVien.equals("KO")) {
			model.addAttribute("danhsach", quanLyNhiemVuService.timtheoMaTrangThai(maTrangThai));
		} else if (maDuAn.equals("KO")) {
			model.addAttribute("danhsach",
					quanLyNhiemVuService.timTheoMaNhanVienvaMaTrangThai(maNhanVien, maTrangThai));
		} else if (maNhanVien.equals("KO")) {
			model.addAttribute("danhsach", quanLyNhiemVuService.timTheoMaDuAnvaMaTrangThai(maDuAn, maTrangThai));
		} else if (maTrangThai == 0) {
			model.addAttribute("danhsach", quanLyNhiemVuService.timTheoMaDuAnvaMaNhanVien(maDuAn, maNhanVien));
		} else {
			model.addAttribute("danhsach",
					quanLyNhiemVuService.timTheoMaDuAnvaMaNhanVienvaMaTrangThai(maDuAn, maNhanVien, maTrangThai));
		}
		return "QuanLyNhiemVu/congviec/listCongViecTheoTieuChi";
	}

	@RequestMapping(value = "selectNhanVien/{maDAn}", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String selectDSNV(@PathVariable("maDAn") String maDuAn, HttpServletResponse res) {
		List<NhanVienDuAn> listCV = quanLyNhiemVuService.timNhanVienTheoDuAn(maDuAn);

		String json = "[";

		for (int i = 0; i < listCV.size(); i++) {
			String ho = listCV.get(i).getNhanVienKhanhCN().getHoDem();
			String ten = listCV.get(i).getNhanVienKhanhCN().getTen();
			String hoTen = ho + " " + ten;
			if (i == listCV.size() - 1) {
				json += "{\"maNguoiDuocPhanCong\":" + "\"" + listCV.get(i).getMaNhanVien() + "\""
						+ ", \"tenNguoiDuocPhanCong\" :" + "\"" + hoTen + "\"" + "}";
			} else {
				json += "{\"maNguoiDuocPhanCong\":" + "\"" + listCV.get(i).getMaNhanVien() + "\""
						+ ", \"tenNguoiDuocPhanCong\" :" + "\"" + hoTen + "\"" + "},";
			}
		}
		json += "]";

		return json;

	}

	@RequestMapping(value = "selectNhanVienView/{maDAn}", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String selectDSNVView(@PathVariable("maDAn") String maDuAn, HttpServletResponse res) {
		List<CongViecKhanhCN> listCV = quanLyNhiemVuService.timTheoMaDuAn(maDuAn);

		String json = "[";

		for (int i = 0; i < listCV.size(); i++) {
			String ho = listCV.get(i).getNhanVienDuAn().getNhanVienKhanhCN().getHoDem();
			String ten = listCV.get(i).getNhanVienDuAn().getNhanVienKhanhCN().getTen();
			String hoTen = ho + " " + ten;
			if (i == listCV.size() - 1) {
				json += "{\"maNguoiDuocPhanCong\":" + "\"" + listCV.get(i).getNguoiPhanCong() + "\""
						+ ", \"tenNguoiDuocPhanCong\" :" + "\"" + hoTen + "\"" + "}";
			} else {
				json += "{\"maNguoiDuocPhanCong\":" + "\"" + listCV.get(i).getNguoiPhanCong() + "\""
						+ ", \"tenNguoiDuocPhanCong\" :" + "\"" + hoTen + "\"" + "},";
			}
		}
		json += "]";

		return json;

	}

	@RequestMapping(value = "/dscalendar", method = RequestMethod.GET)
	public String calendar(Model model) {
		return "/QuanLyNhiemVu/congviec/calendar";
	}

}
