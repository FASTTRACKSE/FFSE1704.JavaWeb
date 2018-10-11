package model.bo;

import model.dao.*;

public class SinhVienBO {
	
	private SinhVienDAO sinhVienDao = new SinhVienDAO();
	
	public boolean checkExistSinhVien(String maSV) {
		return sinhVienDao.searchSinhVien(maSV) != null;
	}
}
