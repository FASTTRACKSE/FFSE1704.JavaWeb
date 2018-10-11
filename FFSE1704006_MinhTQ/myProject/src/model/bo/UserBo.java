package model.bo;

import model.Dao.SinhVienDAO;
import model.Dao.UserDAO;

public class UserBo {
	private UserDAO userDao = new UserDAO();
	private SinhVienDAO sinhvienDao=new SinhVienDAO();

	
	//kiểm tra Admin
	public boolean kiemTraUser(String username, String password) {
		return userDao.getUser(username, password) != null;
	}
	
	
//	//kiểm tra sinh viên 
//	public boolean kiemTraSinhVien(String maSinhVien, String tenSinhVien, String tuoiSinhVien, String lopHoc,
//			String diaChi) {
//		return sinhvienDao.getSinhVien(maSinhVien, tenSinhVien, tuoiSinhVien, lopHoc, diaChi) != null;
//	}
}
