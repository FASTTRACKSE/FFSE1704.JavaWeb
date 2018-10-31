package giangvien;

public class GiangVienLam implements GiangVien {
String tenGiangVien = "Nguyễn Lâm ";
String emailGiangVien = "Lam@fasttrack.edu.vn";
public String getTenGiangVien() {
	return tenGiangVien;
}
public void setTenGiangVien(String tenGiangVien) {
	this.tenGiangVien = tenGiangVien;
}
public String getEmailGiangVien() {
	return emailGiangVien;
}
public void setEmailGiangVien(String emailGiangVien) {
	this.emailGiangVien = emailGiangVien;
}
public GiangVienLam() {
	super();
}
public GiangVienLam(String tenGiangVien, String emailGiangVien) {
	super();
	this.tenGiangVien = tenGiangVien;
	this.emailGiangVien = emailGiangVien;
}
}
