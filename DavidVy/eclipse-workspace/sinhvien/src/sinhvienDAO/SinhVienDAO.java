package sinhvienDAO;



import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import com.mysql.jdbc.Connection;

import sinhvien.java.SinhVien;

public class SinhVienDAO {
	
	public static Connection getConnection(){
		Connection con= null;
			try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");  
	            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:8080:xe","system","oracle"); 
			}catch(Exception e){System.out.println(e);}  
		return con;
		
	}
	public static int save(SinhVien e) {
		int status = 0;
		try {
			Connection con = SinhVienDAO.getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into sinhvien(id,ten,tuoi,ngaysinh,diachi) values (?,?,?,?,?)");
			ps.setInt(1, e.getid());
			ps.setString(2, e.getten());
			ps.setString(3, e.gettuoi());
			ps.setString(4, e.getngaysinh());
			ps.setString(5, e.getdiachi());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}

	public static int update(SinhVien e) {
		int status = 0;
		try {
			Connection con = SinhVienDAO.getConnection();
			PreparedStatement ps = con
					.prepareStatement("update sinhvien set ten=?,tuoi=?,ngaysinh=?,diachi=? where id=?");
			ps.setString(1, e.getten());
			ps.setString(2, e.gettuoi());
			ps.setString(3, e.getngaysinh());
			ps.setString(4, e.getdiachi());
			ps.setInt(5, e.getid());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}

	public static int delete(int id) {
		int status = 0;
		try {
			Connection con = SinhVienDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from sinhvien where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static SinhVien getEmployeeByid(int id) {
		SinhVien e = new SinhVien();
		
		try {
			Connection con=SinhVienDAO.getConnection();
			 PreparedStatement ps=con.prepareStatement("select * from sinhvien where id=?"); 
			 ps.setInt(1,id);
			 ResultSet rs = ps.executeQuery();
			 if(rs.next()) {
					ps.setInt(1, e.getid());
					ps.setString(2, e.getten());
					ps.setString(3, e.gettuoi());
					ps.setString(4, e.getngaysinh());
					ps.setString(5, e.getdiachi()); 
			 }
			 
			 con.close();
		}catch(Exception ex){ex.printStackTrace();} 
		
		return e;
		
	}
	
	public static List<SinhVien> getAllEmployees(){
		  List<SinhVien> list=new ArrayList<SinhVien>();
	        try{  
	            Connection con=SinhVienDAO.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from sinhvien");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	                SinhVien e=new SinhVien();  
	                e.setid(rs.getInt(1));  
	                e.setten(rs.getString(2));  
	                e.settuoi(rs.getString(3));  
	                e.setngaysinh(rs.getString(4));  
	                e.setdiachi(rs.getString(5));  
	                list.add(e);  
	            }  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
		return list;
		
	}
}
