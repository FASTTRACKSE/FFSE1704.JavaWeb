package fasttrackse.ffse1704.fbms.controller.quanlynhansu;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ChungChi;
import fasttrackse.ffse1704.fbms.service.quanlynhansu.ChungChiService;

@Controller
public class ChungChiController {
	@Autowired
	ChungChiService chungChiService;

	public void setChungChiService(ChungChiService chungChiService) {
		this.chungChiService = chungChiService;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
	}

	@RequestMapping(value = "/ViewCC/{maNhanVien}", method = RequestMethod.GET)
	public String ViewBangCap(@PathVariable("maNhanVien") String maNhanVien, Model model) {
		model.addAttribute("chungChi", chungChiService.getChungChiByID(maNhanVien));
		return "QuanTriNhanSu/chungChi/allchungchi";
	}

	@RequestMapping(value = "/addCC/{maNhanVien}")
	public String ViewAddChungChi(Model model, @PathVariable("maNhanVien") String maNhanVien) {
		model.addAttribute("chungChi", new ChungChi());
		model.addAttribute("chungChi2", chungChiService.getChungChiByID(maNhanVien));
		return "QuanTriNhanSu/chungChi/addCC";
	}

	@RequestMapping(value = "saveCC")
	public ModelAndView AddChungChi(@ModelAttribute("chungChi") ChungChi chungChi) {
		chungChiService.addChungChi(chungChi);
		return new ModelAndView("redirect:/QuanTriNhanSu/danhsach_nhansu/1");
	}

	@RequestMapping("/updateCC/{id}&{maNhanVien}")
	public String ShowViewUpdate(Model model, @PathVariable("maNhanVien") String maNhanVien,
			@PathVariable("id") int id) {
		model.addAttribute("chungChi1", new ChungChi());
		model.addAttribute("chungChi", chungChiService.getChungChiByID(maNhanVien));
		model.addAttribute("chungChi2", chungChiService.getChungChiUpdate(id));
		return "QuanTriNhanSu/chungChi/updateCC";
	}

	@RequestMapping(value = "/viewUpdate/{maNhanVien}")
	public ModelAndView UpdateCC(@ModelAttribute("chungChi") ChungChi chungChi) {
		chungChiService.update(chungChi);
		return new ModelAndView("redirect:/QuanTriNhanSu/danhsach_nhansu/1");
	}

	@RequestMapping("/deleteCC/{id}&{maNhanVien}")
	public String ShowViewDelete(Model model, @PathVariable("maNhanVien") String maNhanVien,
			@PathVariable("id") int id) {
		model.addAttribute("chungChi1", new ChungChi());
		model.addAttribute("chungChi", chungChiService.getChungChiByID(maNhanVien));
		model.addAttribute("chungChi2", chungChiService.getChungChiUpdate(id));
		return "QuanTriNhanSu/chungChi/deleteCC";
	}

	@RequestMapping(value = "/viewDelete/{ID}")
	public ModelAndView DeleteCC(@PathVariable("ID") int id) {
		chungChiService.delete(id);
		return new ModelAndView("redirect:/QuanTriNhanSu/danhsach_nhansu/1");
	}

}
