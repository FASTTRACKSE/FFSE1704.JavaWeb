package fasttrackse.ffse1704.fbms.controller.quanlythoigian;

import java.io.IOException;
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

import fasttrackse.ffse1704.fbms.entity.quanlythoigian.DuAnLogwork;
import fasttrackse.ffse1704.fbms.entity.quanlythoigian.Logwork;
import fasttrackse.ffse1704.fbms.entity.quanlythoigian.PhongBanLogwork;
import fasttrackse.ffse1704.fbms.entity.quanlythoigian.TrangThaiLogwork;
import fasttrackse.ffse1704.fbms.entity.quanlythoigian.VaiTroDuAnLogwork;
import fasttrackse.ffse1704.fbms.entity.security.ChucNang;
import fasttrackse.ffse1704.fbms.service.quanlythoigian.LogworkService;

@Controller
@RequestMapping("QuanLyThoiGian/Logwork")
public class LogworkController {
	@Autowired
	private LogworkService logworkService;

	/*
	 * @RequestMapping(value = "/list", method = RequestMethod.GET) public String
	 * viewLogwork(Model model) { List<Logwork> allLogwork =
	 * logworkService.findAll(); model.addAttribute("logwork", allLogwork); return
	 * "QuanLyThoiGian/logwork/list"; }
	 */
	@RequestMapping("/list")
	public String viewLogworkPage(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
		int totalRecords = logworkService.findAll().size();
		System.out.println(totalRecords);
		int total = 2;
		int totalPages = 0;
		if ((totalRecords / total) % 2 != 0) {
			totalPages = totalRecords / total;
		} else {
			totalPages = totalRecords / total + 1;
		}
		int star = total * (currentPage - 1);
		model.addAttribute("logwork", logworkService.findAllForPaging(star, total));
		model.addAttribute("lastPage", totalPages);
		model.addAttribute("currentPage", currentPage);
		return "QuanLyThoiGian/logwork/list";
	}

	// add
	@RequestMapping(value = "/addlogwork", method = RequestMethod.GET)
	public String addForm(Model model, final RedirectAttributes redirectAttributes) {
		List<PhongBanLogwork> listPhongBan = logworkService.listPhongBan();
		List<DuAnLogwork> listDuAn = logworkService.listDuAn();
		List<VaiTroDuAnLogwork> listVaiTroDuAn = logworkService.listVaiTroDuAn();
		model.addAttribute("logworkk", new Logwork());
		model.addAttribute("dsPhongBan", listPhongBan);
		model.addAttribute("dsDuAn", listDuAn);
		model.addAttribute("dsVaiTroDuAn", listVaiTroDuAn);
		return "QuanLyThoiGian/logwork/add_logwork";
	}

	@RequestMapping(value = "/addlogwork", method = RequestMethod.POST)
	public String doAdd(Model model, @ModelAttribute("logworkk") Logwork logwork,
			final RedirectAttributes redirectAttributes, @RequestParam String action) {
		try {
			String msg = "";
			if (action.equals("luuNhap")) {
				msg = "Đã lưu nháp";
				TrangThaiLogwork trangThaiLogwork = new TrangThaiLogwork();
				trangThaiLogwork.setMaTrangThai(4);
				logwork.setTrangThaiLogwork(trangThaiLogwork);
			} else if (action.equals("submit")) {
				msg = "Đã gửi phê duyệt";
				TrangThaiLogwork trangThaiLogwork = new TrangThaiLogwork();
				trangThaiLogwork.setMaTrangThai(1);
				logwork.setTrangThaiLogwork(trangThaiLogwork);
			} else if (action.equals("exit")) {
				return "redirect:/QuanLyThoiGian/Logwork/list";
			}
			logworkService.addNew(logwork);
			model.addAttribute("button", msg);
			redirectAttributes.addFlashAttribute("button", msg);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:/QuanLyThoiGian/Logwork/list";
	}

	// edit
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit_view(@PathVariable("id") int id, Model model) {
		List<PhongBanLogwork> listPhongBan = logworkService.listPhongBan();
		List<DuAnLogwork> listDuAn = logworkService.listDuAn();
		List<VaiTroDuAnLogwork> listVaiTroDuAn = logworkService.listVaiTroDuAn();
		model.addAttribute("dsPhongBan", listPhongBan);
		model.addAttribute("dsDuAn", listDuAn);
		model.addAttribute("dsVaiTroDuAn", listVaiTroDuAn);
		model.addAttribute("editlogwork", logworkService.findByIdLogwork(id));
		return "QuanLyThoiGian/logwork/edit_logwork";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String doEdit(Model model, @ModelAttribute("editlogwork") Logwork logwork,
			final RedirectAttributes redirectAttributes, @RequestParam String action) {
		try {
			String msg = "";
			if (action.equals("submit")) {
				msg = "Đã gửi phê duyệt";
				TrangThaiLogwork trangThaiLogwork = new TrangThaiLogwork();
				trangThaiLogwork.setMaTrangThai(1);
				logwork.setTrangThaiLogwork(trangThaiLogwork);
			} else if (action.equals("edit")) {
				msg = "Sửa thành công";
				TrangThaiLogwork trangThaiLogwork = new TrangThaiLogwork();
				trangThaiLogwork.setMaTrangThai(1);
				logwork.setTrangThaiLogwork(trangThaiLogwork);
			} else if (action.equals("exit")) {
				return "redirect:/QuanLyThoiGian/Logwork/list";
			}
			logworkService.update(logwork);
			redirectAttributes.addFlashAttribute("button", msg);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:/QuanLyThoiGian/Logwork/list";
	}

	// delete
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {
		try {
			logworkService.delete(id);
			redirectAttributes.addFlashAttribute("button", "Xóa thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại");
		}
		return "redirect:/QuanLyThoiGian/Logwork/list";
	}

}
