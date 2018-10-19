package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import common.database.DatabaseUltil;
import common.database.DatabaseUltil.IPareEntity;
import common.database.DatabaseUltil.IPrePareStatementSetParam;
import model.bean.SinhVien;

@ManagedBean
@SessionScoped
public class SinhVienDao {
	public static final int RECORD_IN_PAGE = 3;

	private IPareEntity<SinhVien> iPareEntity = new IPareEntity<SinhVien>() {
		public SinhVien pare(ResultSet result) throws SQLException {
			return new SinhVien(result.getString("id"), result.getString("user"), result.getString("password"),
					result.getString("fullname"));

		}
	};

	public int getaddUser(final SinhVien us) {
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

	public SinhVien showtt(final String id) {
		String sql = "SELECT * FROM baitap WHERE id=?";
		SinhVien listUser = DatabaseUltil.selectForObject(sql, new IPrePareStatementSetParam() {
			public void setParameterQuery(PreparedStatement statement) throws SQLException {

				statement.setString(1, id);

			}
		}, iPareEntity);
		return listUser;

	}

	public int getupdateUser(final SinhVien stt) {
		String sql = "UPDATE baitap SET   user = ?, password = ?, fullname = ? WHERE id=?";

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

	public int getdeleteUser(final String id) {
		String sql = "DELETE FROM baitap where id = ?";

		int listUser = DatabaseUltil.executeUpdateWithValues(sql, id);
		return listUser;

	}

	public List<SinhVien> getAllUser() {
		String sql = "SELECT * FROM baitap";
		List<SinhVien> arrList = DatabaseUltil.selectForList(sql, iPareEntity);

		return arrList;
	}

	public List<SinhVien> getSinhVienInPage(int currentPage) {
		return currentPage > 0 ? pt((currentPage - 1) * RECORD_IN_PAGE, RECORD_IN_PAGE) : new ArrayList<SinhVien>();
	}

	public List<SinhVien> pt(int start, int recordinPage) {
		String sql = "SELECT * FROM  baitap LIMIT ?, ?";
		return DatabaseUltil.selectForList(sql, new IPareEntity<SinhVien>() {
			public SinhVien pare(ResultSet result) throws SQLException {
				return new SinhVien(result.getString("id"), result.getString("user"), result.getString("password"),
						result.getString("fullname"));
			}
		}, start, recordinPage);
	}

}