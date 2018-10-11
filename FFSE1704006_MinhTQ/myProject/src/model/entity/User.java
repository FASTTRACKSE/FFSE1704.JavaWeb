package model.entity;

public class User {

	private String tenAdmin;
	private String passWord;
	private String tuoiAdmin;
	private String diachi;

	public User(String tenAdmin, String tuoiAdmin, String diachi, String passWord) {
	
		this.tenAdmin = tenAdmin;
		this.tuoiAdmin = tuoiAdmin;
		this.diachi = diachi;
		this.passWord = passWord;
		
		
	}

	public String getTenAdmin() {
		return tenAdmin;
	}

	public void setTenAdmin(String tenAdmin) {
		this.tenAdmin = tenAdmin;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getTuoiAdmin() {
		return tuoiAdmin;
	}

	public void setTuoiAdmin(String tuoiAdmin) {
		this.tuoiAdmin = tuoiAdmin;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

}
