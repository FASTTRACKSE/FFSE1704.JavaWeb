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

	public static final int RECORD_IN_PAGE = 1;
	
	private IPareEntity<SinhVien> iPareEntity = new IPareEntity<SinhVien>() {
		public SinhVien pare(ResultSet result) throws SQLException {
			return new SinhVien(result.getString("id"), result.getString("tensinhvien"), result.getString("masinhvien"),
					result.getString("lop"), result.getString("tuoi"), result.getString("gioitinh"),
					result.getString("diachi"), result.getString("sodt"), result.getString("email"));
		}
	};
	
	public List<SinhVien> checkSinhVien(final String username, final String password) {
		String sql = "SELECT * FROM member WHERE username=?,password=?";
		List<SinhVien> loginSinhVien = DatabaseUltil.selectForList(sql, new IPrePareStatementSetParam() {

			public void setParameterQuery(PreparedStatement statement) throws SQLException {
				statement.setString(1, username);
				statement.setString(2, password);
			}
		}, iPareEntity);
		return loginSinhVien;

	}

	public List<SinhVien> getAllSinhVien() {
		String sql = "SELECT * FROM sinhvien";
		List<SinhVien> arrList = DatabaseUltil.selectForList(sql, iPareEntity);
		return arrList;
	}

	public SinhVien searchSinhVien(final String id) {
		String sql = "SELECT * FROM sinhvien WHERE masinhvien=?";
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
	
	public List<SinhVien> getSinhVienInPage(int currentPage){
		return currentPage > 0 ? getSinhVienLimit((currentPage - 1) * RECORD_IN_PAGE, RECORD_IN_PAGE):new ArrayList<SinhVien>();
	}

	public List<SinhVien> getSinhVienLimit(int start, int recordinPage){
		String sql = "SELECT * FROM sinhvien  LIMIT ?,?";
		return DatabaseUltil.selectForList(sql, new IPrePareStatementSetParam() {

			public void setParameterQuery(PreparedStatement statement) throws SQLException {
				statement.setInt(1, start);
				statement.setInt(2, recordinPage);
			}
		}, iPareEntity);
	}
	
}
