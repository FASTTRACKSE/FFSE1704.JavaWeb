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
	@RequestMapping(value = "/listDonNghiPhepNhap", method = RequestMethod.GET)
	public String listNhap(Model model) {

		List<DonNghiPhepMinhtq> listnhap = donNghiPhepService.listDonNghiPhepNhap();
		model.addAttribute("listnhap", listnhap);

		return "QuanLyVangNghi/minhtq/donnghiphepnhap/list";
	}

	// list toàn bộ đơn nghỉ phép chờ phê duyệt
	@RequestMapping(value = "/listDonNghiPhepChoDuyet", method = RequestMethod.GET)
	public String listChoDuyet(Model model) {

		List<DonNghiPhepMinhtq> listchoduyet = donNghiPhepService.listDonNghiPhepChoDuyet();
		model.addAttribute("listchoduyet", listchoduyet);

		return "QuanLyVangNghi/minhtq/donnghiphepchopheduyet/list";
	}

	// list toàn bộ đơn nghỉ phép đã duyêt
	@RequestMapping(value = "/listDonNghiPhepDaDuyet", method = RequestMethod.GET)
	public String listDaDuyet(Model model) {

		List<DonNghiPhepMinhtq> listdaduyet = donNghiPhepService.listDonNghiPhepDaDuyet();
		model.addAttribute("listdaduyet", listdaduyet);

		return "QuanLyVangNghi/minhtq/donnghiphepdapheduyet/list";
	}

	// list toàn bộ đơn nghỉ phép từ chối
	@RequestMapping(value = "/listDonNghiPhepTuChoi", method = RequestMethod.GET)
	public String listTuChoi(Model model) {

		List<DonNghiPhepMinhtq> listtuchoi = donNghiPhepService.listDonNghiPhepTuChoi();
		model.addAttribute("listtuchoi", listtuchoi);

		return "QuanLyVangNghi/minhtq/donnghipheptuchoi/list";
	}

	//////////////////// hết phần list 4 loại danh sách đơn nghỉ phép///////////////

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
			BindingResult bindingResult, final RedirectAttributes redirectAttributes, @RequestParam String action)
			throws IllegalStateException, IOException {

		if (bindingResult.hasErrors()) {

			return "/QuanLyVangNghi/minhtq/donnghiphepnhap/add_form";
		}

		String msg = "";
		if (action.equals("nhap")) {
			msg = "trạng thái lưu nháp";
			TrangThaiVangNghiMinhtq trangThaiNghiphep = new TrangThaiVangNghiMinhtq();
			trangThaiNghiphep.setMaTrangThai(1);
			donnghiphepnhap.setTrangThaiDNP(trangThaiNghiphep);
		} else if (action.equals("them")) {
			msg = "đang chờ phê duyệt";
			TrangThaiVangNghiMinhtq trangThaiNghiphep = new TrangThaiVangNghiMinhtq();
			trangThaiNghiphep.setMaTrangThai(2);
			donnghiphepnhap.setTrangThaiDNP(trangThaiNghiphep);
		}

		donNghiPhepService.addDonNghiPhepNhap(donnghiphepnhap);
		redirectAttributes.addFlashAttribute("messageSuccess", "Bạn vừa thêm một đơn nghỉ phép nháp!");
		redirectAttributes.addFlashAttribute("button", msg);
		return "redirect:/QuanLyVangNghi/minhtq/listDonNghiPhepNhap";
	}

	// thêm một đơn nghỉ phép chờ phê duyệt
	@RequestMapping(value = "/addDonNghiPhepChoDuyet", method = RequestMethod.POST)
	public String listDonChoDuyet(@Valid @ModelAttribute("taodonmoi") DonNghiPhepMinhtq donnghiphepduyet,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {

			return "/QuanLyVangNghi/minhtq/donnghiphepnhap/add_form";
		}
		donNghiPhepService.addDonNghiPhepNhap(donnghiphepduyet);
		;
		redirectAttributes.addFlashAttribute("messageSuccess", "Bạn vừa thêm một đơn nghỉ phép và đang chờ duyệt!");
		return "redirect:/QuanLyVangNghi/minhtq/listDonNghiPhepNhap";
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
			BindingResult bindingResult, final RedirectAttributes redirectAttributes)
			throws SQLException, IllegalStateException, IOException {

		if (bindingResult.hasErrors()) {

			return "/QuanLyVangNghi/minhtq/donnghiphepnhap/edit_form";
		}

		redirectAttributes.addFlashAttribute("messageSuccess", "Bạn vừa sửa thành công một đơn nghỉ phép nháp!");
		donNghiPhepService.editDonNghiPhepNhap(donnghiphep);
		return "redirect:/QuanLyVangNghi/minhtq/listDonNghiPhepNhap";
	}

	// xóa một đơn nghỉ phép nháp
	@RequestMapping("/deleteDonNghiPhepNhap/{id}")
	public String xoaDonNghiPhepNhap(@PathVariable int id, HttpSession session, Model model) {
		donNghiPhepService.deleteDonNghiPhep(id);
		return "redirect:/QuanLyVangNghi/minhtq/listDonNghiPhepNhap";
	}

	// xóa một đơn nghỉ phép chờ duyệt
	@RequestMapping("/deleteDonNghiPhepChoDuyet/{id}")
	public String xoaDonNghiPhepChoDuyet(@PathVariable int id, HttpSession session, Model model) {
		donNghiPhepService.deleteDonNghiPhep(id);
		return "redirect:/QuanLyVangNghi/minhtq/listDonNghiPhepChoDuyet";
	}

	// xóa một đơn nghỉ phép đã duyệt
	@RequestMapping("/deleteDonNghiPhepDuyet/{id}")
	public String xoaDonNghiPhepDaDuyet(@PathVariable int id, HttpSession session, Model model) {
		donNghiPhepService.deleteDonNghiPhep(id);
		return "redirect:/QuanLyVangNghi/minhtq/listDonNghiPhepDaDuyet";
	}

	// xóa một đơn nghỉ phép từ chối
	@RequestMapping("/deleteDonNghiPhepTuChoi/{id}")
	public String xoaDonNghiPhepTuChoi(@PathVariable int id, HttpSession session, Model model) {
		donNghiPhepService.deleteDonNghiPhep(id);
		return "redirect:/QuanLyVangNghi/minhtq/listDonNghiPhepTuChoi";
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
	
	@RequestMapping("/deleteTrangThai/{maTrangThai}")
	public String deletetrangthai(@PathVariable int maTrangThai, Model model) {
		donNghiPhepService.deleteTrangThai(maTrangThai);
		return "redirect:/QuanLyVangNghi/minhtq/listTrangThai";
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
	
	@RequestMapping("/deleteLoaiNgayNghi/{maNgayNghi}")
	public String deleteloaingaynghi(@PathVariable int maNgayNghi, Model model) {
		donNghiPhepService.deleteLoaiNgayNghi(maNgayNghi);
		return "redirect:/QuanLyVangNghi/minhtq/listLoaiNgayNghi";
	}
	
	
	/////////////////// hết CRUD List loại ngày nghỉ///////////////
}
