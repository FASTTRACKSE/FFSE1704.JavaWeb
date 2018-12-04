package fasttrackse.ffse1704.fbms.dao.quanlyvangnghi.khoann;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.khoann.*;

public interface DonNghiPhepDaoKhoann {

	public List<DonNghiPhepKhoann> listDonNghiPhep();
	
	public void themDon(DonNghiPhepKhoann hs);
	
	public DonNghiPhepKhoann getNhanVienByID(int maNhanVien);
	
	public void suaDon(DonNghiPhepKhoann hs);

	public List<LoaiHinhNghiPhepKhoann> danhSachLyDo();

}
