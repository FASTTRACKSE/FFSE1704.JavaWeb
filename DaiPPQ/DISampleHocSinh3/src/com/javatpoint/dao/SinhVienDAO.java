package com.javatpoint.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
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
				+ sv.getLop() + "','" + sv.getImage() + "')";
		return template.update(sql);
	}
	
	public int update(SinhVien sv) {
		String sql = "update sinhvien set masv='" + sv.getMasv() + "', tensv='" + sv.getTensv() + "', namsinh='"
				+ sv.getNamsinh() + "', email='" + sv.getEmail() + "', diachi='" + sv.getDiachi() + "', lop='"
				+ sv.getLop() + "', image='" + sv.getImage() + "' where id=" + sv.getId() + "";
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
	/*
	 * //Ds sinh vien khong phan trang public List<SinhVien> getSinhVienloyees() {
	 * return template.query("select * from sinhvien", new RowMapper<SinhVien>() {
	 * public SinhVien mapRow(ResultSet rs, int row) throws SQLException { SinhVien
	 * e = new SinhVien(); e.setId(rs.getInt(1)); e.setMasv(rs.getString(2));
	 * e.setTensv(rs.getString(3)); e.setNamsinh(rs.getInt(4));
	 * e.setEmail(rs.getString(5)); e.setDiachi(rs.getString(6));
	 * e.setLop(rs.getString(7)); return e; } }); }
	 */
	/*
	 * //Ds sinh vien phan trang cung public List<SinhVien>
	 * getSinhVienloyeesByPage(int pageid, int total) { String sql =
	 * "select * from sinhvien limit " + (pageid - 1) + "," + total; return
	 * template.query(sql, new RowMapper<SinhVien>() { public SinhVien
	 * mapRow(ResultSet rs, int row) throws SQLException { SinhVien e = new
	 * SinhVien(); e.setId(rs.getInt(1)); e.setMasv(rs.getString(2));
	 * e.setTensv(rs.getString(3)); e.setNamsinh(rs.getInt(4));
	 * e.setEmail(rs.getString(5)); e.setDiachi(rs.getString(6));
	 * e.setLop(rs.getString(7)); return e; } }); }
	 */

	// Ds sinh vien phan trang dong
	public List<SinhVien> getSinhVienloyeesByPage(int start, int total) {
		return template.query("select * from sinhvien limit " + start + "," + total + "", new RowMapper<SinhVien>() {
			public SinhVien mapRow(ResultSet rs, int row) throws SQLException {
				SinhVien sv = new SinhVien();
				sv.setId(rs.getInt(1));
				sv.setMasv(rs.getString(2));
				sv.setTensv(rs.getString(3));
				sv.setNamsinh(rs.getInt(4));
				sv.setEmail(rs.getString(5));
				sv.setDiachi(rs.getString(6));
				sv.setLop(rs.getString(7));
				sv.setImage(rs.getString(8));
				return sv;
			}
		});
	}

	// Dem
	public int countSV() {
		String sql = "select count(*) from sinhvien ";
		int records = template.queryForObject(sql, Integer.class);
		return records;

	}
}
