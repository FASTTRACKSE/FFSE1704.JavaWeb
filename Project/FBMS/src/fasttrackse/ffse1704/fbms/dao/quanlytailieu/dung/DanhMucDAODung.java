package fasttrackse.ffse1704.fbms.dao.quanlytailieu.dung;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung.DanhMucDung;
import fasttrackse.ffse1704.fbms.entity.security.PhongBan;

public interface DanhMucDAODung {

	public List<DanhMucDung> getAll();

	public void addDanhMuc(DanhMucDung danhmuc);

	public void updateDanhMuc(DanhMucDung danhmuc);
	
	public void deleteDanhMuc(final int id); 

	public DanhMucDung findById(final int id);
	
	public List<PhongBan> listQuyen();
}
