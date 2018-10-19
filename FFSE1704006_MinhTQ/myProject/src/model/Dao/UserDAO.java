package model.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import common.database.DatabaseUtil;
import common.database.DatabaseUtil.IPareEntity;
import common.database.DatabaseUtil.IPrePareStatementSetParam;
import model.entity.User;

public class UserDAO {

	private IPareEntity<User> iPareEntity = new IPareEntity<User>() {
		public User pare(ResultSet result) throws SQLException {
			return new User(result.getString("tenAdmin"), result.getString("tuoiAdmin"), result.getString("diachi"),
					result.getString("passWord"));
		}
	};

	public User getUser(final String username, final String password) {
		/*
		 * User user = null; if ("abc".equals(username) && "123".equals(password)) {
		 * user = new User(); user.setUsername("ABC"); user.setPassword("123");
		 * user.setFullname("ABC"); user.setOld("25"); } return user;
		 */
		String sql = "SELECT * FROM dsadmin WHERE tenAdmin = ? and password = ?";

		User listUser = DatabaseUtil.selectForObject(sql, new IPrePareStatementSetParam() {

			public void setParameterQuery(PreparedStatement statement) throws SQLException {
				statement.setString(1, username);
				statement.setString(2, password);

			}

		}, iPareEntity);

		return listUser;

	}

	public List<User> getAllUser() {
		String sql = "SELECT * FROM dsadmin";
		List<User> arrList = DatabaseUtil.selectForList(sql, iPareEntity);
		return arrList;
	}
}
