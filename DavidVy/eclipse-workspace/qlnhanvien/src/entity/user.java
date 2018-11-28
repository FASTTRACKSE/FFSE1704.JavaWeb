package entity;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ReferencedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.sun.faces.facelets.tag.jsf.core.SetPropertyActionListenerHandler;

@ManagedBean
@RequestScoped

public class user {
	int id;
	String hoten;
	String namsinh;
	String gender;
	String hokhau;

	ArrayList usersList ;  
	private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();  
	Connection connection;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getNamsinh() {
		return namsinh;
	}
	public void setNamsinh(String namsinh) {
		this.namsinh = namsinh;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHokhau() {
		return hokhau;
	}
	public void setHokhau(String hokhau) {
		this.hokhau = hokhau;
	}
	
	
	
	// Used to establish connection  
			public Connection getConnection(){
			try{  
				Class.forName("com.mysql.jdbc.Driver");     
				connection = DriverManager.getConnection( "jdbc:mysql://localhost/qlnhanvien","User","root");  
				}catch(Exception e){  
				System.out.println(e);  
			}  
			return connection;  
			}
			
			// Used to fetch all records  
			public ArrayList usersList(){  
			try{  
				usersList = new ArrayList();  
				connection = getConnection();  
				Statement stmt=getConnection().createStatement();    
				ResultSet rs=stmt.executeQuery("select * from qlnhanvien ");    
				while(rs.next()){  
				user user = new user();  
				user.setId(rs.getInt("id"));  
				user.setHoten(rs.getString("hoten"));  
				user.setNamsinh(rs.getString("namsinh"));    
				user.setGender(rs.getString("gender"));  
				user.setHokhau(rs.getString("hokhau"));  
				usersList.add(user);  
			}  
				connection.close();          
			}catch(Exception e){  
				System.out.println(e);  
			}  
				return usersList;  
			} 
			
			// Used to save user record  
			public String save(){  
			int result = 0;  
			try{  
				connection = getConnection();  
				PreparedStatement stmt = connection.prepareStatement(  
				"insert into qlnhanvien(hoten,namsinh,gender,hokhau) values(?,?,?,?)");  
				stmt.setString(1, hoten);  
				stmt.setString(2, namsinh);   
				stmt.setString(3, gender);  
				stmt.setString(4, hokhau);  
				result = stmt.executeUpdate();  
				connection.close();  
			}catch(Exception e){  
				System.out.println(e);  
			}  
				if(result !=0)  
				return "indexx.xhtml?faces-redirect=true";  
				else return "create.xhtml?faces-redirect=true";  
			} 
			
			// Used to fetch record to update  
			public String edit(int id){  
				user user = null;  
				System.out.println(id);  
				try{  
				connection = getConnection();  
				Statement stmt=getConnection().createStatement();    
				ResultSet rs=stmt.executeQuery("select * from qlnhanvien where id = "+(id));  
				rs.next();  
				user = new user();  
				user.setId(rs.getInt("id"));  
				user.setHoten(rs.getString("hoten"));  
				user.setNamsinh(rs.getString("namsinh"));  
				user.setGender(rs.getString("gender"));  
				user.setHokhau(rs.getString("hokhau"));    
				sessionMap.put("editUser", user);  
				connection.close();  
			}catch(Exception e){  
				System.out.println(e);  
			}         
				return "/edit.xhtml?faces-redirect=true";  
			}
			
			// Used to update user record  
			public String update(user u){  
			//int result = 0;  
			try{  
				connection = getConnection();    
				PreparedStatement stmt=connection.prepareStatement(  
				"update qlnhanvien set hoten=?,namsinh=?,gender=?,hokhau=? where id=?");    
				stmt.setString(1,u.getHoten());    
				stmt.setString(2,u.getNamsinh());      
				stmt.setString(3,u.getGender());    
				stmt.setString(4,u.getHokhau());    
				stmt.setInt(5,u.getId());    
				stmt.executeUpdate();  
				connection.close();  
			}catch(Exception e){  
				System.out.println();  
			}  
				return "/indexx.xhtml?faces-redirect=true";	}  
			
			// Used to delete user record  
			public void delete(int id){  
			try{  
				connection = getConnection();    
				PreparedStatement stmt = connection.prepareStatement("delete from qlnhanvien where id = "+id);    
				stmt.executeUpdate();    
				}catch(Exception e){  
				System.out.println(e);  
			}  
		}  
			
			// Used to set user gender  
			public String getGenderName(char gender){  
			if(gender == 'M'){  
				return "Male";  
			}else return "Female"; 
			
		} 
			
			
	/*	public List user(int currPage, int perPage){
			int user = (currPage -1) * perPage;
			ArrayList<entity.user> usersList = new ArrayList<user>();
			return null;
		}*/



}
