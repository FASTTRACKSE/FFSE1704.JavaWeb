package monhoc.entity;

public class LapTrinhJavaWeb implements MonHoc {
	String tenMonHoc ;
	String giangVien ;
	String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LapTrinhJavaWeb(String tenMonHoc, String giangVien, String email) {
		super();
		this.tenMonHoc = tenMonHoc;
		this.giangVien = giangVien;
		this.email = email;
	}
	public String getTenMonHoc() {
		return tenMonHoc;
	}
	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}
	public String getGiangVien() {
		return giangVien;
	}
	public void setGiangVien(String giangVien) {
		this.giangVien = giangVien;
	}
	public LapTrinhJavaWeb() {
		super();
		// TODO Auto-generated constructor stub
	}
}
