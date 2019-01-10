package fasttrackse.ffse1704.fbms.controller.quanlynhansu;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

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

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.BangCap;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.TrinhDo;
import fasttrackse.ffse1704.fbms.service.quanlynhansu.BangCapService;
import fasttrackse.ffse1704.fbms.service.quanlynhansu.XemThongTinNVService;

@Controller
public class BangCapController {
	@Autowired
	BangCapService bangCapService;

	public void setBangCapService(BangCapService bangCapService) {
		this.bangCapService = bangCapService;
	}

	@Autowired
	XemThongTinNVService xemThongTinNVService;

	public void setXemThongTinNVService(XemThongTinNVService xemThongTinNVService) {
		this.xemThongTinNVService = xemThongTinNVService;
	}

	// mac dinh
	// @RequestMapping("/ViewBC/")
	// public String ShowList() {
	// return "redirect:/ViewBC/1";
	//
	// }
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
	}

	// danh sach bằng cấp
	@RequestMapping(value = "/ViewBC/{maNhanVien}", method = RequestMethod.GET)
	public String ViewBangCap(@PathVariable("maNhanVien") String maNhanVien, Model model) {

		model.addAttribute("bangCap", bangCapService.getBangCapByID(maNhanVien));
		model.addAttribute("pbcd", xemThongTinNVService.findPBCDByMaNhanVien(maNhanVien));
		return "QuanTriNhanSu/BangCap/ListBangCap";

	}

	@RequestMapping(value = "/addBC/{maNhanVien}")
	public String ShowViewADD(Model model, @PathVariable("maNhanVien") String maNhanVien) {
		model.addAttribute("bang", new BangCap());
		model.addAttribute("bangCap", bangCapService.getBangCapByID(maNhanVien));
		model.addAttribute("pbcd", xemThongTinNVService.findPBCDByMaNhanVien(maNhanVien));
		List<TrinhDo> listTrinhDo = bangCapService.listTrinhDo();
		model.addAttribute("listTrinhDo", listTrinhDo);
		return "QuanTriNhanSu/BangCap/view_addBC";

	}

	@RequestMapping(value = "/saveBangCap/{maNhanVien}", method = RequestMethod.POST)
	public String addSave(Model model, @ModelAttribute("bang") BangCap bang,
			@PathVariable("maNhanVien") String maNhanVien) {

		// Long startTime = bang.getBatDau().getTime();
		// Long endTime = bang.getKetThuc().getTime();
		// Long secs = endTime - startTime;

		Date dateStart = bang.getBatDau();
		LocalDate LDStart = dateStart.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int yearStart = LDStart.getYear();

		Date dateEnd = bang.getKetThuc();
		LocalDate LDEnd = dateEnd.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int yearEnd = LDEnd.getYear();

		int secs = yearEnd - yearStart;
		if ((bang.getIdtrinhDo() == 1) && (secs >= 3) || (bang.getIdtrinhDo() == 2) && (secs > 1)
				|| (bang.getIdtrinhDo() == 3) && (secs > 2) || (bang.getIdtrinhDo() == 4) && (secs == 4)
				|| (bang.getIdtrinhDo() == 5) && (secs > 1) || (bang.getIdtrinhDo() == 6) && (secs > 3)) {

			bangCapService.addBangCap(bang);
			model.addAttribute("bangCap", bangCapService.getBangCapByID(maNhanVien));
		} else {
			model.addAttribute("bang", new BangCap());
			model.addAttribute("bangCap", bangCapService.getBangCapByID(maNhanVien));
			List<TrinhDo> listTrinhDo = bangCapService.listTrinhDo();
			model.addAttribute("listTrinhDo", listTrinhDo);
			model.addAttribute("attenion", "Thời gian kết thúc phải đúng. Đối với THPT:3 năm,Trung "
					+ "Cấp:trên 1 năm, Cao Đẳng trên 2 năm, Đại học 4 năm. Thạc sĩ:trên 1 năm,Tiến sĩ:trên 3 năm. Mời nhập lại");
			return "QuanTriNhanSu/BangCap/view_addBC";
		}

		return "QuanTriNhanSu/BangCap/ListBangCap";

	}

	// danh sach edit
	@RequestMapping(value = "/editBC/{id}&{maNhanVien}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") int id, @PathVariable("maNhanVien") String maNhanVien, Model model) {

		model.addAttribute("bangCap", bangCapService.getBangCapByID(maNhanVien));
		model.addAttribute("bangCap2", bangCapService.getBangCapUpdate(id));
		model.addAttribute("pbcd", xemThongTinNVService.findPBCDByMaNhanVien(maNhanVien));
		List<TrinhDo> listTrinhDo = bangCapService.listTrinhDo();
		model.addAttribute("listTrinhDo", listTrinhDo);
		return "QuanTriNhanSu/BangCap/editBangCap";

	}

	// UPDATE
	@RequestMapping(value = "/ViewBC/update/{maNhanVien}", method = RequestMethod.POST)
	public String editSave(@ModelAttribute("bangCap2") BangCap bangCap, @PathVariable("maNhanVien") String maNhanVien,
			Model model) {

		bangCapService.update(bangCap);

		model.addAttribute("bangCap", bangCapService.getBangCapByID(maNhanVien));

		return "QuanTriNhanSu/BangCap/ListBangCap";
	}

	@RequestMapping(value = "/DeleteBC/{id}&{maNhanVien}", method = RequestMethod.GET)
	public String ViewDeleteBC(@PathVariable("id") int id, @PathVariable("maNhanVien") String maNhanVien, Model model) {

		model.addAttribute("bangCap", bangCapService.getBangCapByID(maNhanVien));
		model.addAttribute("bangCap2", bangCapService.getBangCapUpdate(id));
		model.addAttribute("pbcd", xemThongTinNVService.findPBCDByMaNhanVien(maNhanVien));

		return "QuanTriNhanSu/BangCap/deleteBangCap";

	}

	@RequestMapping(value = "/ViewBC/delete/{id}&{maNhanVien}", method = RequestMethod.POST)
	public String doDelete(@ModelAttribute("id") int id, @PathVariable("maNhanVien") String maNhanVien, Model model) {

		bangCapService.delete(id);
		;

		model.addAttribute("bangCap", bangCapService.getBangCapByID(maNhanVien));

		return "QuanTriNhanSu/BangCap/ListBangCap";

	}
}
