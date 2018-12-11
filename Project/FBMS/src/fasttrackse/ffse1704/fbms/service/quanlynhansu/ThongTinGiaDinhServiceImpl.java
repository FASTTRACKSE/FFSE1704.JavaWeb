package fasttrackse.ffse1704.fbms.service.quanlynhansu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1704.fbms.dao.quanlynhansu.ThongTinGiaDinhDao;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.NhanSu;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ThongTinGiaDinh;

@Service
@Transactional
public class ThongTinGiaDinhServiceImpl implements ThongTinGiaDinhService {
	@Autowired
	ThongTinGiaDinhDao thongTinGiaDinhDao;

	public ThongTinGiaDinhDao getThongTinGiaDinhDao() {
		return thongTinGiaDinhDao;
	}

	public void setThongTinGiaDinhDao(ThongTinGiaDinhDao thongTinGiaDinhDao) {
		this.thongTinGiaDinhDao = thongTinGiaDinhDao;
	}

	@Override
	public List<ThongTinGiaDinh> viewAll() {
		return this.thongTinGiaDinhDao.viewAll();
	}

	@Override
	public void addThongTinGiaDinh(ThongTinGiaDinh tt) {
this.thongTinGiaDinhDao.addThongTinGiaDinh(tt);		
	}

	@Override
	public List<ThongTinGiaDinh> GetListThongTinGiaDinhByPage(int start, int total) {
		return this.thongTinGiaDinhDao.GetListThongTinGiaDinhByPage(start, total);
	}

	@Override
	public long CountThongTinGiaDinh() {
		return this.thongTinGiaDinhDao.CountThongTinGiaDinh();
	}

	@Override
	public NhanSu getThongTinGiaDinhByID(String id) {
		return this.thongTinGiaDinhDao.getThongTinGiaDinhByID(id);
	}

	@Override
	public void update(ThongTinGiaDinh tt) {
this.thongTinGiaDinhDao.update(tt);		
	}

	@Override
	public void delete(int id) {
this.thongTinGiaDinhDao.delete(id);		
	}

	@Override
	public boolean checkExistMa(String maNS) {
		return this.thongTinGiaDinhDao.checkExistMa(maNS);
	}

	@Override
	public ThongTinGiaDinh getThongTinGiaDinhUpdate(int id) {
		return this.thongTinGiaDinhDao.getThongTinGiaDinhUpdate(id);
	}

	

}
