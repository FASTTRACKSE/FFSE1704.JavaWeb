package fasttrackse.ffse1704.fbms.dao.quanlyvangnghi.minhtq;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.DonNghiPhep;

public interface DonNghiPhepDao {

	public List<DonNghiPhep> listDonNghiPhep();
	public DonNghiPhep getByIdDonNghiPhep(int id);

	public void deleteDonNghiPhep(int id);

	public void editDonNghiPhep(DonNghiPhep donnghiphep);

	public void addDonNghiPhep(DonNghiPhep donnghiphep);

	

	
	
}
