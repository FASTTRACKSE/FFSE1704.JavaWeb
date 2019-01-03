package fasttrackse.ffse1704.fbms.controller.quanlythoigian;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import fasttrackse.ffse1704.fbms.entity.quanlythoigian.DuAnLogwork;
import fasttrackse.ffse1704.fbms.entity.quanlythoigian.Logwork;
import fasttrackse.ffse1704.fbms.entity.quanlythoigian.NhanVienLogwork;
import fasttrackse.ffse1704.fbms.entity.quanlythoigian.PhongBanLogwork;
import fasttrackse.ffse1704.fbms.entity.quanlythoigian.TrangThaiLogwork;
import fasttrackse.ffse1704.fbms.entity.quanlythoigian.VaiTroDuAnLogwork;
import fasttrackse.ffse1704.fbms.service.quanlythoigian.LogworkService;

@Controller
@RequestMapping("QuanLyThoiGian/Logwork")
public class LogworkController {
	@Autowired
	private LogworkService logworkService;

	// list all
	@RequestMapping("/list")
	public String viewLogworkPage(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
		int totalRecords = logworkService.findAll().size();
		int total = 10;
		int totalPages = 0;
		if ((totalRecords / total) % 2 == 0) {
			totalPages = totalRecords / total;
		} else if ((totalRecords / total) % 2 != 0 && totalRecords != total) {
			totalPages = totalRecords / total + 1;
		} else if (totalRecords == total) {
			totalPages = 1;
		}
		int star = total * (currentPage - 1);
		model.addAttribute("logwork", logworkService.findAllForPaging(star, total));
		model.addAttribute("lastPage", totalPages);
		model.addAttribute("currentPage", currentPage);
		return "QuanLyThoiGian/logwork/list";
	}

	// list all where month
	@RequestMapping(value = "/listMonth/{month}")
	public String viewMonth(@PathVariable("month") String month, Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
		int totalRecords = logworkService.listAllMonth(month).size();
		int total = 10;
		int totalPages = 0;
		if ((totalRecords / total) % 2 == 0) {
			totalPages = totalRecords / total;
		} else if ((totalRecords / total) % 2 != 0 && totalRecords != total) {
			totalPages = totalRecords / total + 1;
		} else if (totalRecords == total) {
			totalPages = 1;
		}
		int star = total * (currentPage - 1);
		model.addAttribute("listMonth", logworkService.listMonth(star, total, month));
		model.addAttribute("lastPage", totalPages);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("thang", month);
		return "QuanLyThoiGian/logwork/listmonth";
	}

	// view one
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public String viewLogwork(@PathVariable("id") int id, Model model) {
		model.addAttribute("viewLogwork", logworkService.findByIdLogwork(id));
		return "QuanLyThoiGian/logwork/viewOne";
	}

