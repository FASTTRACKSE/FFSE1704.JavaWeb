package springmvc.form.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import springmvc.form.entity.User;

public class UserDao {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int add(User sv) {
		String sql = "INSERT INTO `quanlisinhvien`(`ma_SV`, `ten_SV`, `nam_sinh`, `dia_chi`, `lop_hoc`, `avatar`)" + " VALUES ('"
				+ sv.getMaSV() + "','" + sv.getTenSV() + "','" + sv.getNamSinh() + "','" + sv.getDiaChi() + "','"
				+ sv.getLopHoc() + "','"+sv.getAvatar()+"')";
		return template.update(sql);
	}

	public User getUserById(int id) {
		String sql = "SELECT id,`ma_SV` as maSV, `ten_SV` as tenSV, `nam_sinh`, `dia_chi`, `lop_hoc`, `avatar` FROM `quanlisinhvien` WHERE id =?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<User>(User.class));
	}

	public int update(User sv) {
		String sql = "UPDATE `quanlisinhvien` SET `ma_SV`='" + sv.getMaSV() + "',`ten_SV`='" + sv.getTenSV() + "',"
				+ "`nam_sinh`='" + sv.getNamSinh() + "',`dia_chi`='" + sv.getDiaChi() + "',`lop_hoc`='" + sv.getLopHoc()
				+ "',`avatar`='"+sv.getAvatar()+"'  WHERE `id`=" + sv.getId() ;
		return template.update(sql);
	}

	public int delete(int id) {
		String sql = "DELETE FROM `quanlisinhvien` WHERE `id`='" + id + "'";
		return template.update(sql);
	}

	public int coutSV() throws SQLException {
		String sql = "SELECT count(*) as totalSV FROM quanlisinhvien";
		return template.queryForObject(sql, Integer.class);

	}

	public List<User> getAllSVByPage(int start, int total) {
		return template.query("SELECT * FROM `quanlisinhvien` limit " + start + ", " + total + "",
				new RowMapper<User>() {
					@Override
					public User mapRow(ResultSet rs, int row) throws SQLException {
						User sv = new User();
						sv.setId(rs.getInt(1));
						sv.setMaSV(rs.getString(2));
						sv.setTenSV(rs.getString(3));
						sv.setNamSinh(rs.getInt(4));
						sv.setDiaChi(rs.getString(5));
						sv.setLopHoc(rs.getString(6));
						sv.setAvatar(rs.getString(7));
						return sv;
					}

				});
	}
}
