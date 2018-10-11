package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import common.database.DatabaseUltil;
import common.database.DatabaseUltil.IPareEntity;
import common.database.DatabaseUltil.IPrePareStatementSetParam;
import model.entity.SinhVien;

public class SinhVienDAO {

	private IPareEntity<SinhVien> iPareEntity = new IPareEntity<SinhVien>() {
		public SinhVien pare(ResultSet result) throws SQLException {
			return new SinhVien(result.getString("id"), result.getString("tensinhvien"), result.getString("masinhvien"),
					result.getString("lop"), result.getString("tuoi"), result.getString("gioitinh"),
					result.getString("diachi"), result.getString("sodt"), result.getString("email"));
		}
	};

	public List<SinhVien> getAllSinhVien() {
		String sql = "SELECT * FROM sinhvien";
		List<SinhVien> arrList = DatabaseUltil.selectForList(sql, iPareEntity);
		return arrList;
	}

	public SinhVien searchSinhVien(final String id) {
		String sql = "SELECT * FROM sinhvien WHERE masinhvien=?";
		return DatabaseUltil.selectForObject(sql, iPareEntity, id);
		
//		SinhVien searchSinhVien = DatabaseUltil.selectForObject(sql, new IPrePareStatementSetParam() {
//
//			public void setParameterQuery(PreparedStatement statement) throws SQLException {
//				statement.setString(1, id);
//			}
//		}, iPareEntity);
//		return searchSinhVien;

	}

	public List<SinhVien> pageSinhVien(final int start, final String KT) {
		String sql = "SELECT * FROM sinhvien  LIMIT ?,?";
		List<SinhVien> pageSinhVien = DatabaseUltil.selectForList(sql, new IPrePareStatementSetParam() {

			public void setParameterQuery(PreparedStatement statement) throws SQLException {
				statement.setInt(1, start);
				statement.setInt(2, Integer.parseInt(KT));
			}
		}, iPareEntity);
		return pageSinhVien;

	}

	public int editSinhVien(final SinhVien sv) {
		String sql = "UPDATE sinhvien SET tensinhvien=?, lop=?, tuoi=?, gioitinh=?, diachi=?, sodt=?, email=? WHERE masinhvien=?";

		int updateSinhVien = DatabaseUltil.executeUpdate(sql, new IPrePareStatementSetParam() {

			public void setParameterQuery(PreparedStatement statement) throws SQLException {
				statement.setString(1, sv.getTenSinhVien());
				statement.setString(2, sv.getLopHoc());
				statement.setString(3, sv.getTuoiSinhVien());
				statement.setString(4, sv.getGioiTinh());
				statement.setString(5, sv.getDiaChi());
				statement.setString(6, sv.getSoDT());
				statement.setString(7, sv.getEmail());
				statement.setString(8, sv.getMaSinhVien());
			}
		});
		return updateSinhVien;

	}

	public int addSinhVien(final SinhVien sv) {
		String sql = "INSERT INTO sinhvien(tensinhvien,masinhvien,lop,tuoi,gioitinh,diachi,sodt,email) VALUES (?,?,?,?,?,?,?,?)";
		int addSV = DatabaseUltil.executeUpdateWithValues(sql, sv.getTenSinhVien(), sv.getMaSinhVien(), sv.getLopHoc(),
				sv.getTuoiSinhVien(), sv.getGioiTinh(), sv.getDiaChi(), sv.getSoDT(), sv.getEmail());
		 return addSV;
		// int addSinhVien = DatabaseUltil.executeUpdate(sql, new
		// IPrePareStatementSetParam() {
		//
		// public void setParameterQuery(PreparedStatement statement) throws
		// SQLException {
		// statement.setString(1, sv.getTenSinhVien());
		// statement.setString(2, sv.getMaSinhVien());
		// statement.setString(3, sv.getLopHoc());
		// statement.setString(4, sv.getTuoiSinhVien());
		// statement.setString(5, sv.getGioiTinh());
		// statement.setString(6, sv.getDiaChi());
		// statement.setString(7, sv.getSoDT());
		// statement.setString(8, sv.getEmail());
		//
		// }
		// });
		// return addSinhVien;
	}

	public int deleteSinhVien(final String maSV) {
		String sql = "DELETE FROM sinhvien WHERE masinhvien=? ";
		int addSinhVien = DatabaseUltil.executeUpdate(sql, new IPrePareStatementSetParam() {

			public void setParameterQuery(PreparedStatement statement) throws SQLException {
				statement.setString(1, maSV);

			}
		});
		return addSinhVien;
	}

	// User user = null;
	// if ("Joker".equals(userName) && "123456".equals(passWord)) {
	// user = new User();
	// user.setUserName("Joker");
	// user.setPassWord("123456");
	// }
	// return user;
}
