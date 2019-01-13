package fasttrackse.ffse1704.fbms.dao.quanlynhansu;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.CheDoHuong;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.DanhSachCongViec;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.DanhSachNgayNghi;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.DiaDiemLamViec;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.HopDong;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ThongTinHopDong;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.TrangThaiHopDong;


public interface HopDongDao {
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
	public List<ThongTinHopDong> findByMNVandMHDandMTT(String maNhanVien,String maHopDong, String maTrangThai);
	public List<ThongTinHopDong> findByMTT(String maTrangThai);
	public List<ThongTinHopDong> findByMNV(String maNhanVien);
	//update ngày nghỉ nếu đã có từ trước
	public void editNgayNghiPhepNam(String maNhanVien, int soNgayNghi);
	//check maNV trong ds ngay nghi
	public boolean checkExistMaNV(String maNhanVien);
	//check TrangThai Đang chờ duyệt trong thongTinHopDong
	public boolean checkExistMaTT(String maNhanVien, String maTrangThai);
	//check HopDongTruocKhiSua
	public boolean checkHDbyMaNV(int id, String tenNguoiCode);
	//Thêm phòng ban.  Chức Danh vào Hồ Sơ
	public void addPhongBanChucDanhtoHoSo(String maNhanVien, String maChucDanh,  String maPhongBan);
	//Update trạng thái hợp đồng cũ khi duyệt hợp đồng mới
	public void updateHopDongCu(String maNhanVien, String trangThai);
	//update Hết hạn hợp đồng nếu hết hạn
	public void updateHetHanHopDong(int id, String nguoiCode);
    //update trạng thái hợp đồng nếu đc duyệt
	public void pheDuyetHopDong(int id);
	//thêm ngày nghỉ nếu chưa có
	public void insertNgayNghi(String maNhanVien, int NgayNghiPhepNam);
	//từ chối hợp đồng
	public void tuChoiHopDong(int id);
	
	
}
