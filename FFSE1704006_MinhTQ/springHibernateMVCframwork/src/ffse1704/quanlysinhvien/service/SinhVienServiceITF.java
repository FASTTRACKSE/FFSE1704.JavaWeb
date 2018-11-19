package ffse1704.quanlysinhvien.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ffse1704.quanlysinhvien.entity.DiemSinhVien;
import ffse1704.quanlysinhvien.entity.SinhVien;
import ffse1704.quanlysinhvien.model.SinhVienDAO;

@Service
@Transactional
public class SinhVienServiceITF implements SinhVienService {

	@Autowired
	SinhVienDAO sinhVienDAO;

	public void setStudentDAO(SinhVienDAO sinhVienDAO) {
		this.sinhVienDAO = sinhVienDAO;

	}

	public void add(SinhVien sinhvien) {
		sinhVienDAO.add(sinhvien);
	}

	public SinhVien findById(int id) {
		return sinhVienDAO.findById(id);
	}

	public void delete(int id) {
		sinhVienDAO.delete(id);
	}

	

	public List<SinhVien> listSinhVien() {
		
		return sinhVienDAO.listSinhVien();
	}

	public void edit(SinhVien sinhvien) {
		sinhVienDAO.edit(sinhvien);

	}
	
	@Override
	public List<SinhVien> findAll(Integer offset, Integer maxResult) {
		// TODO Auto-generated method stub
		return sinhVienDAO.findAll(offset, maxResult);
	}
	
	@Override
	public int count() {
		return sinhVienDAO.count();
	}

	

	
}