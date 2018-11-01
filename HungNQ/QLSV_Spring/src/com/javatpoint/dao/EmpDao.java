package com.javatpoint.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.javatpoint.beans.Emp;

public class EmpDao {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(Emp p) {
		String sql = "insert into student(masv,tensv,namsinh,email,diachi,lophoc) values('" + p.getMasv() + "','"
				+ p.getTensv() + "','" + p.getNamsinh() + "','" + p.getEmail() + "','" + p.getDiachi() + "','"
				+ p.getLophoc() + "')";
		return template.update(sql);
	}

	public int update(Emp p) {
		String sql = "update student set masv='" + p.getMasv() + "', tensv='" + p.getTensv() + "',namsinh='"
				+ p.getNamsinh() + "',email='" + p.getEmail() + "',diachi='" + p.getDiachi() + "',lophoc='"
				+ p.getLophoc() + "' where id='" + p.getId() + "'";
		return template.update(sql);
	}

	public int delete(int id) {
		String sql = "delete from student where id=" + id + "";
		return template.update(sql);
	}

	public Emp getEmpById(int id) {
		String sql = "select * from student where id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Emp>(Emp.class));
	}

	public List<Emp> getEmployees() {
		return template.query("select * from student", new RowMapper<Emp>() {
			public Emp mapRow(ResultSet rs, int row) throws SQLException {
				Emp e = new Emp();
				e.setId(rs.getInt(1));
				e.setMasv(rs.getString(2));
				e.setTensv(rs.getString(3));
				e.setNamsinh(rs.getInt(4));
				e.setEmail(rs.getString(5));
				e.setDiachi(rs.getString(6));
				e.setLophoc(rs.getString(7));
				return e;
			}
		});
	}
}
