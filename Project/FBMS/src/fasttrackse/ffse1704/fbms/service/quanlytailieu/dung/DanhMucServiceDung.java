package fasttrackse.ffse1704.fbms.service.quanlytailieu.dung;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung.DanhMucDung;
import fasttrackse.ffse1704.fbms.entity.security.PhongBan;

public interface DanhMucServiceDung {

	public List<DanhMucDung> getAll();

	public void addDanhMuc(DanhMucDung danhmuc);

	public List<PhongBan> listQuyen();
	
	public DanhMucDung findById(final int id);
	
	public void updateDanhMuc(DanhMucDung danhmuc);
	
	public void deleteDanhMuc(int id);
}

