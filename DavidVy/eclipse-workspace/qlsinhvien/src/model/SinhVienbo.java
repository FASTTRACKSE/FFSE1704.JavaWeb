package model;

public class SinhVienbo {
	private SinhVienDAO sinhVienDao = new SinhVienDAO();
	
	public boolean checkExistSinhVien(String maSV) {
		return sinhVienDao.searchSinhVien(maSV) != null;
	}

}
