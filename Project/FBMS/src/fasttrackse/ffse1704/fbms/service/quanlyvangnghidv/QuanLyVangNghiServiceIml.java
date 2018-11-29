package fasttrackse.ffse1704.fbms.service.quanlyvangnghidv;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1704.fbms.dao.quanlyvangnghidv.QuanLyVangNghiDao;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghidv.DonNghi;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghidv.LoaiNghi;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghidv.TinhTrangNghi;
import fasttrackse.ffse1704.fbms.entity.security.UserAccount;

@Service
public class QuanLyVangNghiServiceIml implements QuanLyVangNghiService{
	@Autowired
	private QuanLyVangNghiDao qlvnDao;
	
	public void setQlvnDao(QuanLyVangNghiDao qlvnDao) {
		this.qlvnDao = qlvnDao;
	}
	
	@Transactional
	@Override
	public void addDon(DonNghi dn) {
		this.qlvnDao.adddon(dn);
	}
	
	@Transactional
	@Override
	public List<DonNghi> listDonNghiNhap(int idnv) {
		return this.qlvnDao.listDonNghiNhap(idnv);
	}

	@Transactional
	@Override
	public UserAccount getthongtinuser(String username) {
		return this.qlvnDao.getthongtinuser(username);
	}
	
	@Transactional
	@Override
	public TinhTrangNghi getTinhTrang(int idnv) {
		return this.qlvnDao.getTinhTrang(idnv);
	}
	
	@Transactional
	@Override
	public List<LoaiNghi> listLoaiNghi() {
		return this.qlvnDao.listLoaiNghi();
	}

	@Transactional
	@Override
	public void insertUpdateTinhTrang(int idnv, TinhTrangNghi tt) {
		this.qlvnDao.insertTinhTrang(idnv, tt);
		
	}
	
	@Transactional
	@Override
	public List<DonNghi> listDonNghiChoDuyet(int idnv) {
		return this.qlvnDao.listDonNghiChoDuyet(idnv);
	}
	
	@Transactional
	@Override
	public DonNghi getDonNghinv(int iddon) {
		return this.qlvnDao.getDonNghinv(iddon);
	}
	
	@Transactional
	@Override
	public void updateDon(DonNghi dn) {
		 this.qlvnDao.updateDon(dn);
		
	}
	
	
	@Transactional
	@Override
	public void deleteDon(int iddon) {
		this.qlvnDao.deleteDon(iddon);
	}
	
	@Transactional
	@Override
	public List<DonNghi> listDonNghiPhepDuyet1(String tenPhongBan) {
		return this.listDonNghiPhepDuyet1(tenPhongBan);
	}
	
	@Transactional
	@Override
	public List<DonNghi> listDonNghiPhepDuyet2() {
		return this.listDonNghiPhepDuyet2();
	}
	
	@Transactional
	@Override
	public List<DonNghi> listDonNghiTuChoi(int idnv, int start, int end) {
		return this.qlvnDao.listDonNghiBiTuChoi(idnv, start, end);
	}
	
	@Transactional
	@Override
	public List<DonNghi> listDanhSachPheDuyet(int idnv,int start,int end) {
		return this.qlvnDao.listDonNghiPheDuyet(idnv, start, end);
	}
	
	@Transactional
	@Override
	public void updateTinhTrang(TinhTrangNghi tt) {
		this.qlvnDao.updateTinhTrang(tt);
	}

	@Transactional
	@Override
	public Long countListDaDuyet(int idnv) {
		return this.qlvnDao.countListDaDuyet(idnv);
	}
	
	@Transactional
	@Override
	public Long countListTuChoi(int idnv) {
		return this.qlvnDao.countListTuChoi(idnv);
	}
	
	@Transactional
	@Override
	public List<DonNghi> listdanhsachpheduyetcty() {
		return this.qlvnDao.listdanhsachpheduyetcty();
	}

}
