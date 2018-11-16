package fasttrackse.monhoc;

public class LapTrinhJavaCoBan {
	String tenMonHoc = "Lập trình Web PHP & MySQL";
	String giangVienPhuTrach = "Thầy 1";
	public LapTrinhJavaCoBan(String tenMonHoc, String giangVienPhuTrach) {
		super();
		this.tenMonHoc = tenMonHoc;
		this.giangVienPhuTrach = giangVienPhuTrach;
	}
	public String getTenMonHoc() {
		return tenMonHoc;
	}
	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}
	public String getGiangVienPhuTrach() {
		return giangVienPhuTrach;
	}
	public void setGiangVienPhuTrach(String giangVienPhuTrach) {
		this.giangVienPhuTrach = giangVienPhuTrach;
	}
}
