package myjavaJSF;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import controler.DAO.*;
@ManagedBean
public class UserBean{
	private int id;
	
	private String username = "Thach Hoang";
	
	@ManagedProperty(value = "#{userDao}")
	private UserDao userDao;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String sayHelloUser(){
	 
		//System.out.println("username");
		return "xinchao";
	}
	
	}