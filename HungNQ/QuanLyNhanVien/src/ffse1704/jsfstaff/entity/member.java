package ffse1704.jsfstaff.entity;

import javax.faces.bean.ManagedBean;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean(name="user")
public class member {
	int id;

	@NotNull(message = "Tên đăng nhập không được để trống")
	@Size(min = 1, message = "Tên không được để trống")
	String userName;
	String passWord;

	public member(int id,String userName, String passWord) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
	}

	public member(String userName, String passWord) {
		this.userName = userName;
		this.passWord = passWord;
	}
	
	public member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

}
