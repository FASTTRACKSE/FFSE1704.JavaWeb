package ftse1801.demo.spring.model.bean;

public class students {
	private String maSinhVien;
	private String tenSinhVien;
	private String pass;

	public students() {
	}

	public students(String maSinhVien, String tenSinhVien, String pass) {
		this.maSinhVien = maSinhVien;
		this.tenSinhVien = tenSinhVien;
		this.pass = pass;
	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getTenSinhVien() {
		return tenSinhVien;
	}

	public void setTenSinhVien(String tenSinhVien) {
		this.tenSinhVien = tenSinhVien;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
