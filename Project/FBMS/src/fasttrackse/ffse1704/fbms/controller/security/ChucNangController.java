package fasttrackse.ffse1704.fbms.controller.security;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1704.fbms.entity.security.ChucNang;
import fasttrackse.ffse1704.fbms.service.security.ChucNangService;
import fasttrackse.ffse1704.fbms.service.security.DatatableService;

@Controller
@RequestMapping("/quantrihethong/chuc_nang")
public class ChucNangController {

	@Autowired
	private ChucNangService cnService;

	@Autowired
	private DatatableService datatableService;
	
	@RequestMapping(value = "/view/danhSachChucNang", method = RequestMethod.GET)
	public String viewChucDanh(Model model) {
		return "quantrihethong/chucnang/list";
	}
	
	@RequestMapping(value = "/view/{maChucNang}", method = RequestMethod.GET)
	public String viewOneChucDanh(@PathVariable("maChucNang") String maChucNang, Model model) {
		model.addAttribute("chucNang", cnService.getChucNangByCode(maChucNang));
		return "quantrihethong/chucnang/viewOne";
	}
	
	@RequestMapping(value = "/view/getListChucNang", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String getListChucNang(Model model, HttpServletRequest request) {
		
		int iDisplayStart = Integer.parseInt(request.getParameter("iDisplayStart"));
		int iDisplayLength = Integer.parseInt(request.getParameter("iDisplayLength"));
		String sql = cnService.getSQL(request);
		List<ChucNang> listChucNang = cnService.findAll(iDisplayStart, iDisplayLength, sql);

		String recordsTotal = cnService.getRecordsTotal();
		String recordsFiltered = cnService.getRecordsFiltered(sql);
		String json = datatableService.getJsonChucNang(recordsTotal, recordsFiltered, listChucNang);
		return json;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Model model, final RedirectAttributes redirectAttributes) {
		model.addAttribute("chucNang", new ChucNang());
		return "quantrihethong/chucnang/add_form";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String doAdd(Model model, @ModelAttribute("chucNang") ChucNang cn,
			final RedirectAttributes redirectAttributes) {
		try {
			cnService.save(cn);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thêm mới thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:/quantrihethong/chuc_nang/view/danhSachChucNang";
	}

	@RequestMapping(value = "/edit/{code}", method = RequestMethod.GET)
	public String editForm(@PathVariable("code") String code, Model model) {
		model.addAttribute("chucNang", cnService.getChucNangByCode(code));
		return "quantrihethong/chucnang/edit_form";
	}

	@RequestMapping(value = "/edit/{code}", method = RequestMethod.POST)
	public String doEdit(Model model, @ModelAttribute("chucNang") ChucNang cn,
			final RedirectAttributes redirectAttributes) {
		try {
			cnService.update(cn);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:/quantrihethong/chuc_nang/view/danhSachChucNang";
	}

	@RequestMapping(value = "/active/{code}", method = RequestMethod.GET)
	public String active(@PathVariable("code") String ma_chuc_nang, final RedirectAttributes redirectAttributes) {
		try {
			cnService.active(ma_chuc_nang);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:/quantrihethong/chuc_nang/view/danhSachChucNang";
	}
	
	@RequestMapping(value = "/delete/{code}", method = RequestMethod.GET)
	public String delete(@PathVariable("code") String ma_chuc_nang, final RedirectAttributes redirectAttributes) {
		try {
			cnService.delete(ma_chuc_nang);
			redirectAttributes.addFlashAttribute("messageSuccess", "Xóa Thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:/quantrihethong/chuc_nang/view/danhSachChucNang";
	}
}
