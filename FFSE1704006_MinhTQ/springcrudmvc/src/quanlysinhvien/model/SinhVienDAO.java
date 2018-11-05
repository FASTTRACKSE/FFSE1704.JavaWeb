package quanlysinhvien.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import quanlysinhvien.entity.SinhVien;
import quanlysinhvien.entity.TinhThanh;

public class SinhVienDAO {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int add(SinhVien sv) {
		String sql = "INSERT INTO sinhvien(tenSinhVien,tuoiSinhVien,diaChi,avatar,email) VALUES('" + sv.getTenSinhVien()
				+ "','" + sv.getTuoiSinhVien() + "','" + sv.getDiaChi() + "','" + sv.getAvatar() + "','" + sv.getEmail()
				+ "')";
		return template.update(sql);

	}

	public int update(SinhVien sv) {
		String sql = "UPDATE sinhvien SET tenSinhVien='" + sv.getTenSinhVien() + "', tuoiSinhVien="
				+ sv.getTuoiSinhVien() + ",diaChi='" + sv.getDiaChi() + "',avatar='" + sv.getAvatar() + "',email='"
				+ sv.getEmail() + "' WHERE id=" + sv.getId() + "";
		return template.update(sql);

	}

	public SinhVien getSVById(int id) {
		String sql = "SELECT sinhvien.id,sinhvien.tenSinhVien,sinhvien.tuoiSinhVien,tinhthanh.tenTinh AS diaChi,sinhvien.avatar,sinhvien.email FROM sinhvien INNER JOIN tinhthanh ON sinhvien.diachi=tinhthanh.id WHERE sinhvien.id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<SinhVien>(SinhVien.class));
	}

	public int delete(int id) {
		String sql = "DELETE FROM sinhvien WHERE  id=" + id + "";
		return template.update(sql);
	}

	public List<SinhVien> getSinhVien() {
		return template.query("SELECT sinhvien.id,sinhvien.tenSinhVien,sinhvien.tuoiSinhVien,tinhthanh.tenTinh AS diaChi,sinhvien.avatar,sinhvien.email FROM sinhvien INNER JOIN tinhthanh ON sinhvien.diachi=tinhthanh.id ORDER BY id ASC ", new RowMapper<SinhVien>() {
			public SinhVien mapRow(ResultSet rs, int row) throws SQLException {
				SinhVien list = new SinhVien();
				list.setId(rs.getString(1));
				list.setTenSinhVien(rs.getString(2));
				list.setTuoiSinhVien(rs.getString(3));
				list.setDiaChi(rs.getString(4));
				list.setAvatar(rs.getString(5));
				list.setEmail(rs.getString(6));
				return list;
			}
		});
	}
 
	public List<TinhThanh> getListThanhPho(){
	return template.query("SELECT * FROM tinhthanh", new RowMapper<TinhThanh>() {
		public TinhThanh mapRow(ResultSet rs, int row) throws SQLException {
			TinhThanh list = new TinhThanh();
			list.setMaTinhThanh(rs.getInt(1));
			list.setTenTinhThanh(rs.getString(2));
			
			return list;
		}
	});
	}
	
}
