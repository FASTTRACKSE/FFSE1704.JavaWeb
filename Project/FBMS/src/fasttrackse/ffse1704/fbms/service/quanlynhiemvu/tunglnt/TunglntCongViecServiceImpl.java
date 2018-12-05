package fasttrackse.ffse1704.fbms.service.quanlynhiemvu.tunglnt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1704.fbms.dao.quanlynhiemvu.tunglnt.TunglntCongViecDao;
import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.tunglnt.TunglntCongViec;
import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.tunglnt.TunglntDuAn;
import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.tunglnt.TunglntLoaiCongViec;
import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.tunglnt.TunglntTrangThai;
import fasttrackse.ffse1704.fbms.entity.security.HoSoNhanVien;
@Service
public class TunglntCongViecServiceImpl implements TunglntCongViecService{

	@Autowired
	private TunglntCongViecDao tunglntCongViecDao;
	public TunglntCongViecDao getTunglntCongViecDao() {
		return tunglntCongViecDao;
	}
	public void setTunglntCongViecDao(TunglntCongViecDao tunglntCongViecDao) {
		this.tunglntCongViecDao = tunglntCongViecDao;
	}
	@Override
	public List<TunglntCongViec> AllCV() {
		// TODO Auto-generated method stub
		return tunglntCongViecDao.AllCV();
	}
	@Override
	public List<TunglntTrangThai> trangThai() {
		// TODO Auto-generated method stub
		return tunglntCongViecDao.trangThai();
	}
	@Override
	public List<TunglntLoaiCongViec> loaiCongViec() {
		// TODO Auto-generated method stub
		return tunglntCongViecDao.loaiCongViec();
	}
	@Override
	public List<TunglntDuAn> duAn() {
		// TODO Auto-generated method stub
		return tunglntCongViecDao.duAn();
	}
	@Override
	public List<HoSoNhanVien> nhanVien() {
		// TODO Auto-generated method stub
		return tunglntCongViecDao.nhanVien();
	}

	
}
