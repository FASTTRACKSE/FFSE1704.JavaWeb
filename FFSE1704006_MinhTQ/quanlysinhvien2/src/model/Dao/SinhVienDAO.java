 package model.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import common.database.DatabaseUtil;
import common.database.DatabaseUtil.IPareEntity;
import common.database.DatabaseUtil.IPrePareStatementSetParam;
import model.entity.SinhVien;

@ManagedBean
@SessionScoped
public class SinhVienDAO {
	public static final int RECORD_IN_PAGE = 5;

	private IPareEntity<SinhVien> iPareEntity = new IPareEntity<SinhVien>() {
		public SinhVien pare(ResultSet result) throws SQLException {
			return new SinhVien(result.getString("maSinhVien"), result.getString("tenSinhVien"),
					result.getString("tuoiSinhVien"), result.getString("lopHoc"), result.getString("diaChi"), result.getString("images"));
		}
	};

	public SinhVien seach(final String maSinhVien) {
		/*
		 * User user = null; if ("abc".equals(username) && "123".equals(password)) {
		 * user = new User(); user.setUsername("ABC"); user.setPassword("123");
		 * user.setFullname("ABC"); user.setOld("25"); } return user;
		 */
		String sql = "SELECT * FROM dssinhvien WHERE maSinhVien= ?";
		SinhVien listSinhVien = DatabaseUtil.selectForObject(sql, iPareEntity, maSinhVien);
		return listSinhVien;

	}

	public List<SinhVien> getAllSinhVien() {
		String sql = "SELECT * FROM dssinhvien";
		List<SinhVien> arrList = DatabaseUtil.selectForList(sql, iPareEntity);
		return arrList;
	}

	public int add(final SinhVien sv) {
		String sql = "INSERT INTO dssinhvien( maSinhVien, tenSinhVien, tuoiSinhVien,lopHoc, diaChi, images) VALUES(?,?,?,?,?,?)";
		int listSinhVien = DatabaseUtil.executeUpdate(sql, new IPrePareStatementSetParam() {

			public void setParameterQuery(PreparedStatement statement) throws SQLException {
				statement.setString(1, sv.getMaSinhVien());
				statement.setString(2, sv.getTenSinhVien());
				statement.setString(3, sv.getTuoiSinhVien());
				statement.setString(4, sv.getLopHoc());
				statement.setString(5, sv.getDiaChi());
				statement.setString(6, sv.getImages());
				

			}

		});
		return listSinhVien;
	}

	public int edit(final SinhVien sv) {
		String sql = "UPDATE dssinhvien SET tenSinhVien=? , tuoiSinhVien=? , lopHoc=? , diaChi=? ,images=? WHERE maSinhVien=?";
		int listSinhVien = DatabaseUtil.executeUpdate(sql, new IPrePareStatementSetParam() {
			public void setParameterQuery(PreparedStatement statement) throws SQLException {

				statement.setString(1, sv.getTenSinhVien());
				statement.setString(2, sv.getTuoiSinhVien());
				statement.setString(3, sv.getLopHoc());
				statement.setString(4, sv.getDiaChi());
				statement.setString(5, sv.getImages());
				statement.setString(6, sv.getMaSinhVien());

			}
		});
		return listSinhVien;
	}

	public int delete(final String maSinhVien) {
		String sql = "DELETE FROM dssinhvien WHERE maSinhVien=?";
		int listSinhVien = DatabaseUtil.executeUpdateWithValues(sql, maSinhVien);
		return listSinhVien;
	}

	public List<SinhVien> getSinhVienInPage(int currentPage) {
		return currentPage > 0 ? PTtrang((currentPage - 1) * RECORD_IN_PAGE, RECORD_IN_PAGE)
				: new ArrayList<SinhVien>();
	}

	public List<SinhVien> PTtrang(int start, int recordinPage) {
		String sql = "SELECT * FROM dssinhvien  LIMIT ?,?";
		return DatabaseUtil.selectForList(sql, new IPareEntity<SinhVien>() {
			public SinhVien pare(ResultSet result) throws SQLException {
				return new SinhVien(result.getString("maSinhVien"), result.getString("tenSinhVien"),
						result.getString("tuoiSinhVien"), result.getString("lopHoc"), result.getString("diaChi"), result.getString("images"));
			}
		}, start, recordinPage);

	}
}
