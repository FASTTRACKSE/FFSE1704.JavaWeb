package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.database.DatabaseUltil;
import common.database.DatabaseUltil.IPareEntity;
import common.database.DatabaseUltil.IPrePareStatement;
import model.entity.User;

public class UserDao {
	private IPrePareStatement iPrePareStatement = new IPrePareStatement() {
		public void setParameterQuery(Map<?, ?> mapParam, PreparedStatement statement) throws SQLException {
			statement.setString(1, (String) mapParam.get("user"));
			statement.setString(2, (String) mapParam.get("pass"));
		}

	};

	private IPareEntity<User> iPareEntity = new IPareEntity<User>() {
		public User pare(ResultSet result) throws SQLException {
			return new User(result.getInt("Id"), result.getString("username"), result.getString("password"),
					result.getString("fullname"), result.getString("age"));

		}
	};

	public User getUser(String username, String password) {
		String sql = "SELECT * FROM user WHERE username=? and password=?";
		Map<String, String> mapParam = new HashMap<String, String>();
		mapParam.put("user", username);
		mapParam.put("pass", password);
		List<User> listUser = DatabaseUltil.executeSelect(sql, mapParam, iPrePareStatement, iPareEntity);
		return listUser.size() == 0 ? null : listUser.get(0);
	}

	public List<User> getAllUser() {
		String sql = "SELECT * FROM user";
		List<User> arrList = DatabaseUltil.executeSelect(sql, null, null, iPareEntity);
		return arrList;
	}

	public User editUser(String id) {
		String sql = "SELECT * FROM user WHERE id=?";
		Map<String, String> mapParam = new HashMap<String, String>();
		mapParam.put("user", id);
		List<User> listUser = DatabaseUltil.executeSelect(sql, mapParam, new IPrePareStatement() {

			@Override
			public void setParameterQuery(Map<?, ?> mapParam, PreparedStatement statement) throws SQLException {
				statement.setInt(1, Integer.parseInt((String) mapParam.get("user")));
			}
		}, iPareEntity);
		return listUser.size() == 0 ? null : listUser.get(0);
	}

	
	/*Đang tạo addUser*/
	public boolean createUser(String username, String password, String fullname, String age) {
		String sql = "INSERT INTO user(username,password,fullname,age) VALUES (?,?,?,?)";
		Map<String, String> mapParam = new HashMap<String, String>();
		mapParam.put("username", username);
		mapParam.put("password", password);
		mapParam.put("fullname", fullname);
		mapParam.put("age", age);
		
		return DatabaseUltil.executeUpdate(sql, mapParam, new IPrePareStatement() {
			
			@Override
			public void setParameterQuery(Map<?, ?> mapParam, PreparedStatement statement) throws SQLException {
				statement.setString(1, (String) mapParam.get("username"));
				statement.setString(2, (String) mapParam.get("password"));
				statement.setString(3, (String) mapParam.get("fullname"));
				statement.setString(4, (String) mapParam.get("age"));
			}
		});

	}
	
	public boolean deleteUser(String id) {
		String sql = "DELETE FROM user WHERE id=?";
		Map<String, String> mapParam = new HashMap<String, String>();
		mapParam.put("user", id);
		return DatabaseUltil.executeUpdate(sql, mapParam, new IPrePareStatement() {
			
			@Override
			public void setParameterQuery(Map<?, ?> mapParam, PreparedStatement statement) throws SQLException {
				statement.setInt(1, Integer.parseInt((String) mapParam.get("user")));
			}
		});
	}
}
