package model.bo;

import model.dao.SinhVienDAO;

public class SinhVienBO {
	private SinhVienDAO sinhvienDAO = new SinhVienDAO();

	public boolean checkExistUser(String username, String password) {
		return sinhvienDAO.getUser(username, password) != null;
	}
}
