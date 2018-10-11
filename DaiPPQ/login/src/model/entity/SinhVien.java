package model.entity;

public class SinhVien {
	private String id;
	private String masv;
	private String ho;
	private String ten;
	private String gioitinh;
	private String namsinh;
	private String lop;
	
	public SinhVien(String masv ,String ho, String ten, String gioitinh, String namsinh, String lop) {
		super();
		this.masv = masv;
		this.ho = ho;
		this.ten = ten;
		this.gioitinh = gioitinh;
		this.namsinh = namsinh;
		this.lop = lop;
	}
	public SinhVien(String id, String masv ,String ho, String ten, String gioitinh, String namsinh, String lop) {
		super();
		this.id = id;
		this.masv = masv;
		this.ho = ho;
		this.ten = ten;
		this.gioitinh = gioitinh;
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
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
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
