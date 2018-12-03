package fasttrackse.ffse1704.fbms.dao.quanlynhansu;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ChungChi;

public interface ChungChiDao {
	public List<ChungChi> allCC();
	
	public void addCC(ChungChi cc);
	
	public void updateCC(ChungChi cc);
	
	public ChungChi getChungChiById(int id);
	
	public void deleteCC(ChungChi cc);
	
	public List<ChungChi> getEmployeesByPage(int pageid, int total);
	
	public long countSV();
}
