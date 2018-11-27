package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import common.database.DatabaseUltil;
import common.database.DatabaseUltil.IPareEntity;
import common.database.DatabaseUltil.IPrePareStatementSetParam;
import model.bean.SinhVien;

public class SinhVienDAO {

	public static final int RECORD_IN_PAGE = 2;

	public List<SinhVien> getAllSinhVien() {
		String sql = "SELECT * FROM  sinh_vien";
		return DatabaseUltil.selectForList(sql, new IPareEntity<SinhVien>() {
			public SinhVien pare(ResultSet result) throws SQLException {
				return new SinhVien(result.getString("MASV"), result.getString("TEN"), result.getString("PASS"));
			}
		});
	}

	public SinhVien getSinhVienByMaSinhVien(final String maSinhVien) {
		String sql = "SELECT * FROM  sinh_vien WHERE MASV = ?";

		return DatabaseUltil.selectForObject(sql, new IPrePareStatementSetParam() {

			public void setParameterQuery(PreparedStatement statement) throws SQLException {
				statement.setString(1, maSinhVien);
			}

		}, new IPareEntity<SinhVien>() {
			public SinhVien pare(ResultSet result) throws SQLException {
				return new SinhVien(result.getString("MASV"), result.getString("TEN"), result.getString("PASS"));
			}
		});
	}

	public void updateSinhVien(String maSinhVien, String tenSinhVien, String pass) {
		String sql = "UPDATE sinh_vien SET TEN = ?, PASS = ? WHERE MASV = ?";
		DatabaseUltil.updateWithValue(sql, tenSinhVien, pass, maSinhVien);
	}

	public void addSinhVien(String codeSv, String nameSv, String passSv) {
		String sql = "INSERT INTO sinh_vien VALUES (?, ?, ?)";
		DatabaseUltil.updateWithValue(sql, codeSv, nameSv, passSv);
	}

	public void deleteSinhVien(String maSinhVien) {
		String sql = "DELETE FROM sinh_vien WHERE MASV = ?";
		DatabaseUltil.updateWithValue(sql, maSinhVien);
	}

	public List<SinhVien> getSinhVienInPage(int currentPage) {

		int startRecord = (currentPage - 1) * RECORD_IN_PAGE;

		String sql = "SELECT * FROM  sinh_vien LIMIT ?, ?";

		return DatabaseUltil.selectForList(sql, new IPareEntity<SinhVien>() {
			public SinhVien pare(ResultSet result) throws SQLException {
				return new SinhVien(result.getString("MASV"), result.getString("TEN"), result.getString("PASS"));
			}
		}, startRecord, RECORD_IN_PAGE);
	}
}
