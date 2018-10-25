package quanlyhocsinh.entity;

public class HocSinh {
	String hoTen;
	int namSinh;
	String diaChi;
	String dienThoai;
	String email;

	HeDaoTao heDaoTao;
	TheLoaiHinhHoc theLoaiHinhHoc;
    GiangVien giangVien;

	public String getThongTinSinhVien() {
		return hoTen + "  - " + namSinh + " - " + email;
	}

	public String getThongTinHeDaoTao() {
		return heDaoTao.getMaHeDaoTao() + " - " + heDaoTao.getThongTinDaoTao() + " - " + theLoaiHinhHoc.getTheLoai()+ " - " + giangVien.getTenGiangVien();
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
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

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public HocSinh(String hoTen, int namSinh, String diaChi, String dienThoai, String email, HeDaoTao heDaoTao ,TheLoaiHinhHoc theLoaiHinhHoc , GiangVien giangVien) {
		super();
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.email = email;
		this.heDaoTao = heDaoTao;
		this.theLoaiHinhHoc = theLoaiHinhHoc;
		this.giangVien = giangVien ; 
	}

	public HocSinh() {
		super();
	}
}