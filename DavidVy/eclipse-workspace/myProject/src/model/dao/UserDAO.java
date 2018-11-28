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

public class UserDAO {
	
	private IPrePareStatement iPrePareStatement= new IPrePareStatement() {
		public void setParameterQuery(Map<?, ?> mapParam, PreparedStatement satatement) throws SQLException{
			satatement.setString(1, (String) mapParam.get("user"));
			satatement.setString(2, (String) mapParam.get("pass"));
		}

		
	};
	private IPareEntity<User> iPareEntity = new IPareEntity<User>() {
		public User pare(ResultSet result) throws SQLException{
			return new User(result.getInt("id"), result.getString("username"), result.getString("password"));
		}
	};
	public User getUser(String userName, String passWord) {
		String sql = "SELECT * FROM user  WHERE username=? AND password=?";
		Map<String, String> mapParam = new HashMap<String, String>();
		mapParam.put("user", userName);
		mapParam.put("pass", passWord);
		List<User> listUser = DatabaseUltil.executeSelect(sql, mapParam, iPrePareStatement, iPareEntity);
		return listUser.size() == 0 ? null : listUser.get(0);
			
	}
	public List<User> getAllUser(){
		String sql = "SELECT * FROM user";
		List<User> arrList = DatabaseUltil.executeSelect(sql, null, null, iPareEntity);
		return arrList;
	}
	
	public User searchUser(String id) {
		String sql = "SELECT * FROM user WHERE id=?";
		Map<String, String> mapParam = new HashMap<String, String>();
		mapParam.put("user", id);
		List<User> listUser = DatabaseUltil.executeSelect(sql, mapParam, new IPrePareStatement() {
			
			public void setParameterQuery(Map<?, ?> mapParam, PreparedStatement statement) throws SQLException {
				statement.setInt(1, Integer.parseInt((String) mapParam.get("user")));
			}
		}, iPareEntity);
		return listUser.size() == 0 ? null : listUser.get(0);
			
	}
	
	
//	User user = null;
//	if ("Joker".equals(userName) && "123456".equals(passWord)) {
//		user = new User();
//		user.setUserName("Joker");
//		user.setPassWord("123456");
//	}
//	return user;
}
