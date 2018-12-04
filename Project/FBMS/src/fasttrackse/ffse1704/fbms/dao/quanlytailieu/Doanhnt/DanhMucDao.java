package fasttrackse.ffse1704.fbms.dao.quanlytailieu.Doanhnt;


import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlytailieu.Doanhnt.DanhMuc;

public interface DanhMucDao {
	public List<DanhMuc> listAllDanhMuc();

	public void addDM(DanhMuc dm);

	public void updateDM(DanhMuc dm);

	public void deleteDM(String id);

	public DanhMuc getDMbyID(String id);
	
	public List<DanhMuc> listAllDanhMuc(int start, int limit,String sql);

	public String getRecordTotal();
	
}