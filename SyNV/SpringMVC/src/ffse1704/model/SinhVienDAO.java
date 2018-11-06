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
		String sql = "insert into student(masv,tensv,namsinh,email,diachi,lophoc) values('" + p.getMasv() + "','" + p.getTensv() + "','" + p.getNamsinh() + "','" + p.getEmail() + "','" + p.getDiachi() + "','" + p.getLophoc() + "','" + p.getImage() + "')";
		return template.update(sql);
	}

	public int update(SinhVien p) {
		String sql = "update student set masv='" + p.getMasv() + "', tensv='" + p.getTensv() + "', namsinh='"+ p.getNamsinh() + "', email='"+ p.getEmail() + "', diachi='"+ p.getDiachi() + "', lophoc='"+ p.getLophoc() + "', image='"+ p.getImage() + "' where id=" + p.getId() + "";
		return template.update(sql);
	}

	public int delete(int id) {
		String sql = "delete from student where id=" + id + "";
		return template.update(sql);
	}

	public SinhVien getSinhVienById(int id) {
		String sql = "select * from student where id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<SinhVien>(SinhVien.class));
	}

	public List<SinhVien> getSinhVienloyees() {
		return template.query("select * from student", new RowMapper<SinhVien>() {
			public SinhVien mapRow(ResultSet rs, int row) throws SQLException {
				SinhVien e = new SinhVien();
				e.setId(rs.getInt(1));
				e.setMasv(rs.getString(2));
				e.setTensv(rs.getString(3));
				e.setNamsinh(rs.getString(4));
				e.setEmail(rs.getString(5));
				e.setDiachi(rs.getString(6));
				e.setLophoc(rs.getString(7));
				e.setImage(rs.getString(8));
				return e;
			}
		});
	}

	public List<SinhVien> getEmployeesByPage(int pageid, int total) {
		String sql = "select * from student limit "+(pageid-1)+","+total;  
		return template.query(sql, new RowMapper<SinhVien>() {
			public SinhVien mapRow(ResultSet rs, int row) throws SQLException {
				SinhVien e = new SinhVien();
				e.setId(rs.getInt(1));
				e.setMasv(rs.getString(2));
				e.setTensv(rs.getString(3));
				e.setNamsinh(rs.getString(4));
				e.setEmail(rs.getString(5));
				e.setDiachi(rs.getString(6));
				e.setLophoc(rs.getString(7));
				e.setImage(rs.getString(8));
				return e;
			}
		});
	}
}
