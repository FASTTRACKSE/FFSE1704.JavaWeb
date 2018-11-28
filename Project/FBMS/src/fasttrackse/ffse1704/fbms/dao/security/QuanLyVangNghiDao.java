package fasttrackse.ffse1704.fbms.dao.security;



import java.util.List;

import fasttrackse.ffse1704.fbms.entity.security.DonNghi;
import fasttrackse.ffse1704.fbms.entity.security.LoaiNghi;
import fasttrackse.ffse1704.fbms.entity.security.TinhTrangNghi;
import fasttrackse.ffse1704.fbms.entity.security.UserAccount;

public interface QuanLyVangNghiDao {
	
	public void adddon(DonNghi dn);
	public List<DonNghi> listDonNghiNhap(int idnv);
	public UserAccount getthongtinuser(String username);
	public TinhTrangNghi getTinhTrang(int idnv);
	public List<LoaiNghi> listLoaiNghi();
	public void insertTinhTrang(int idnv, TinhTrangNghi tt);
	public List<DonNghi> listDonNghiChoDuyet(int idnv);
	public DonNghi getDonNghinv(int iddon);
	public void updateDon(DonNghi dn);
	public void deleteDon(int iddon);
	public List<DonNghi> listDonNghiPheDuyet1(String tenPhongBan);
	public List<DonNghi> listDonNghiPheDuyet2();
	public List<DonNghi> listDonNghiPheDuyet(int idnv,int start,int end);
	public List<DonNghi> listDonNghiBiTuChoi(int idnv,int start,int end);
	public void updateTinhTrang(TinhTrangNghi tt);
	public Long countListDaDuyet(int idnv);
	public Long countListTuChoi(int idnv);
	public List<DonNghi> listdanhsachpheduyetcty();
}
