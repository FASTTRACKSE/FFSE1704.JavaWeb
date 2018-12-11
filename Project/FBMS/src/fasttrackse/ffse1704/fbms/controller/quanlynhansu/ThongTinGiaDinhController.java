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

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ThongTinGiaDinh;
import fasttrackse.ffse1704.fbms.service.quanlynhansu.ThongTinGiaDinhService;

@Controller
public class ThongTinGiaDinhController {
	@Autowired
	ThongTinGiaDinhService thongTinGiaDinhService;

	public void setThongTinGiaDinhService(ThongTinGiaDinhService thongTinGiaDinhService) {
		this.thongTinGiaDinhService = thongTinGiaDinhService;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
	}

	// danh sach bằng cấp
	@RequestMapping(value = "/ViewTTGD/{maNhanVien}", method = RequestMethod.GET)
	public String ViewThongTinGiaDinh(@PathVariable("maNhanVien") String maNhanVien, Model model) {

		model.addAttribute("thongTinGiaDinh", thongTinGiaDinhService.getThongTinGiaDinhByID(maNhanVien));

		return "QuanTriNhanSu/thongTinGiaDinh/allthongtin";

	}

	// danh sach edit
	@RequestMapping(value = "/ViewTTGD/updateTTGD/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") int id, Model model) {

		model.addAttribute("thongTinGiaDinh", thongTinGiaDinhService.getThongTinGiaDinhUpdate(id));

		return "QuanTriNhanSu/thongTinGiaDinh/updateTTGD";

	}

	// UPDATE
	@RequestMapping(value = "/ViewTTGD/update", method = RequestMethod.POST)
	public String editSave(@ModelAttribute("thongTinGiaDinh") ThongTinGiaDinh thongTinGiaDinh, Model model) {

		thongTinGiaDinhService.update(thongTinGiaDinh);

		return "QuanTriNhanSu/thongTinGiaDinh/allthongtin";

	}
}
