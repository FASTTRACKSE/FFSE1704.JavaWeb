package quanlihocsinh.entity;

public class HocSinh {
	
	String hoTen;
	int namSinh;
	String diaChi;
	String dienThoai;
	String email;
	HeDaoTao heDaoTao;
	LoaiDaoTao loaiDaoTao;
	
	public String getThongTinSinhVien() {
		return hoTen+ " - "+ namSinh  + diaChi + "-"+email;
	}
	public String getThongTinHeDaoTao() {
		return heDaoTao.getMaHeDaoTao() + " - " + heDaoTao.getThongTinHeDaoTao();
	}
	
	public String getThongTinLoaiDaoTao() {
		return loaiDaoTao.getMaLoaiDaoTao() + " -" + loaiDaoTao.getThongTinLoaiDaoTao();
	}
	public HocSinh(String hoTen, int namSinh, String diaChi, String dienThoai, String email, HeDaoTao heDaoTao, LoaiDaoTao loaiDaoTao) {
		super();
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.email = email;
		this.heDaoTao = heDaoTao;
		this.loaiDaoTao = loaiDaoTao;
	}
	public HocSinh() {
		super();
		// TODO Auto-generated constructor stub
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
	public LoaiDaoTao getLoaiDaoTao() {
		return loaiDaoTao;
	}
	public void setLoaiDaoTao(LoaiDaoTao loaiDaoTao) {
		this.loaiDaoTao = loaiDaoTao;
	}
}
