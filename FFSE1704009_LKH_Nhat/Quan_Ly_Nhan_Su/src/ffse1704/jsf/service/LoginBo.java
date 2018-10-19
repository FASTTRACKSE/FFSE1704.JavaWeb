package ffse1704.jsf.service;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ffse1704.jsf.dao.AdminDao;

@ManagedBean
@SessionScoped
public class LoginBo {
	private AdminDao adminDao = new AdminDao();

	public boolean checkExistAdmin(String userName, String passWord) {
		return adminDao.loginAdmin(userName, passWord) != null;
	}
}
