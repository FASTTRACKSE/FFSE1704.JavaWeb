package fasttrackse.ffse1704.fbms.controller.quanlynhansu;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;


import fasttrackse.ffse1704.fbms.entity.quanlynhansu.CheDoHuong;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.DanhSachCongViec;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.DanhSachNgayNghi;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.DiaDiemLamViec;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.HopDong;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ThongTinHopDong;
import fasttrackse.ffse1704.fbms.service.quanlynhansu.HopDongService;
import fasttrackse.ffse1704.fbms.service.quanlynhansu.NhanSuService;
import fasttrackse.ffse1704.fbms.service.quanlynhansu.XemThongTinNVService;

@Controller
public class HopDongCheDoController {
	
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

	@Autowired
	HopDongService hopDongService;

	public HopDongService getHopDongService() {
		return hopDongService;
	}

	public void setHopDongService(HopDongService hopDongService) {
		this.hopDongService = hopDongService;
	}

	@RequestMapping(value = "/thongTinHopDong/{maNhanVien}", method = RequestMethod.GET)
	public String thongTinHopDong(@PathVariable("maNhanVien") String maNhanVien, Model model) {
		model.addAttribute("thongTinNhanVien", xemThongTinNVService.findByMaNhanVien(maNhanVien));
		model.addAttribute("pbcd", xemThongTinNVService.findPBCDByMaNhanVien(maNhanVien));
		return "QuanTriNhanSu/xemThongTinHoSo/listthongtinHopDong";
	}
	
	@RequestMapping(value = "/thongTinChiTietHopDong/{maNhanVien}&{id}", method = RequestMethod.GET)
	public String thongTinChiTietHopDong(@PathVariable("maNhanVien") String maNhanVien,@PathVariable("id") int id, Model model) {
		model.addAttribute("thongTinNhanVien", xemThongTinNVService.findByMaNhanVien(maNhanVien));
		model.addAttribute("ngaynghiconlai", hopDongService.findNgayNghiConLaibyMaNV(maNhanVien));
		List<DanhSachNgayNghi> listDSNN = hopDongService.listDanhSachNgayNghi();
		model.addAttribute("dsnn", listDSNN);
		model.addAttribute("hopDong", hopDongService.findById(id));
		return "QuanTriNhanSu/xemThongTinHoSo/chitietHopDong";
	}
	
	@RequestMapping(value = "/addHopDongCheDo/{maNhanVien}")
	public String addHopDongCheDo(Model model, @PathVariable("maNhanVien") String maNhanVien) {
		model.addAttribute("hopdongchedo", new ThongTinHopDong());
		model.addAttribute("thongTinNhanVien", xemThongTinNVService.findByMaNhanVien(maNhanVien));
		List<HopDong> listHD = hopDongService.listHopDong();
		model.addAttribute("hd", listHD);
		List<CheDoHuong> listCDH = hopDongService.listCheDoHuong();
		model.addAttribute("cdh", listCDH);
		List<DanhSachCongViec> listDSCV = hopDongService.listDanhSachCongViec();
		model.addAttribute("dscv", listDSCV);
		List<DiaDiemLamViec> listDDLV = hopDongService.listDiaDiemLamViec();
		model.addAttribute("ddlv", listDDLV);
		model.addAttribute("listChucDanh", nhanSuService.listChucDanh());
		model.addAttribute("listPhongBan", nhanSuService.listPhongBan());
		model.addAttribute("listTrangThaiHopDong", hopDongService.TrangThaiHopDong());
		return "QuanTriNhanSu/HopDongCheDo/add";
	}
	

	
	@RequestMapping(value = { "/saveHopDongCheDo/{maNhanVien}" }, method = RequestMethod.POST)
	public String saveHopDongCheDo(@PathVariable("maNhanVien") String maNhanVien,@Valid ThongTinHopDong hopdongchedo, BindingResult result,
        Model model) {
		hopDongService.saveHopDongCheDo(hopdongchedo);
		return "redirect:/thongTinHopDong/{maNhanVien}";
	}
	
	@RequestMapping(value = "/editHopDong/{id}&{maNhanVien}", method = RequestMethod.GET)
	public String editGiaBan(@PathVariable("id") int id, @PathVariable("maNhanVien") String maNhanVien, Model model) {
		model.addAttribute("thongTinNhanVien", xemThongTinNVService.findByMaNhanVien(maNhanVien));
		model.addAttribute("hopdong", hopDongService.findById(id));
		List<HopDong> listHD = hopDongService.listHopDong();
		model.addAttribute("hd", listHD);
		List<CheDoHuong> listCDH = hopDongService.listCheDoHuong();
		model.addAttribute("cdh", listCDH);
		List<DanhSachCongViec> listDSCV = hopDongService.listDanhSachCongViec();
		model.addAttribute("dscv", listDSCV);
		List<DiaDiemLamViec> listDDLV = hopDongService.listDiaDiemLamViec();
		model.addAttribute("ddlv", listDDLV);
		model.addAttribute("listChucDanh", nhanSuService.listChucDanh());
		model.addAttribute("listPhongBan", nhanSuService.listPhongBan());
		model.addAttribute("listTrangThaiHopDong", hopDongService.TrangThaiHopDong());
		return "QuanTriNhanSu/HopDongCheDo/edit";
	}
	@RequestMapping(value = "/editHopDongCheDo/{maNhanVien}&{id}", method = RequestMethod.POST)
	public String editGiaBan(@PathVariable("maNhanVien") String maNhanVien, @PathVariable("id") int id,Model model, @ModelAttribute("hopdong") @Valid ThongTinHopDong thongtinhopdong, HttpSession session,
			MultipartFile file, BindingResult bindingResult) throws IllegalStateException, IOException {
		hopDongService.editHopDong(thongtinhopdong);
		return "redirect:/thongTinHopDong/{maNhanVien}";
	}
	@RequestMapping("/deleteHopDongCheDo/{id}&{maNhanVien}")
	public String deleteHopDongCheDo(@PathVariable("id") int id, @PathVariable("maNhanVien") String maNhanVien, HttpSession session, Model model) {
		hopDongService.deleteHopDong(id);
		return "redirect:/thongTinHopDong/{maNhanVien}";
	}
}
