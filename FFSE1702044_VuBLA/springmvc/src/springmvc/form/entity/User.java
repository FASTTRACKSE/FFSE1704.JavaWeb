package springmvc.form.entity;

public class User {
	int id;
	String diaChi, lopHoc, avatar;

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	int namSinh;

	String maSV, tenSV;

	public User() {
		super();
	}

	public User(int id, String diaChi, String lopHoc, String avatar, int namSinh, String maSV, String tenSV) {
		super();
		this.id = id;
		this.diaChi = diaChi;
		this.lopHoc = lopHoc;
		this.avatar = avatar;
		this.namSinh = namSinh;
		this.maSV = maSV;
		this.tenSV = tenSV;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getTenSV() {
		return tenSV;
	}

	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getLopHoc() {
		return lopHoc;
	}

	public void setLopHoc(String lopHoc) {
		this.lopHoc = lopHoc;
	}

}
