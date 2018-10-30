package quanlyhocsinh.entity;

import loaihinhdaotao.LoaiHinhDaoTao;

public class HocSinh {

	String hoTen;
	int namSinh;
	String diaChi;
	String dienThoai;
	String email;
	LoaiHinhDaoTao loaiHinhDaotao;
	HeDaoTao heDaoTao;

	public HocSinh() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HocSinh(String hoTen, int namSinh, String diaChi, String dienThoai, String email,
			LoaiHinhDaoTao loaiHinhDaotao, HeDaoTao heDaoTao) {
		super();
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.email = email;
		this.loaiHinhDaotao = loaiHinhDaotao;
		this.heDaoTao = heDaoTao;
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

	

	public LoaiHinhDaoTao getLoaiHinhDaotao() {
		return loaiHinhDaotao;
	}

	public void setLoaiHinhDaotao(LoaiHinhDaoTao loaiHinhDaotao) {
		this.loaiHinhDaotao = loaiHinhDaotao;
	}

	public HeDaoTao getHeDaoTao() {
		return heDaoTao;
	}

	public void setHeDaoTao(HeDaoTao heDaoTao) {
		this.heDaoTao = heDaoTao;
	}
	
	public String getThongTinHocSinh() {
		return hoTen + "---" + namSinh + "---" + diaChi + "---" + dienThoai + "---" + email;
	}

	public String getThongTinHeDaoTao() {
		return " MA"+heDaoTao.getMaHeDaoTao() + "---" + heDaoTao.getThongTinHeDaoTao();
	}

	public String getThongTinLoaiHinhDaoTao() {
		return " Mã loại hình đào tạo: "+loaiHinhDaotao.getMaLoaiHinhDaoTao() + " -- ; Tên hệ đào tạo: " +  loaiHinhDaotao.getThongTinLoaiHinhDaoTao();
	}


}
