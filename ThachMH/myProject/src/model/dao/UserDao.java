
package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.database.DatabaseUltil;
import common.database.DatabaseUltil.IPareEntity;
import common.database.DatabaseUltil.IPrePareStatementSetParam;
import model.bean.User;

public class UserDao {

	private IPareEntity<User> iPareEntity = new IPareEntity<User>() {
		public User pare(ResultSet result) throws SQLException {
			return new User(result.getString("user"), result.getString("password"), result.getString("fullname"));

		}
	};

	public User getUser(final String user, final String password) {
		String sql = "SELECT * FROM baitap WHERE user=? and password=?";

		User listUser = DatabaseUltil.selectForObject(sql, new IPrePareStatementSetParam() {
			public void setParameterQuery(PreparedStatement statement) throws SQLException {
				statement.setString(1, user);
				statement.setString(2, password);
			}
		}, iPareEntity);
		return listUser;

	}

	public int getaddUser(final User us) {
		String sql = "INSERT INTO baitap(user,password,fullname) VALUES(?,?,?)";

		int listUser = DatabaseUltil.executeUpdate(sql, new IPrePareStatementSetParam() {
			public void setParameterQuery(PreparedStatement statement) throws SQLException {

				statement.setString(1, us.getUser());
				statement.setString(2, us.getPassword());
				statement.setString(3, us.getFullname());
			}
		});
		return listUser;

	}

	public User showtt(final String user) {
		String sql = "SELECT * FROM baitap WHERE user=?";
		User listUser = DatabaseUltil.selectForObject(sql, new IPrePareStatementSetParam() {
			public void setParameterQuery(PreparedStatement statement) throws SQLException {

				statement.setString(1, user);
			}
		}, iPareEntity);
		return listUser;
	}

	public int getupdateUser(final User stt) {
		String sql = "UPDATE baitap SET  user = ?, password = ?, fullname = ? WHERE id=?";

		int listUser = DatabaseUltil.executeUpdate(sql, new IPrePareStatementSetParam() {
			public void setParameterQuery(PreparedStatement statement) throws SQLException {
				statement.setString(1, stt.getUser());
				statement.setString(2, stt.getPassword());
				statement.setString(3, stt.getFullname());
				statement.setString(4, stt.getId());
			}
		});
		return listUser;

	}

	public int getdeleteUser(final String user) {
		String sql = "DELETE FROM baitap where user = ?";

		int listUser = DatabaseUltil.executeUpdate(sql, new IPrePareStatementSetParam() {
			public void setParameterQuery(PreparedStatement statement) throws SQLException {
				statement.setString(1, user);
			}
		});
		return listUser;

	}

	public List<User> getAllUser() {
		String sql = "SELECT * FROM baitap";
		List<User> arrList = DatabaseUltil.selectForList(sql, iPareEntity);

		return arrList;
	}

	public List<User> pageSinhVien(final int start, final String KT) {
		String spl = "SELECT * FROM baitap LIMIT ?,?";
		List<User> pageSinhVien = DatabaseUltil.selectForList(spl, new IPrePareStatementSetParam() {
			public void setParameterQuery(PreparedStatement statement) throws SQLException {
				statement.setInt(1, start);
				statement.setInt(2, Integer.parseInt(KT));
			}
		}, iPareEntity);
		return pageSinhVien;

	}
}