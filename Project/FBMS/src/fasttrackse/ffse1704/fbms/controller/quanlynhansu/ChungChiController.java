package fasttrackse.ffse1704.fbms.controller.quanlynhansu;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ChungChi;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.NhanSu;
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

	@RequestMapping("/ViewCC/addCC")
	public ModelAndView ShowViewADD() {
		return new ModelAndView("QuanTriNhanSu/chungChi/addCC", "chungChi", new ChungChi());
	}

	@RequestMapping("/ViewCC/updateCC/{ID}")
	public ModelAndView ShowViewUpdate() {
		return new ModelAndView("QuanTriNhanSu/chungChi/updateCC", "chungChi", new ChungChi());
	}

	@RequestMapping("/ViewCC/deleteCC/{ID}")
	public ModelAndView ShowViewDelete() {
		return new ModelAndView("QuanTriNhanSu/chungChi/deleteCC", "chungChi", new ChungChi());
	}

	@RequestMapping(value = "addCC", method = RequestMethod.POST)
	public ModelAndView AddNhanSu(Model model, @ModelAttribute("chungChi") @Valid ChungChi chungChi)
			throws IllegalStateException, IOException {
		chungChiService.addChungChi(chungChi);
		return new ModelAndView("redirect:/ViewCC/{maNhanVien}");
	}

	@RequestMapping(value = "/ViewCC/updateCC/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") int id, Model model) {

		model.addAttribute("chungChi", chungChiService.getChungChiUpdate(id));

		return "QuanTriNhanSu/chungChi/updateCC";

	}

	// UPDATE
	@RequestMapping(value = "/ViewCC/update", method = RequestMethod.POST)
	public String editSave(@ModelAttribute("chungChi") ChungChi chungChi, Model model) {

		chungChiService.update(chungChi);

		return "QuanTriNhanSu/chungChi/allchungchi";

	}
}
