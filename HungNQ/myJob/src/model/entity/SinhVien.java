package model.entity;

public class SinhVien {
	private String id;
	private String lop;
	private String maSV;
	private String ten;
	private String tuoi;
	private String gioitinh;

	public SinhVien(String id, String lop, String maSV, String ten, String tuoi, String gioitinh) {
		super();
		this.id = id;
		this.lop = lop;
		this.maSV = maSV;
		this.ten = ten;
		this.tuoi = tuoi;
		this.gioitinh = gioitinh;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getTuoi() {
		return tuoi;
	}

	public void setTuoi(String tuoi) {
		this.tuoi = tuoi;
	}

	public String getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

}
