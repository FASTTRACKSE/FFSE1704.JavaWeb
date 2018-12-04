package fasttrackse.ffse1704.fbms.service.quanlynhiemvu.khanhcn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1704.fbms.dao.quanlynhiemvu.khanhcn.QuanLyNhiemVuDao;
import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn.CongViecKhanhCN;
import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn.DuAnKhanhCN;

@Service
@Transactional
public class QuanLyNhiemVuServiceImpl implements QuanLyNhiemVuService {

	@Autowired
	QuanLyNhiemVuDao congViecDao;

	public QuanLyNhiemVuDao getNhiemVuDao() {
		return congViecDao;
	}

	public void setNhiemVuDao(QuanLyNhiemVuDao nhiemVuDao) {
		this.congViecDao = nhiemVuDao;
	}

	// List danh sách công việc
	@Override
	public List<CongViecKhanhCN> congViec() {
		// TODO Auto-generated method stub
		return congViecDao.congViec();
	}

	@Override
	public void addCongViec(CongViecKhanhCN cv) {
		congViecDao.addCongViec(cv);

	}

	@Override
	public void updateCongViec(CongViecKhanhCN cv) {
		// TODO Auto-generated method stub
		congViecDao.updateCongViec(cv);

	}

}
