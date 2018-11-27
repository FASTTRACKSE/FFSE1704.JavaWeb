package fasttrackse.monhoc;

public class LapTrinhJavaWeb {
	String tenMonHoc = "Lập trình Java Web";
	String giangVienPhuTrach = "Thầy 2";
	public LapTrinhJavaWeb(String tenMonHoc, String giangVienPhuTrach) {
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
