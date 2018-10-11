package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.Connection;

import common.database.DatabaseUltil;
import common.database.DatabaseUltil.IPareEntity;
import common.database.DatabaseUltil.IPrePareStatement;
import model.entity.User;

public class UserDao {
	//final static Connection conn = (Connection) connectDB.getConnect("localhost", "login", "nghia111", "123456");
	static ArrayList<User> list = new ArrayList<User>();

	private IPrePareStatement iprePareStatement = new IPrePareStatement() {
		@Override
		public void setParameterQuery(Map<?, ?> mapParam, java.sql.PreparedStatement statement) throws SQLException {
			statement.setString(1, (String) mapParam.get("user"));
			statement.setString(2, (String) mapParam.get("pass"));

		}
	};
	private IPareEntity<User> iPareEntity = new IPareEntity<User>() {
		public User pare(ResultSet result) throws SQLException {
			return new User(result.getInt("id"), result.getString("username"), result.getString("password"), result.getString("fullname"),
					result.getString("old"));

		}
	};

	public User getUser(String username, String password) {
		String sql = "select * from member where username = ? and password = ?";
		Map<String, String> mapParam = new HashMap<String, String>();
		mapParam.put("user", username);
		mapParam.put("pass", password);
		List<User> listUser = DatabaseUltil.executeSelect(sql, mapParam, iprePareStatement, iPareEntity);
		return listUser.size() == 0 ? null : listUser.get(0);
	}
	public List<User> getAllUser() {
		String sql = "select * from member ";
		List<User> arrayList = DatabaseUltil.executeSelect(sql, null, null, iPareEntity);
		return arrayList;
	}
	public User searchUser(String id) {
		String sql = "select * from member where id = ?";
		Map<String, String> mapParam = new HashMap<String, String>();
		mapParam.put("user", id);
		
		List<User> listUser = DatabaseUltil.executeSelect(sql, mapParam, new IPrePareStatement() {
			public void setParameterQuery(Map<?, ?> mapParam, java.sql.PreparedStatement statement) throws SQLException {
				statement.setInt(1, Integer.parseInt((String) mapParam.get("user")));
				

			}
		}, iPareEntity);
		return listUser.size() == 0 ? null : listUser.get(0);
	}
	public User updateUser(String id) {
		String sql = "UPDATE member SET id = ?";
		Map<String, String> mapParam = new HashMap<String, String>();
		mapParam.put("user", id);
		
		List<User> listUser = DatabaseUltil.executeSelect(sql, mapParam, new IPrePareStatement() {
			public void setParameterQuery(Map<?, ?> mapParam, java.sql.PreparedStatement statement) throws SQLException {
				statement.setInt(1, Integer.parseInt((String) mapParam.get("user")));
				

			}
		}, iPareEntity);
		return listUser.size() == 0 ? null : listUser.get(0);
	}
}
