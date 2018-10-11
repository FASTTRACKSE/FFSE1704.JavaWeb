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
import model.entity.SinhVien;
import model.entity.User;



public class UserDao {
	private IPareEntity<SinhVien> iPareEntity = new IPareEntity<SinhVien>() {
		public SinhVien pare(ResultSet result) throws SQLException {
			return new SinhVien(result.getString("id"), result.getString("name"), result.getString("age"), result.getString("DiaChi"),
					result.getString("sdt"));

		}
	};
	private IPareEntity<User> iPareEntityUser = new IPareEntity<User>() {
		public User pare(ResultSet result) throws SQLException {
			return new User(result.getString("username"),result.getString("password"));

		}
	};
	public User getUser(String username, String password) {
		String sql = "select * from member where username = ? and password = ?";
		User listuser = DatabaseUltil.selectForObject(sql,new IPrePareStatementSetParam(){
			public void setParameterQuery(PreparedStatement statement) throws SQLException{
				statement.setString(1, username);
				statement.setString(2, password);

			}

		},iPareEntityUser);

		return listuser;

	}
	public  List<SinhVien> getAllUser() {
		String sql = "select * from sinhvien ";
		List<SinhVien> arrayList = DatabaseUltil.selectForList(sql, iPareEntity);
		return arrayList;
	}
	public SinhVien searchUser(String id)  {

		String sql = "select * from sinhvien where id=? ";
		SinhVien listSV = DatabaseUltil.selectForObject(sql, new IPrePareStatementSetParam() {
			public void setParameterQuery(java.sql.PreparedStatement statement) throws SQLException{
				statement.setString(1, id);

			}

		},iPareEntity);

		return listSV;
	}

	private  IPrePareStatementSetParam iPareStatement = new IPrePareStatementSetParam() {

		public void setParameterQuery(java.sql.PreparedStatement statement) throws SQLException {
			// TODO Auto-generated method stub
		}	

	};
	public static int insert(final SinhVien sv)  {

		String sql = "INSERT INTO sinhvien(name,age,DiaChi,sdt) VALUES(?,?,?,?) ";
		int listSV = DatabaseUltil.executeUpdate(sql, new IPrePareStatementSetParam() {
			public void setParameterQuery(java.sql.PreparedStatement statement) throws SQLException{


				statement.setString(1, sv.getName());
				statement.setString(2, sv.getAge());
				statement.setString(3, sv.getDiaChi());
				statement.setString(4, sv.getSdt());
			}

		});

		return listSV;
	}
	public static int edit(final SinhVien sv)  {

		String sql = "UPDATE sinhvien SET name=?, age=?, DiaChi=?, sdt=? where id=?";
		int listSV = DatabaseUltil.executeUpdate(sql, new IPrePareStatementSetParam() {
			public void setParameterQuery(PreparedStatement statement) throws SQLException{


				statement.setString(1, sv.getName());
				statement.setString(2, sv.getAge());
				statement.setString(3, sv.getDiaChi());
				statement.setString(4, sv.getSdt());
				statement.setString(5, sv.getId());
			}

		});

		return listSV;
	}

	public int delete(final String sv)  {

		String sql = "DELETE FROM sinhvien where id=?";
		int listSV = DatabaseUltil.executeUpdate(sql, new IPrePareStatementSetParam() {
			public void setParameterQuery(PreparedStatement statement) throws SQLException{

				statement.setString(1, sv);
			}

		});

		return listSV;
	}
	public List<SinhVien> searchReCords(final int start, final int end)  {

		String sql = "select * from sinhvien limit ?,? ";
		List<SinhVien> listSV = DatabaseUltil.selectForList(sql, new IPrePareStatementSetParam() {
			public void setParameterQuery(PreparedStatement statement) throws SQLException{
				statement.setInt(1, start);
				statement.setInt(2, end);

			}

		},iPareEntity);

		return listSV;
	}
}


