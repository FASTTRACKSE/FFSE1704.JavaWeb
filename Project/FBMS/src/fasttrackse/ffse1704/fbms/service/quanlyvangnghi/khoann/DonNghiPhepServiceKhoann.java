package fasttrackse.ffse1704.fbms.service.quanlyvangnghi.khoann;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.khoann.DonNghiPhepKhoann;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.khoann.LoaiHinhNghiPhepKhoann;

public interface DonNghiPhepServiceKhoann {

	public List<DonNghiPhepKhoann> listDonNghiPhep();

	public void themDon(DonNghiPhepKhoann hs);

	public DonNghiPhepKhoann getNhanVienByID(int maNhanVien);

	public void suaDon(DonNghiPhepKhoann hs);
	
	public List<LoaiHinhNghiPhepKhoann> danhSachLyDo();

}
