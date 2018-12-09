package fasttrackse.ffse1704.fbms.dao.quanlynhansu;



import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.BangCap;


public interface BangCapDao {
	
	public List<BangCap> viewAll();
	public void addBangCap(BangCap bc);
	public List<BangCap> GetListBangCapByPage(int start,int total);
	public long CountBangCap();
	public BangCap getNhanSuByID(int id);
	public void update(BangCap ns);
	public void delete(int id);
	public boolean checkExistMa(String maNS);
}
