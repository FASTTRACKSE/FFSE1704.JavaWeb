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

	private IPareEntity<SinhVien> iPareEntity = new IPareEntity<SinhVien>() {
		public SinhVien pare(ResultSet result) throws SQLException {
			return new SinhVien(result.getString("id"), result.getString("masv"), result.getString("ho"),
					result.getString("ten"), result.getString("gioitinh"), result.getString("namsinh"),
					result.getString("lop"));
		}
	};

	public List<SinhVien> getAllSinhVien() {
		String sql = "SELECT * FROM sinhvien";
		List<SinhVien> arrList = DatabaseUltil.executeSelect(sql, null, null, iPareEntity);
		return arrList;
	}

	public SinhVien searchSinhVien(String id) {
		String sql = "SELECT * FROM sinhvien WHERE masinhvien=?";
		Map<String, String> mapParam = new HashMap<String, String>();
		mapParam.put("user", id);
		List<SinhVien> listSinhVien = DatabaseUltil.executeSelect(sql, mapParam, new IPrePareStatement() {

			public void setParameterQuery(Map<?, ?> mapParam, PreparedStatement statement) throws SQLException {
				statement.setString(1, (String) mapParam.get("user"));
			}
		}, iPareEntity);
		return listSinhVien.size() == 0 ? null : listSinhVien.get(0);

	}

	public SinhVien editSinhVien(SinhVien sv) {
		String sql = "UPDATE sinhvien SET masv=?, ho=?, ten=?, gioitinh=?, namsinh=?, lop=? WHERE id=?";
		Map<String, String> mapParam = new HashMap<String, String>();
		mapParam.put("masv", sv.getMasv());
		mapParam.put("ho", sv.getHo());
		mapParam.put("ten", sv.getTen());
		mapParam.put("gioitinh", sv.getGioitinh());
		mapParam.put("namsinh", sv.getNamsinh());
		mapParam.put("lop", sv.getLop());

		List<SinhVien> listSinhVien = DatabaseUltil.executeSelect(sql, mapParam, new IPrePareStatement() {

			public void setParameterQuery(Map<?, ?> mapParam, PreparedStatement statement) throws SQLException {
				statement.setString(1, (String) mapParam.get("masv"));
				statement.setString(2, (String) mapParam.get("ho"));
				statement.setString(3, (String) mapParam.get("ten"));
				statement.setString(4, (String) mapParam.get("gioitinh"));
				statement.setString(5, (String) mapParam.get("namsinh"));
				statement.setString(6, (String) mapParam.get("lop"));
			}
		}, iPareEntity);
		return listSinhVien.size() == 0 ? null : listSinhVien.get(0);

	}

	public SinhVien AddSinhVien(SinhVien sv) {
		String sql = "INSERT INTO sinhvien ( masv, ho, ten, gioitinh, namsinh, lop) VALUES (?, ?, ?, ?, ?, ?)";
		Map<String, String> mapParam = new HashMap<String, String>();
		mapParam.put("masv", sv.getMasv());
		mapParam.put("ho", sv.getHo());
		mapParam.put("ten", sv.getTen());
		mapParam.put("gioitinh", sv.getGioitinh());
		mapParam.put("namsinh", sv.getNamsinh());
		mapParam.put("lop", sv.getLop());

		List<SinhVien> listSinhVien = DatabaseUltil.executeSelect(sql, mapParam, new IPrePareStatement() {

			public void setParameterQuery(Map<?, ?> mapParam, PreparedStatement statement) throws SQLException {
				statement.setString(1, (String) mapParam.get("masv"));
				statement.setString(2, (String) mapParam.get("ho"));
				statement.setString(3, (String) mapParam.get("ten"));
				statement.setString(4, (String) mapParam.get("gioitinh"));
				statement.setString(5, (String) mapParam.get("namsinh"));
				statement.setString(6, (String) mapParam.get("lop"));

			}
		}, iPareEntity);
		return listSinhVien.size() == 0 ? null : listSinhVien.get(0);
	}

	// User user = null;
	// if ("Joker".equals(userName) && "123456".equals(passWord)) {
	// user = new User();
	// user.setUserName("Joker");
	// user.setPassWord("123456");
	// }
	// return user;
}
