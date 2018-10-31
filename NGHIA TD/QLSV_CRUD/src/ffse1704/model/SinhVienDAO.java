package ffse1704.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ffse1704.entity.SinhVien;

public class SinhVienDAO {
	JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int addSV(SinhVien p) {
		String sql = "insert into sinhvien(MASV,TenSV,NamSinh,Email,DiaChi,LopHoc) values('" + p.getMaSV() + "','" + p.getTenSV()
				+ "','" + p.getNamSinh() + "','" + p.getEmail() +"','" + p.getDiaChi() + "','" + p.getLopHoc() +"')";
		return template.update(sql);
	}

	public int update(SinhVien p) {
		String sql = "update sinhvien set MASV='" + p.getMaSV() + "', TenSV='" + p.getTenSV() + "', NamSinh=" + p.getNamSinh() + ", Email='"
				+ p.getEmail() + "', DiaChi='" + p.getDiaChi() + "', LopHoc='" + p.getLopHoc()  + "' where id=" + p.getId()+ "";
		return template.update(sql);
	}

	public int delete(int id) {
		String sql = "delete from sinhvien where id=" + id + "";
		return template.update(sql);
	}

	public SinhVien getSinhVienById(int id) {
		String sql = "select * from sinhvien where id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<SinhVien>(SinhVien.class));
	}

	public List<SinhVien> getAllSinhVien() {
		return template.query("select * from sinhvien", new RowMapper<SinhVien>() {
			public SinhVien mapRow(ResultSet rs, int row) throws SQLException {
				SinhVien e = new SinhVien();
				e.setId(rs.getInt(1));
				e.setMaSV(rs.getString(2));
				e.setTenSV(rs.getString(3));
				e.setNamSinh(rs.getInt(4));
				e.setEmail(rs.getString(5));
				e.setDiaChi(rs.getString(6));
				e.setLopHoc(rs.getString(7));
				
				return e;
			}
		});
	}

	public List<SinhVien> getEmployeesByPage(int pageid, int total) {
		String sql = "select * from sinhvien limit " + (pageid - 1) + "," + total;
		return template.query(sql, new RowMapper<SinhVien>() {
			public SinhVien mapRow(ResultSet rs, int row) throws SQLException {
				SinhVien e = new SinhVien();
				e.setId(rs.getInt(1));
				e.setMaSV(rs.getString(2));
				e.setTenSV(rs.getString(3));
				e.setNamSinh(rs.getInt(4));
				e.setEmail(rs.getString(5));
				e.setDiaChi(rs.getString(6));
				e.setLopHoc(rs.getString(7));
				return e;
			}
		});
	}
}
