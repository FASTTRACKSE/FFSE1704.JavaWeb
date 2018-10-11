package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import common.database.DatabaseUltil;
import common.database.DatabaseUltil.IPareEntity;
import common.database.DatabaseUltil.IPrePareStatementSetParam;
import model.bean.SinhVien;

@ManagedBean
@SessionScoped
public class SinhVienDAO {
	private IPareEntity<SinhVien> iPareEntity = new IPareEntity<SinhVien>() {
		public SinhVien pare(ResultSet result) throws SQLException {
			return new SinhVien(result.getString("MASV"), result.getString("TEN"), result.getString("PASS"));
		}
	};

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

	public int updateSinhVien(final SinhVien sv) {
		String sql = "UPDATE sinh_vien SET TEN = ?, PASS = ? WHERE MASV = ?";
		int listSinhVien = DatabaseUltil.executeUpdate(sql, new IPrePareStatementSetParam() {

			@Override
			public void setParameterQuery(PreparedStatement statement) throws SQLException {
				// TODO Auto-generated method stub
				
				statement.setString(1, sv.getTEN());
				statement.setString(2, sv.getPASS());
				statement.setString(3, sv.getMASV());
			}
		});
		return listSinhVien;
	}

	public int addSinhVien(final SinhVien sv) {
		String sql = "INSERT INTO sinh_vien( MASV, TEN, PASS) VALUES (?, ?, ?)";

		int listSinhVien = DatabaseUltil.executeUpdate(sql, new IPrePareStatementSetParam() {

			@Override
			public void setParameterQuery(PreparedStatement statement) throws SQLException {
				// TODO Auto-generated method stub
				statement.setString(1, sv.getMASV());
				statement.setString(2, sv.getTEN());
				statement.setString(3, sv.getPASS());
			}
		});
		return listSinhVien;
	}

	public int deleteSinhVien(String MASV) {
		String sql = "DELETE FROM sinh_vien WHERE MASV = ?";
		int listSinhVien = DatabaseUltil.executeUpdateWithValues(sql, MASV);

		return listSinhVien;
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

	public SinhVien seach(final String maSinhVien) {
		String sql = "SELECT * FROM sinh_vien WHERE MASV=?";
		SinhVien listSinhVien = DatabaseUltil.selectForObject(sql, iPareEntity, maSinhVien);
		return listSinhVien;

	}

}
