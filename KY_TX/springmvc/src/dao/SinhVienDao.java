package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import sinhvien.entity.SinhVien;
import sinhvien.entity.TinhThanh;

public class SinhVienDao {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	// list SinhVien
	public List<SinhVien> getSinhVien() {
		return template.query(
				"SELECT id,name,email,address,birth,nameClass,tinhthanh.nametp FROM `sinhvien`LEFT JOIN tinhthanh ON sinhvien.address = tinhthanh.matp",
				new RowMapper<SinhVien>() {
					public SinhVien mapRow(ResultSet rs, int row) throws SQLException {
						SinhVien sv = new SinhVien();
						sv.setId(rs.getInt(1));
						sv.setName(rs.getString(2));
						sv.setEmail(rs.getString(3));
						sv.setAddress(rs.getInt(4));
						sv.setBirth(rs.getInt(5));
						sv.setNameClass(rs.getString(6));
						sv.setNameTinhThanh(rs.getString(7));
						return sv;
					}
				});
	}

	// add SinhVien
	public int addSV(SinhVien sv) {
		String sql = "insert into sinhvien(name,email,address,birth,nameClass) values('" + sv.getName() + "','"
				+ sv.getEmail() + "'," + sv.getAddress() + "," + sv.getBirth() + ",'" + sv.getNameClass() + "')";
		return template.update(sql);
	}

	// edit SinhVien
	public int update(SinhVien sv) {
		String sql = "update sinhvien set name='" + sv.getName() + "', email='" + sv.getEmail() + "', address="
				+ sv.getAddress() + ", birth = '" + sv.getBirth() + "', nameClass= '" + sv.getNameClass()
				+ "' where id=" + sv.getId() + "";
		return template.update(sql);
	}

	// delete SinhVien
	public int delete(int id) {
		String sql = "delete from sinhvien where id=" + id + "";
		return template.update(sql);
	}

	// get SinhVien ByID
	public SinhVien getSVById(int id) {
		String sql = "select * from sinhvien where id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<SinhVien>(SinhVien.class));
	}

	// get list TinhThanh
	public List<TinhThanh> getListTinhThanh() {
		return template.query("select * from tinhthanh", new RowMapper<TinhThanh>() {
			public TinhThanh mapRow(ResultSet rs, int row) throws SQLException {
				TinhThanh tp = new TinhThanh();
				tp.setMatp(rs.getInt(1));
				tp.setNametp(rs.getString(2));
				return tp;
			}
		});
	}
}
