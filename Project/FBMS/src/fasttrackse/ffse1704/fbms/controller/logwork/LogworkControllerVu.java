package fasttrackse.ffse1704.fbms.controller.logwork;

import java.util.ArrayList;
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
import fasttrackse.ffse1704.fbms.entity.logwork.VuNhanVien;
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
				trangThaiLogwork.setMaTrangThai(5);
				thoiGianLamViec.setTrangThaiLogwork(trangThaiLogwork);
			} else if (action.equals("exit")) {
				return "redirect:/logwork/list/4";
			}
			service.create(thoiGianLamViec);
			redirectAttributes.addFlashAttribute("button", msg);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:/logwork/list/4";
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
				trangThaiLogwork.setMaTrangThai(5);
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
		return "redirect:/logwork/list/4";
	}

	@RequestMapping(value = "/deletelogwork/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {
		try {
			service.delete(id);
			redirectAttributes.addFlashAttribute("button", "Xóa thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại");
		}
		return "redirect:/logwork/list/2";
	}

	@RequestMapping(value = "/list/{maTrangThai}", method = RequestMethod.GET)
	public String viewLogworkTheoTrangThai(@PathVariable("maTrangThai") int maTrangThai, Model model) {
		List<ThoiGianLamViec> allLogwork = service.listTheoTrangThai(maTrangThai);
		model.addAttribute("logwork", allLogwork);
		return "logwork/list";
	}

	@RequestMapping(value = "/listMonth/{month}")
	public String viewMonth(@PathVariable("month") String month, Model model) {
		model.addAttribute("thang", month);
		model.addAttribute("listMonth", service.listOneMonth(month));
		return "logwork/listmonth";

	}

	@RequestMapping(value = "/maNV/{maNhanVien}", method = RequestMethod.GET)
	public String viewBaoCaoTheoMaNV(@PathVariable("maNhanVien") String maNhanVien, Model model) {
		model.addAttribute("maNhanVien", maNhanVien);
		model.addAttribute("baoCao", service.baoCaoTheoMaNV(maNhanVien));

		return "logwork/baocaoNv";

	}

	@RequestMapping(value = "/listChoPheDuyetPM", method = RequestMethod.GET)
	public String viewChoPheDuyetPM(Model model) {
		List<ThoiGianLamViec> allLogwork = service.findAll();
		model.addAttribute("logwork", allLogwork);
		return "logwork/listChoPheDuyet";
	}

	@RequestMapping(value = "/viewPheDuyet/{id}", method = RequestMethod.GET)
	public String viewPheDuyet(@PathVariable("id") int id, Model model) {
		model.addAttribute("viewPheDuyet", service.findByIdLogwork(id));
		return "logwork/ViewPheDuyetPM";
	}

	@RequestMapping(value = "/viewPheDuyet/{id}", method = RequestMethod.POST)
	public String doPheDuyet(@PathVariable("id") int id, Model model, final RedirectAttributes redirectAttributes,
			@RequestParam String action, @RequestParam("nhanXetPM") String nhanXetPM) {

		try {
			ThoiGianLamViec logwork = service.findByIdLogwork(id);
			String msg = "";
			if (action.equals("pheDuyet")) {
				msg = "Đã  phê duyệt,Chờ TPP Phê Duyệt";
				VuTrangThai trangThaiLogwork = new VuTrangThai();
				trangThaiLogwork.setMaTrangThai(1);
				logwork.setNhanXetPM(nhanXetPM);
				logwork.setTrangThaiLogwork(trangThaiLogwork);

			} else if (action.equals("tuChoi")) {
				msg = "Đã Từ Chối";
				VuTrangThai trangThaiLogwork = new VuTrangThai();
				trangThaiLogwork.setMaTrangThai(3);
				logwork.setNhanXetPM(nhanXetPM);
				logwork.setTrangThaiLogwork(trangThaiLogwork);
			}
			service.update(logwork);
			redirectAttributes.addFlashAttribute("button", msg);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:/logwork/listChoPheDuyetPM";
	}

	@RequestMapping(value = "/viewBaoCaoLogwork/{maPhongBan}", method = RequestMethod.GET)
	public String createLogWorkReport(@PathVariable("maPhongBan") String maPhongBan, Model model) {
		
		List<ThoiGianLamViec> listLogWork = service.logworkTheoPB(maPhongBan);
		
		List<ThoiGianLamViec> listLogWorkReport = new ArrayList<ThoiGianLamViec>();
		VuNhanVien currentMaNV = listLogWork.get(0).getMaNhanVien();
		VuDuAnLogwork currentDA = listLogWork.get(0).getMaDuAn();
		String tenCongViec = listLogWork.get(0).getTenCongViec();
		VuPhongBan maPhongBan1 = listLogWork.get(0).getMaPhongBan();
		VuTrangThai maTrangThai = listLogWork.get(0).getTrangThaiLogwork();

		double total = 0;
		for (int i = 0; i < listLogWork.size(); i++) {
			ThoiGianLamViec lg = listLogWork.get(i);
			if (currentMaNV.getMaNVien().equals(lg.getMaNhanVien().getMaNVien())) {
				if (currentDA.getMaDAn().equals(lg.getMaDuAn().getMaDAn())) {
					
					total += lg.getTongTg();
				} else {
					listLogWorkReport.add(new ThoiGianLamViec(currentDA , currentMaNV,tenCongViec,maPhongBan1,maTrangThai, total));
					currentDA = lg.getMaDuAn();
					currentMaNV = lg.getMaNhanVien();
					
					total = lg.getTongTg();
				}
			} else {
				listLogWorkReport.add(new ThoiGianLamViec(currentDA , currentMaNV,tenCongViec,maPhongBan1,maTrangThai, total));
				currentDA = lg.getMaDuAn();
				currentMaNV = lg.getMaNhanVien();
				total = lg.getTongTg();
			}
		}
		listLogWorkReport.add(new ThoiGianLamViec(currentDA , currentMaNV,tenCongViec,maPhongBan1,maTrangThai, total));
		model.addAttribute("baocaologwork", listLogWorkReport);
		return "logwork/listBaoCao";

	}
}
