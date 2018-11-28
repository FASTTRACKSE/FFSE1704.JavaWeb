package user;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.NotNull;  
import javax.validation.constraints.Size;  

@ManagedBean
@RequestScoped
public class User {
	
	@NotNull(message = "Name can't be empty")  
	String name;  
	@NotNull(message = "Mobile can't be empty")  
	@Size(min = 10, max = 10, message = "Mobile must have 10 digits")  
	String mobile;  
	public String getName() {  
	return name;  
	}  
	public void setName(String name) {  
	this.name = name;  
	}  
	public String getMobile() {  
	return mobile;  
	}  
	public void setMobile(String mobile) {  
	this.mobile = mobile;  
	}  


}
