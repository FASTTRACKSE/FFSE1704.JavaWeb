package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.dao.SinhVienDao;
import spring.entity.SinhVien;
import spring.entity.TinhThanh;

@Service
@Transactional
public class SinhVienHBN implements SinhVienServiceHBN {

	@Autowired
	SinhVienDao sinhVienDao;

	public void setStudentDAO(SinhVienDao sinhVienDao) {
		this.sinhVienDao = sinhVienDao;

	}

	public void add(SinhVien sinhVien) {
		sinhVienDao.add(sinhVien);
	}

	public List<SinhVien> listSV() {
		return sinhVienDao.listStudent();
	}
	public List<TinhThanh> listTT() {
		return sinhVienDao.listTinhThanh();
	}

	public void delete(int id) {
		sinhVienDao.delete(id);
	}

	public void edit(SinhVien sinhVien) {
		sinhVienDao.edit(sinhVien);
	}

	public List<SinhVien> findAllForPaging(int startPosition, int maxResult) {
		return sinhVienDao.findAllForPaging(startPosition, maxResult);
	}
	public SinhVien fintByTd(int id) {
		return sinhVienDao.findById(id);
	}
}
