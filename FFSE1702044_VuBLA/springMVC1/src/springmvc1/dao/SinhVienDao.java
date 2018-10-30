package springmvc1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import springmvc1.entity.SinhVien;

public class SinhVienDao {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	public int add(SinhVien sv){  
	    String sql="INSERT INTO `quanlisinhvien`(`ma_sv`, `ten_sv`, `nam_sinh`, `dia_chi`, `lop_hoc`)"
	    		+ " VALUES ('"+sv.getMaSV()+"','"+sv.getTenSV()+"','"+sv.getNamSinh()+"','"+sv.getDiaChi()+"','"+sv.getLopHoc()+"')";  
	    return template.update(sql);
	}
	public List<SinhVien> getAllSV(){
		return template.query("SELECT * FROM `quanlisinhvien`", new RowMapper<SinhVien>(){

			@Override
			public SinhVien mapRow(ResultSet rs, int row) throws SQLException {
					SinhVien sv = new SinhVien();
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
