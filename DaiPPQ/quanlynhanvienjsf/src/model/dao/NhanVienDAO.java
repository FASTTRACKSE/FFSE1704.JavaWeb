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
import model.entity.NhanVien;

@ManagedBean
@SessionScoped
public class NhanVienDAO {
	public static final int RECORD_IN_PAGE = 5;

	public static List<NhanVien> getNhanVienInPage(int currentPage) {
		return currentPage > 0 ? getNhanVienLimit((currentPage - 1) * RECORD_IN_PAGE, RECORD_IN_PAGE)
				: new ArrayList<NhanVien>();
	}

	public static List<NhanVien> getNhanVienLimit(int start, int recordinPage) {

		String sql = "SELECT nhanvien.id, nhanvien.name, nhanvien.date, nhanvien.gender, devvn_tinhthanhpho.name AS address, nhanvien.images "
				+ "FROM nhanvien "
				+ "INNER JOIN devvn_tinhthanhpho "
				+ "ON nhanvien.address = devvn_tinhthanhpho.matp "
				+ "LIMIT ?,?";
		return DatabaseUltil.selectForList(sql, new IPareEntity<NhanVien>() {
			public NhanVien pare(ResultSet result) throws SQLException {
				return new NhanVien(result.getString("id"), result.getString("name"), result.getString("date"),
						result.getString("gender"), result.getString("address"), result.getString("images"));
			}
		}, start, recordinPage);
	}

	private IPareEntity<NhanVien> iPareEntity = new IPareEntity<NhanVien>() {
		public NhanVien pare(ResultSet result) throws SQLException {
			return new NhanVien(result.getString("id"), result.getString("name"), result.getString("date"),
					result.getString("gender"), result.getString("address"), result.getString("images"));
		}
	};

	public List<NhanVien> getAllNhanVien() {
		String sql = "SELECT nhanvien.id, nhanvien.name, nhanvien.date, nhanvien.gender, devvn_tinhthanhpho.name AS address, nhanvien.images "
				+ "FROM nhanvien "
				+ "INNER JOIN devvn_tinhthanhpho "
				+ "ON nhanvien.address = devvn_tinhthanhpho.matp";
		List<NhanVien> arrList = DatabaseUltil.selectForList(sql, iPareEntity);
		return arrList;
	}

	public NhanVien searchNhanVien(final String id) {
		String sql = "SELECT * FROM nhanvien WHERE id=?";
		return DatabaseUltil.selectForObject(sql, iPareEntity, id);
	}

	public List<NhanVien> pageNhanVien(final int start, final String KT) {
		String sql = "SELECT * FROM nhanvien  LIMIT ?,?";
		List<NhanVien> pageNhanVien = DatabaseUltil.selectForList(sql, new IPrePareStatementSetParam() {

			public void setParameterQuery(PreparedStatement statement) throws SQLException {
				statement.setInt(1, start);
				statement.setInt(2, Integer.parseInt(KT));
			}
		}, iPareEntity);
		return pageNhanVien;

	}

	public int editNhanVien(final NhanVien nv) {
		String sql = "UPDATE nhanvien SET manv=?, ho=?, ten=?, gioitinh=?, namsinh=?, lop=?, image=? WHERE id=?";
		int updateNhanVien = DatabaseUltil.executeUpdateWithValues(sql, nv.getName(), nv.getDate(), nv.getGender(),
				nv.getAddress(), nv.getImages(), nv.getId());
		return updateNhanVien;
		/*
		 * int updateNhanVien = DatabaseUltil.executeUpdate(sql, new
		 * IPrePareStatementSetParam() {
		 * 
		 * public void setParameterQuery(PreparedStatement statement) throws
		 * SQLException { statement.setString(1, nv.getManv()); statement.setString(2,
		 * nv.getHo()); statement.setString(3, nv.getTen()); statement.setString(4,
		 * nv.getGioiTinh()); statement.setString(5, nv.getNamsinh());
		 * statement.setString(6, nv.getLop()); statement.setString(7, nv.getImage());
		 * statement.setString(8, nv.getId()); } }); return updateNhanVien;
		 */
	}

	public int addNhanvien(final NhanVien nv) {
		String sql = "INSERT INTO nhanvien(name, date, gender, address, images) VALUES (?, ?, ?, ?, ?)";
		int addnv = DatabaseUltil.executeUpdateWithValues(sql, nv.getName(), nv.getDate(), nv.getGender(),
				nv.getAddress(), nv.getImages());
		return addnv;
		// int addNhanVien = DatabaseUltil.executeUpdate(sql, new
		// IPrePareStatementSetParam() {
		//
		// public void setParameterQuery(PreparedStatement statement) throws
		// SQLException {
		// statement.setString(1, nv.getManv());
		// statement.setString(2, nv.getHo());
		// statement.setString(3, nv.getTen());
		// statement.setString(4, nv.getGioiTinh());
		// statement.setString(5, nv.getNamsinh());
		// statement.setString(6, nv.getLop());
		// }
		// });
		// return addNhanVien;
	}

	public int deleteNhanVien(final String manv) {
		String sql = "DELETE FROM nhanvien WHERE id=? ";
		int addNhanVien = DatabaseUltil.executeUpdate(sql, new IPrePareStatementSetParam() {

			public void setParameterQuery(PreparedStatement statement) throws SQLException {
				statement.setString(1, manv);
			}
		});
		return addNhanVien;
	}
}
