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
import model.entity.SinhVien;

@ManagedBean
@SessionScoped
public class SinhVienDAO {
	public static final int RECORD_IN_PAGE = 5;
	
	public List<SinhVien> getSinhVienInPage(int currentPage) {
		return currentPage > 0 ? getSinhVienLimit((currentPage - 1) * RECORD_IN_PAGE, RECORD_IN_PAGE) : new ArrayList<SinhVien>();
	}

	public List<SinhVien> getSinhVienLimit(int start, int recordinPage) {
		
		String sql = "SELECT * FROM sinhvien  LIMIT ?,?";
		
		return DatabaseUltil.selectForList(sql, new IPareEntity<SinhVien>() {
			public SinhVien pare(ResultSet result) throws SQLException {
				return new SinhVien(result.getString("id"), result.getString("masv"), result.getString("ho"),
						result.getString("ten"), result.getString("gioitinh"),
						result.getString("namsinh"), result.getString("lop"), result.getString("image"));
			}
		}, start, recordinPage);
	}
	
	private IPareEntity<SinhVien> iPareEntity = new IPareEntity<SinhVien>() {
		public SinhVien pare(ResultSet result) throws SQLException {
			return new SinhVien(result.getString("id"), result.getString("masv"), result.getString("ho"),
					result.getString("ten"), result.getString("gioitinh"),
					result.getString("namsinh"), result.getString("lop"), result.getString("image"));
		}
	};

	public List<SinhVien> getAllSinhVien() {
		String sql = "SELECT * FROM sinhvien";
		List<SinhVien> arrList = DatabaseUltil.selectForList(sql, iPareEntity);
		return arrList;
	}

	public SinhVien searchSinhVien(final String id) {
		String sql = "SELECT * FROM sinhvien WHERE id=?";
		return DatabaseUltil.selectForObject(sql, iPareEntity, id);
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
		String sql = "UPDATE sinhvien SET masv=?, ho=?, ten=?, gioitinh=?, namsinh=?, lop=?, image=? WHERE id=?";

		int updateSinhVien = DatabaseUltil.executeUpdate(sql, new IPrePareStatementSetParam() {

			public void setParameterQuery(PreparedStatement statement) throws SQLException {
				statement.setString(1, sv.getMasv());
				statement.setString(2, sv.getHo());
				statement.setString(3, sv.getTen());
				statement.setString(4, sv.getGioiTinh());
				statement.setString(5, sv.getNamsinh());
				statement.setString(6, sv.getLop());
				statement.setString(7, sv.getImage());
				statement.setString(8, sv.getId());
			}
		});
		return updateSinhVien;
	}

	public int addSinhVien(final SinhVien sv) {
		String sql = "INSERT INTO sinhvien(masv, ho, ten, gioitinh, namsinh, lop, image) VALUES (?, ?, ?, ?, ?, ?, image)";
		int addSV = DatabaseUltil.executeUpdateWithValues(sql, sv.getMasv(), sv.getHo(), sv.getTen(),
				sv.getGioiTinh(), sv.getNamsinh(), sv.getLop(), sv.getImage());
		 return addSV;
		// int addSinhVien = DatabaseUltil.executeUpdate(sql, new
		// IPrePareStatementSetParam() {
		//
		// public void setParameterQuery(PreparedStatement statement) throws
		// SQLException {
		// statement.setString(1, sv.getMasv());
		// statement.setString(2, sv.getHo());
		// statement.setString(3, sv.getTen());
		// statement.setString(4, sv.getGioiTinh());
		// statement.setString(5, sv.getNamsinh());
		// statement.setString(6, sv.getLop());
		// }
		// });
		// return addSinhVien;
	}

	public int deleteSinhVien(final String maSV) {
		String sql = "DELETE FROM sinhvien WHERE id=? ";
		int addSinhVien = DatabaseUltil.executeUpdate(sql, new IPrePareStatementSetParam() {

			public void setParameterQuery(PreparedStatement statement) throws SQLException {
				statement.setString(1, maSV);
			}
		});
		return addSinhVien;
	}
}
