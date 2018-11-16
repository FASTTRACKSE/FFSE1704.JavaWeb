package fasttrack.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import fasttrack.entity.HocSinh;
import fasttrack.entity.TinhThanh;

public class HocSinhDao {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(HocSinh hs) {
		String sql = "INSERT INTO sinhvien(nameStudent , classStudent , gender , address, avatar) VALUE ('"
				+ hs.getNameStudent() + "', '" + hs.getClassStudent() + "' , '" + hs.getGender() + "' , '"
				+ hs.getAddress() + "','" + hs.getAvatar() + "')";
		return template.update(sql);
	}

	public HocSinh getStudentById(int id) {
	String sql = "SELECT * FROM sinhvien WHERE id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<HocSinh>(HocSinh.class));
	}

	public int update(HocSinh hs) {

		String sql = "UPDATE `sinhvien` SET `nameStudent`='" + hs.getNameStudent() + "'," + "`classStudent`='"
				+ hs.getClassStudent() + "',`gender`='" + hs.getGender() + "' ,`address`  = '" + hs.getAddress()
				+ "', `avatar`='" + hs.getAvatar() + "' WHERE id = '" + hs.getId() + "'";

		return template.update(sql);
	}

	public int delete(int id) {
		String sql = "DELETE FROM sinhvien WHERE id='" + id + "'";
		return template.update(sql);
	}

	public List<TinhThanh> getTinhThanh() {
		return template.query("SELECT * FROM tinhthanh", new RowMapper<TinhThanh>() {
			public TinhThanh mapRow(ResultSet rs, int row) throws SQLException {
				TinhThanh th = new TinhThanh();
				th.setMaTinh(rs.getInt(1));
				th.setTenTinh(rs.getString(3));

				return th;
			}
		});
	}

	public List<HocSinh> getStudentByPage(int start, int total) {
		String sql = "SELECT sinhvien.id , sinhvien.nameStudent , sinhvien.classStudent , sinhvien.gender , tinhthanh.tentinh AS address , sinhvien.avatar FROM sinhvien LEFT JOIN tinhthanh ON sinhvien.address = tinhthanh.matinh ORDER BY id ASC limit "
				+ start + "," + total + "";
		return template.query(sql, new RowMapper<HocSinh>() {
			public HocSinh mapRow(ResultSet rs, int row) throws SQLException {
				HocSinh hs = new HocSinh();
				hs.setId(rs.getInt(1));
				hs.setNameStudent(rs.getString(2));
				hs.setClassStudent(rs.getString(3));
				hs.setGender(rs.getString(4));
				hs.setAddress(rs.getString(5));
				hs.setAvatar(rs.getString(6));
				return hs;
			}
		});
	}

	public int counths() throws SQLException {
		String sql = "SELECT COUNT(*) FROM sinhvien";
		return template.queryForObject(sql, Integer.class);
	}

}
