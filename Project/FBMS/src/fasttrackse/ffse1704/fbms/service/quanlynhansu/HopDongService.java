package fasttrackse.ffse1704.fbms.service.quanlynhansu;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.CheDoHuong;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.DanhSachCongViec;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.DanhSachNgayNghi;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.DiaDiemLamViec;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.HopDong;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.SoNgayNghiNhanVien;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ThongTinHopDong;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.TrangThaiHopDong;


public interface HopDongService {
	public List<HopDong> listHopDong();
	public List<CheDoHuong> listCheDoHuong();
	public void saveHopDongCheDo(ThongTinHopDong thongtinhopdong);
	public void editHopDong(ThongTinHopDong thongtinhopdong);
	public ThongTinHopDong findById(int id);
	public void deleteHopDong(int id);
	public List<DanhSachCongViec> listDanhSachCongViec();
	public List<DiaDiemLamViec> listDiaDiemLamViec();
	public SoNgayNghiNhanVien findNgayNghiConLaibyMaNV(String maNhanVien);
	public List<DanhSachNgayNghi> listDanhSachNgayNghi();
	public List<TrangThaiHopDong> TrangThaiHopDong();
}
