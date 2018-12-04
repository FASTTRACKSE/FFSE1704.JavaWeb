package fasttrackse.ffse1704.fbms.service.quanlyduan.nhanvienduan;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1704.fbms.dao.quanlyduan.nhanvienduan.NhanVienDuAnDao;
import fasttrackse.ffse1704.fbms.entity.quanlyduan.nhanvienduan.NhanVienDuAn;
/**
 * @author Joker
 *
 */
@Service
public class NhanVienDuAnServiceIPM implements NhanVienDuAnService {
	
	@Autowired
	private NhanVienDuAnDao nhanVienDuAnDao;
	
	public NhanVienDuAnDao getNhanVienDuAnDao() {
		return nhanVienDuAnDao;
	}

	public void setNhanVienDuAnDao(NhanVienDuAnDao nhanVienDuAnDao) {
		this.nhanVienDuAnDao = nhanVienDuAnDao;
	}

	@Override
	@Transactional
	public void addNew(NhanVienDuAn nhanVienDuAn) {
		this.nhanVienDuAnDao.addNew(nhanVienDuAn);

	}

	@Override
	@Transactional
	public void update(NhanVienDuAn nhanVienDuAn) {
		this.nhanVienDuAnDao.update(nhanVienDuAn);

	}

	@Override
	@Transactional
	public void delete(String maDuAn, String maNhanVien) {
		this.nhanVienDuAnDao.delete(maDuAn, maNhanVien);

	}

	@Override
	@Transactional
	public NhanVienDuAn getNhanVienDuAnByIdDuAnAndIdNhanVien(String maDuAn, String maNhanVien) {
		return this.nhanVienDuAnDao.getNhanVienDuAnByIdDuAnAndIdNhanVien(maDuAn, maNhanVien);
	}

	@Override
	@Transactional
	public List<NhanVienDuAn> listNhanVienDuAn(int iDisPlayStart, int iDinPlayLength) {
		return this.nhanVienDuAnDao.listNhanVienDuAn(iDisPlayStart, iDinPlayLength);
	}

	@Override
	@Transactional
	public int getRecordsTotal() {
		return this.nhanVienDuAnDao.getRecordsTotal();
	}

}
