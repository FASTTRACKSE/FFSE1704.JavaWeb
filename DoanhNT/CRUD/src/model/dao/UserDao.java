package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.database.DatabaseUltil;
import common.database.DatabaseUltil.IPareEntity;
import common.database.DatabaseUltil.IPrePareStatementSetParam;
import model.bean.User;

public class UserDao {

	public User getUser(final String username, final String password) {
		String sql = "select * from user where username = ? and password =?";

		return DatabaseUltil.selectForObject(sql, new IPrePareStatementSetParam() {
			public void setParameterQuery(PreparedStatement statement) throws SQLException {
				statement.setString(1, username);
				statement.setString(2, password);
			}
		}, new IPareEntity<User>() {
			public User pare(ResultSet result) throws SQLException {
				return new User(result.getString("username"), result.getString("password"),
						result.getString("fullname"), result.getString("old"));
			}
		});
	}
}
