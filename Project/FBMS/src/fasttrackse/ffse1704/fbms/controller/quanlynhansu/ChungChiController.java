package fasttrackse.ffse1704.fbms.controller.quanlynhansu;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.servlet.ModelAndView;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.BangCap;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ChungChi;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.HopDong;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.NhanSu;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.TrangThaiNhanSu;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.TrinhDo;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.fromqlda.QuanLyThongTinDuAnNS;
import fasttrackse.ffse1704.fbms.entity.security.PhongBan;
import fasttrackse.ffse1704.fbms.service.quanlynhansu.ChungChiService;
import fasttrackse.ffse1704.fbms.service.quanlynhansu.NhanSuService;
import fasttrackse.ffse1704.fbms.service.quanlynhansu.XemThongTinNVService;

@Controller
public class ChungChiController {

	@Autowired
	ChungChiService chungChiService;

	public void setChungChiService(ChungChiService chungChiService) {
		this.chungChiService = chungChiService;
	}

	@Autowired
	NhanSuService nhanSuService;

	public void setNhanSuService(NhanSuService nhanSuService) {
		this.nhanSuService = nhanSuService;
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

	@RequestMapping(value = "/ViewCC/{maNhanVien}", method = RequestMethod.GET)
	public String ViewChungChi(@PathVariable("maNhanVien") String maNhanVien, Model model) {
		model.addAttribute("chungChi", chungChiService.getChungChiByID(maNhanVien));
		model.addAttribute("pbcd", xemThongTinNVService.findPBCDByMaNhanVien(maNhanVien));
		return "QuanTriNhanSu/chungChi/allchungchi";
	}

	@RequestMapping(value = "/addCC/{maNhanVien}")
	public String ViewAddChungChi(Model model, @PathVariable("maNhanVien") String maNhanVien) {
		model.addAttribute("chungChi", new ChungChi());
		model.addAttribute("chungChi2", chungChiService.getChungChiByID(maNhanVien));
		model.addAttribute("pbcd", xemThongTinNVService.findPBCDByMaNhanVien(maNhanVien));
		return "QuanTriNhanSu/chungChi/addCC";
	}

	@RequestMapping(value = "saveCC/{maNhanVien}")
	public String AddChungChi(@PathVariable("maNhanVien") String maNhanVien,
			@ModelAttribute("chungChi") @Valid ChungChi chungChi, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("chungChi", new ChungChi());
			model.addAttribute("chungChi2", chungChiService.getChungChiByID(maNhanVien));
			model.addAttribute("pbcd", xemThongTinNVService.findPBCDByMaNhanVien(maNhanVien));
			model.addAttribute("thatbai", "Xin mời bạn nhập lại!");
			return "QuanTriNhanSu/chungChi/addCC";
		}
		
		chungChiService.addChungChi(chungChi);
		return ("redirect:/ViewCC/{maNhanVien}");
	}

	@RequestMapping("/updateCC/{id}&{maNhanVien}")
	public String ShowViewUpdate(Model model, @PathVariable("maNhanVien") String maNhanVien,
			@PathVariable("id") int id) {
		model.addAttribute("chungChi1", new ChungChi());
		model.addAttribute("chungChi", chungChiService.getChungChiByID(maNhanVien));
		model.addAttribute("chungChi2", chungChiService.getChungChiUpdate(id));
		model.addAttribute("pbcd", xemThongTinNVService.findPBCDByMaNhanVien(maNhanVien));
		return "QuanTriNhanSu/chungChi/updateCC";
	}

	@RequestMapping(value = "/viewUpdate/{maNhanVien}")
	public ModelAndView UpdateCC(@PathVariable("maNhanVien") String maNhanVien,
			@ModelAttribute("chungChi") ChungChi chungChi) {
		chungChiService.update(chungChi);
		return new ModelAndView("redirect:/ViewCC/{maNhanVien}");
	}

	@RequestMapping("/deleteCC/{id}&{maNhanVien}")
	public String ShowViewDelete(Model model, @PathVariable("maNhanVien") String maNhanVien,
			@PathVariable("id") int id) {
		model.addAttribute("chungChi1", new ChungChi());
		model.addAttribute("chungChi", chungChiService.getChungChiByID(maNhanVien));
		model.addAttribute("pbcd", xemThongTinNVService.findPBCDByMaNhanVien(maNhanVien));
		model.addAttribute("chungChi2", chungChiService.getChungChiUpdate(id));
		return "QuanTriNhanSu/chungChi/deleteCC";
	}

	@RequestMapping(value = "/viewDelete/{ID}/{maNhanVien}")
	public ModelAndView DeleteCC(@PathVariable("maNhanVien") String maNhanVien, @PathVariable("ID") int id) {
		chungChiService.delete(id);
		return new ModelAndView("redirect:/ViewCC/{maNhanVien}");
	}

	@RequestMapping(value = "/listBCfindbyMaBangCap", method = RequestMethod.GET)
	public String ThongKeBC(@RequestParam("dsTrinhDoId") int IdtrinhDo, Model model) {
		List<BangCap> trangThai = chungChiService.findMaBangByMaTrinhDo(IdtrinhDo);
		model.addAttribute("trangThai", trangThai);
		model.addAttribute("trinhdo", chungChiService.findTenTrinhDoByMaTrinhDo(IdtrinhDo));

		List<NhanSu> dsNhanSu = nhanSuService.allNS();
		model.addAttribute("nSu", dsNhanSu);

		List<TrinhDo> dsTrinhDoBC = chungChiService.listTrinhDo();
		model.addAttribute("dsTrinhDo", dsTrinhDoBC);

		List<TrangThaiNhanSu> dsTrangThai = nhanSuService.listTrangThai();
		model.addAttribute("dsTrangThai", dsTrangThai);

		List<PhongBan> allPhongBan = xemThongTinNVService.listPhongBan();
		model.addAttribute("dsPhongBan", allPhongBan);

		List<HopDong> allHopDong = xemThongTinNVService.listHopDong();
		model.addAttribute("dsHopDong", allHopDong);

		List<QuanLyThongTinDuAnNS> allDuAn = xemThongTinNVService.listDuAn();
		model.addAttribute("dsDuAn", allDuAn);

		return "QuanTriNhanSu/chungChi/listTrinhDoByBC";

	}

}
