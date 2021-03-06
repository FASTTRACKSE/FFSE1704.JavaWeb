package quanlyhocsinh.entity;

public class HocSinh {
	String hoTen;
	int namSinh;
	String diaChi;
	String dienThoai;
	String email;

	HeDaoTao heDaoTao;
	LoaiHinhDaoTao loaiHinhDaoTao;

	public String getThongTinSinhVien() {
		return hoTen + " - " + namSinh + " - " + email;

	}

	public String getThongTinHeDaoTao() {
		return "Mã Hệ Đào Tạo: " + heDaoTao.getMaHeDaoTao() + ". Thông Tin: " + heDaoTao.getThongTinHeDaoTao();
	}

	public String getThongTinLoaiHinh() {
		return loaiHinhDaoTao.getMaLoaiHinh() + ". " + loaiHinhDaoTao.getThongTinLoaiHinh();
	}

//	public String getGiangVien() {
//		return "Giảng Viên: " + giangVien.getTenGiangVien() + ". Email: " + giangVien.getEmailGiangVien();
//	}

	public String gethoTen() {
		return hoTen;
	}

	public void sethoTen(String hoTen) {
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

	public LoaiHinhDaoTao getLoaiHinhDaoTao() {
		return loaiHinhDaoTao;
	}

	public void setLoaiHinhDaoTao(LoaiHinhDaoTao loaiHinhDaoTao) {
		this.loaiHinhDaoTao = loaiHinhDaoTao;
	}

	public HeDaoTao getHeDaoTao() {
		return heDaoTao;
	}

	public void setHeDaoTao(HeDaoTao heDaoTao) {
		this.heDaoTao = heDaoTao;
	}

	public HocSinh(String hoTen, int namSinh, String diaChi, String dienThoai, String email, HeDaoTao heDaoTao,
			LoaiHinhDaoTao loaiHinhDaoTao) {
		super();
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.email = email;
		this.heDaoTao = heDaoTao;
		this.loaiHinhDaoTao = loaiHinhDaoTao;

	}

	public HocSinh() {
		super();
	}
}
