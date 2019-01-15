package fasttrackse.ffse1704.fbms.controller.quanlynhansu;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ThongTinGiaDinh;
import fasttrackse.ffse1704.fbms.service.quanlynhansu.ThongTinGiaDinhService;
import fasttrackse.ffse1704.fbms.service.quanlynhansu.XemThongTinNVService;

@Controller
public class ThongTinGiaDinhController {
	@Autowired
	ThongTinGiaDinhService thongTinGiaDinhService;

	public void setThongTinGiaDinhService(ThongTinGiaDinhService thongTinGiaDinhService) {
		this.thongTinGiaDinhService = thongTinGiaDinhService;
	}

	@Autowired
	XemThongTinNVService xemThongTinNVService;

	public void setXemThongTinNVService(XemThongTinNVService xemThongTinNVService) {
		this.xemThongTinNVService = xemThongTinNVService;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
	}

	@RequestMapping(value = "/ViewTT/{maNhanVien}", method = RequestMethod.GET)
	public String ViewThongTinGiaDinh(@PathVariable("maNhanVien") String maNhanVien, Model model) {
		model.addAttribute("thongTinGiaDinh", thongTinGiaDinhService.getThongTinGiaDinhByID(maNhanVien));
		return "QuanTriNhanSu/thongTinGiaDinh/allthongtin";
	}

	@RequestMapping(value = "/addTT/{maNhanVien}")
	public String ViewAddThongTin(Model model, @PathVariable("maNhanVien") String maNhanVien) {
		model.addAttribute("thongTinGiaDinh", new ThongTinGiaDinh());
		model.addAttribute("thongTinGiaDinh2", thongTinGiaDinhService.getThongTinGiaDinhByID(maNhanVien));
		return "QuanTriNhanSu/thongTinGiaDinh/addTT";
	}

	@RequestMapping(value = "saveTT/{maNhanVien}")
	public String AddThongTin(@PathVariable("maNhanVien") String maNhanVien,
			@ModelAttribute("thongTinGiaDinh") @Valid ThongTinGiaDinh thongTinGiaDinh, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("thongTinGiaDinh", new ThongTinGiaDinh());
			model.addAttribute("thongTinGiaDinh2", thongTinGiaDinhService.getThongTinGiaDinhByID(maNhanVien));
			model.addAttribute("thatbai", "Xin mời bạn nhập lại!");
			return "QuanTriNhanSu/thongTinGiaDinh/addTT";
		}
		thongTinGiaDinhService.addThongTinGiaDinh(thongTinGiaDinh);
		return ("redirect:/ViewTT/{maNhanVien}");
	}

	@RequestMapping("/updateTT/{id}&{maNhanVien}")
	public String ShowViewUpdateTT(Model model, @PathVariable("maNhanVien") String maNhanVien,
			@PathVariable("id") int id) {
		model.addAttribute("thongTinGiaDinh1", new ThongTinGiaDinh());
		model.addAttribute("thongTinGiaDinh", thongTinGiaDinhService.getThongTinGiaDinhByID(maNhanVien));
		model.addAttribute("thongTinGiaDinh2", thongTinGiaDinhService.getThongTinGiaDinhUpdate(id));
		return "QuanTriNhanSu/thongTinGiaDinh/updateTT";
	}

	@RequestMapping(value = "/viewUpdateTT/{maNhanVien}")
	public ModelAndView UpdateTT(@PathVariable("maNhanVien") String maNhanVien,
			@ModelAttribute("thongTinGiaDinh") ThongTinGiaDinh thongTinGiaDinh) {
		thongTinGiaDinhService.update(thongTinGiaDinh);
		return new ModelAndView("redirect:/ViewTT/{maNhanVien}");
	}

	@RequestMapping("/deleteTT/{id}&{maNhanVien}")
	public String ShowViewDeleteTT(Model model, @PathVariable("maNhanVien") String maNhanVien,
			@PathVariable("id") int id) {
		model.addAttribute("thongTinGiaDinh1", new ThongTinGiaDinh());
		model.addAttribute("thongTinGiaDinh", thongTinGiaDinhService.getThongTinGiaDinhByID(maNhanVien));
		model.addAttribute("thongTinGiaDinh2", thongTinGiaDinhService.getThongTinGiaDinhUpdate(id));
		return "QuanTriNhanSu/thongTinGiaDinh/deleteTT";
	}

	@RequestMapping(value = "/viewDeleteTT/{id}/{maNhanVien}")
	public ModelAndView DeleteTT(@PathVariable("maNhanVien") String maNhanVien, @PathVariable("id") int id) {
		thongTinGiaDinhService.delete(id);
		return new ModelAndView("redirect:/ViewTT/{maNhanVien}");
	}

}
