package fasttrackse.ffse1704.fbms.controller.logwork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1704.fbms.entity.logwork.ThoiGianLamViec;
import fasttrackse.ffse1704.fbms.service.logwork.LogworkService;

@Controller
@RequestMapping("logwork")
public class LogworkControllerVu {
	@Autowired
	private LogworkService service;

	public LogworkService getService() {
		return service;
	}

	public void setService(LogworkService service) {
		this.service = service;
	}

	@RequestMapping(value = "/tao", method = RequestMethod.GET)
	public String addForm(Model model, final RedirectAttributes redirectAttributes) {
		model.addAttribute("logwork", new ThoiGianLamViec());
		return "/logwork/create";
	}

	@RequestMapping(value = "/tao", method = RequestMethod.POST)
	public String create(Model model, @ModelAttribute("logwork") ThoiGianLamViec thoiGianLamViec,
			final RedirectAttributes redirectAttributes) {
		try {
			service.create(thoiGianLamViec);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thêm mới thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:/home";
	}

}
