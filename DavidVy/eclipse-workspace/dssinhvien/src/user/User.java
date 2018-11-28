package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class User {
	String masinhvien;
	
	public String getMasinhvien() {
		return masinhvien;
	}
	public void setMasinhvien(String masinhvien) {
		this.masinhvien = masinhvien;
	}

	String name;
	String tuoi;
	String gioitinh;
	String diachi;
	 
	ArrayList usersList ; 
	
	private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();  
	Connection connection;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTuoi() {
		return tuoi;
	}
	public void setTuoi(String tuoi) {
		this.tuoi = tuoi;
	}
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	
	public Connection getConnection(){  
		try{  
		Class.forName("com.mysql.jdbc.Driver");     
		connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/dssinhvien","juny8888","ho123456");  
		}catch(Exception e){  
		System.out.println(e);  
		}  
		return connection;  
		}  
	
	public ArrayList usersList() {
		try {
			usersList = new ArrayList();
			connection = getConnection();
			Statement stmt=getConnection().createStatement();
			ResultSet rs=stmt.executeQuery("select * from dssinhvien"); 
			while(rs.next()) {
				User user = new User();
				user.setMasinhvien(rs.getString("masinhvien"));
				user.setName(rs.getString("name"));
				user.setTuoi(rs.getString("tuoi"));
				user.setGioitinh(rs.getString("gioitinh"));
				user.setDiachi(rs.getString("diachi"));
				usersList.add(user);
			}
			connection.close();
		}catch(Exception e) {
			System.out.println(e);  
		}
		return usersList;
	}
	
	public String save() {
		int result = 0;
		try {
			connection = getConnection();
			PreparedStatement slmt = connection.prepareStatement("insert into user(masinhvien,name,tuoi,gioitinh,diachi) values(?,?,?,?,?)");
			slmt.setString(1,masinhvien);
			slmt.setString(2,name);
			slmt.setString(3,tuoi);
			slmt.setString(4,gioitinh);
			slmt.setString(5,diachi);
			result = slmt.executeUpdate();
			connection.close(); 
		}catch(Exception e) {
			System.out.println(e); 
		}
		if(result !=0)
			return "index.xhtml?faces-redirect=true";
		else return "create.xhtml?faces-redirect=true";	
	}
	
	public String edit(int masinhvien) {
		User user = null;
		System.out.println(masinhvien); 
		try {
			connection = getConnection();  
			Statement stmt=getConnection().createStatement();  
			ResultSet rs=stmt.executeQuery("select * from dssinhvien where masinhvien = "+(masinhvien));  
			rs.next();  
			user = new User();
			user.setMasinhvien(rs.getString("masinhvien"));
			user.setName(rs.getString("name"));
			user.setTuoi(rs.getString("tuoi"));
			user.setGioitinh(rs.getString("gioitinh"));
			user.setDiachi(rs.getString("diachi"));
			sessionMap.put("editUser", user);  
			connection.close(); 
		}catch(Exception e){  
			System.out.println(e);  
		} 
		return "/edit.xhtml?faces-redirect=true";
	}
	
	public String update(User u) {
		//int result = 0; 
		try {
			connection = getConnection();
			PreparedStatement stmt=connection.prepareStatement("update dssinhvien set name=?,tuoi=?,gioitinh=?,diachi=? where masinhvien=?");
			stmt.setString(1,u.getName());
			stmt.setString(2,u.getTuoi());
			stmt.setString(3,u.getGioitinh());
			stmt.setString(4,u.getDiachi());
			stmt.setString(5,u.getMasinhvien());
			stmt.executeUpdate();
			connection.close();  
		}catch(Exception e){  
			System.out.println();  
		}  
		return "/index.xhtml?faces-redirect=true";
	}
	
	public void delete(int masinhvien) {
		try {
			connection = getConnection();
			PreparedStatement stmt = connection.prepareStatement("delete from dssinhvien where masinhvien =" + masinhvien);
			stmt.executeUpdate();   
		}catch(Exception e){  
			System.out.println(e);  
		}  
	}
	
	public String getgioitinhName(char gioitinh){  
		if(gioitinh == 'M'){  
		return "nữ";  
		}else return "nam";  
		}

}
