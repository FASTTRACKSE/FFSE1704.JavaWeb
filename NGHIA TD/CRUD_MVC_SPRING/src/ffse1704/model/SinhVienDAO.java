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

	public int save(SinhVien p) {
		String sql = "insert into hello_crud(name,salary,designation) values('" + p.getName() + "'," + p.getSalary()
				+ ",'" + p.getDesignation() + "')";
		return template.update(sql);
	}

	public int update(SinhVien p) {
		String sql = "update hello_crud set name='" + p.getName() + "', salary=" + p.getSalary() + ",designation='"
				+ p.getDesignation() + "' where id=" + p.getId() + "";
		return template.update(sql);
	}

	public int delete(int id) {
		String sql = "delete from hello_crud where id=" + id + "";
		return template.update(sql);
	}

	public SinhVien getSinhVienById(int id) {
		String sql = "select * from hello_crud where id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<SinhVien>(SinhVien.class));
	}

	public List<SinhVien> getSinhVienloyees() {
		return template.query("select * from hello_crud", new RowMapper<SinhVien>() {
			public SinhVien mapRow(ResultSet rs, int row) throws SQLException {
				SinhVien e = new SinhVien();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getFloat(3));
				e.setDesignation(rs.getString(4));
				return e;
			}
		});
	}

	public List<SinhVien> getEmployeesByPage(int pageid, int total) {
		String sql = "select * from Emp limit " + (pageid - 1) + "," + total;
		return template.query(sql, new RowMapper<SinhVien>() {
			public SinhVien mapRow(ResultSet rs, int row) throws SQLException {
				SinhVien e = new SinhVien();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getFloat(3));
				return e;
			}
		});
	}
}
