package ffse1704.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ffse1704.entity.BangDiem;
import ffse1704.entity.SinhVien;
import ffse1704.model.SinhVienDAO;

@Service
public class SinhVienServiceImpl implements SinhVienService {

	@Autowired
	private SinhVienDAO sinhVienDAO;

	public SinhVienDAO getSinhVienDAO() {
		return sinhVienDAO;
	}

	public void setSinhVienDAO(SinhVienDAO sinhVienDAO) {
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

	@Override
	@Transactional
	public List<SinhVien> getEmployeesByPage(int pageid, int total) {
		// TODO Auto-generated method stub
		return this.sinhVienDAO.getEmployeesByPage(pageid, total);
	}

	@Override
	@Transactional
	public long countSV() {
		// TODO Auto-generated method stub
		return this.sinhVienDAO.countSV();
	}

	@Override
	@Transactional
	public List<BangDiem> getDiemSV(String maSV) {
		// TODO Auto-generated method stub
		return this.sinhVienDAO.getDiemSV(maSV);
	}

}
