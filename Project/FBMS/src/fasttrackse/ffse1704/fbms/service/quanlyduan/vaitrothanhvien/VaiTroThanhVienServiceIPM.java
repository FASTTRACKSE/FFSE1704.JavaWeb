package fasttrackse.ffse1704.fbms.service.quanlyduan.vaitrothanhvien;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1704.fbms.dao.quanlyduan.vaitrothanhvien.VaiTroThanhVienDao;
import fasttrackse.ffse1704.fbms.entity.quanlyduan.vaitrothanhvien.VaiTroThanhVien;
/**
 * @author Joker
 *
 */
@Service
public class VaiTroThanhVienServiceIPM implements VaiTroThanhVienService {
	@Autowired
	private VaiTroThanhVienDao vaiTroThanhVienDao;
	
	public VaiTroThanhVienDao getVaiTroThanhVienDao() {
		return vaiTroThanhVienDao;
	}

	public void setVaiTroThanhVienDao(VaiTroThanhVienDao vaiTroThanhVienDao) {
		this.vaiTroThanhVienDao = vaiTroThanhVienDao;
	}

	@Override
	@Transactional
	public void addNew(VaiTroThanhVien vaiTroThanhVien) {
		this.vaiTroThanhVienDao.addNew(vaiTroThanhVien);

	}

	@Override
	@Transactional
	public void update(VaiTroThanhVien vaiTroThanhVien) {
		this.vaiTroThanhVienDao.update(vaiTroThanhVien);

	}

	@Override
	@Transactional
	public void delete(String VaiTroThanhVien) {
		this.vaiTroThanhVienDao.delete(VaiTroThanhVien);

	}

	@Override
	@Transactional
	public VaiTroThanhVien getVaiTroThanhVienByIdVaiTroThanhVien(String maVaiTroThanhVien) {
		return this.vaiTroThanhVienDao.getVaiTroThanhVienByIdVaiTroThanhVien(maVaiTroThanhVien);
	}

	@Override
	@Transactional
	public List<VaiTroThanhVien> listVaiTroThanhVien(int iDisPlayStart, int iDinPlayLength) {
		return this.vaiTroThanhVienDao.listVaiTroThanhVien(iDisPlayStart, iDinPlayLength);
	}

	@Override
	@Transactional
	public int getRecordsTotal() {
		return this.vaiTroThanhVienDao.getRecordsTotal();
	}

	@Override
	public int getRecordsByIdVaiTroThanhVien(String maVaiTroThanhVien) {
		return this.vaiTroThanhVienDao.getRecordsByIdVaiTroThanhVien(maVaiTroThanhVien);
	}

}
