package fasttrack.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import fasttrack.entity.SinhVien;

public class SinhVienDAO {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public List<SinhVien> getAllSinhVien() {
		return template.query("select * from sinhvien", new RowMapper<SinhVien>() {
			@Override
			public SinhVien mapRow(ResultSet rs, int row) throws SQLException {
				SinhVien sv = new SinhVien();
				sv.setId(rs.getInt(1));
				sv.setName(rs.getString(2));
				sv.setBirthday(rs.getString(3));
				sv.setEmail(rs.getString(4));
				sv.setAddress(rs.getString(5));
				sv.setClasssv(rs.getString(6));
				return sv;
			}
		});
	}

	public int save(SinhVien sv) {
		String sql = "insert into sinhvien(name,birthday,email,address,classsv) values('" + sv.getName() + "','"
				+ sv.getBirthday() + "','" + sv.getEmail() + "','" + sv.getAddress() + "','" + sv.getClasssv() + "')";
		return template.update(sql);
	}

	public SinhVien getSinhVienById(int id) {
		String sql = "select * from sinhvien where id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<SinhVien>(SinhVien.class));
	}

	public int update(SinhVien sv) {
		String sql = "UPDATE `sinhvien` SET `name`='" + sv.getName() + "',`birthday`='" + sv.getBirthday()
				+ "',`email`='" + sv.getEmail() + "',`address`='" + sv.getAddress() + "',`classsv`='" + sv.getClasssv()
				+ "' WHERE id='" + sv.getId() + "'";
		return template.update(sql);
	}

	public int delete(int id) {
		String sql = "delete from sinhvien where id=" +id+ "";
		return template.update(sql);
	}

}
