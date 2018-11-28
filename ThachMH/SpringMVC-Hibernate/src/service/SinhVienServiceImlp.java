package service;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import dao.SinhVienDao;
import entity.SinhVien;
public class SinhVienServiceImlp implements SinhVienService {
	
	@Autowired
	SinhVienDao sinhVienDao;

	@Override
	@Transactional
	public List<SinhVien> getAllSinhVien() {
		// TODO Auto-generated method stub
		return sinhVienDao.getAllSinhVien();
	}

}
