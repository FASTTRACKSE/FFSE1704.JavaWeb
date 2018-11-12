package quanlyhocsinh.entity;

import quanlyhocsinh.entity.hedaotao.HeDaoTao;
import quanlyhocsinh.entity.loaihinhdaotao.LoaiHinhDaoTao;

public class SinhVien {
	String hoTen;
	int namSinh;
	String diaChi;
	String dienThoai;
	String email;

	LoaiHinhDaoTao loaiHinhDaoTao;
	HeDaoTao heDaoTao;	

	public String getThongTinSinhVien() {
		return hoTen + " - " + namSinh + " - " + diaChi + " - " + dienThoai + " - " + email;
	}
	
	public String getThongTinLoaiHinhDaoTao() {
		return loaiHinhDaoTao.getMaLoaiHinhDaoTao() + " - " + loaiHinhDaoTao.getThongTinLoaiHinhDaoTao();
	}

	public String getThongTinHeDaoTao() {
		return heDaoTao.getMaHeDaoTao() + " - " + heDaoTao.getThongTinHeDaoTao();
	}

	public SinhVien() {
		super();
	}

	public SinhVien(String hoTen, int namSinh, String diaChi, String dienThoai, String email, LoaiHinhDaoTao loaiHinhDaoTao, HeDaoTao heDaoTao) {
		super();
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.email = email;
		this.loaiHinhDaoTao = loaiHinhDaoTao;
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
}