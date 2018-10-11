package model.entity;

public class SinhVien {
	private String id;
	private String masv;
	private String ho;
	private String ten;
	private String gioiTinh;
	private String namsinh;
	private String lop;

	public SinhVien(String id, String masv, String ho, String ten, 
			String gioiTinh, String namsinh, String lop) {
		super();
		this.id = id;
		this.masv = masv;
		this.ho = ho;
		this.ten = ten;
		this.gioiTinh = gioiTinh;
		this.namsinh = namsinh;
		this.lop = lop;
	}
	
	public SinhVien(String masv, String ho, String ten, 
			String gioiTinh, String namsinh, String lop) {
		super();
		this.masv = masv;
		this.ho = ho;
		this.ten = ten;
		this.gioiTinh = gioiTinh;
		this.namsinh = namsinh;
		this.lop = lop;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMasv() {
		return masv;
	}

	public void setMasv(String masv) {
		this.masv = masv;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getNamsinh() {
		return namsinh;
	}

	public void setNamsinh(String namsinh) {
		this.namsinh = namsinh;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

}
