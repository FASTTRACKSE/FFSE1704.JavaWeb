package fasttrackse.monhoc;

public class QuyTrinhDuAn {
	String tenMonHoc = "Quy Trình Dự Án";
	String giangVienPhuTrach = "Thầy 1";
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
	public QuyTrinhDuAn(String tenMonHoc, String giangVienPhuTrach) {
		super();
		this.tenMonHoc = tenMonHoc;
		this.giangVienPhuTrach = giangVienPhuTrach;
	}
	
}
