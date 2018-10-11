package model.bo;

import model.dao.*;

public class SinhVienBo {
	
	private SinhVienDAO sinhVienDao = new SinhVienDAO();
	
	public boolean checkExistSinhVien(String maSV) {
		return sinhVienDao.searchSinhVien(maSV) != null;
	}
}
