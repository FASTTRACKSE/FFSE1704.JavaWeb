package fasttrackse.ffse1704.fbms.controller.logwork;

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

import fasttrackse.ffse1704.fbms.entity.logwork.ThoiGianLamViec;
import fasttrackse.ffse1704.fbms.entity.logwork.VuDuAnLogwork;
import fasttrackse.ffse1704.fbms.entity.logwork.VuPhongBan;
import fasttrackse.ffse1704.fbms.entity.logwork.VuTrangThai;
import fasttrackse.ffse1704.fbms.entity.logwork.VuVaiTroDuAn;
import fasttrackse.ffse1704.fbms.entity.quanlythoigian.Logwork;
import fasttrackse.ffse1704.fbms.service.logwork.VuLogworkService;

@Controller
@RequestMapping("logwork")
public class LogworkControllerVu {
	@Autowired
	private VuLogworkService service;

	public VuLogworkService getService() {
		return service;
	}

	public void setService(VuLogworkService service) {
		this.service = service;
	}

	@RequestMapping(value = "/addlogwork", method = RequestMethod.GET)
	public String addForm(Model model, final RedirectAttributes redirectAttributes) {
		List<VuPhongBan> listPhongBan = service.listPhongBan();
		List<VuDuAnLogwork> listDuAn = service.listDuAn();
		List<VuVaiTroDuAn> listVaiTroDuAn = service.listVaiTroDuAn();
		model.addAttribute("logworkk", new Logwork());
		model.addAttribute("dsPhongBan", listPhongBan);
		model.addAttribute("dsDuAn", listDuAn);
		model.addAttribute("dsVaiTroDuAn", listVaiTroDuAn);
		return "logwork/add_logwork";
	}

	@RequestMapping(value = "/addlogwork", method = RequestMethod.POST)
	public String create(Model model, @ModelAttribute("logwork") ThoiGianLamViec thoiGianLamViec,
			final RedirectAttributes redirectAttributes, @RequestParam String action) {
		try {
			String msg = "";
			if (action.equals("luuNhap")) {
				msg = "Đã lưu nháp";
				VuTrangThai trangThaiLogwork = new VuTrangThai();
				trangThaiLogwork.setMaTrangThai(4);
				thoiGianLamViec.setTrangThaiLogwork(trangThaiLogwork);
			} else if (action.equals("submit")) {
				msg = "Đã gửi phê duyệt";
				VuTrangThai trangThaiLogwork = new VuTrangThai();
				trangThaiLogwork.setMaTrangThai(1);
				thoiGianLamViec.setTrangThaiLogwork(trangThaiLogwork);
			} else if (action.equals("exit")) {
				return "redirect:/logwork/list";
			}
			service.create(thoiGianLamViec);
			redirectAttributes.addFlashAttribute("button", msg);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:/logwork/list";
	}
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public String viewLogwork(@PathVariable("id") int id, Model model) {
		model.addAttribute("viewLogwork", service.findByIdLogwork(id));
		return "logwork/view";
	}
	@RequestMapping(value = "/editlogwork/{id}", method = RequestMethod.GET)
	public String editForm(@PathVariable("id") int id, Model model, final RedirectAttributes redirectAttributes) {
		List<VuPhongBan> listPhongBan = service.listPhongBan();
		List<VuDuAnLogwork> listDuAn = service.listDuAn();
		List<VuVaiTroDuAn> listVaiTroDuAn = service.listVaiTroDuAn();
		model.addAttribute("logworkk", new Logwork());
		model.addAttribute("dsPhongBan", listPhongBan);
		model.addAttribute("dsDuAn", listDuAn);
		model.addAttribute("dsVaiTroDuAn", listVaiTroDuAn);
		model.addAttribute("editlogwork", service.findByIdLogwork(id));
		return "logwork/edit_logwork";
	}

	@RequestMapping(value = "/editlogwork/{id}", method = RequestMethod.POST)
	public String doEdit(Model model, @ModelAttribute("editlogwork") ThoiGianLamViec logwork,
			final RedirectAttributes redirectAttributes, @RequestParam String action) {
		try {
			String msg = "";
			if (action.equals("submit")) {
				msg = "Đã Chuyển Trạng Thái Thành Đã gửi phê duyệt";
				VuTrangThai trangThaiLogwork = new VuTrangThai();
				trangThaiLogwork.setMaTrangThai(1);
				logwork.setTrangThaiLogwork(trangThaiLogwork);
			} else if (action.equals("editlogwork")) {
				msg = "Sửa thành công";
			} else if (action.equals("luuNhap")) {
				msg = "Đã Chuyển Trạng Thái Thành lưu nháp";
				VuTrangThai trangThaiLogwork = new VuTrangThai();
				trangThaiLogwork.setMaTrangThai(4);
				logwork.setTrangThaiLogwork(trangThaiLogwork);
			}
			service.update(logwork);
			redirectAttributes.addFlashAttribute("button", msg);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:/logwork/list";
	}

	@RequestMapping(value = "/deletelogwork/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {
		try {
			service.delete(id);
			redirectAttributes.addFlashAttribute("button", "Xóa thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại");
		}
		return "redirect:/logwork/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String viewLogwork(Model model) {
		List<ThoiGianLamViec> allLogwork = service.findAll();
		model.addAttribute("logwork", allLogwork);
		return "logwork/list";
	}
	@RequestMapping(value = "/listMonth/{month}")
	public String viewMonth(@PathVariable("month") String month, Model model) {
		model.addAttribute("thang", month);
		model.addAttribute("listMonth", service.listOneMonth(month));
		return "logwork/listmonth";
		
	}
}
