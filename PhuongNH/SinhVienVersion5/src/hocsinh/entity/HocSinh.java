package hocsinh.entity;

import hedaotao.entity.HeDaoTao;
import loaihinhdaotao.entity.LoaiHinhDaoTao;

public class HocSinh {
	String hoTen;
	int namSinh ;
	String diaChi;
	String sDT;
	String email;
	
	HeDaoTao heDaoTao;
	LoaiHinhDaoTao LoaiHinhDaoTao;
	public HocSinh() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HocSinh(String hoTen, int namSinh, String diaChi, String sDT, String email,HeDaoTao heDaoTao, LoaiHinhDaoTao LoaiHinhDaoTao) {
		super();
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.diaChi = diaChi;
		this.sDT = sDT;
		this.email = email;
		this.heDaoTao = heDaoTao;
		this.LoaiHinhDaoTao= LoaiHinhDaoTao;
	}
	public String getThongTinHocSinh() {
		return hoTen+"   "+sDT+"   "+email;
	}
	public String getThongTinHeDaoTao() {
		return  " - " + heDaoTao.getThongTinHeDaoTao();
	}
	public String getLoaiHinhDaoTao() {
		return "-" + LoaiHinhDaoTao.getLoaiHinh()+"-" +LoaiHinhDaoTao.getDiaDiem()+"-" +LoaiHinhDaoTao.getThoiGian();
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
	public String getsDt() {
		return sDT;
	}
	public void setsDt(String sDt) {
		this.sDT = sDt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
