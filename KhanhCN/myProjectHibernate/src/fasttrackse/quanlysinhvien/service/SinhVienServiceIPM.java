package fasttrackse.quanlysinhvien.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.quanlysinhvien.DAO.SinhVienDao;
import fasttrackse.quanlysinhvien.entity.SinhVien;

@Service
@Transactional
public class SinhVienServiceIPM implements SinhVienService {
	public SinhVienDao getSinhVienDao() {
		return sinhVienDao;
	}

	public void setSinhVienDao(SinhVienDao sinhVienDao) {
		this.sinhVienDao = sinhVienDao;
	}

	@Autowired
	SinhVienDao sinhVienDao;

	@Override
	@Transactional
	public List<SinhVien> listStudent() {
		return sinhVienDao.listStudent();
	}

	@Override
	@Transactional
	public void addStudent(SinhVien sv) {
		// TODO Auto-generated method stub
		sinhVienDao.addStudent(sv);

	}

	@Override
	public void updateStudent(SinhVien sv) {
		// TODO Auto-generated method stub
		sinhVienDao.editStudent(sv);
	}

	@Override
	public SinhVien getSinhVienById(int id) {
		// TODO Auto-generated method stub
		return sinhVienDao.getSinhVienById(id);
	}

	@Override
	public void deleteSinhVien(int id) {
		// TODO Auto-generated method stub
		sinhVienDao.deleteSinhVien(id);
	}

	@Override
	@Transactional
	public List<SinhVien> findAll(Integer offset, Integer maxResult) {
		return sinhVienDao.findAll(offset, maxResult);
	}

	@Override
	@Transactional
	public int count() {
		return sinhVienDao.count();
	}
}
