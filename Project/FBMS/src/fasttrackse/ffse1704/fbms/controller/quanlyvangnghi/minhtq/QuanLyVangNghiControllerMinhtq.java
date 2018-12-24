package fasttrackse.ffse1704.fbms.controller.quanlyvangnghi.minhtq;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.annotations.Parameter;
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
	// private int perPage = 2;

	public DonNghiPhepServiceMinhtq getDonNghiPhepService() {
		return donNghiPhepService;
	}

	public void setDonNghiPhepService(DonNghiPhepServiceMinhtq donNghiPhepService) {
		this.donNghiPhepService = donNghiPhepService;
	}

	// @RequestMapping("/")
	// public String view(HttpSession session) {
	// int currentPage;
	// if (session.getAttribute("page") == null) {
	// currentPage = 1;
	// } else {
	// currentPage = (int) session.getAttribute("page");
	// }
	// return "redirect:/list/" + currentPage;
	// }
	//
	// public int totalPage(int perPage) {
	// int totalPage = (int) Math.ceil((double) donNghiPhepService.count() /
	// (double) perPage);
	// return totalPage;
	// }

	// @RequestMapping("/list/{page}")
	// public String index(Model model,@PathVariable("page") int page) {
	// int start = (page - 1) * perPage;
	// List<DonNghiPhepMinhtq> list = donNghiPhepService.findAll(start, perPage);
	// model.addAttribute("list", list);
	// model.addAttribute("total", totalPage(perPage));
	// model.addAttribute("page", page);
	//
	// return "ViewSinhVien";
	// }

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

	// thêm một đơn nghỉ phép nháp và chờ phê duyệt
	@RequestMapping(value = "/addDonNghiPhepMoi", method = RequestMethod.GET)
	public String showForm(Model model) {
		model.addAttribute("taodonmoi", new DonNghiPhepMinhtq());
		return "/QuanLyVangNghi/minhtq/donnghiphepnhap/add_form";
	}

	@RequestMapping(value = "/addDonNghiPhepNhap", method = RequestMethod.POST)
	public String createDonNhap(Model model, @ModelAttribute("taodonmoi") @Valid DonNghiPhepMinhtq donnghiphep,
			BindingResult bindingResult, final RedirectAttributes redirectAttributes, @RequestParam String action)
			throws IllegalStateException, IOException {
		String url = "";
		if (bindingResult.hasErrors()) {

			return "/QuanLyVangNghi/minhtq/donnghiphepnhap/add_form";
		} else {

			if (action.equals("luunhap")) {

				donnghiphep.setTrangThai(1);
				donNghiPhepService.addDonNghiPhep(donnghiphep);
				redirectAttributes.addFlashAttribute("messageSuccess", "Bạn vừa thêm một đơn nghỉ phép nháp!");
				url = "redirect:/QuanLyVangNghi/minhtq/listDonNghiPhepNhap";
			}
			if (action.equals("chopheduyet")) {

				donnghiphep.setTrangThai(2);
				donNghiPhepService.addDonNghiPhep(donnghiphep);
				redirectAttributes.addFlashAttribute("messageSuccess",
						"Bạn vừa thêm một đơn nghỉ phép và đang chờ duyệt!");
				url = "redirect:/QuanLyVangNghi/minhtq/listDonNghiPhepChoDuyet";
			}

		}
		return url;
	}

	// tìm view đơn nghỉ phép nháp theo id
	@RequestMapping(value = "/suaDonNghiPhepView/{id}", method = RequestMethod.GET)
	public String edit_ById(@PathVariable("id") int id, Model model) {
		model.addAttribute("suadonnhap", donNghiPhepService.getByIdDonNghiPhep(id));
		return "/QuanLyVangNghi/minhtq/donnghiphepnhap/edit_form";
	}

	// sửa đơn nghỉ phép nháp
	@RequestMapping(value = "/suaDonNghiPhepNhap", method = RequestMethod.POST)
	public String editDonNghiPhepnhap(Model model, @ModelAttribute("taodonmoi") @Valid DonNghiPhepMinhtq donnghiphep,
			BindingResult bindingResult, final RedirectAttributes redirectAttributes, @RequestParam String actional)
			throws SQLException, IllegalStateException, IOException {

		String url = "";
		if (bindingResult.hasErrors()) {

			return "/QuanLyVangNghi/minhtq/donnghiphepnhap/edit_form";
		} else {

			if (actional.equals("cancel")) {

				donnghiphep.setTrangThai(1);
				donNghiPhepService.editDonNghiPhep(donnghiphep);
				redirectAttributes.addFlashAttribute("messageSuccess", "Đã hủy gửi đơn!");
				url = "redirect:/QuanLyVangNghi/minhtq/listDonNghiPhepNhap";
			} else {

				donnghiphep.setTrangThai(2);
				donNghiPhepService.editDonNghiPhep(donnghiphep);
				redirectAttributes.addFlashAttribute("messageSuccess",
						"Bạn vừa thêm một đơn nghỉ phép và đang chờ duyệt!");
				url = "redirect:/QuanLyVangNghi/minhtq/listDonNghiPhepChoDuyet";
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
		return "/QuanLyVangNghi/minhtq/listDonNghiPhepDaDuyet";

	}

	// Đơn bị từ chối
	@RequestMapping(value = "/DonChoPheDuyet/TuChoi/{id}", method = RequestMethod.GET)
	public String DonBiTuChoi(@PathVariable("id") int id, final RedirectAttributes redirectAttributes)
			throws IllegalStateException, IOException {

		redirectAttributes.addFlashAttribute("messageSuccess", "Đã duyệt đơn nghỉ phép!");
		return "/QuanLyVangNghi/minhtq/listDonNghiPhepTuChoi";

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

	// tìm view trạng thái theo id
	@RequestMapping(value = "/editViewTrangThai/{maTrangThai}", method = RequestMethod.GET)
	public String edittrangthai_ById(@PathVariable("maTrangThai") int maTrangThai, Model model) {
		model.addAttribute("suatrangthai", donNghiPhepService.getByIdTrangThai(maTrangThai));
		return "/QuanLyVangNghi/minhtq/trangthai/edit_form";
	}

	// sửa đơn nghỉ phép nháp và chờ phê duyệt
	@RequestMapping(value = "/suaTrangThai", method = RequestMethod.POST)
	public String edittrangthai(Model model, @ModelAttribute("suatrangthai") @Valid TrangThaiVangNghiMinhtq trangthai,
			BindingResult bindingResult, final RedirectAttributes redirectAttributes)
			throws SQLException, IllegalStateException, IOException {

		if (bindingResult.hasErrors()) {

			return "/QuanLyVangNghi/minhtq/trangthai/edit_form";
		} else {

			donNghiPhepService.editTrangThai(trangthai);
			redirectAttributes.addFlashAttribute("messageSuccess", "Bạn vừa thêm một trạng thái!");
			return "/QuanLyVangNghi/minhtq/listTrangThai";

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
	@RequestMapping(value = "/editViewLoaiNgayNghi/{maNgayNghi}", method = RequestMethod.GET)
	public String editngaynghi_ById(@PathVariable("maNgayNghi") int maNgayNghi, Model model) {
		model.addAttribute("sualydo", donNghiPhepService.getByIdLoaiNgayNghi(maNgayNghi));
		return "/QuanLyVangNghi/minhtq/loaingaynghi/edit_form";
	}

	// sửa đơn nghỉ phép nháp và chờ phê duyệt
	@RequestMapping(value = "/suaLoaiNgayNghi", method = RequestMethod.POST)
	public String editloaingaynghi(Model model, @ModelAttribute("sualydo") @Valid LoaiNgayNghiMinhtq loaingaynghi,
			BindingResult bindingResult, final RedirectAttributes redirectAttributes)
			throws SQLException, IllegalStateException, IOException {

		if (bindingResult.hasErrors()) {

			return "/QuanLyVangNghi/minhtq/loaingaynghi/edit_form";
		} else {

			donNghiPhepService.editLoaiNgayNghi(loaingaynghi);
			redirectAttributes.addFlashAttribute("messageSuccess", "Bạn vừa thêm một loại ngày nghỉ!");
			return "/QuanLyVangNghi/minhtq/listLoaiNgayNghi";

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

	@RequestMapping("/deleteLoaiNgayNghi/{maNgayNghi}")
	public String deleteloaingaynghi(@PathVariable int maNgayNghi, Model model) {
		donNghiPhepService.deleteLoaiNgayNghi(maNgayNghi);
		return "redirect:/QuanLyVangNghi/minhtq/listLoaiNgayNghi";
	}

	/////////////////// hết CRUD List loại ngày nghỉ///////////////
}
