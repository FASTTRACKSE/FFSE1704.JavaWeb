package quanlyhocsinh.entity;

import hedaotao.HeDaoTao;
import hedaotao.LoaiHinhDaoTao;

public class HocSinh {

	String hoTen;
	int namSinh;
	String diaChi;
	String dienThoai;
	String email;
	LoaiHinhDaoTao loaiHinhDaotao;
	HeDaoTao heDaoTao;

	public String getThongTinHocSinh() {
		return hoTen + "-" + namSinh + "-" + diaChi;
	}

	public String getThongTinHeDaoTao() {
		return "*------"+heDaoTao.getMaHeDaoTao() + " --- " + heDaoTao.getThongTinHeDaoTao() +" -- "+ loaiHinhDaotao.getThongTinLoaiHinhDaoTao();
	}

	public HocSinh(String hoTen, int namSinh, String diaChi, String dienThoai, String email, HeDaoTao heDaoTao,LoaiHinhDaoTao loaiHinhDaotao) {
		super();

		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.email = email;
		this.heDaoTao = heDaoTao;
		this.loaiHinhDaotao = loaiHinhDaotao;
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

}
