package entity;

public class HocSinh {
	String hoTen;
	int namSinh;
	String diaChi;
	String dienThoai;
	String email;

	HeDaoTao heDaoTao;
	LoTrinhHoc loTrinhHoc;
	public String getThongTinSinhVien() {
		return hoTen + "  - " + namSinh + " - " + email;
	}

	public String getThongTinHeDaoTao() {
		return heDaoTao.getMaHeDaoTao() + " - " + heDaoTao.getThongTinHeDaoTao();
	}
	
	public String getThongTinLoTrinhHoc() {
	   return loTrinhHoc.getLoTrinhHoc()+ " - "	+ loTrinhHoc.thongTinLoTrinhHoc();
	}
	public String getTenMonHoc() {
	   return "Môn học :" + heDaoTao.getTenMonHoc();
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

	public HocSinh(String hoTen, int namSinh, String diaChi, String dienThoai, String email, HeDaoTao heDaoTao,
			LoTrinhHoc loTrinhHoc) {
		super();
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.email = email;
		this.heDaoTao = heDaoTao;
		this.loTrinhHoc = loTrinhHoc;
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

	public HocSinh(String hoTen, int namSinh, String diaChi, String dienThoai, String email, HeDaoTao heDaoTao) {
		super();
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.email = email;
		this.heDaoTao = heDaoTao;
	}

	public HocSinh() {
		super();
	}
}
