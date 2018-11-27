package ffse1704.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ffse1704.entity.SinhVien;
import ffse1704.model.SinhVienDao;

@Service
@Transactional
public class SinhVienServicelmpl implements SinhVienService {

	@Autowired
	private SinhVienDao sinhVienDAO;

	public SinhVienDao getSinhVienDAO() {
		return sinhVienDAO;
	}

	public void setSinhVienDAO(SinhVienDao sinhVienDAO) {
		this.sinhVienDAO = sinhVienDAO;
	}

	@Override
	@Transactional
	public void addSV(SinhVien p) {
		// TODO Auto-generated method stub
		this.sinhVienDAO.addSV(p);
	}

	@Override
	@Transactional
	public void update(SinhVien p) {
		// TODO Auto-generated method stub
		this.sinhVienDAO.update(p);
	}

	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		this.sinhVienDAO.delete(id);
	}

	@Override
	@Transactional
	public SinhVien getSinhVienById(int id) {
		// TODO Auto-generated method stub
		return this.sinhVienDAO.getSinhVienById(id);
	}

/*	@Override
	@Transactional
	public List<SinhVien> getEmployeesByPage(int pageid, int total) {
		// TODO Auto-generated method stub
		return this.sinhVienDAO.getEmployeesByPage(pageid, total);
	}*/

/*	@Override
	@Transactional
	public int countSV() {
		// TODO Auto-generated method stub
		return this.sinhVienDAO.countSV();
	}*/
	
	public List<SinhVien> getAllSinhVien(){
		return sinhVienDAO.getAllSinhVien();
		
	}


}
