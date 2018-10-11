package facttrack.demo;


import javax.faces.bean.ManagedBean;
@ManagedBean

public class Demo1 {
	private String User = "Khoa";

	public String getUser() {
		return User;
	}

	public void setUser(String user) {
		this.User = user;
	}
	
	public String hellouser() {
		//System.out.println("User");
		return "xinchao";
	}
}
