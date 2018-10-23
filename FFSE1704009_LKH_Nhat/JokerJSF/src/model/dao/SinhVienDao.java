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
import model.entity.SinhVien;

@ManagedBean
@SessionScoped
public class SinhVienDao {
	private IPareEntity<SinhVien> iPareEntity = new IPareEntity<SinhVien>() {
		public SinhVien pare(ResultSet result) throws SQLException {
			return new SinhVien(result.getString("masinhvien"), result.getString("tensinhvien"), 
					result.getString("lop"), result.getString("tuoi"), result.getString("gioitinh"),
					result.getString("diachi"), result.getString("sodt"), result.getString("email"), result.getString("avatar"));
		}
	};

	public List<SinhVien> getAllSinhVien() {
		String sql = "SELECT * FROM sinhvien";
		List<SinhVien> arrList = DatabaseUltil.selectForList(sql, iPareEntity);
		System.out.println(arrList.isEmpty());
		return arrList;
	}

	public SinhVien searchSinhVien(final String id) {
		String sql = "SELECT * FROM sinhvien WHERE masinhvien=?";
		return DatabaseUltil.selectForObject(sql, iPareEntity, id);

	}

	public List<SinhVien> pageSinhVien( int start, String KT) {
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
		String sql = "UPDATE sinhvien SET tensinhvien=?, lop=?, tuoi=?, gioitinh=?, diachi=?, sodt=?, email=?, avatar=? WHERE masinhvien=?";
		return DatabaseUltil.executeUpdateWithValues(sql, sv.getTenSinhVien(), sv.getLopHoc(), sv.getTuoiSinhVien(),
				sv.getGioiTinh(), sv.getDiaChi(), sv.getSoDT(), sv.getEmail(), sv.getAvatar(), sv.getMaSinhVien());

	}

	public int addSinhVien(final SinhVien sv) {
		String sql = "INSERT INTO sinhvien(tensinhvien,masinhvien,lop,tuoi,gioitinh,diachi,sodt,email,avatar) VALUES (?,?,?,?,?,?,?,?,?)";
		return DatabaseUltil.executeUpdateWithValues(sql, sv.getTenSinhVien(), sv.getMaSinhVien(), sv.getLopHoc(),
				sv.getTuoiSinhVien(), sv.getGioiTinh(), sv.getDiaChi(), sv.getSoDT(), sv.getEmail(), sv.getAvatar());

	}

	public int deleteSinhVien(final String maSV) {
		String sql = "DELETE FROM sinhvien WHERE masinhvien=? ";
		return DatabaseUltil.executeUpdateWithValues(sql, maSV);

	}

	
}
