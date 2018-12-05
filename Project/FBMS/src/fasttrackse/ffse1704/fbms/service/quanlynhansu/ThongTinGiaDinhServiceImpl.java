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
	public List<ThongTinGiaDinh> dsThongTin() {
		return this.thongTinGiaDinhDao.dsThongTin();
	}

}
