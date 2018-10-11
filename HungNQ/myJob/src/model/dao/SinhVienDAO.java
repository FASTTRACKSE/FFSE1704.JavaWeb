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
import model.entity.SinhVien;

public class SinhVienDAO {
	private IPrePareStatement iPrePareStatement = new IPrePareStatement() {
		public void setParameterQuery(Map<?, ?> mapParam, PreparedStatement statement) throws SQLException {
			statement.setString(1, (String) mapParam.get("user"));
			statement.setString(2, (String) mapParam.get("pass"));
		}

	};

	private IPareEntity<SinhVien> iPareEntity = new IPareEntity<SinhVien>() {
		public SinhVien pare(ResultSet result) throws SQLException {
			return new SinhVien(result.getString("id"), result.getString("lop"), result.getString("maSV"),
					result.getString("ten"), result.getString("tuoi"), result.getString("gioitinh"));

		}
	};

	public SinhVien getUser(String username, String password) {
		String sql = "SELECT * FROM sinhvien WHERE username=? and password=?";
		Map<String, String> mapParam = new HashMap<String, String>();
		mapParam.put("user", username);
		mapParam.put("pass", password);
		List<SinhVien> listSinhVien = DatabaseUltil.executeSelect(sql, mapParam, iPrePareStatement, iPareEntity);
		return listSinhVien.size() == 0 ? null : listSinhVien.get(0);
	}

	public List<SinhVien> getAllUser() {
		String sql = "SELECT * FROM sinhvien";
		List<SinhVien> arrList = DatabaseUltil.executeSelect(sql, null, null, iPareEntity);
		return arrList;
	}

	public SinhVien readSinhVien(String id) {
		String sql = "SELECT * FROM sinhvien WHERE id=?";
		Map<String, String> mapParam = new HashMap<String, String>();
		mapParam.put("sinhvien", id);
		List<SinhVien> listSinhVien = DatabaseUltil.executeSelect(sql, mapParam, new IPrePareStatement() {

			@Override
			public void setParameterQuery(Map<?, ?> mapParam, PreparedStatement statement) throws SQLException {
				statement.setInt(1, Integer.parseInt((String) mapParam.get("sinhvien")));
			}
		}, iPareEntity);
		return listSinhVien.size() == 0 ? null : listSinhVien.get(0);
	}

	public boolean createSinhVien(String lop, String ma, String ten, String tuoi, String gioitinh) {
		String sql = "INSERT INTO sinhvien(Lop,MaSV,Ten,Tuoi,GioiTinh) VALUES (?,?,?,?,?)";
		Map<String, String> mapParam = new HashMap<String, String>();
		mapParam.put("lop", lop);
		mapParam.put("masv", ma);
		mapParam.put("ten", ten);
		mapParam.put("tuoi", tuoi);
		mapParam.put("gioitinh", gioitinh);

		return DatabaseUltil.executeUpdate(sql, mapParam, new IPrePareStatement() {

			@Override
			public void setParameterQuery(Map<?, ?> mapParam, PreparedStatement statement) throws SQLException {
				statement.setString(1, (String) mapParam.get("lop"));
				statement.setString(2, (String) mapParam.get("masv"));
				statement.setString(3, (String) mapParam.get("ten"));
				statement.setString(4, (String) mapParam.get("tuoi"));
				statement.setString(5, (String) mapParam.get("gioitinh"));
			}
		});

	}

	public boolean deleteSinhVien(String id) {
		String sql = "DELETE FROM sinhvien WHERE id=?";
		Map<String, String> mapParam = new HashMap<String, String>();
		mapParam.put("sinhvien", id);
		return DatabaseUltil.executeUpdate(sql, mapParam, new IPrePareStatement() {

			@Override
			public void setParameterQuery(Map<?, ?> mapParam, PreparedStatement statement) throws SQLException {
				statement.setInt(1, Integer.parseInt((String) mapParam.get("sinhvien")));
			}
		});
	}

	public boolean updateSinhVien(String lop, String ma, String ten, String tuoi, String gioitinh, String id) {
		String sql = "UPDATE sinhvien SET Lop=?,MaSV=?,Ten=?,Tuoi=?,GioiTinh=? WHERE ID=?";
		Map<String, String> mapParam = new HashMap<String, String>();
		mapParam.put("id", id);
		mapParam.put("lop", lop);
		mapParam.put("ma", ma);
		mapParam.put("ten", ten);
		mapParam.put("tuoi", tuoi);
		mapParam.put("gioitinh", gioitinh);
		return DatabaseUltil.executeUpdate(sql, mapParam, new IPrePareStatement() {

			@Override
			public void setParameterQuery(Map<?, ?> mapParam, PreparedStatement statement) throws SQLException {
				statement.setString(1, (String) mapParam.get("id"));
				statement.setString(2, (String) mapParam.get("lop"));
				statement.setString(3, (String) mapParam.get("ma"));
				statement.setString(4, (String) mapParam.get("ten"));
				statement.setString(5, (String) mapParam.get("tuoi"));
				statement.setString(6, (String) mapParam.get("gioitinh"));
			}
		});
	}

	/*public List<SinhVien> searchReCords(final int start, final int end) {
		String sql = "select * from sinhvien limit ?,? ";
		Map<String, String> mapParam = new HashMap<String, String>();
		
		List<SinhVien> arrSinhVien = DatabaseUltil.executeSelect(sql, mapParam, new IPrePareStatement() {

			@Override
			public void setParameterQuery(Map<?, ?> mapParam, PreparedStatement statement) throws SQLException {
				statement.setInt(1, start);
				statement.setInt(2, end);
			}
		}, iPareEntity);
		return arrSinhVien;
	}*/
}
