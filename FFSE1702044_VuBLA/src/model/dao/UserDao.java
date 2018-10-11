package model.dao;

import model.entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.database.DatabaseUltil;
import common.database.DatabaseUltil.IPareEntity;
import common.database.DatabaseUltil.IPrePareStatementSetParam;

public class UserDao {

	private IPareEntity<User> iPareEntity = new IPareEntity<User>() {
		public User pare(ResultSet result) throws SQLException {
			return new User(result.getString("id_user"), result.getString("user_name"), result.getString("pass"),
					result.getString("full_name"), result.getString("old"));

		}
	};

	
	public List<User> pageSinhVien(final int start, final String KT) {
		String sql = "SELECT * FROM user  LIMIT ?,?";
		List<User> pageSinhVien = DatabaseUltil.selectForList(sql, new IPrePareStatementSetParam() {

			public void setParameterQuery(PreparedStatement statement) throws SQLException {
				statement.setInt(1, start);
				statement.setInt(2, Integer.parseInt(KT));
			}
		}, iPareEntity);
		return pageSinhVien;

	}
	public User getUser(String user, String password) {
		String sql = "SELECT * FROM user WHERE user_name=? and pass=?";
		User listUser = DatabaseUltil.selectForObject(sql, new IPrePareStatementSetParam() {

			@Override
			public void setParameterQuery(PreparedStatement statement) throws SQLException {
				statement.setString(1, user);
				statement.setString(2, password);
			}
		}, iPareEntity);
		return listUser;

	}

	public List<User> getAllUser() {
		String sql = "SELECT * FROM user";
		List<User> arrList = DatabaseUltil.selectForList(sql, iPareEntity);
		return arrList;
	}

	public User editUser(final String id) {
		String sql = "SELECT * FROM `user` WHERE `id_user`=?";
		User listUser = DatabaseUltil.selectForObject(sql, new IPrePareStatementSetParam() {
			@Override
			public void setParameterQuery(PreparedStatement statement) throws SQLException {
				statement.setString(1, id);
			}
		}, iPareEntity);
		return listUser;
	}
	public int updateUser(final User User) {
		String sql = "UPDATE user SET user_name=?,pass=? WHERE id_user=?";
		int listUser = DatabaseUltil.executeUpdate(sql,new IPrePareStatementSetParam() {
			@Override
			public void setParameterQuery(PreparedStatement statement) throws SQLException {
				statement.setString(1, User.getUser());
				statement.setString(2, User.getPass());
				statement.setString(3, User.getId_user());
			}
		});
		return listUser;
	}
	public int deleteUser(final String User) {
		String sql = "DELETE FROM user WHERE id_user=?";
		int listUser = DatabaseUltil.executeUpdate(sql,new IPrePareStatementSetParam() {
			@Override
			public void setParameterQuery(PreparedStatement statement) throws SQLException {
				statement.setString(1, User);
			}
		});
		return listUser;
	}
	public int addSinhVien(final User User) {
		String sql = "INSERT INTO user (`id_user`, `user_name`, `pass`, `full_name`, `old`) VALUES (?,?,?,?,?)";
		int addSV = DatabaseUltil.executeUpdateWithValues(sql, User.getId_user(),User.getUser(),User.getPass(),User.getFullname(),User.getOld());
		 return addSV;
	}
}
