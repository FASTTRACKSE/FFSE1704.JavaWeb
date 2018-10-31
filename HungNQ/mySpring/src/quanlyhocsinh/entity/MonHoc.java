package quanlyhocsinh.entity;

public class MonHoc {
	String tenMonHoc;

	GiangVien giangVien;

	public String getThongTinGiangVien() {
		return giangVien.getTenGiangVien() + " - " + giangVien.getEmail();
	}
	
	public MonHoc(String tenMonHoc) {
		super();
		this.tenMonHoc = tenMonHoc;
	}

	public MonHoc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTenMonHoc() {
		return tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}

}
