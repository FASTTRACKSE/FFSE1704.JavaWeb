package fasttrackse.ffse1704.fbms.service.quanlynhansu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1704.fbms.dao.quanlynhansu.XemThongTinNVDao;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.NhanSu;
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
}
