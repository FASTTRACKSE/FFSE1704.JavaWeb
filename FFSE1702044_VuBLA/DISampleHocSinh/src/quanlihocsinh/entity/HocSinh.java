package quanlihocsinh.entity;

import quanlihocsinh.entity.BuoiHoc.BuoiHoc;
import quanlihocsinh.entity.hedaotao.HeDaoTao;

public class HocSinh {
	private String hoTen;
	private int namSinh;
	private String diaChi;
	private String dienThoai;
	private String email;
	HeDaoTao heDaoTao;
	BuoiHoc buoiHoc;
	public String getThongTinSinhVien() {
		return hoTen+"-"+diaChi+ "-" + "  - " + namSinh + " - " + email + "-"+dienThoai;
	}

	public String getThongTinHeDaoTao() {
		return heDaoTao.getMaHeDaoTao() + " - " + heDaoTao.getThongTinHeDaoTao();
	}
	public String getThongTinBuoiHoc() {
		return buoiHoc.getLoaiDaoTao() + " - " + buoiHoc.getThoiGianHoc();
	}
	
	public HeDaoTao getHeDaoTao() {
		return heDaoTao;
	}

	public void setHeDaoTao(HeDaoTao heDaoTao) {
		this.heDaoTao = heDaoTao;
	}

	public BuoiHoc getBuoiHoc() {
		return buoiHoc;
	}

	public void setBuoiHoc(BuoiHoc buoiHoc) {
		this.buoiHoc = buoiHoc;
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

	public HocSinh() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HocSinh(String hoTen, int namSinh, String diaChi, String dienThoai, String email, HeDaoTao heDaoTao , BuoiHoc buoiHoc) {
		super();
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.email = email;
		this.heDaoTao = heDaoTao;
		this.buoiHoc = buoiHoc;
	}
	
}
