package fasttrackse.ffse1704.fbms.service.quanlytailieu.dung;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1704.fbms.dao.quanlytailieu.dung.DanhMucDAODung;
import fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung.DanhMucDung;
import fasttrackse.ffse1704.fbms.entity.security.PhongBan;

@Service

@Transactional
public class DanhMucServiceImplDung implements DanhMucServiceDung {
	@Autowired
	private DanhMucDAODung danhMucDAO;

	@Override
	public List<DanhMucDung> getAll() {
		return danhMucDAO.getAll();

	}

	@Override
	public void addDanhMuc(DanhMucDung danhmuc) {
		danhMucDAO.addDanhMuc(danhmuc);
	}

	@Override
	public void updateDanhMuc(DanhMucDung danhmuc) {
		danhMucDAO.updateDanhMuc(danhmuc);
	}
	@Override
	public void deleteDanhMuc(int id) {
		danhMucDAO.deleteDanhMuc(id);
	}
	
	@Override
	public DanhMucDung findById(final int id) {
		return danhMucDAO.findById(id);
		
	}
	
	@Override
	@Transactional
	//List toàn bộ phòng ban (Quyền truy cập)
	public List<PhongBan> listQuyen(){
		return danhMucDAO.listQuyen();
	}
	
}
