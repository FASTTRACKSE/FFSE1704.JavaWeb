package fasttrackse.ffse1704.fbms.controller.quanlynhansu;

import java.io.IOException;
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
		model.addAttribute("thongTinNhanVien", xemThongTinNVService.findByMaNhanVien(maNhanVien));
		model.addAttribute("pbcd", xemThongTinNVService.findPBCDByMaNhanVien(maNhanVien));
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
		model.addAttribute("hopDong", hopDongService.findById(id));
		model.addAttribute("pbcd", xemThongTinNVService.findPBCDByMaNhanVien(maNhanVien));
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
		model.addAttribute("pbcd", xemThongTinNVService.findPBCDByMaNhanVien(maNhanVien));
		return "QuanTriNhanSu/HopDongCheDo/add";
	}

	@RequestMapping(value = { "/saveHopDongCheDo/{maNhanVien}" }, method = RequestMethod.POST)
	public String saveHopDongCheDo(@PathVariable("maNhanVien") String maNhanVien, @Valid ThongTinHopDong hopdongchedo,
			BindingResult result, Model model) {
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
			model.addAttribute("pbcd", xemThongTinNVService.findPBCDByMaNhanVien(maNhanVien));
			return "QuanTriNhanSu/HopDongCheDo/add";
		} else {
			int soNgayNghi = hopdongchedo.getSoNgayNghiTrongNam();
			String maHD = hopdongchedo.getMaHopDong();
			String trangThaiHD = hopdongchedo.getMaTrangThai();
			boolean checkMaNV = hopDongService.checkExistMaNV(maNhanVien);
			boolean checkTT = hopDongService.checkExistMaTT(maNhanVien, trangThaiHD);
			Date ngayBatDau = hopdongchedo.getNgayBatDau();
			Date ngayKetThuc = hopdongchedo.getNgayKetThuc();
			if (ngayBatDau.compareTo(ngayKetThuc) > 0) { 
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
				model.addAttribute("pbcd", xemThongTinNVService.findPBCDByMaNhanVien(maNhanVien));
				return "QuanTriNhanSu/HopDongCheDo/add";
			} else {
				if (checkTT && trangThaiHD.equals("ACTIVE")) {
					model.addAttribute("attenion",
							"Nhân viên này đang có 1 hợp đồng còn hiệu lực, vui lòng kiểm tra lại!!!");
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
					model.addAttribute("pbcd", xemThongTinNVService.findPBCDByMaNhanVien(maNhanVien));
					return "QuanTriNhanSu/HopDongCheDo/add";
				} else {

					if (checkMaNV && maHD.equals("HD3") && trangThaiHD.equals("ACTIVE")) {
						hopDongService.editNgayNghiPhepNam(maNhanVien, soNgayNghi);
						hopDongService.saveHopDongCheDo(hopdongchedo, checkMaNV);

					} else {
						hopDongService.saveHopDongCheDo(hopdongchedo, checkMaNV);
					}
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
		model.addAttribute("pbcd", xemThongTinNVService.findPBCDByMaNhanVien(maNhanVien));
		return "QuanTriNhanSu/HopDongCheDo/edit";
	}

	@RequestMapping(value = "/editHopDongCheDo/{maNhanVien}&{id}", method = RequestMethod.POST)
	public String editGiaBan(@PathVariable("maNhanVien") String maNhanVien, @PathVariable("id") int id, Model model,
			@ModelAttribute("hopdong") @Valid ThongTinHopDong thongtinhopdong, HttpSession session, MultipartFile file,
			BindingResult bindingResult) throws IllegalStateException, IOException {
		int soNgayNghi = thongtinhopdong.getSoNgayNghiTrongNam();
		String maHD = thongtinhopdong.getMaHopDong();
		String trangThaiHD = thongtinhopdong.getMaTrangThai();
		String tenNguoiCode = "QuanLT";
		// check xem hợp đồng có phải là Active, trước khi check lỗi .
		boolean checkHD = hopDongService.checkHDbyMaNV(id, tenNguoiCode);

		if (checkHD) {
			//nếu phải là Active trước thì:
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
				model.addAttribute("pbcd", xemThongTinNVService.findPBCDByMaNhanVien(maNhanVien));
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
					model.addAttribute("pbcd", xemThongTinNVService.findPBCDByMaNhanVien(maNhanVien));
					return "QuanTriNhanSu/HopDongCheDo/edit";
				}else {
					if (maHD.equals("HD3") && trangThaiHD.equals("ACTIVE")) {
						hopDongService.editNgayNghiPhepNam(maNhanVien, soNgayNghi);
						hopDongService.editHopDong(thongtinhopdong);
					} else {
						hopDongService.editHopDong(thongtinhopdong);
					}
					}
				}
		} else {
			//nếu ko phải thì:
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
				model.addAttribute("pbcd", xemThongTinNVService.findPBCDByMaNhanVien(maNhanVien));
				return "QuanTriNhanSu/HopDongCheDo/edit";
			} else {
				boolean checkTT = hopDongService.checkExistMaTT(maNhanVien, trangThaiHD);
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
					model.addAttribute("pbcd", xemThongTinNVService.findPBCDByMaNhanVien(maNhanVien));
					return "QuanTriNhanSu/HopDongCheDo/edit";
				} else {
					if (checkTT && trangThaiHD.equals("ACTIVE")) {
						model.addAttribute("attenion",
								"Nhân viên này đang có 1 hợp đồng còn hiệu lực, vui lòng kiểm tra lại!!!");
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
						model.addAttribute("pbcd", xemThongTinNVService.findPBCDByMaNhanVien(maNhanVien));
						return "QuanTriNhanSu/HopDongCheDo/edit";
					} else {
						if (maHD.equals("HD3") && trangThaiHD.equals("ACTIVE")) {
							hopDongService.editNgayNghiPhepNam(maNhanVien, soNgayNghi);
							hopDongService.editHopDong(thongtinhopdong);
						} else {
							hopDongService.editHopDong(thongtinhopdong);
						}
					}
				}
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
		// Phong ban -ChucDanh
		model.addAttribute("pbcd", xemThongTinNVService.findPBCDByMaNhanVien(maNhanVien));
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
}