	// add
	@RequestMapping(value = "/addlogwork", method = RequestMethod.GET)
	public String addForm(Model model, final RedirectAttributes redirectAttributes) {
		List<PhongBanLogwork> listPhongBan = logworkService.listPhongBan();
		List<DuAnLogwork> listDuAn = logworkService.listDuAn();
		List<NhanVienLogwork> listNhanVien = logworkService.listNhanVien();
		List<VaiTroDuAnLogwork> listVaiTroDuAn = logworkService.listVaiTroDuAn();

		Date startDate = new Date();
		LocalDate date = java.time.LocalDate.now();
		LocalTime time = java.time.LocalTime.now();
		long h = startDate.getHours();
		long m = startDate.getMinutes();
		model.addAttribute("logworkk", new Logwork());
		model.addAttribute("dsPhongBan", listPhongBan);
		model.addAttribute("dsDuAn", listDuAn);
		model.addAttribute("dsVaiTroDuAn", listVaiTroDuAn);
		model.addAttribute("dsNhanVien", listNhanVien);
		model.addAttribute("time", date + " " + h + ":" + m);
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
				trangThaiLogwork.setMaTrangThai(5);
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
		List<NhanVienLogwork> listNhanVien = logworkService.listNhanVien();
		List<VaiTroDuAnLogwork> listVaiTroDuAn = logworkService.listVaiTroDuAn();
		model.addAttribute("dsPhongBan", listPhongBan);
		model.addAttribute("dsDuAn", listDuAn);
		model.addAttribute("dsVaiTroDuAn", listVaiTroDuAn);
		model.addAttribute("dsNhanVien", listNhanVien);
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
				trangThaiLogwork.setMaTrangThai(5);
				logwork.setTrangThaiLogwork(trangThaiLogwork);
			} else if (action.equals("luunhap")) {
				msg = "Đã lưu nháp";
				TrangThaiLogwork trangThaiLogwork = new TrangThaiLogwork();
				trangThaiLogwork.setMaTrangThai(4);
				logwork.setTrangThaiLogwork(trangThaiLogwork);
			} else if (action.equals("edit")) {
				msg = "Sửa thành công";
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
	
	
	//PM
	@RequestMapping(value = "/listDate/{date}")
	public String pmViewLogwork(@PathVariable("date") String date, Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
		int totalRecords = logworkService.listAllDate(date).size();
		int total = 10;
		int totalPages = 0;
		if ((totalRecords / total) % 2 == 0) {
			totalPages = totalRecords / total;
		} else if ((totalRecords / total) % 2 != 0 && totalRecords != total) {
			totalPages = totalRecords / total + 1;
		} else if (totalRecords == total) {
			totalPages = 1;
		}
		int star = total * (currentPage - 1);
		model.addAttribute("listDate", logworkService.listDate(star, total, date));
		model.addAttribute("lastPage", totalPages);
		model.addAttribute("currentPage", currentPage);
		return "QuanLyThoiGian/logwork/listdate";
	}
	
	//view by pm
	
		@RequestMapping(value = "/pmview/{id}", method = RequestMethod.GET)
		public String pmview(@PathVariable("id") int id, Model model) {
			List<PhongBanLogwork> listPhongBan = logworkService.listPhongBan();
			List<DuAnLogwork> listDuAn = logworkService.listDuAn();
			List<NhanVienLogwork> listNhanVien = logworkService.listNhanVien();
			List<VaiTroDuAnLogwork> listVaiTroDuAn = logworkService.listVaiTroDuAn();
			model.addAttribute("dsPhongBan", listPhongBan);
			model.addAttribute("dsDuAn", listDuAn);
			model.addAttribute("dsVaiTroDuAn", listVaiTroDuAn);
			model.addAttribute("dsNhanVien", listNhanVien);
			model.addAttribute("editlogwork", logworkService.findByIdLogwork(id));
			return "QuanLyThoiGian/logwork/viewbypm";
		}

		@RequestMapping(value = "/pmview/{id}", method = RequestMethod.POST)
		public String pmPD(@PathVariable("id") int id,Model model, @ModelAttribute("pmPD") Logwork logwork,
				final RedirectAttributes redirectAttributes, @RequestParam String action) {
			Calendar ca = Calendar.getInstance();
			int m = ca.get(Calendar.MONTH) + 1;
			int d = ca.get(Calendar.DAY_OF_MONTH);
			int y = ca.get(Calendar.YEAR);

			try {
				String msg = "";
				if (action.equals("pheduyet")) {
					msg = "Đã phê duyệt";
					TrangThaiLogwork trangThaiLogwork = new TrangThaiLogwork();
					trangThaiLogwork.setMaTrangThai(1);
					logwork.setTrangThaiLogwork(trangThaiLogwork);
				} else if (action.equals("exit")) {
					return "redirect:/QuanLyThoiGian/Logwork/listDate/" + Integer.toString(y) + Integer.toString(m) + Integer.toString(d);	
				}
				logworkService.update(logwork);
				redirectAttributes.addFlashAttribute("button", msg);
			} catch (Exception e) {
				redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
			}
			
			return "redirect:/QuanLyThoiGian/Logwork/listDate/" + Integer.toString(y) + Integer.toString(m) + Integer.toString(d);
		}

}
