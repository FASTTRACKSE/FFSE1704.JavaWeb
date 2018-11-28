package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import common.dataase.DataaseUltil;
import common.dataase.DataaseUltil.IPareEntity;
import common.dataase.DataaseUltil.IPrePareStatementSetParam;

import entity.SinhVien;

public class SinhVienDAO {

	private IPareEntity<SinhVien> iPareEntity = new IPareEntity<SinhVien>() {
		public SinhVien pare(ResultSet result) throws SQLException {
			return new SinhVien(result.getString("maSinhVien"),result.getString("tenSinhVien"), 
					result.getString("lopHoc"), result.getString("tuoiSinhVien"), result.getString("gioiTinh"),
					result.getString("diaChi"), result.getString("soDT"), result.getString("email"));
		}
	};

	public List<SinhVien> getAllSinhVien() {
		String sql = "SELECT * FROM qlsinhvien";
		List<SinhVien> arrList = DataaseUltil.selectForList(sql, iPareEntity);
		return arrList;
	}

	public SinhVien searchSinhVien(final String id) {
		String sql = "SELECT * FROM qlsinhvien WHERE masinhvien=?";
		return DataaseUltil.selectForObject(sql, iPareEntity, id);

		// SinhVien searchSinhVien = DatabaseUltil.selectForObject(sql, new
		// IPrePareStatementSetParam() {
		//
		// public void setParameterQuery(PreparedStatement statement) throws
		// SQLException {
		// statement.setString(1, id);
		// }
		// }, iPareEntity);
		// return searchSinhVien;

	}

	public List<SinhVien> pageSinhVien(final int start, final String KT) {
		String sql = "SELECT * FROM qlsinhvien  LIMIT ?,?";
		List<SinhVien> pageSinhVien = DataaseUltil.selectForList(sql, new IPrePareStatementSetParam() {

			public void setParameterQuery(PreparedStatement statement) throws SQLException {
				statement.setInt(1, start);
				statement.setInt(2, Integer.parseInt(KT));
			}
		}, iPareEntity);
		return pageSinhVien;

	}

	public int editSinhVien(final SinhVien sv) {
		String sql = "UPDATE qlsinhvien SET tensinhvien=?, lophoc=?, tuoisinhvien=?, gioitinh=?, diachi=?, sodt=?, email=? WHERE masinhvien=?";

		int updateSinhVien = DataaseUltil.executeUpdate(sql, new IPrePareStatementSetParam() {

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
		String sql = "INSERT INTO qlsinhvien(masinhvien,tensinhvien,lophoc,tuoisinhvien,gioitinh,diachi,sodt,email) VALUES (?,?,?,?,?,?,?,?)";

		int addsinhvien = DataaseUltil.executeUpdate(sql, new IPrePareStatementSetParam() {

			public void setParameterQuery(PreparedStatement statement) throws SQLException {
				statement.setString(1, sv.getMaSinhVien());
				statement.setString(2, sv.getTenSinhVien());
				statement.setString(3, sv.getLopHoc());
				statement.setString(4, sv.getTuoiSinhVien());
				statement.setString(5, sv.getGioiTinh());
				statement.setString(6, sv.getDiaChi());
				statement.setString(7, sv.getSoDT());
				statement.setString(8, sv.getEmail());

			}
		});
		return addsinhvien;
	}

	public int deleteSinhVien(final String maSV) {
		String sql = "DELETE FROM qlsinhvien WHERE masinhvien=? ";
		int addSinhVien = DataaseUltil.executeUpdate(sql, new IPrePareStatementSetParam() {

			public void setParameterQuery(PreparedStatement statement) throws SQLException {
				statement.setString(1, maSV);

			}
		});
		return addSinhVien;
	}
}
