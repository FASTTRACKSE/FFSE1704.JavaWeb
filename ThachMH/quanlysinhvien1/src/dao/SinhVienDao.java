package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import entity.SinhVien;

public class SinhVienDao {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	// list SinhVien
	public List<SinhVien> getList() {
		return template.query("select * from qlsinhvien", new RowMapper<SinhVien>() {
			public SinhVien mapRow(ResultSet rs, int row) throws SQLException {
				SinhVien e = new SinhVien();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setBirth_year(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setAddress(rs.getString(5));
				e.setLop(rs.getString(6));
				e.setGender(rs.getString(7));
				return e;
			}
		});
	}

	public SinhVien getSVById(int id) {
		String sql = "select * from qlsinhvien where id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<SinhVien>(SinhVien.class));
	}

	public int update(SinhVien sv) {
		String sql = "UPDATE qlsinhvien SET name = '" + sv.getName() + "', birth_year = '" + sv.getBirth_year()
				+ "', email = '" + sv.getEmail() + "', address = '" + sv.getAddress() + "', lop = '" + sv.getLop()
				+ "', gender='" + sv.getGender() + "' WHERE id = " + sv.getId() + "";
		return template.update(sql);
	}
	
	public int delete(int id) {
		String sql = "DELETE FROM qlsinhvien WHERE  id=" + id + "";
		return template.update(sql);
	}
	
	public int add(SinhVien sv) {
		String sql = "INSERT INTO qlsinhvien(name,birth_year,email,address,lop,gender) VALUES('" + sv.getName() + "','"
				+ sv.getBirth_year() + "','" + sv.getEmail() + "','" + sv.getAddress() + "','" + sv.getLop() + "','"
				+ sv.getGender() + "')";
		return template.update(sql);
	}
	
	 

}
