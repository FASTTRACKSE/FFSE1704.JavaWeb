package quanlihocsinh.entity;

import java.util.List;

import quanlihocsinh.monhoc.MonHoc;

public class HeDaoTaoLienKetCD implements HeDaoTao{
	String maHeDaoTao="MAD1103";
	String thongTinHeDaoTao="Đào tạo liên kết cd";
	public HeDaoTaoLienKetCD(String maHeDaoTao, String thongTinHeDaoTao) {
		super();
		this.maHeDaoTao = maHeDaoTao;
		this.thongTinHeDaoTao = thongTinHeDaoTao;
	}
	public HeDaoTaoLienKetCD() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaHeDaoTao() {
		return maHeDaoTao;
	}
	public void setMaHeDaoTao(String maHeDaoTao) {
		this.maHeDaoTao = maHeDaoTao;
	}
	public String getThongTinHeDaoTao() {
		return thongTinHeDaoTao;
	}
	public void setThongTinHeDaoTao(String thongTinHeDaoTao) {
		this.thongTinHeDaoTao = thongTinHeDaoTao;
	}
	@Override
	public List<MonHoc> getDsMonHoc() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
