package controller.DAO;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import common.database.DatabaseUltil;
import common.database.DatabaseUltil.IPareEntity;
import common.database.DatabaseUltil.IPrePareStatementSetParam;
import model.bean.SinhVien;

@ManagedBean
public class SinhVienDao {
	public static final int RECORD_IN_PAGE = 5;

	private IPareEntity<SinhVien> iPareEntity = new IPareEntity<SinhVien>() {
		public SinhVien pare(ResultSet result) throws SQLException {
			return new SinhVien(result.getInt("id"), result.getString("name"), result.getString("email"),
					result.getString("password"), result.getString("gender"),result.getString("address"));}};

	public List<SinhVien> getSinhVien() {
		String sql = "select * from sinhvien";
		List<SinhVien> arraylist = DatabaseUltil.selectForList(sql, iPareEntity);
		return arraylist;
	}

	public SinhVien seach(final String maSinhVien) {
		String sql = "select * from sinhvien where id = ?";
		SinhVien listSV = DatabaseUltil.selectForObject(sql, iPareEntity, maSinhVien);
		return listSV;
	}

	public static int addSinhVien(final SinhVien sv) {
		String sql = "INSERT INTO sinhvien(name,email,password,gender,address) VALUES (?,?,?,?,?)";
		int listSV = DatabaseUltil.executeUpdate(sql, new IPrePareStatementSetParam() {
			public void setParameterQuery(java.sql.PreparedStatement statement) throws SQLException {
				statement.setString(1, sv.getName());
				statement.setString(2, sv.getemail());
				statement.setString(3, sv.getpassword());
				statement.setString(4, sv.getGender());
				statement.setString(5, sv.getAddress());
			}
		});
		return listSV;
	}

	public static int editSinhVien(final SinhVien sv) {
		String sql = "UPDATE sinhvien SET name=?,email=?,password=?,gender=?,address=? WHERE id = ?";
		int listSV = DatabaseUltil.executeUpdate(sql, new IPrePareStatementSetParam() {
			public void setParameterQuery(java.sql.PreparedStatement statement) throws SQLException {
				statement.setString(1, sv.getName());
				statement.setString(2, sv.getemail());
				statement.setString(3, sv.getpassword());
				statement.setString(4, sv.getGender());
				statement.setString(5, sv.getAddress());
				statement.setInt(6, sv.getId());
			}
		});
		return listSV;
	}

	public int delete(final String maSinhVien) {
		String sql = "DELETE FROM sinhvien WHERE id=?";
		int listSV = DatabaseUltil.executeUpdateWithValues(sql, maSinhVien);
		return listSV;
	}

	public List<SinhVien> getSinhVienInPage(int currentPage) {
		return currentPage > 0 ? PTtrang((currentPage - 1) * RECORD_IN_PAGE, RECORD_IN_PAGE)
				: new ArrayList<SinhVien>();
	}

	

	public List<SinhVien> PTtrang(int start, int recordinPage) {
		String sql = "SELECT * FROM dssinhvien  LIMIT ?,?";
		return DatabaseUltil.selectForList(sql, new IPareEntity<SinhVien>() {
			public SinhVien pare(ResultSet result) throws SQLException {
				return new SinhVien(result.getString("maSinhVien"), result.getString("tenSinhVien"),
						result.getString("tuoiSinhVien"), result.getString("lopHoc"), result.getString("diaChi"));
			}
		}, start, recordinPage);

	}
}
