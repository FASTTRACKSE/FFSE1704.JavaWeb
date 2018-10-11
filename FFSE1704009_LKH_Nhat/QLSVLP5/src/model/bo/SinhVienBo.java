package model.bo;

import model.dao.*;

public class SinhVienBo {
	
	private SinhVienDAO sinhVienDao = new SinhVienDAO();
	
	public boolean checkExistSinhVien(String maSV) {
		return sinhVienDao.searchSinhVien(maSV) != null;
	}
	public boolean checkExistAdmin(String userName, String passWord) {
		return sinhVienDao.loginAdmin(userName, passWord) != null;
	}
}
