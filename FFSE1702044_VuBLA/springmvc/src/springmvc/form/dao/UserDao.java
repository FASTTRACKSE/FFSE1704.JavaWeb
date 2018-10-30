package springmvc.form.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import springmvc.form.entity.User;

public class UserDao {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int add(User sv) {
		String sql = "INSERT INTO `quanlisinhvien`(`ma_sv`, `ten_sv`, `nam_sinh`, `dia_chi`, `lop_hoc`)" + " VALUES ('"
				+ sv.getMaSV() + "','" + sv.getTenSV() + "','" + sv.getNamSinh() + "','" + sv.getDiaChi() + "','"
				+ sv.getLopHoc() + "')";
		return template.update(sql);
	}
	public User getUserById(int id) {
		String sql= "select * form quanlisinhvien where id=?";
		return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<User>(User.class));  
	}
	public int update(User sv) {
		String sql = "UPDATE `quanlisinhvien` SET `ma_sv`='"+sv.getMaSV()+"',`ten_sv`='"+sv.getTenSV()+"',"
				+ "`nam_sinh`='"+sv.getNamSinh()+"',`dia_chi`='"+sv.getDiaChi()+"',`lop_hoc`='"+sv.getLopHoc()+"' WHERE `id`='"+sv.getId()+"' ";
	return template.update(sql);
	}
	public int delete(int id) {
		String sql="delete form quanlisinhvien where id='"+id+"'";
		return template.update(sql);
	}
	public List<User> getAllSV() {
		return template.query("SELECT * FROM `quanlisinhvien`", new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int row) throws SQLException {
				User sv = new User();
				sv.setId(rs.getInt(1));
				sv.setMaSV(rs.getString(2));
				sv.setTenSV(rs.getString(3));
				sv.setDiaChi(rs.getString(4));
				sv.setLopHoc(rs.getString(5));
				return sv;
			}

		});
	}
}
