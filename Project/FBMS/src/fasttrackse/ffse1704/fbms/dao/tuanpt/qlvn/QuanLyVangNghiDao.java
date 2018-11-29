package fasttrackse.ffse1704.fbms.dao.tuanpt.qlvn;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.tuanpt.qlvn.DonNghi;
import fasttrackse.ffse1704.fbms.entity.tuanpt.qlvn.LyDo;
import fasttrackse.ffse1704.fbms.entity.tuanpt.qlvn.TinhTrang;
import fasttrackse.ffse1704.fbms.entity.security.UserAccount;

public interface QuanLyVangNghiDao {
	public void addDon(DonNghi donnghi);
	public List<DonNghi> listDonNghiNhap(int id_nhan_vien);
	public UserAccount getThongTinUser(String username);
	public TinhTrang getTinhTrang(int id_nhanvien);
	public List<LyDo> listLyDo();
	public void insertTinhTrang(int id_nhan_vien, TinhTrang tinhtrang);
	public List<DonNghi> listDonNghiChoDuyet(int id_nhan_vien);
	public DonNghi getDonNghiNv(int id_don_nghi);
	public void updateDon(DonNghi donnghi); 
	public void deleteDon(int id_don_nghi );
	public List<DonNghi> listDonNghiPheDuyet1(String tenPhongBan);
	public List<DonNghi> listDonNghiPheDuyet2();
	public List<DonNghi> listDanhSachPheDuyet(int id_nhan_vien,int start,int end);
	public List<DonNghi> listDonNghiBiTuChoi(int id_nhan_vien,int start,int end);
	public void updateTinhTrang(TinhTrang tinhtrang);
	public Long countListDaDuyet(int id_nhan_vien);
	public Long countListTuChoi(int id_nhan_vien);
	public List<DonNghi> listdanhsachpheduyetcty();
}
