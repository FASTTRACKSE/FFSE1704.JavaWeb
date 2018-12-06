package fasttrackse.ffse1704.fbms.controller.thongtinlogwork.quanlythoigian;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1704.fbms.entity.thongtinlogwork.quanlythoigian.ThongTinLogwork;
import fasttrackse.ffse1704.fbms.entity.thongtinlogwork.quanlythoigian.ThongTinNhanVienPhuongNH;
import fasttrackse.ffse1704.fbms.entity.thongtinlogwork.quanlythoigian.ThongTinPhongBan;
import fasttrackse.ffse1704.fbms.entity.thongtinlogwork.quanlythoigian.TrangThaiThongTinLogwork;
import fasttrackse.ffse1704.fbms.entity.thongtinlogwork.quanlythoigian.VaiTroDuAn;
import fasttrackse.ffse1704.fbms.service.security.DatatableService;
import fasttrackse.ffse1704.fbms.service.thongtinlogwork.quanlythoigian.ThongTinLogworkService;

@Controller
@RequestMapping("/PhuongQuanLyThoiGian/Logwork")

public class PhuongLogworkController {
	@Autowired
	private ThongTinLogworkService logworkService;

	
	  @Autowired private DatatableService datatableService;
	 

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Model model, final RedirectAttributes redirectAttributes) {
		List<ThongTinPhongBan> listPhongBan = logworkService.listDSPhongBan();
		List<VaiTroDuAn> listVaiTro = logworkService.listVaiTro();
		model.addAttribute("thongTinLogwork", new ThongTinLogwork());
		model.addAttribute("dsPhongBan", listPhongBan);
		model.addAttribute("dsVaiTro", listVaiTro);
		return "PhuongQuanLyThoiGian/Logwork/add_logwork";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String doAdd(Model model, @ModelAttribute("thongTinLogwork") ThongTinLogwork lw,
			final RedirectAttributes redirectAttributes) {
		try {
			logworkService.addNew(lw);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thêm mới thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:/PhuongQuanLyThoiGian/Logwork/list/";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String viewLogwork(Model model) {
		List<ThongTinLogwork> allLogwork = logworkService.findAll();
		model.addAttribute("thongTinLogwork", allLogwork);
		return "PhuongQuanLyThoiGian/Logwork/list";
	}
}
