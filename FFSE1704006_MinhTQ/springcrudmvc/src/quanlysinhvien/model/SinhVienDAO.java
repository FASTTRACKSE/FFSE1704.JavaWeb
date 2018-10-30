package quanlysinhvien.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import quanlysinhvien.entity.SinhVien;

public class SinhVienDAO {
	JdbcTemplate template;  
	
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}  
	
	public List<SinhVien> getEmployees(){  
	    return template.query("SELECT * FROM sinhvien",new RowMapper<SinhVien>(){  
	        public SinhVien mapRow(ResultSet rs, int row) throws SQLException {  
	            SinhVien list=new SinhVien();  
	            list.setId(rs.getString(1));  
	            list.setTenHocSinh(rs.getString(2));  
	            list.setTuoiHocSinh(rs.getString(3));  
	            list.setDiaChi(rs.getString(4));
	            list.setEmail(rs.getString(5));
	            return list;  
	        }  
	    });  
	}  
}
