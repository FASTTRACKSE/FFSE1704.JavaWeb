package fasttrackse.ffse1704.fbms.service.quanlynhansu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1704.fbms.dao.quanlynhansu.NhanSuDao;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.NhanSu;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.QuanHuyen;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.QuocTich;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ThanhPho;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.TrangThaiNhanSu;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.XaPhuong;
import fasttrackse.ffse1704.fbms.entity.security.ChucDanh;
import fasttrackse.ffse1704.fbms.entity.security.PhongBan;

@Service
@Transactional
public class NhanSuServiceImpl implements NhanSuService {
	@Autowired
	NhanSuDao nhanSuDao;


	public NhanSuDao getNhanSuDao() {
		return nhanSuDao;
	}


	public void setNhanSuDao(NhanSuDao nhanSuDao) {
		this.nhanSuDao = nhanSuDao;
	}


	@Override
	public List<NhanSu> allNS() {
		return nhanSuDao.allNS();
	}


	@Override
	public void addNS(NhanSu ns) {
		this.nhanSuDao.addNS(ns);
	}
	@Override
	public List<NhanSu> GetListNhanSuByPage(int start, int total) {
		
		return this.nhanSuDao.GetListNhanSuByPage(start, total);
	}
	@Override
	public long CountNhanSu() {
		// TODO Auto-generated method stub
		return this.nhanSuDao.CountNhanSu();
	}
	@Override
	public NhanSu getNhanSuByID(int id) {
		// TODO Auto-generated method stub
		return this.nhanSuDao.getNhanSuByID(id);
	}


	@Override
	public void update(NhanSu ns) {
		this.nhanSuDao.update(ns);
		
	}


	@Override
	public void delete(int id) {
		this.nhanSuDao.delete(id);
		
	}


	@Override
	public boolean checkExistMa(String maNS) {
		
		return nhanSuDao.checkExistMa(maNS);
	}


	@Override
	public List<ChucDanh> listChucDanh() {
		
		return nhanSuDao.listChucDanh();
	}


	@Override
	public List<PhongBan> listPhongBan() {
		
		return nhanSuDao.listPhongBan();
	}


	@Override
	public List<ThanhPho> listTinhThanhPho() {
		return nhanSuDao.listTinhThanhPho();
	}





	@Override
	public List<QuanHuyen> listQuanHuyenbyID(String maTinhThanh) {
		
		return nhanSuDao.listQuanHuyenbyID(maTinhThanh);
	}





	@Override
	public List<XaPhuong> listPhuongXabyID(String maQuanHuyen) {
		
		return nhanSuDao.listPhuongXabyID(maQuanHuyen);
	}


	@Override
	public List<QuanHuyen> listQuanHuyen() {
		
		return nhanSuDao.listQuanHuyen();
	}


	@Override
	public List<XaPhuong> listXaPhuong() {
		
		return nhanSuDao.listXaPhuong();
	}


	@Override
	public List<QuocTich> listQuocTich() {
		
		return nhanSuDao.listQuocTich();
	}


	@Override
	public List<TrangThaiNhanSu> listTrangThai() {
		
		return nhanSuDao.listTrangThai();
	}




}
