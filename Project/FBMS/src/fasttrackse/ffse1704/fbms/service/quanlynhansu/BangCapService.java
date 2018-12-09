package fasttrackse.ffse1704.fbms.service.quanlynhansu;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.BangCap;

public interface BangCapService {

	public List<BangCap> viewAll();
	public void addBangCap(BangCap bc);
	public List<BangCap> GetListBangCapByPage(int start,int total);
	public long CountBangCap();
	public BangCap getNhanSuByID(int id);
	public void update(BangCap ns);
	public void delete(int id);
	public boolean checkExistMa(String maNS);
}
