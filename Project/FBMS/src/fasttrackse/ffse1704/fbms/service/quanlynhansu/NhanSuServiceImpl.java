package fasttrackse.ffse1704.fbms.service.quanlynhansu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1704.fbms.dao.quanlynhansu.NhanSuDao;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.NhanSu;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.QuanHuyen;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ThanhPho;
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
	public List<ThanhPho> listTinhThanh() {
		
		return nhanSuDao.listTinhThanh();
	}


	@Override
	public List<QuanHuyen> listQuanHuyen() {
		
		return nhanSuDao.listQuanHuyen();
	}


	@Override
	public List<XaPhuong> listXaPhuong() {
		// TODO Auto-generated method stub
		return nhanSuDao.listXaPhuong();
	}

}
