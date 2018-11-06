package MonHoc;

public class QuiTrinhDuAn {

	String tenMonHoc = "Qui trình dự án";
	String giangVien = " ";

	public QuiTrinhDuAn(String tenMonHoc, String giangVien) {
		super();
		this.tenMonHoc = tenMonHoc;
		this.giangVien = giangVien;
	}

	public QuiTrinhDuAn() {
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
