package fasttrackse.ffse1704.fbms.service.quanlyvangnghi.thachmh;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.thachmh.DonXinNghiPhep;

public interface DonXinNghiPhepService {
	public List<DonXinNghiPhep> getAllDonXinNghiPhep();
	public void addNew(DonXinNghiPhep dx);
	public void update(DonXinNghiPhep dx);
	public DonXinNghiPhep findByidDon(int idDon);
	public void delete(int idDon);


}
