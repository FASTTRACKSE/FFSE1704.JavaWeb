package fasttrackse.ffse1704.fbms.dao.quanlynhansu;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.NhanSu;

public interface NhanSuDao {
	public List<NhanSu> allNS();
	public void addNS(NhanSu ns);
	public List<NhanSu> GetListNhanSuByPage(int start,int total);
	public long CountNhanSu();
	public NhanSu getNhanSuByID(int id);
	public void update(NhanSu ns);
	
}
