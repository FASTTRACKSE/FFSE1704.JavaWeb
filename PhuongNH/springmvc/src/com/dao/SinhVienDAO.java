package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.entity.SinhVien;
import com.entity.TinhThanhPho;

public class SinhVienDAO {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(SinhVien p) {
		String sql = "insert into sinhvien(masinhvien,ten,namsinh,email,diachi,lophoc)  values('" + p.getMaSV() + "','"
				+ p.getTen() + "'," + p.getNamSinh() + ",'" + p.getEmail() + "','" + p.getDiaChi() + "','"
				+ p.getLopHoc() + "')";
		return template.update(sql);
	}

	public int update(SinhVien p) {
		String sql = "update sinhvien set masinhvien='" + p.getMaSV() + "', ten='" + p.getTen() + "', namsinh='"
				+ p.getNamSinh() + "', email='" + p.getEmail() + "',diachi='" + p.getDiaChi() + "'lophoc='"
				+ p.getLopHoc() + "' where id='" + p.getId() + "'";
		return template.update(sql);
	}

	public int delete(int id) {
		String sql = "delete from sinhvien where id=" + id + "";
		return template.update(sql);
	}

	public SinhVien getsinhvienById(int id) {
		String sql = "select * from sinhvien where id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<SinhVien>(SinhVien.class));
	}

	public List<SinhVien> getEmployees() {
		return template.query("select * from sinhvien", new RowMapper<SinhVien>() {
			public SinhVien mapRow(ResultSet rs, int row) throws SQLException {
				SinhVien sv = new SinhVien();
				sv.setId(rs.getInt(1));
				sv.setMaSV(rs.getString(2));
				sv.setTen(rs.getString(3));
				sv.setNamSinh(rs.getInt(4));
				sv.setEmail(rs.getString(5));
				sv.setDiaChi(rs.getString(6));
				sv.setLopHoc(rs.getString(7));
				return sv;
			}
		});
	}

	public List<TinhThanhPho> getListTinhThanh() {
		return template.query("select * from tinhthanhpho", new RowMapper<TinhThanhPho>() {
			public TinhThanhPho mapRow(ResultSet rs, int row) throws SQLException {
				TinhThanhPho tp = new TinhThanhPho();
				tp.setId(rs.getInt(1));
				tp.setTenTinhThanh(rs.getString(2));
				return tp;
			}
		});
	}
}
