package ffse1704007.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import ffse1704007.entity.SinhVien;


public class SinhVienDAO {
	JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int addSV(SinhVien p) {
		String sql = "insert into sinhvien(MASV,TenSV,images,NamSinh,Email,DiaChi,LopHoc) values('" + p.getMaSV() + "','" + p.getTenSV()
				+ "','" + p.getImages() + "','" + p.getNamSinh() + "','" + p.getEmail() +"','" + p.getDiaChi() + "','" + p.getLopHoc() +"')";
		return template.update(sql);
	}

	public int update(SinhVien p) {
		String sql = "update sinhvien set MASV='" + p.getMaSV() + "', TenSV='" + p.getTenSV() + "', images='" + p.getImages() + "', NamSinh=" + p.getNamSinh() + ", Email='"
				+ p.getEmail() + "', DiaChi='" + p.getDiaChi() + "', LopHoc='" + p.getLopHoc()  + "' where id=" + p.getId()+ "";
		return template.update(sql);
	}

	public int delete(int id) {
		String sql = "delete from sinhvien where id=" + id + "";
		return template.update(sql);
	}

	public SinhVien getSinhVienById(int id) {
		String sql = "select * from sinhvien where id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<SinhVien>(SinhVien.class));
	}

	public List<SinhVien> getAllSinhVien() {
		return template.query("select * from sinhvien", new RowMapper<SinhVien>() {
			public SinhVien mapRow(ResultSet rs, int row) throws SQLException {
				SinhVien e = new SinhVien();
				e.setId(rs.getInt(1));
				e.setMaSV(rs.getString(2));
				e.setTenSV(rs.getString(3));
				e.setImages(rs.getString(4));
				e.setNamSinh(rs.getInt(5));
				e.setEmail(rs.getString(6));
				e.setDiaChi(rs.getString(7));
				e.setLopHoc(rs.getString(8));
				
				return e;
			}
		});
	}

	public List<SinhVien> getEmployeesByPage(int pageid, int total) {
		String sql = "select * from sinhvien limit " + pageid  + "," + total;
		return template.query(sql, new ResultSetExtractor<List<SinhVien>>() {
			@Override
			public List<SinhVien> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<SinhVien> list = new ArrayList<SinhVien>();
				while(rs.next()) {
				int id = rs.getInt("id");
				String MaSV = rs.getString("MaSV");
				String TenSV = rs.getString("TenSV");
				String images = rs.getString("images");
				Integer namSinh = rs.getInt("NamSinh");
				String email = rs.getString("Email");
				String diaChi = rs.getString("DiaChi");
				String lopHoc = rs.getString("LopHoc");
				SinhVien sv = new SinhVien(id,MaSV,TenSV,images,namSinh,email,diaChi,lopHoc);
				list.add(sv);
				}
				return list;
			}
		});
	}
	
	public int countSV() {
		String sql = "select count(*) from sinhvien ";
		int records = template.queryForObject(sql,Integer.class );
		return records;
		
	}
}
