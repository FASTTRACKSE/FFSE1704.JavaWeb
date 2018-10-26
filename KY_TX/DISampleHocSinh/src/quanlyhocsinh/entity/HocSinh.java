package quanlyhocsinh.entity;

public class HocSinh {
	String name;
	int birth;
	String address;
	String numberphone;
	String email;
	
	HeDaoTao heDaoTao;
	LoaiHinhHoc loaiHinhHoc;
	GiangVien giangVien;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getThongTinSinhVien() {
		return name + "---" + birth + "---" + email;	
	}
	public String getThongTinHeDaoTao() {
		return heDaoTao.getMaHeDaoTao() + "---" + heDaoTao.getThongTinHeDaoTao();
	}
	public String getThongTinLoaiHinhHoc() {
		return loaiHinhHoc.getThongTinLoaiHinhHoc();
	}
	public String getThongTinGiangVien() {
		return giangVien.getTenGiangVien() + " " + giangVien.getThongTinGiangVien();
	}
	public HocSinh(String name, int birth, String address, String numberphone, String email, HeDaoTao heDaoTao,
			LoaiHinhHoc loaiHinhHoc, GiangVien giangVien) {
		super();
		this.name = name;
		this.birth = birth;
		this.address = address;
		this.numberphone = numberphone;
		this.email = email;
		this.heDaoTao = heDaoTao;
		this.loaiHinhHoc = loaiHinhHoc;
		this.giangVien = giangVien;
	}
	public HocSinh(String name, int birth, String address, String numberphone, String email, HeDaoTao heDaoTao,
			LoaiHinhHoc loaiHinhHoc) {
		super();
		this.name = name;
		this.birth = birth;
		this.address = address;
		this.numberphone = numberphone;
		this.email = email;
		this.heDaoTao = heDaoTao;
		this.loaiHinhHoc = loaiHinhHoc;
	}
	public HocSinh(String name, int birth, String address, String numberphone, String email, HeDaoTao heDaoTao) {
		super();
		this.name = name;
		this.birth = birth;
		this.address = address;
		this.numberphone = numberphone;
		this.email = email;
		this.heDaoTao = heDaoTao;
	}
	public HocSinh() {
		super();
	}
	public int getBirth() {
		return birth;
	}
	public void setBirth(int birth) {
		this.birth = birth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNumberphone() {
		return numberphone;
	}
	public void setNumberphone(String numberphone) {
		this.numberphone = numberphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
