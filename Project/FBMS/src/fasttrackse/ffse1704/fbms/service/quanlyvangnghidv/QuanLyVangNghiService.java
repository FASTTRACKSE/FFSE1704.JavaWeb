package fasttrackse.ffse1704.fbms.service.quanlyvangnghidv;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlyvangnghidv.DonNghi;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghidv.LoaiNghi;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghidv.TinhTrangNghi;
import fasttrackse.ffse1704.fbms.entity.security.UserAccount;

public interface QuanLyVangNghiService {
	
	public void addDon(DonNghi dn);
	public List<DonNghi> listDonNghiNhap(int idnv);
	public UserAccount getthongtinuser(String username);
	public TinhTrangNghi getTinhTrang(int idnv);
	public List<LoaiNghi> listLoaiNghi();
	public void insertUpdateTinhTrang(int idnv, TinhTrangNghi tt);
	public List<DonNghi> listDonNghiChoDuyet(int idnv);
	public DonNghi getDonNghinv(int iddon);
	public void updateDon(DonNghi dn);
	public void deleteDon(int iddon);
	public List<DonNghi> listDonNghiPhepDuyet1(String tenPhongBan);
	public List<DonNghi> listDonNghiPhepDuyet2();
	public List<DonNghi> listDonNghiTuChoi(int idnv, int start, int end);
	public List<DonNghi> listDanhSachPheDuyet(int idnv, int start, int end);
	public void updateTinhTrang(TinhTrangNghi tt);
	public Long countListDaDuyet(int idnv);
	public Long countListTuChoi(int idnv);
	public List<DonNghi> listdanhsachpheduyetcty();

}
