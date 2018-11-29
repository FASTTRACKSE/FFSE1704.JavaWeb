package fasttrackse.ffse1704.fbms.dao.quanlynhansu;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ChungChi;

public interface ChungChiDao {
	public List<ChungChi> allCC();
	
	public void addCC(ChungChi cc);
}
