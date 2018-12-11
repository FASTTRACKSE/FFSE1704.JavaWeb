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

	// danh sach bằng cấp
	@RequestMapping(value = "/ViewCC/{maNhanVien}", method = RequestMethod.GET)
	public String ViewBangCap(@PathVariable("maNhanVien") String maNhanVien, Model model) {

		model.addAttribute("chungChi", chungChiService.getChungChiByID(maNhanVien));

		return "QuanTriNhanSu/chungChi/allchungchi";

	}

	// danh sach edit
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
