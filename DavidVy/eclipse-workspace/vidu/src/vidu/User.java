package vidu;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class User {
	String name;
	String email;
	String password;
	String gander;
	String address;
	
	public String getName() {  
		return name;  
		}  
		public void setName(String name) {  
		this.name = name;  
		}  
		public String getEmail() {  
		return email;  
		}  
		  
		public void setEmail(String email) {  
		this.email = email;  
		}  
		public String getPassword() {  
		return password;  
		}  
		public void setPassword(String password) {  
		this.password = password;  
		}  
		public String getGander() {  
		return gander;  
		}  
		public void setGander(String gander) {  
		this.gander = gander;  
		}  
		public String getAddress() {  
		return address;  
		}  
		public void setAddress(String address) {  
		this.address = address;  
		} 
}
