package fasttrackse.ffse1704.fbms.controller.quanlyvangnghi.minhtq;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.HoSoNhanVienMinhtq;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.LoaiNgayNghiMinhtq;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.PhongBanMinhtq;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.SoNgayNghiMinhtq;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.TrangThaiVangNghiMinhtq;
import fasttrackse.ffse1704.fbms.entity.security.CustomUserDetail;
import fasttrackse.ffse1704.fbms.entity.security.HoSoNhanVien;
import fasttrackse.ffse1704.fbms.service.quanlyvangnghi.minhtq.DonNghiPhepServiceMinhtq;
import fasttrackse.ffse1704.fbms.service.quanlyvangnghi.minhtq.SoNgayNghiPhepServiceMinhtq;

@Controller
@RequestMapping("/QuanLyVangNghi/minhtq")
public class QuanLyVangNghiControllerMinhtq {
	HoSoNhanVien userLogin;

	@PostConstruct
	public void initialize() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			userLogin = ((CustomUserDetail) auth.getPrincipal()).getUser().getNhanVien();
		}
	}

	@Autowired
	private DonNghiPhepServiceMinhtq donNghiPhepService;

	public DonNghiPhepServiceMinhtq getDonNghiPhepService() {
		return donNghiPhepService;
	}

	public void setDonNghiPhepService(DonNghiPhepServiceMinhtq donNghiPhepService) {
		this.donNghiPhepService = donNghiPhepService;
	}

	@Autowired
	private SoNgayNghiPhepServiceMinhtq soNgayNghiService;

	//////////////////// list 4 loại danh sách đơn nghỉ phép///////////////////
	// list toàn bộ đơn nghỉ phép nháp

	public SoNgayNghiPhepServiceMinhtq getSoNgayNghiService() {
		return soNgayNghiService;
	}

	public void setSoNgayNghiService(SoNgayNghiPhepServiceMinhtq soNgayNghiService) {
		this.soNgayNghiService = soNgayNghiService;
	}

	@RequestMapping(value = "/listDonNghiPhep/{idTT}", method = RequestMethod.GET)
	public String listNhap(Model model, @PathVariable("idTT") String idTT,
			@RequestParam(name = "page", required = false, defaultValue = "1") int Page) {
		int totalRecords = donNghiPhepService.listAllDonNghiPhep(idTT).size();

		int perPage = 3;
		int totalPages = 0;

		if ((totalRecords / perPage) % 2 == 0) {
			totalPages = totalRecords / perPage;
		} else if ((totalRecords / perPage) % 2 != 0 && totalRecords != perPage) {
			totalPages = totalRecords / perPage + 1;
		} else if (totalRecords == perPage) {
			totalPages = 1;
		}

		int start = perPage * (Page - 1);

		model.addAttribute("listdonnghiphep", donNghiPhepService.listDonNghiPhep(start, perPage, idTT));
		model.addAttribute("lastPage", totalPages);
		model.addAttribute("currentPage", Page);

		return "QuanLyVangNghi/minhtq/donnghiphep/list";
	}

	// xem thông tin một đơn nghỉ phép
	@RequestMapping(value = "/readDNP/{id}", method = RequestMethod.GET)
	public String xemDonNghiPhep(Model model, @PathVariable("id") int id) {
		model.addAttribute("thongtindonnghiphep", donNghiPhepService.read(id));

		return "/QuanLyVangNghi/minhtq/donnghiphep/read";
	}

	//////////////////// hết phần list 4 loại danh sách đơn nghỉ phép///////////////

	// thêm một đơn nghỉ phép nháp và chờ phê duyệt
	@RequestMapping(value = "/addDonNghiPhepMoi", method = RequestMethod.GET)
	public String showForm(Model model) {
		// String maNhanVien = userLogin.getMaNhanVien();
		List<LoaiNgayNghiMinhtq> countryList = donNghiPhepService.listLoaiNgayNghi();
		List<PhongBanMinhtq> phongban = donNghiPhepService.listPhongBan();
		List<HoSoNhanVienMinhtq> manhanvien = donNghiPhepService.listMaNhanVien();
		List<SoNgayNghiMinhtq> songaynghi = soNgayNghiService.listSoNgayNghi();

		model.addAttribute("songaynghi", songaynghi);
		model.addAttribute("manhanvien", manhanvien);
		model.addAttribute("countryList", countryList);
		model.addAttribute("phongban", phongban);
		model.addAttribute("taodonmoi", new DonNghiPhepMinhtq());
		return "/QuanLyVangNghi/minhtq/donnghiphep/add_form";
	}

	@RequestMapping(value = "/addDonNghiPhepNhap", method = RequestMethod.POST)
	public String createDonNhap(Model model, @ModelAttribute("taodonmoi") @Valid DonNghiPhepMinhtq donnghiphep,
			BindingResult bindingResult, final RedirectAttributes redirectAttributes, @RequestParam String action)
			throws IllegalStateException, IOException {
		int songayconlai;
		int tongsongayduocnghi;
		int tongsongaydanghi;
		int soluong;
		String url = "";

		String maNhanVien = donnghiphep.getMaNhanVien();
		String maNgayNghi = donnghiphep.getLoaiNgayNghi();
		soluong = donnghiphep.getSoLuong();

		SoNgayNghiMinhtq soNN = soNgayNghiService.getNgayNghi(maNhanVien, maNgayNghi);
		tongsongayduocnghi = soNN.getTongNgayDuocNghi();
		tongsongaydanghi = soNN.getSoNgayDaNghi();
		songayconlai = tongsongayduocnghi - tongsongaydanghi;

		if (bindingResult.hasErrors()) {

			return "/QuanLyVangNghi/minhtq/donnghiphep/add_form";
		} else {

			if (action.equals("luunhap")) {

				donnghiphep.setTrangThai("TT1");
				donNghiPhepService.addDonNghiPhep(donnghiphep);
				redirectAttributes.addFlashAttribute("messageSuccess", "Đã lưu nháp!");
				url = "redirect:/QuanLyVangNghi/minhtq/listDonNghiPhep/TT1";
			}
			if (soluong > tongsongayduocnghi) {
				List<LoaiNgayNghiMinhtq> countryList = donNghiPhepService.listLoaiNgayNghi();
				List<PhongBanMinhtq> phongban = donNghiPhepService.listPhongBan();
				List<HoSoNhanVienMinhtq> manhanvien = donNghiPhepService.listMaNhanVien();
				SoNgayNghiMinhtq songaynghi = soNgayNghiService.getNgayNghi(maNhanVien, maNgayNghi);

				model.addAttribute("songayconlai", songayconlai);
				model.addAttribute("songaynghi", songaynghi);
				model.addAttribute("manhanvien", manhanvien);
				model.addAttribute("countryList", countryList);
				model.addAttribute("phongban", phongban);
				model.addAttribute("taodonmoi", new DonNghiPhepMinhtq());
				model.addAttribute("attenion", " Error : Bạn không thể nghỉ quá số ngày quy định , mời nhập lại !");
				return "/QuanLyVangNghi/minhtq/donnghiphep/add_form";
			} else {
				if (action.equals("chopheduyet")) {

					donnghiphep.setTrangThai("TT2");
					donNghiPhepService.addDonNghiPhep(donnghiphep);
					redirectAttributes.addFlashAttribute("messageSuccess",
							"Bạn vừa thêm một đơn nghỉ phép và đang chờ duyệt !");
					url = "redirect:/QuanLyVangNghi/minhtq/listDonNghiPhep/TT2";
				}
			}
		}
		return url;
	}

	// tìm view đơn nghỉ phép nháp theo id
	@RequestMapping(value = "/suaDonNghiPhepView/{id}", method = RequestMethod.GET)
	public String edit_ById(@PathVariable("id") int id, Model model) {
		List<LoaiNgayNghiMinhtq> countryList = donNghiPhepService.listLoaiNgayNghi();
		List<PhongBanMinhtq> phongban = donNghiPhepService.listPhongBan();
		List<HoSoNhanVienMinhtq> maNhanvien = donNghiPhepService.listMaNhanVien();

		model.addAttribute("manhanvien", maNhanvien);
		model.addAttribute("phongban", phongban);
		model.addAttribute("countryList", countryList);
		model.addAttribute("suadonnhap", donNghiPhepService.getByIdDonNghiPhep(id));

		return "/QuanLyVangNghi/minhtq/donnghiphep/edit_form";
	}

	// sửa đơn nghỉ phép nháp
	@RequestMapping(value = "/suaDonNghiPhepNhap", method = RequestMethod.POST)
	public String editDonNghiPhepnhap(Model model, @ModelAttribute("taodonmoi") @Valid DonNghiPhepMinhtq donnghiphep,
			BindingResult bindingResult, final RedirectAttributes redirectAttributes, @RequestParam String actional)
			throws SQLException, IllegalStateException, IOException {

		String url = "";
		if (bindingResult.hasErrors()) {

			return "/QuanLyVangNghi/minhtq/donnghiphep/edit_form";
		} else {

			if (actional.equals("cancel")) {

				redirectAttributes.addFlashAttribute("messageSuccess", "Đã hủy gửi đơn!");
				url = "redirect:/QuanLyVangNghi/minhtq/listDonNghiPhep/TT1";
			}
			if (actional.equals("chopheduyet")) {

				donnghiphep.setTrangThai("TT2");
				donNghiPhepService.editDonNghiPhep(donnghiphep);
				redirectAttributes.addFlashAttribute("messageSuccess", "Đã gửi lại đơn và đang chờ duyệt!");
				url = "redirect:/QuanLyVangNghi/minhtq/listDonNghiPhep/TT2";

			}

		}
		return url;

	}

	// chuyển Đơn chờ phê duyệt thành phê duyệt hoặc từ chối
	@RequestMapping(value = "/viewPheDuyetDon/{id}", method = RequestMethod.GET)
	public String DonChoPheDuyet(@PathVariable("id") int id, Model model) {
		List<LoaiNgayNghiMinhtq> countryList = donNghiPhepService.listLoaiNgayNghi();
		List<PhongBanMinhtq> phongban = donNghiPhepService.listPhongBan();
		List<HoSoNhanVienMinhtq> maNhanvien = donNghiPhepService.listMaNhanVien();

		model.addAttribute("manhanvien", maNhanvien);
		model.addAttribute("phongban", phongban);
		model.addAttribute("countryList", countryList);
		model.addAttribute("pheduyetdon", donNghiPhepService.getByIdDonNghiPhep(id));
		return "/QuanLyVangNghi/minhtq/donnghiphep/pheduyet_form";

	}

	@RequestMapping(value = "/pheDuyetDon", method = RequestMethod.POST)
	public String DonTuChoi(Model model, @ModelAttribute("pheduyetdon") @Valid DonNghiPhepMinhtq donnghiphep,
			BindingResult bindingResult, final RedirectAttributes redirectAttributes, @RequestParam String action)
			throws IllegalStateException, IOException {

		String url = "";

		if (bindingResult.hasErrors()) {

			return "/QuanLyVangNghi/minhtq/donnghiphep/pheduyet_form";
		} else {

			if (action.equals("duyetdon")) {
				String maNhanVien = donnghiphep.getMaNhanVien();
				String maNgayNghi = donnghiphep.getLoaiNgayNghi();
				int soNgayDaNghi = donnghiphep.getSoLuong();
				boolean check = soNgayNghiService.chekSongayNghi(maNhanVien, maNgayNghi);
				SoNgayNghiMinhtq snn = soNgayNghiService.getNgayNghi(maNhanVien, maNgayNghi);
				int soNgayDaNghiCu = snn.getSoNgayDaNghi();
				if (check) {
					int SoNgayDaNghiMoi = soNgayDaNghiCu + soNgayDaNghi;
					soNgayNghiService.addSNN(maNhanVien, maNgayNghi, SoNgayDaNghiMoi);
					donnghiphep.setTrangThai("TT3");
					donNghiPhepService.editDonNghiPhep(donnghiphep);
					redirectAttributes.addFlashAttribute("messageSuccess", "Đã duyệt đơn!");
				} else {

					soNgayNghiService.addSNN(maNhanVien, maNgayNghi, soNgayDaNghi);

					donnghiphep.setTrangThai("TT3");
					donNghiPhepService.editDonNghiPhep(donnghiphep);
					redirectAttributes.addFlashAttribute("messageSuccess", "Đã duyệt đơn!");
				}
				return "redirect:/QuanLyVangNghi/minhtq/listDonNghiPhep/TT3";
			}
			if (action.equals("tuchoi")) {

				donnghiphep.setTrangThai("TT4");
				donNghiPhepService.editDonNghiPhep(donnghiphep);
				redirectAttributes.addFlashAttribute("messageSuccess", "Đã từ chối đơn nghỉ phép!");
				url = "redirect:/QuanLyVangNghi/minhtq/listDonNghiPhep/TT4";
			}

		}
		return url;

	}

	// xóa một đơn nghỉ phép nháp
	@RequestMapping("/deleteDonNghiPhepNhap/{id}")
	public String xoaDonNghiPhepNhap(@PathVariable int id, HttpSession session, Model model,
			final RedirectAttributes redirectAttributes) {
		donNghiPhepService.deleteDonNghiPhep(id);
		redirectAttributes.addFlashAttribute("messageSuccess", "Đã xóa một đơn nghỉ phép !");
		return "redirect:/QuanLyVangNghi/minhtq/listDonNghiPhep/TT1";
	}

	// xóa một đơn nghỉ phép từ chối
	@RequestMapping("/deleteDonNghiPhepTuChoi/{id}")
	public String xoaDonNghiPhepTuChoi(@PathVariable int id, HttpSession session, Model model,
			final RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("messageSuccess", "Đã xóa một đơn nghỉ phép !");
		donNghiPhepService.deleteDonNghiPhep(id);
		return "redirect:/QuanLyVangNghi/minhtq/listDonNghiPhep/TT4";
	}

	/////////////////// CRUD List trạng thái///////////////

	// list trạng thái

	@RequestMapping(value = "/listTrangThai", method = RequestMethod.GET)
	public String listTrangThai(Model model) {

		List<TrangThaiVangNghiMinhtq> listtrangthai = donNghiPhepService.listAllTrangThai();
		model.addAttribute("listtrangthai", listtrangthai);

		return "QuanLyVangNghi/minhtq/trangthai/list";
	}

	// thêm một trạng thái
	@RequestMapping(value = "/addTrangThaiMoi", method = RequestMethod.GET)
	public String showADDTrangThai(Model model) {
		model.addAttribute("taomoitrangthai", new TrangThaiVangNghiMinhtq());
		return "/QuanLyVangNghi/minhtq/trangthai/add_form";
	}

	@RequestMapping(value = "/addTrangThai", method = RequestMethod.POST)
	public String createTrangThai(Model model,
			@ModelAttribute("taomoitrangthai") @Valid TrangThaiVangNghiMinhtq trangthai, BindingResult bindingResult,
			final RedirectAttributes redirectAttributes) throws IllegalStateException, IOException {

		if (bindingResult.hasErrors()) {
			return "/QuanLyVangNghi/minhtq/trangthai/add_form";
		}

		donNghiPhepService.addTrangThai(trangthai);
		redirectAttributes.addFlashAttribute("messageSuccess", "Bạn vừa thêm một trạng thái!");
		return "redirect:/QuanLyVangNghi/minhtq/listTrangThai";
	}

	// xóa trạng thái
	@RequestMapping("/deleteTrangThai/{id}")
	public String deletetrangthai(@PathVariable int id, final RedirectAttributes redirectAttributes) {
		donNghiPhepService.deleteTrangThai(id);
		redirectAttributes.addFlashAttribute("messageSuccess", "Đã xóa Một trang thái!");
		return "redirect:/QuanLyVangNghi/minhtq/listTrangThai";
	}

	// tìm view trạng thái theo id
	@RequestMapping(value = "/editViewTrangThai/{id}", method = RequestMethod.GET)
	public String edittrangthai_ById(@PathVariable("id") int id, Model model) {

		model.addAttribute("suatrangthai", donNghiPhepService.getByIdTrangThai(id));

		return "/QuanLyVangNghi/minhtq/trangthai/edit_form";
	}

	// sửa đơn nghỉ phép nháp và chờ phê duyệt
	@RequestMapping(value = "/editViewTrangThai/{id}", method = RequestMethod.POST)
	public String edittrangthai(Model model, @ModelAttribute("suatrangthai") @Valid TrangThaiVangNghiMinhtq trangthai,
			BindingResult bindingResult, final RedirectAttributes redirectAttributes)
			throws SQLException, IllegalStateException, IOException {

		if (bindingResult.hasErrors()) {

			return "QuanLyVangNghi/minhtq/trangthai/edit_form";
		} else {

			donNghiPhepService.editTrangThai(trangthai);
			redirectAttributes.addFlashAttribute("messageSuccess", "Đã sửa một trạng thái!");
			return "redirect:/QuanLyVangNghi/minhtq/listTrangThai";

		}

	}

	/////////////////// hết CRUD List trạng thái///////////////

	/////////////////// CRUD List loại ngày nghỉ///////////////
	// list loại ngày nghỉ
	@RequestMapping(value = "/listLoaiNgayNghi", method = RequestMethod.GET)
	public String listLoaiNgayNghi(Model model) {

		List<LoaiNgayNghiMinhtq> listloaingaynghi = donNghiPhepService.listLoaiNgayNghi();
		model.addAttribute("listloaingaynghi", listloaingaynghi);

		return "QuanLyVangNghi/minhtq/loaingaynghi/list";
	}

	// tìm view loại nghỉ phép theo id
	@RequestMapping(value = "/editViewLoaiNgayNghi/{id}", method = RequestMethod.GET)
	public String editngaynghi_ById(@PathVariable("id") int id, Model model) {
		model.addAttribute("suamoilydo", donNghiPhepService.getByIdLoaiNgayNghi(id));
		return "/QuanLyVangNghi/minhtq/loaingaynghi/edit_form";
	}

	// sửa đơn nghỉ phép nháp và chờ phê duyệt
	@RequestMapping(value = "/editViewLoaiNgayNghi/{id}", method = RequestMethod.POST)
	public String editloaingaynghi(Model model, @ModelAttribute("suamoilydo") @Valid LoaiNgayNghiMinhtq loaingaynghi,
			BindingResult bindingResult, final RedirectAttributes redirectAttributes)
			throws SQLException, IllegalStateException, IOException {

		if (bindingResult.hasErrors()) {

			return "/QuanLyVangNghi/minhtq/loaingaynghi/edit_form";
		} else {

			donNghiPhepService.editLoaiNgayNghi(loaingaynghi);
			redirectAttributes.addFlashAttribute("messageSuccess", "Đã sửa một loại ngày nghỉ!");
			return "redirect:/QuanLyVangNghi/minhtq/listLoaiNgayNghi";

		}

	}

	// thêm một loại ngày nghỉ
	@RequestMapping(value = "/addLoaiNgayNghiMoi", method = RequestMethod.GET)
	public String showADDLoaiNgayNghi(Model model) {
		model.addAttribute("taomoilydo", new LoaiNgayNghiMinhtq());
		return "/QuanLyVangNghi/minhtq/loaingaynghi/add_form";
	}

	@RequestMapping(value = "/addLoaiNgayNghi", method = RequestMethod.POST)
	public String createLoaiNgayNghi(Model model, @ModelAttribute("taomoilydo") @Valid LoaiNgayNghiMinhtq loaingaynghi,
			BindingResult bindingResult, final RedirectAttributes redirectAttributes)
			throws IllegalStateException, IOException {

		if (bindingResult.hasErrors()) {
			return "/QuanLyVangNghi/minhtq/loaingaynghi/add_form";
		}

		donNghiPhepService.addLoaiNgayNghi(loaingaynghi);
		redirectAttributes.addFlashAttribute("messageSuccess", "Bạn vừa thêm một loại ngày nghỉ!");
		return "redirect:/QuanLyVangNghi/minhtq/listLoaiNgayNghi";
	}

	@RequestMapping("/deleteLoaiNgayNghi/{id}")
	public String deleteloaingaynghi(@PathVariable int id, Model model, final RedirectAttributes redirectAttributes) {
		donNghiPhepService.deleteLoaiNgayNghi(id);
		redirectAttributes.addFlashAttribute("messageSuccess", "Đã xóa một trạng thái!");
		return "redirect:/QuanLyVangNghi/minhtq/listLoaiNgayNghi";
	}

	/////////////////// hết CRUD List loại ngày nghỉ///////////////
}
