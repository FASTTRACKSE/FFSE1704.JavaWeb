package quanlyhocsinh.entity;

public class HocSinh {
	String hoTen;
	int namSinh;
	String diaChi;
	String dienThoai;
	String email;

	HeDaoTao heDaoTao;
	TheLoaiHinhHoc theLoaiHinhHoc;

	public String getThongTinSinhVien() {
		return hoTen + "  - " + namSinh + " - " + email;
	}

	public String getThongTinHeDaoTao() {
		return heDaoTao.getMaHeDaoTao() + " - " + heDaoTao.getThongTinDaoTao() + "\n" + "   -" + " Thể loại học : "
				+ theLoaiHinhHoc.getTheLoai() + "\n " + "  -" + " Thời gian : " + theLoaiHinhHoc.getThoiGian() + "\n "
				+ "  -" + " Địa chỉ : " + theLoaiHinhHoc.getDiaChi();
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

	public HeDaoTao getHeDaoTao() {
		return heDaoTao;
	}

	public void setHeDaoTao(HeDaoTao heDaoTao) {
		this.heDaoTao = heDaoTao;
	}

	public TheLoaiHinhHoc getTheLoaiHinhHoc() {
		return theLoaiHinhHoc;
	}

	public void setTheLoaiHinhHoc(TheLoaiHinhHoc theLoaiHinhHoc) {
		this.theLoaiHinhHoc = theLoaiHinhHoc;
	}

	public HocSinh(String hoTen, int namSinh, String diaChi, String dienThoai, String email, HeDaoTao heDaoTao,
			TheLoaiHinhHoc theLoaiHinhHoc) {
		super();
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.email = email;
		this.heDaoTao = heDaoTao;
		this.theLoaiHinhHoc = theLoaiHinhHoc;

	}

	public HocSinh() {
		super();
	}
}