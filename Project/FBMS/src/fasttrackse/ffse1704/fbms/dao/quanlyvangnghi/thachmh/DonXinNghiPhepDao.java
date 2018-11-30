package fasttrackse.ffse1704.fbms.dao.quanlyvangnghi.thachmh;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.thachmh.DonXinNghiPhep;

public interface DonXinNghiPhepDao {
	public List<DonXinNghiPhep> getAllDonXinNghiPhep();
	public void addNew(DonXinNghiPhep dx);
}
