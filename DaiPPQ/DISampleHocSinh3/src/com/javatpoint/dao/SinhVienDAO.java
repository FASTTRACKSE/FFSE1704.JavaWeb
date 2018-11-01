package com.javatpoint.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.javatpoint.entity.SinhVien;

public class SinhVienDAO {
	JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(SinhVien sv) {
		String sql = "insert into sinhvien(masv, tensv, namsinh, email, diachi, lop) values('" + sv.getMasv() + "','"
				+ sv.getTensv() + "','" + sv.getNamsinh() + "','" + sv.getEmail() + "','" + sv.getDiachi() + "','"
				+ sv.getLop() + "')";
		return template.update(sql);
	}

	public int update(SinhVien sv) {
		String sql = "update sinhvien set masv='" + sv.getMasv() + "', tensv='" + sv.getTensv() + "', namsinh='"
				+ sv.getNamsinh() + "', email='" + sv.getEmail() + "', diachi='" + sv.getDiachi() + "', lop='"
				+ sv.getLop() + "' where id=" + sv.getId() + "";
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

	public List<SinhVien> getSinhVienloyees() {
		return template.query("select * from sinhvien", new RowMapper<SinhVien>() {
			public SinhVien mapRow(ResultSet rs, int row) throws SQLException {
				SinhVien e = new SinhVien();
				e.setId(rs.getInt(1));
				e.setMasv(rs.getString(2));
				e.setTensv(rs.getString(3));
				e.setNamsinh(rs.getInt(4));
				e.setEmail(rs.getString(5));
				e.setDiachi(rs.getString(6));
				e.setLop(rs.getString(7));
				return e;
			}
		});
	}

	public List<SinhVien> getSinhVienloyeesByPage(int pageid, int total) {
		String sql = "select * from sinhvien limit " + (pageid - 1) + "," + total;
		return template.query(sql, new RowMapper<SinhVien>() {
			public SinhVien mapRow(ResultSet rs, int row) throws SQLException {
				SinhVien e = new SinhVien();
				e.setId(rs.getInt(1));
				e.setMasv(rs.getString(2));
				e.setTensv(rs.getString(3));
				e.setNamsinh(rs.getInt(4));
				e.setEmail(rs.getString(5));
				e.setDiachi(rs.getString(6));
				e.setLop(rs.getString(7));
				return e;
			}
		});
	}
}
