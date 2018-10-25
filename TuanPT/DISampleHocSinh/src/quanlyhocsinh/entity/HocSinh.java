package quanlyhocsinh.entity;

public class HocSinh {

	String hoTen;
	int namSinh;
	String diaChi;
	String dienThoai;
	String email;
	
	HeDaoTao heDaoTao;
	LoaiHinhDaoTao loaiHinhDaoTao;
	MonHoc monHoc;

	public String getThongTinSinhVien() {
		return hoTen + "-" + namSinh + "-" + email;
	}
	
	public String getThongTin() {
		return loaiHinhDaoTao.getThoiGian() + "-" + loaiHinhDaoTao.getDiaChi();
	}
	
	public String getThongTinHeDaoTao() {
		
		return heDaoTao.getMaHeDaoTao() + "-" + heDaoTao.getThongTinHeDaoTao();
	}
	

	public String getThongTinMonHoc() {
		
		return monHoc.getTenMonHoc();
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
	
	public LoaiHinhDaoTao getLoaiHinhDaoTao() {
		return loaiHinhDaoTao;
	}

	public void setLoaiHinhDaoTao(LoaiHinhDaoTao loaiHinhDaoTao) {
		this.loaiHinhDaoTao = loaiHinhDaoTao;
	}

	public MonHoc getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}
	
	public HocSinh() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HocSinh(String hoTen, int namSinh, String diaChi, String dienThoai, String email, HeDaoTao heDaoTao,LoaiHinhDaoTao loaiHinhDaoTao,
	MonHoc monHoc) {
		super();
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.email = email;
		this.heDaoTao = heDaoTao;
		this.loaiHinhDaoTao = loaiHinhDaoTao;
		this.monHoc = monHoc;
	}
	
		
}
