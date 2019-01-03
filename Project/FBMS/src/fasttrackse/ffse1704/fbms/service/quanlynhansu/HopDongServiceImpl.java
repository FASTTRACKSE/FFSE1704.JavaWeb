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
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.SoNgayNghiNhanVien;
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
	public void saveHopDongCheDo(ThongTinHopDong thongtinhopdong) {
		hopDongDao.saveHopDongCheDo(thongtinhopdong);
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
	public SoNgayNghiNhanVien findNgayNghiConLaibyMaNV(String maNhanVien) {
		return hopDongDao.findNgayNghiConLaibyMaNV(maNhanVien);
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

}
