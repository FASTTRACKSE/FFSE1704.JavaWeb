package fasttrackse.ffse1704.fbms.service.quanlyvangnghi.minhtq;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.DonNghiPhepMinhtq;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.SoNgayNghiMinhtq;

public interface SoNgayNghiPhepServiceMinhtq {
	public void addSoNgayNghiPhep(SoNgayNghiMinhtq songaynghi);

	public SoNgayNghiMinhtq getByIdSoNgayNghi(int id);

	public List<SoNgayNghiMinhtq> listSoNgayNghi();

	public int KiemTraNgayNghi(DonNghiPhepMinhtq donnghiphep);

}
