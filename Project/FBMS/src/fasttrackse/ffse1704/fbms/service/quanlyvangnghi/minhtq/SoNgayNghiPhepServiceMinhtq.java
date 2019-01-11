package fasttrackse.ffse1704.fbms.service.quanlyvangnghi.minhtq;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.DonNghiPhepMinhtq;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.SoNgayNghiMinhtq;

public interface SoNgayNghiPhepServiceMinhtq {
	public void addSoNgayNghiPhep(SoNgayNghiMinhtq songaynghi);

	public SoNgayNghiMinhtq getByIdSoNgayNghi(int id);

	public List<SoNgayNghiMinhtq> listSoNgayNghi();

	public SoNgayNghiMinhtq getNgayNghi(String maNhanVien, String maNgayNghi);

	public void addSNN(String maNhanVien, String maNgayNghi, int soNgayDaNghi);

	public boolean chekSongayNghi(String maNhanVien, String maNgayNghi);

}
