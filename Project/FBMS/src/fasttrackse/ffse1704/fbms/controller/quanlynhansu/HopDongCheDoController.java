package fasttrackse.ffse1704.fbms.controller.quanlynhansu;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.CheDoHuong;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.DanhSachCongViec;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.DanhSachNgayNghi;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.DiaDiemLamViec;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.HopDong;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.NhanSu;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.QuanLySoNgayNghi;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ThongTinHopDong;
import fasttrackse.ffse1704.fbms.entity.security.PhongBan;
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
		//find list hợp đồng by Mã NV
		List<ThongTinHopDong> listTTHD = hopDongService.findByMNV(maNhanVien);
		for (int i = 0; i < listTTHD.size(); i++) {
			int id = listTTHD.get(i).getId();
			String nguoiCode = "QuanLT";
			Date ngayKTTest = listTTHD.get(i).getNgayKetThuc();
			Date today = new Date(System.currentTimeMillis());
			if (ngayKTTest.compareTo(today) < 0) {
				//Kiểm tra xem có hợp đồng nào hết hạn không.
				//Nếu có update trạng thái
				hopDongService.updateHetHanHopDong(id, nguoiCode);
			} else {

			}
		}
		model.addAttribute("thongTinNhanVien", xemThongTinNVService.findByMaNhanVien(maNhanVien));
		List<HopDong> listHD = hopDongService.listHopDong();
		model.addAttribute("hd", listHD);
		model.addAttribute("listTrangThaiHopDong", hopDongService.TrangThaiHopDong());

		return "QuanTriNhanSu/xemThongTinHoSo/listthongtinHopDong";
	}

	@RequestMapping(value = "/thongTinChiTietHopDong/{maNhanVien}&{id}", method = RequestMethod.GET)
	public String thongTinChiTietHopDong(@PathVariable("maNhanVien") String maNhanVien, @PathVariable("id") int id,
			Model model) {
		model.addAttribute("thongTinNhanVien", xemThongTinNVService.findByMaNhanVien(maNhanVien));
		
		List<DanhSachNgayNghi> listDSNN = hopDongService.listDanhSachNgayNghi();
		model.addAttribute("dsnn", listDSNN);
		//chi tiết hợp đồng by id
		model.addAttribute("hopDong", hopDongService.findById(id));
		return "QuanTriNhanSu/xemThongTinHoSo/chitietHopDong";
	}

	@RequestMapping(value = "/addHopDongCheDo/{maNhanVien}")
	public String addHopDongCheDo(Model model, @PathVariable("maNhanVien") String maNhanVien) {
		//view add
		model.addAttribute("hopdongchedo", new ThongTinHopDong());
		model.addAttribute("thongTinNhanVien", xemThongTinNVService.findByMaNhanVien(maNhanVien));
		//combobox
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
	public String saveHopDongCheDo(@PathVariable("maNhanVien") String maNhanVien, @Valid ThongTinHopDong hopdongchedo,
			BindingResult result, Model model) {
		//trạng thái mặc định
		String trangThai = "WAITING";
		Date ngayBatDau = hopdongchedo.getNgayBatDau();
		Date ngayKetThuc = hopdongchedo.getNgayKetThuc();
		hopdongchedo.setMaTrangThai(trangThai);
		if (result.hasErrors()) {
			model.addAttribute("attenion", "Vui lòng nhập đầy đủ ngày bắt đầu và ngày kết thúc hợp đồng!!!");
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
		} else {
			boolean checkMaNV = hopDongService.checkExistMaNV(maNhanVien);
			if (ngayBatDau.compareTo(ngayKetThuc) > 0) {
				//Kiểm tra ô ngày bắt đầu có lớn hơn ngày kết thúc ??
				model.addAttribute("attenion", "Ngày bắt đầu đã lớn hơn ngày kết thúc hợp đồng!!!");
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
			} else {
				boolean checkHDChoPheDuyet = hopDongService.checkExistMaTT(maNhanVien, trangThai);
				//Check xem có hợp đồng nào đang đợi duyệt ko?
				if (checkHDChoPheDuyet) {
					model.addAttribute("attenion", "Nhân viên này đang có một hợp đồng đang đợi duyệt!!!");
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
				} else {
					hopDongService.saveHopDongCheDo(hopdongchedo, checkMaNV);
				}
			}
		}

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
	public String editGiaBan(@PathVariable("maNhanVien") String maNhanVien, @PathVariable("id") int id, Model model,
			@ModelAttribute("hopdong") @Valid ThongTinHopDong thongtinhopdong, HttpSession session, MultipartFile file,
			BindingResult bindingResult) throws IllegalStateException, IOException {
		String trangThai = "WAITING";
		thongtinhopdong.setMaTrangThai(trangThai);
		if (bindingResult.hasErrors()) {
			model.addAttribute("attenion", "Vui lòng nhập đầy đủ ngày bắt đầu và ngày kết thúc hợp đồng!!!");
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
		} else {
			Date ngayBatDau = thongtinhopdong.getNgayBatDau();
			Date ngayKetThuc = thongtinhopdong.getNgayKetThuc();
			if (ngayBatDau.compareTo(ngayKetThuc) > 0) {
				model.addAttribute("attenion", "Ngày bắt đầu đã lớn hơn ngày kết thúc hợp đồng!!!");
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
			} else {
				hopDongService.editHopDong(thongtinhopdong);

			}
		}

		return "redirect:/thongTinChiTietHopDong/{maNhanVien}&{id}";
	}

	@RequestMapping("/deleteHopDongCheDo/{id}&{maNhanVien}")
	public String deleteHopDongCheDo(@PathVariable("id") int id, @PathVariable("maNhanVien") String maNhanVien,
			HttpSession session, Model model) {

		hopDongService.deleteHopDong(id);
		return "redirect:/thongTinHopDong/{maNhanVien}";
	}

	@RequestMapping(value = "/findListHDByMultiOption", method = RequestMethod.GET)
	public String submit(@RequestParam("maNV") String maNhanVien, @RequestParam("maHD") String maHopDong,
			@RequestParam("maTT") String maTrangThai, Model model) {
		List<HopDong> listHD = hopDongService.listHopDong();
		model.addAttribute("hd", listHD);
		// Combobox Loai Hop Dong
		model.addAttribute("listTrangThaiHopDong", hopDongService.TrangThaiHopDong());
		// Combobox Trang thai HD
		// ThonngTinNhanVien
		model.addAttribute("thongTinNhanVien", xemThongTinNVService.findByMaNhanVien(maNhanVien));
		if (maHopDong.equals("KO")) {
			// Nếu mã HĐ = "KO" và có Mã Trạng Thái Thì Tìm kiếm theo mã NV và mã Trạng Thái
			model.addAttribute("listHopDong", hopDongService.findByMNVandMTT(maNhanVien, maTrangThai));
			return "QuanTriNhanSu/xemThongTinHoSo/listthongtinHopDongSearch";
		} else if (maTrangThai.equals("KO")) {
			// Nếu mã Trạng thái = "KO" và có Mã HĐ Thì Tìm kiếm theo mã NV và HĐ
			model.addAttribute("listHopDong", hopDongService.findByMNVandMHD(maNhanVien, maHopDong));
			return "QuanTriNhanSu/xemThongTinHoSo/listthongtinHopDongSearch";
		} else {
			// Nếu có cả Mã HĐ và Mã TT thì tìm kiếm theo Mã NV, Mã HĐ, mã TT
			model.addAttribute("listHopDong", hopDongService.findByMNVandMHDandMTT(maNhanVien, maHopDong, maTrangThai));
			return "QuanTriNhanSu/xemThongTinHoSo/listthongtinHopDongSearch";
		}

	}

	@RequestMapping(value = "/pheDuyetHopDong")
	public String thongTinHopDong(Model model) {
		String maTrangThai = "WAITING";
		model.addAttribute("listHDPD", hopDongService.findByMTT(maTrangThai));
		return "QuanTriNhanSu/HopDongCheDo/viewDSChuaPheDuyet";
	}

	@RequestMapping(value = "/thongTinChiTietHopDongPheDuyet/{maNhanVien}&{id}", method = RequestMethod.GET)
	public String thongTinChiTietHopDongPheDuyet(@PathVariable("maNhanVien") String maNhanVien,
			@PathVariable("id") int id, Model model) {
		model.addAttribute("thongTinNhanVien", xemThongTinNVService.findByMaNhanVien(maNhanVien));

		List<DanhSachNgayNghi> listDSNN = hopDongService.listDanhSachNgayNghi();
		model.addAttribute("dsnn", listDSNN);
		model.addAttribute("hopDong", hopDongService.findById(id));
		return "QuanTriNhanSu/HopDongCheDo/chitietHopDongPheDuyet";
	}

	@RequestMapping(value = "/accessHopDong/{id}&{maNhanVien}&{soNgayNghiTrongNam}&{maHopDong}&{maChucDanh}&{maPhongBan}", method = RequestMethod.GET)
	public String pheDuyetHopDong(@PathVariable("maNhanVien") String maNhanVien, @PathVariable("id") int id,
			@PathVariable("soNgayNghiTrongNam") int soNgayNghiTrongNam, @PathVariable("maHopDong") String maHopDong, @PathVariable("maChucDanh") String maChucDanh, @PathVariable("maPhongBan") String maPhongBan,
			Model model) {
		boolean checkMaNVTrongNN = hopDongService.checkExistMaNV(maNhanVien);
		String trangThai = "NEXT";
		if (checkMaNVTrongNN && maHopDong.equals("HD3")) {
			hopDongService.updateHopDongCu(maNhanVien, trangThai);
			hopDongService.editNgayNghiPhepNam(maNhanVien, soNgayNghiTrongNam);
			hopDongService.pheDuyetHopDong(id);
			hopDongService.addPhongBanChucDanhtoHoSo(maNhanVien, maChucDanh, maPhongBan);
		} else if (!checkMaNVTrongNN && maHopDong.equals("HD3")) {
			hopDongService.updateHopDongCu(maNhanVien, trangThai);
			hopDongService.insertNgayNghi(maNhanVien, soNgayNghiTrongNam);
			hopDongService.pheDuyetHopDong(id);
			hopDongService.addPhongBanChucDanhtoHoSo(maNhanVien, maChucDanh, maPhongBan);
		} else {
			hopDongService.updateHopDongCu(maNhanVien, trangThai);
			hopDongService.pheDuyetHopDong(id);
			hopDongService.addPhongBanChucDanhtoHoSo(maNhanVien, maChucDanh, maPhongBan);
		}
		return "redirect:/pheDuyetHopDong";
	}

	@RequestMapping(value = "/refuseHopDong/{id}", method = RequestMethod.GET)
	public String pheDuyetHopDong(@PathVariable("id") int id, Model model) {
		hopDongService.tuChoiHopDong(id);
		return "redirect:/pheDuyetHopDong";
	}
}
