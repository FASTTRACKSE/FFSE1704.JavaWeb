package MonHoc;

public class LapTrinhJavaCoBan {

	String tenMonHoc = "Lập trình Java cơ bản";
	String giangVien = " ";

	public LapTrinhJavaCoBan(String tenMonHoc, String giangVien) {
		super();
		this.tenMonHoc = tenMonHoc;
		this.giangVien = giangVien;
	}

	public LapTrinhJavaCoBan() {
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
