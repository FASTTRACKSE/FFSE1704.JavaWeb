package ffsespring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ffsespring.dao.SVDao;
import ffsespring.entity.DiemSinhVien;
import ffsespring.entity.SinhVien;

@Service
public class SinhVienServiceIPM implements SVService {
	@Autowired
	private SVDao svDao;

	public SVDao getSvDao() {
		return svDao;
	}

	public void setSvDao(SVDao svDao) {
		this.svDao = svDao;
	}

	
	@Override
	@Transactional
	public void addSinhVien(SinhVien sv) {
		// TODO Auto-generated method stub
		this.svDao.addSinhVien(sv);;
	}

	@Override
	@Transactional
	public void updateSinhVien(SinhVien sv) {
		// TODO Auto-generated method stub
		this.svDao.updateSinhVien(sv);;
	}

	@Override
	@Transactional
	public List<SinhVien> listSinhVien(int start, int end) {
		// TODO Auto-generated method stub
		return this.svDao.listSinhVien(start, end);
	}

	@Override
	@Transactional
	public SinhVien getSinhVien(String maSinhVien) {
		// TODO Auto-generated method stub
		return this.svDao.getSinhVien(maSinhVien);
	}

	@Override
	@Transactional
	public void deleteSinhVien(int maSinhVien) {
		this.svDao.deleteSinhVien(maSinhVien);;

	}

	@Override
	@Transactional
	public int countSinhVien() {
		// TODO Auto-generated method stub
		return this.svDao.countSinhVien();
	}

	@Override
	@Transactional
	public List<DiemSinhVien> getDiemSinhVien(String maSinhVien) {
	
		return this.svDao.getDiemSinhVien(maSinhVien);
	}


}
