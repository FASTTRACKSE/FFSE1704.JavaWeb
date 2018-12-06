package fasttrackse.ffse1704.fbms.controller.quanlyvangnghi.thachmh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.thachmh.DonXinNghiPhep;
import fasttrackse.ffse1704.fbms.service.quanlyvangnghi.thachmh.DonXinNghiPhepService;

@Controller
@RequestMapping("/QuanLyVangNghi512")
public class DonXinNghiPhepController {
	@Autowired
	private DonXinNghiPhepService donXinNghiPhepService;

	@RequestMapping(value = "/list")
	public String view(Model model) {

		model.addAttribute("list", donXinNghiPhepService.getAllDonXinNghiPhep());

		return "QuanLyVangNghiThachMH/listvangnghi";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute("donXinNghiPhep", new DonXinNghiPhep());
		return "QuanLyVangNghiThachMH/addvangnghi";
	}

	@RequestMapping(value = "/doadd", method = RequestMethod.POST)
	public String doAdd(Model model, @ModelAttribute("donXinNghiPhep") DonXinNghiPhep dx,
			final RedirectAttributes redirectAttributes) {
		try {
			donXinNghiPhepService.addNew(dx);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thêm mới thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:/QuanLyVangNghi512/list";
	}

	@RequestMapping(value = "/editdxnp/{idDon}", method = RequestMethod.GET)
	public String editForm(@PathVariable("idDon") int idDon, Model model) {
		model.addAttribute("donXinNghiPhep", donXinNghiPhepService.findByidDon(idDon));
		return "QuanLyVangNghiThachMH/editvangnghi";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String doEdit(Model model, @ModelAttribute("donXinNghiPhep") DonXinNghiPhep dx, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "redirect:/QuanLyVangNghi512/list";
		}

		donXinNghiPhepService.update(dx);
		redirectAttributes.addFlashAttribute("messageSuccess", "Thành công..");
		return "redirect:/QuanLyVangNghi512/list";
	}
	
	@RequestMapping(value = "/delete/{idDon}", method = RequestMethod.GET)
	public String delete(@PathVariable("idDon") int idDon, final RedirectAttributes redirectAttributes) {
		try {
			donXinNghiPhepService.delete(idDon);
			redirectAttributes.addFlashAttribute("messageSuccess", "Xóa thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại");
		}
		return "redirect:/QuanLyVangNghi512/list";
	}

}
