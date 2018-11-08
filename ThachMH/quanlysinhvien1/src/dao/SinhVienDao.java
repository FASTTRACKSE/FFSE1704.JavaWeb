package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
				e.setBirth_year(rs.getInt(3));
				e.setEmail(rs.getString(4));
				e.setAddress(rs.getString(5));
				e.setLop(rs.getString(6));
				e.setGender(rs.getString(7));
				return e;
			}
		});
	}

}
