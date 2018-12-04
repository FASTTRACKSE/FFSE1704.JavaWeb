package fasttrackse.ffse1704.fbms.service.quanlynhansu;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ChungChi;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.NhanSu;

public interface ChungChiService {
	public void addCC(ChungChi cc);
	
	public void updateCC(ChungChi cc);
	
	public ChungChi getChungChiById(int id);
	
	public void deleteCC(ChungChi cc);
	
	public List<ChungChi> getChungChiByPage(int pageid, int total);
	
	public long countSV();
}
