package fasttrackse.ffse1704.fbms.controller.quanlythoigian;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1704.fbms.entity.quanlythoigian.Logwork;
import fasttrackse.ffse1704.fbms.entity.quanlythoigian.PhongBanLogwork;
import fasttrackse.ffse1704.fbms.service.quanlythoigian.LogworkService;

@Controller
@RequestMapping("QuanLyThoiGian/Logwork")
public class LogworkController {
	@Autowired
	private LogworkService logworkService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String viewLogwork(Model model) {
		List<Logwork> allLogwork = logworkService.findAll();
		model.addAttribute("logwork", allLogwork);
		return "QuanLyThoiGian/logwork/list";
	}

	// add
	@RequestMapping(value = "/addlogwork", method = RequestMethod.GET)
	public String addForm(Model model, final RedirectAttributes redirectAttributes) {
		List<PhongBanLogwork> listPhongBan = logworkService.listPhongBan();

		model.addAttribute("logworkk", new Logwork());
		model.addAttribute("dsPhongBan", listPhongBan);
		return "QuanLyThoiGian/logwork/add_logwork";
	}

	@RequestMapping(value = "/addlogwork", method = RequestMethod.POST)
	public String doAdd(Model model, @ModelAttribute("logworkk") Logwork logwork,
			final RedirectAttributes redirectAttributes) {
		try {
			logworkService.addNew(logwork);;
			redirectAttributes.addFlashAttribute("messageSuccess", "Thêm mới thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:/QuanLyThoiGian/Logwork/list";
	}

}
