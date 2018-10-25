package quanlyhocsinh.entity;

public class LapTrinhJavaWeb {

	String tenMonHoc = "Lập trình Java web";
	String giangVien = " ";

	public LapTrinhJavaWeb(String tenMonHoc, String giangVien) {
		super();
		this.tenMonHoc = tenMonHoc;
		this.giangVien = giangVien;
	}

	public LapTrinhJavaWeb() {
		super();
		// TODO Auto-generated constructor stub
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


}
