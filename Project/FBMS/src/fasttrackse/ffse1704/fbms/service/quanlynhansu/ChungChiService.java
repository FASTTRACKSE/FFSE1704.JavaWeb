package fasttrackse.ffse1704.fbms.service.quanlynhansu;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ChungChi;

public interface ChungChiService {
	public List<ChungChi> allCC();
	
	public void addCC(ChungChi cc);
}
