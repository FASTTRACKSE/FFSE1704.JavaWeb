package fasttrackse.ffse1704.fbms.service.quanlynhansu;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.CheDoHuong;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.DanhSachCongViec;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.DanhSachNgayNghi;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.DiaDiemLamViec;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.HopDong;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ThongTinHopDong;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.TrangThaiHopDong;

public interface HopDongService {
	public List<HopDong> listHopDong();

	public List<CheDoHuong> listCheDoHuong();

	public void saveHopDongCheDo(ThongTinHopDong thongtinhopdong, boolean checkMaNV);

	public void editHopDong(ThongTinHopDong thongtinhopdong);

	public ThongTinHopDong findById(int id);

	public void deleteHopDong(int id);

	public List<DanhSachCongViec> listDanhSachCongViec();

	public List<DiaDiemLamViec> listDiaDiemLamViec();

	public List<DanhSachNgayNghi> listDanhSachNgayNghi();

	public List<TrangThaiHopDong> TrangThaiHopDong();

	public HopDong findTenHopDongbyMaHopDong(String maHopDong);

	public List<ThongTinHopDong> findByMNVandMHD(String maNhanVien, String maHopDong);

	public List<ThongTinHopDong> findByMNVandMTT(String maNhanVien, String maTrangThai);

	public List<ThongTinHopDong> findByMNVandMHDandMTT(String maNhanVien, String maHopDong, String maTrangThai);

	public void editNgayNghiPhepNam(String maNhanVien, int soNgayNghi);

	public boolean checkExistMaNV(String maNhanVien);

	public boolean checkExistMaTT(String maNhanVien, String maTrangThai);

	public boolean checkHDbyMaNV(int id, String tenNguoiCode);

	public void addPhongBanChucDanhtoHoSo(String maNhanVien, String maChucDanh, String maPhongBan);

	public void updateHopDongCu(String maNhanVien, String trangThai);
	
	public List<ThongTinHopDong> findByMTT(String maTrangThai);
	
	public List<ThongTinHopDong> findByMNV(String maNhanVien);
	
	public void updateHetHanHopDong(int id, String nguoiCode);
	
	public void pheDuyetHopDong(int id);
	
	public void insertNgayNghi(String maNhanVien, int NgayNghiPhepNam);
	
	public void tuChoiHopDong(int id);
}
