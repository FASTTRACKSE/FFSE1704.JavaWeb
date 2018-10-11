package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import common.database.DatabaseUltil;
import common.database.DatabaseUltil.IPareEntity;
import model.entity.Admin;

@ManagedBean
@SessionScoped
public class UserDao {
	public String getName(String id) {
		String name = "Le Kha Hong Nhat";
		return name;
	}

	private IPareEntity<Admin> iPareEntityAdmin = new IPareEntity<Admin>() {
		public Admin pare(ResultSet result) throws SQLException {
			return new Admin(result.getString("username"), result.getString("password"));
		}
	};

	public Admin loginAdmin(final String username, final String password) {
		String sql = "SELECT * FROM admin WHERE username=? and password=?";
		return DatabaseUltil.selectForObject(sql, iPareEntityAdmin, username, password);
	}
	
	
}
