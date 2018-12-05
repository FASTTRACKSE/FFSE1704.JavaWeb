package fasttrackse.ffse1704.fbms.service.quanlynhansu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1704.fbms.dao.quanlynhansu.ThongTinGiaDinhDao;
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
	public void addTT(ThongTinGiaDinh tt) {
		this.thongTinGiaDinhDao.addTT(tt);
	}

	@Override
	public void updateTT(ThongTinGiaDinh tt) {
		this.thongTinGiaDinhDao.updateTT(tt);
	}

	@Override
	public ThongTinGiaDinh getThongTinById(int id) {
		return this.thongTinGiaDinhDao.getThongTinById(id);
	}

	@Override
	public void deleteTT(ThongTinGiaDinh tt) {
		this.thongTinGiaDinhDao.deleteTT(tt);
	}

	@Override
	public List<ThongTinGiaDinh> getThongTinByPage(int pageid, int total) {
		return this.thongTinGiaDinhDao.getThongTinByPage(pageid, total);
	}

	@Override
	public long countTT() {
		return this.thongTinGiaDinhDao.countTT();
	}

}
