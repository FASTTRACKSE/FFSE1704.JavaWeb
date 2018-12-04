package fasttrackse.ffse1704.fbms.service.quanlyvangnghi.minhtq;

import java.util.List;

import fasttrackse.ffse1704.fbms.dao.quanlyvangnghi.minhtq.DonNghiPhepDaoMinhtq;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.DonNghiPhepMinhtq;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.LoaiNgayNghiMinhtq;

public interface DonNghiPhepServiceMinhtq {
	public List<DonNghiPhepMinhtq> listDonNghiPhepNhap();

	public DonNghiPhepMinhtq getByIdDonNghiPhepNhap(int id);

	public void deleteDonNghiPhepNhap(int id);

	public void editDonNghiPhepNhap(DonNghiPhepMinhtq donnghiphepnhap);

	public void addDonNghiPhepNhap(DonNghiPhepMinhtq donnghiphepnhap);

	public List<LoaiNgayNghiMinhtq> listLoaiNgayNghi();
	
	

}
