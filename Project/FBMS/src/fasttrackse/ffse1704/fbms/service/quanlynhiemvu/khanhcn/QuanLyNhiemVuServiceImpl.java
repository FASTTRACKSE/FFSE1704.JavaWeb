package fasttrackse.ffse1704.fbms.service.quanlynhiemvu.khanhcn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1704.fbms.dao.quanlynhiemvu.khanhcn.QuanLyNhiemVuDao;
import fasttrackse.ffse1704.fbms.entity.quanlyduan.thongtinduan.ThongTinDuAn;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.NhanSu;
import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn.CongViecKhanhCN;
import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn.DuAnKhanhCN;
import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn.LoaiCongViec;
import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn.NhanVienDuAn;
import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn.NhanVienKhanhCN;
import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn.TrangThaiKhanhCN;

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

	@Override
	public CongViecKhanhCN findByID(int id) {
		// TODO Auto-generated method stub
		return congViecDao.findByID(id);
	}

	@Override
	public void deleteCongViec(int id) {
		// TODO Auto-generated method stub
		congViecDao.deleteCongViec(id);

	}

	@Override
	public List<TrangThaiKhanhCN> trangThai() {
		// TODO Auto-generated method stub
		return congViecDao.trangThai();
	}

	@Override
	public List<LoaiCongViec> loaiCongViec() {
		// TODO Auto-generated method stub
		return congViecDao.loaiCongViec();
	}

	@Override
	public List<DuAnKhanhCN> duAn() {
		// TODO Auto-generated method stub
		return congViecDao.duAn();
	}

	@Override
	public List<NhanVienDuAn> nhanVienDuAn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NhanVienKhanhCN> nhanVien() {
		// TODO Auto-generated method stub
		return congViecDao.nhanVien();
	}

}
