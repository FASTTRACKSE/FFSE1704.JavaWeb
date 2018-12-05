package fasttrackse.ffse1704.fbms.controller.quanlytailieu.Doanhnt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1704.fbms.entity.quanlytailieu.Doanhnt.DanhMuc;
import fasttrackse.ffse1704.fbms.service.quanlytailieu.Doanhnt.DanhMucService;

@Controller
@RequestMapping("/quanlytailieu/Doanhnt/DanhMuc")
public class DanhMucController {
	@Autowired
	private DanhMucService serviceDM;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewDanhMuc(Model model) {
		model.addAttribute("ListDanhMuc", serviceDM.listAllDanhMuc());
		return "/quanlytailieu/Doanhnt/DanhMuc/DanhMucList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET) 
	public String addFormDM(Model model) {
		model.addAttribute("DanhMuc", new DanhMuc());
		return "quanlytailieu/Doanhnt/DanhMuc/add_formDM";
	}

	@RequestMapping(value = "/doAddDM", method = RequestMethod.POST)
	public String doAddDM(Model model, @ModelAttribute("DanhMuc") DanhMuc dm,
			final RedirectAttributes redirectAttributes) {
		try {
			serviceDM.addDM(dm);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thêm Mới Thành Công !");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Có lỗi, xin thử lại !");
		}
		return "redirect:quanlytailieu/Doanhnt/DanhMuc/";
	}

	@RequestMapping(value = "/sua/{maDM}", method = RequestMethod.GET)
	public String editFormDM(@PathVariable("maDM") String maDM, Model model) {
		model.addAttribute("DanhMuc", serviceDM.getDMbyID(maDM));
		return "quanlytailieu/Doanhnt/DanhMuc/edit_formDM";
	}

	@RequestMapping(value = "/sua/{maDM}", method = RequestMethod.POST)
	public String doEdit(@ModelAttribute("DanhMuc") DanhMuc dm,
			final RedirectAttributes redirectAttributes,Model model) {
		try {
			serviceDM.updateDM(dm);
			redirectAttributes.addFlashAttribute("messageSuccess", "Sửa Thành Công !");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Có Lỗi, Xin Thử Lại!");
		}
		return "redirect:quanlytailieu/Doanhnt/DanhMuc/";
	}

	@RequestMapping(value = "/xoa/{maDM}", method = RequestMethod.GET)
	public String delete(@PathVariable("maDM") String maDM, final RedirectAttributes redirectAttributes) {
		try {
			DanhMuc dm=serviceDM.getDMbyID(maDM);
			dm.setIsDelete(1);
			serviceDM.updateDM(dm);
			redirectAttributes.addFlashAttribute("messageSuccess", "Xóa Thành Công !");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Có lỗi, xin thử lại !");
		}
		return "redirect:quanlytailieu/Doanhnt/DanhMuc/";
	}

	@RequestMapping(value = "/view/{maDM}", method = RequestMethod.GET)
	public String viewOneDM(@PathVariable("maDM") String maDM, Model model) {
		model.addAttribute("DanhMuc", serviceDM.getDMbyID(maDM));
		return "quanlytailieu/Doanhnt/DanhMuc/view_oneDM";
	}
}