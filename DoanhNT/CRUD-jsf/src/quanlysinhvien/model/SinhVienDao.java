package quanlysinhvien.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import common.DatabaseUntil;
import common.DatabaseUntil.IPareEntity;
import common.DatabaseUntil.IPrePareStatementSetParam;
import quanlysinhvien.entity.SinhVien;

@ManagedBean
@SessionScoped
public class SinhVienDao {
	public static final int RECORD_IN_PAGE = 3;
	private IPareEntity<SinhVien> iPareEntity = new IPareEntity<SinhVien>() {
		public SinhVien pare(ResultSet result) throws SQLException {
			return new SinhVien(result.getString("id"), result.getString("name"), result.getString("age"),
					result.getString("gender"), result.getString("address"));
		}
	};

	public List<SinhVien> getSinhVien() {
		String sql = "select * from sinhvien";
		List<SinhVien> arraylist = DatabaseUntil.selectForList(sql, iPareEntity);
		return arraylist;
	}
	public SinhVien seach(final String maSinhVien) {
		String sql = "select * from sinhvien where id = ?";
		SinhVien listSV = DatabaseUntil.selectForObject(sql, iPareEntity, maSinhVien);
		return listSV;
	}
	public int addSinhVien(final SinhVien sv) {
		String sql = "INSERT INTO sinhvien(name,age,gender,address) VALUES (?,?,?,?)";
		int listSV = DatabaseUntil.executeUpdate(sql, new IPrePareStatementSetParam() {
			public void setParameterQuery(java.sql.PreparedStatement statement) throws SQLException{
				statement.setString(1, sv.getName());
				statement.setString(2, sv.getAge());
				statement.setString(3, sv.getGender());
				statement.setString(4, sv.getAddress());
			}
		});
		return listSV;
	}
	public int editSinhVien(final SinhVien sv) {
		String sql = "UPDATE sinhvien SET name=?,age=?,gender=?,address=? WHERE id = ?";
		int listSV = DatabaseUntil.executeUpdate(sql, new IPrePareStatementSetParam() {
			public void setParameterQuery(java.sql.PreparedStatement statement) throws SQLException{
				statement.setString(1, sv.getName());
				statement.setString(2, sv.getAge());
				statement.setString(3, sv.getGender());
				statement.setString(4, sv.getAddress());
				statement.setString(5, sv.getId());
			}
		});
		return listSV;
	}
	public int deleteSinhVien(final String id) {
		String sql = "delete from sinhvien where id=?";
		int listSV = DatabaseUntil.executeUpdateWithValues(sql, id);
		return listSV;
	}
	public List<SinhVien> getSinhVienInPage(int currentPage) {

		int startRecord = (currentPage - 1) * RECORD_IN_PAGE;

		String sql = "SELECT * FROM  sinhvien LIMIT ?, ?";

		return DatabaseUntil.selectForList(sql, new IPareEntity<SinhVien>() {
			public SinhVien pare(ResultSet result) throws SQLException {
				return new SinhVien(result.getString("id"),  result.getString("name"), result.getString("age"), result.getString("gender"), result.getString("address") );
			}
		}, startRecord, RECORD_IN_PAGE);
	}
}
