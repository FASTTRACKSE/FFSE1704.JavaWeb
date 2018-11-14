package ffse1704.fasttrack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ffse1704.fasttrack.dao.SinhVienDao;
import ffse1704.fasttrack.entity.SinhVien;

@Service
public class SinhVienServiceImlp implements SinhVienService {

	@Autowired
	SinhVienDao sinhVienDao;

	@Override
	@Transactional
	public List<SinhVien> getAllSinhViens() {
		return sinhVienDao.getAllSinhViens();
	}

	@Override
	@Transactional
	public void saveSV(SinhVien v) {
		sinhVienDao.saveSV(v);
	}

	@Override
	@Transactional
	public SinhVien getSinhVien(int theId) {
		return sinhVienDao.getSinhVien(theId);
	}

	@Override
	@Transactional
	public void deleteSV(int theId) {
		sinhVienDao.deleteSV(theId);
		
	}

}
