package fasttrackse.demo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import fasttrackse.DAO.*;

@ManagedBean
public class demo1 {
	
	private int id ; 
	private String username = "Cao Ngoc Khanh";
	@ManagedProperty(value = "#{userDAO}")
	private UserDAO usDao;
	
	
	
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserDAO getUsDao() {
		return usDao;
	}

	public void setUsDao(UserDAO usDao) {
		this.usDao = usDao;
	}

	public String getUsername() {
		return username ;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public String helloUsername() {
		
		username = usDao.hocsinh(id);
		//System.out.println("username");
		return "xinchao";
	}
}
