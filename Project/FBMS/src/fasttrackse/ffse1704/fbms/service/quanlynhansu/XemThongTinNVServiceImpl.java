package fasttrackse.ffse1704.fbms.service.quanlynhansu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1704.fbms.dao.quanlynhansu.XemThongTinNVDao;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.NhanSu;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.QuanHuyen;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ThongTinHopDong;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.XaPhuong;
import fasttrackse.ffse1704.fbms.entity.security.PhongBan;

@Service
@Transactional
public class XemThongTinNVServiceImpl implements XemThongTinNVService {
	@Autowired
	XemThongTinNVDao xemThongTinNVDao;

	public void setXemThongTinNVDao(XemThongTinNVDao xemThongTinNVDao) {
		this.xemThongTinNVDao = xemThongTinNVDao;
	}

	public List<PhongBan> listPhongBan() {
		return xemThongTinNVDao.listPhongBan();
	}

	public List<NhanSu> findByPhongBan(String maPhongBan) {
		return xemThongTinNVDao.findByPhongBan(maPhongBan);
	}

	public NhanSu findByMaNhanVien(String maNhanVien) {
		return xemThongTinNVDao.findByMaNhanVien(maNhanVien);
	}

	@Override
	public List<NhanSu> findAllForPaging(String maPhongBan, int startPosition, int maxResult) {
		return xemThongTinNVDao.findAllForPaging(maPhongBan, startPosition, maxResult);
	}

	@Override
	public PhongBan findTenPhongBanByMaPhongBan(String maPhongBan) {
		return xemThongTinNVDao.findTenPhongBanByMaPhongBan(maPhongBan);
	}

	@Override
	public List<QuanHuyen> findQuanHuyenByIdThanhPho(String maThanhPho) {
		return xemThongTinNVDao.findQuanHuyenByIdThanhPho(maThanhPho);
	}

	@Override
	public List<XaPhuong> findXaPhuongByIdQuanHuyen(String maQuanHuyen) {
		return xemThongTinNVDao.findXaPhuongByIdQuanHuyen(maQuanHuyen);
	}

	@Override
	public List<ThongTinHopDong> findTTByMaPhongBan(String maPhongBan) {
		return xemThongTinNVDao.findTTByMaPhongBan(maPhongBan);
	}

	@Override
	public ThongTinHopDong findPBCDByMaNhanVien(String maNhanVien) {
		return xemThongTinNVDao.findPBCDByMaNhanVien(maNhanVien);
	}
}
