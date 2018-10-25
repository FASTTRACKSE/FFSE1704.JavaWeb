package quanlyhocsinh.entity;

import quanlyhocsinh.entity.GiangVien.GiangVien;
import quanlyhocsinh.entity.HeDaoTao.HeDaoTao;
import quanlyhocsinh.entity.LoaiHinhDaoTao.LoaiHinhDaoTao;
import quanlyhocsinh.entity.MonHoc.MonHoc;

public class HocSinh {
	String hoTen;
	int namSinh;
	String diaChi;
	String dienThoai;
	String email;

	HeDaoTao heDaoTao;
	LoaiHinhDaoTao loaiHinhDaoTao;
	GiangVien giangVien;
	MonHoc monHoc;

	public String getThongTinSinhVien() {
		return hoTen + "  - " + namSinh + " - " + diaChi + " - " + email;
	}

	public String getThongTinHeDaoTao() {
		return heDaoTao.getMaHeDaoTao() + " - " + heDaoTao.getThongTinHeDaoTao();
	}

	public String getphuongThucDaoTao() {
		return loaiHinhDaoTao.getDiaChiDaoTao() + " - " + loaiHinhDaoTao.getThoiGianDaoTao();
	}

	public String getthongTinGiangVien() {
		return giangVien.getTenGiangVien() + " - " + giangVien.getEmailGiangVien();
	}
	
	public String getmonHoc() {
		return monHoc.getTenMonHoc() + " - " + monHoc.getGiangVienPhuTrach();
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

	public HocSinh(String hoTen, int namSinh, String diaChi, String dienThoai, String email, HeDaoTao heDaoTao,
			LoaiHinhDaoTao loaiHinhDaoTao, GiangVien giangVien, MonHoc monHoc) {
		super();
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.email = email;
		this.heDaoTao = heDaoTao;
		this.loaiHinhDaoTao = loaiHinhDaoTao;
		this.giangVien = giangVien;
		this.monHoc = monHoc;
	}

	public HocSinh() {
		super();
	}
}