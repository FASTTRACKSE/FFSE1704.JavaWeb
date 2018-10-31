package fasttrack.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import fasttrack.entity.HocSinh;

public class HocSinhDao {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(HocSinh hs) {
		String sql = "INSERT INTO sinhvien(nameStudent , classStudent , Gender) VALUE ('" + hs.getNameStudent() + "', '"
				+ hs.getClassStudent() + "' , '" + hs.getGender() + "')";
		return template.update(sql);
	}

	public HocSinh getStudentById(int id) {
		String sql = "SELECT * FROM sinhvien WHERE id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<HocSinh>(HocSinh.class));
	}

	public int update(HocSinh hs) {
		
		
		String sql = "UPDATE `sinhvien` SET `nameStudent`='" +hs.getNameStudent()+ "',"
				+ "`classStudent`='"+hs.getClassStudent()+"',`gender`='"+hs.getGender()+"' WHERE id = '"+ hs.getId()+"'";

		return template.update(sql);
	}

	public int delete(int id) {
		String sql = "DELETE FROM sinhvien WHERE id='" + id + "'";
		return template.update(sql);
	}

	public List<HocSinh> getStudent() {
		return template.query("SELECT * FROM sinhvien", new RowMapper<HocSinh>() {
			public HocSinh mapRow(ResultSet rs, int row) throws SQLException {
				HocSinh hs = new HocSinh();
				hs.setId(rs.getInt(1));
				hs.setNameStudent(rs.getString(2));
				hs.setClassStudent(rs.getString(3));
				hs.setGender(rs.getString(4));
				return hs;
			}
		});
	}

}
