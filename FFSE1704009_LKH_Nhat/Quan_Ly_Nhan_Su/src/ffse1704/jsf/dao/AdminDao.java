package ffse1704.jsf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ffse1704.jsf.common.database.DatabaseUltil;
import ffse1704.jsf.common.database.DatabaseUltil.IPareEntity;
import ffse1704.jsf.entity.Admin;

@ManagedBean
@SessionScoped
public class AdminDao {
	private IPareEntity<Admin> iPareEntityAdmin = new IPareEntity<Admin>() {
		public Admin pare(ResultSet result) throws SQLException {
			return new Admin(result.getString("username"), result.getString("password"));
		}
	};

	public Admin loginAdmin(final String username, final String password) {
		String sql = "SELECT * FROM admin WHERE username= ? and password=MD5(?)";
		return DatabaseUltil.selectForObject(sql, iPareEntityAdmin, username, password);
	}
}
