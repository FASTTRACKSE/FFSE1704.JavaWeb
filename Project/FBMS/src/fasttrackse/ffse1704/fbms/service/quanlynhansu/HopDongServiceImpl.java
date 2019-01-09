package fasttrackse.ffse1704.fbms.service.quanlynhansu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import fasttrackse.ffse1704.fbms.dao.quanlynhansu.HopDongDao;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.CheDoHuong;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.DanhSachCongViec;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.DanhSachNgayNghi;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.DiaDiemLamViec;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.HopDong;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ThongTinHopDong;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.TrangThaiHopDong;

@Service
@Transactional
public class HopDongServiceImpl implements HopDongService {
	@Autowired
	HopDongDao hopDongDao;

	public HopDongDao getHopDongDao() {
		return hopDongDao;
	}

	public void setHopDongDao(HopDongDao hopDongDao) {
		this.hopDongDao = hopDongDao;
	}

	public List<HopDong> listHopDong() {
		return hopDongDao.listHopDong();
	}

	public List<CheDoHuong> listCheDoHuong() {
		return hopDongDao.listCheDoHuong();
	}
	public void saveHopDongCheDo(ThongTinHopDong thongtinhopdong, boolean checkMaNV) {
		hopDongDao.saveHopDongCheDo(thongtinhopdong, checkMaNV);
	}
	public void editHopDong(ThongTinHopDong thongtinhopdong) {
		hopDongDao.editHopDong(thongtinhopdong);
	}
	public ThongTinHopDong findById(int id) {
		return hopDongDao.findById(id);
	}
	public void deleteHopDong(int id) {
		hopDongDao.deleteHopDong(id);
	}
	public List<DanhSachCongViec> listDanhSachCongViec() {
		return hopDongDao.listDanhSachCongViec();
	}

	@Override
	public List<DiaDiemLamViec> listDiaDiemLamViec() {
		return hopDongDao.listDiaDiemLamViec();
	}

	@Override
	public List<DanhSachNgayNghi> listDanhSachNgayNghi() {
		return hopDongDao.listDanhSachNgayNghi();
	}

	@Override
	public List<TrangThaiHopDong> TrangThaiHopDong() {
		return hopDongDao.TrangThaiHopDong();
	}

	@Override
	public HopDong findTenHopDongbyMaHopDong(String maHopDong) {
		return hopDongDao.findTenHopDongbyMaHopDong(maHopDong);
	}

	@Override
	public List<ThongTinHopDong> findByMNVandMHD(String maNhanVien, String maHopDong) {
		
		return hopDongDao.findByMNVandMHD(maNhanVien, maHopDong);
	}

	@Override
	public List<ThongTinHopDong> findByMNVandMTT(String maNhanVien, String maTrangThai) {
		return hopDongDao.findByMNVandMTT(maNhanVien, maTrangThai);
	}

	@Override
	public List<ThongTinHopDong> findByMNVandMHDandMTT(String maNhanVien, String maHopDong, String maTrangThai) {
		return hopDongDao.findByMNVandMHDandMTT(maNhanVien, maHopDong, maTrangThai);
	}

	@Override
	public void editNgayNghiPhepNam(String maNhanVien, int soNgayNghi) {
		 hopDongDao.editNgayNghiPhepNam(maNhanVien, soNgayNghi);
		
	}

	@Override
	public boolean checkExistMaNV(String maNhanVien) {
		return hopDongDao.checkExistMaNV(maNhanVien);
	}

	@Override
	public boolean checkExistMaTT(String maNhanVien, String maTrangThai) {
		return hopDongDao.checkExistMaTT(maNhanVien, maTrangThai);
	}

}
