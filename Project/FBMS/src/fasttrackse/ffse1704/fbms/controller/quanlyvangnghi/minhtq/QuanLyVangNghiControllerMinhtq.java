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
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.TrangThaiVangNghiMinhtq;
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

	//////////////////// list 4 loại danh sách đơn nghỉ phép///////////////////
	// list toàn bộ đơn nghỉ phép nháp

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
		List<LoaiNgayNghiMinhtq> countryList = donNghiPhepService.listLoaiNgayNghi();
		model.addAttribute("countryList", countryList);
		model.addAttribute("taodonmoi", new DonNghiPhepMinhtq());
		return "/QuanLyVangNghi/minhtq/donnghiphep/add_form";
	}

	@RequestMapping(value = "/addDonNghiPhepNhap", method = RequestMethod.POST)
	public String createDonNhap(Model model, @ModelAttribute("taodonmoi") @Valid DonNghiPhepMinhtq donnghiphep,
			BindingResult bindingResult, final RedirectAttributes redirectAttributes, @RequestParam String action)
			throws IllegalStateException, IOException {

		String url = "";
		if (bindingResult.hasErrors()) {

			return "/QuanLyVangNghi/minhtq/donnghiphep/add_form";
		} else {

			if (action.equals("luunhap")) {

				donnghiphep.setTrangThai("TT1");
				donNghiPhepService.addDonNghiPhep(donnghiphep);
				redirectAttributes.addFlashAttribute("messageSuccess", "Bạn vừa thêm một đơn nghỉ phép nháp!");
				url = "redirect:/QuanLyVangNghi/minhtq/listDonNghiPhep/TT1";
			}
			if (action.equals("chopheduyet")) {

				donnghiphep.setTrangThai("TT2");
				donNghiPhepService.addDonNghiPhep(donnghiphep);
				redirectAttributes.addFlashAttribute("messageSuccess",
						"Bạn vừa thêm một đơn nghỉ phép và đang chờ duyệt!");
				url = "redirect:/QuanLyVangNghi/minhtq/listDonNghiPhep/TT2";
			}

		}
		return url;
	}

	// tìm view đơn nghỉ phép nháp theo id
	@RequestMapping(value = "/suaDonNghiPhepView/{id}", method = RequestMethod.GET)
	public String edit_ById(@PathVariable("id") int id, Model model) {
		List<LoaiNgayNghiMinhtq> countryList = donNghiPhepService.listLoaiNgayNghi();
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

				donnghiphep.setTrangThai("TT1");
				donNghiPhepService.editDonNghiPhep(donnghiphep);
				redirectAttributes.addFlashAttribute("messageSuccess", "Đã hủy gửi đơn!");
				url = "redirect:/QuanLyVangNghi/minhtq/listDonNghiPhep/TT1";
			} else {

				donnghiphep.setTrangThai("TT2");
				donNghiPhepService.editDonNghiPhep(donnghiphep);
				redirectAttributes.addFlashAttribute("messageSuccess", "Đã gửi lại đơn và đang chờ duyệt!");
				url = "redirect:/QuanLyVangNghi/minhtq/listDonNghiPhep/TT2";
			}

		}
		return url;

	}

	// Đơn chờ phê duyệt
	@RequestMapping(value = "/DonChoPheDuyet/PheDuyet/{id}", method = RequestMethod.GET)
	public String DonChoPheDuyet(@PathVariable("id") int id, final RedirectAttributes redirectAttributes)
			throws IllegalStateException, IOException {
		donNghiPhepService.getByIdDonNghiPhep(id);
	
		redirectAttributes.addFlashAttribute("messageSuccess", "Đã duyệt đơn nghỉ phép!");
		return "/QuanLyVangNghi/minhtq/listDonNghiPhep";

	}

	// xóa một đơn nghỉ phép nháp
	@RequestMapping("/deleteDonNghiPhepNhap/{id}")
	public String xoaDonNghiPhepNhap(@PathVariable int id, HttpSession session, Model model) {
		donNghiPhepService.deleteDonNghiPhep(id);
		return "redirect:/QuanLyVangNghi/minhtq/listDonNghiPhep/TT1";
	}

	// xóa một đơn nghỉ phép từ chối
	@RequestMapping("/deleteDonNghiPhepTuChoi/{id}")
	public String xoaDonNghiPhepTuChoi(@PathVariable int id, HttpSession session, Model model) {
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
	public String deletetrangthai(@PathVariable int id, Model model) {
		donNghiPhepService.deleteTrangThai(id);
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
			redirectAttributes.addFlashAttribute("messageSuccess", "Bạn vừa thêm một trạng thái!");
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
			redirectAttributes.addFlashAttribute("messageSuccess", "Bạn vừa thêm một loại ngày nghỉ!");
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
	public String deleteloaingaynghi(@PathVariable int id, Model model) {
		donNghiPhepService.deleteLoaiNgayNghi(id);
		return "redirect:/QuanLyVangNghi/minhtq/listLoaiNgayNghi";
	}

	/////////////////// hết CRUD List loại ngày nghỉ///////////////
}
