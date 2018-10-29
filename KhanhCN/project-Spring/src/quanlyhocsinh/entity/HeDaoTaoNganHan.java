package quanlyhocsinh.entity;

import java.util.List;

import quanlyhocsinh.monhoc.MonHoc;

public class HeDaoTaoNganHan implements HeDaoTao {

	String maHeDaoTao = "FFSENHJ";
	String thongTinDaoTao = "Đào tạo 6 tháng java.....!!";
	List<MonHoc> danhSachMonHoc;

	public HeDaoTaoNganHan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HeDaoTaoNganHan(String maHeDaoTao, String thongTinDaoTao, List<MonHoc> danhSachMonHoc) {
		super();
		this.maHeDaoTao = maHeDaoTao;
		this.thongTinDaoTao = thongTinDaoTao;
		this.danhSachMonHoc = danhSachMonHoc;
	}

	public String getMaHeDaoTao() {
		return maHeDaoTao;
	}

	public void setMaHeDaoTao(String maHeDaoTao) {
		this.maHeDaoTao = maHeDaoTao;
	}

	public String getThongTinDaoTao() {
		return thongTinDaoTao;
	}

	public void setThongTinDaoTao(String thongTinDaoTao) {
		this.thongTinDaoTao = thongTinDaoTao;
	}

	public List<MonHoc> getDanhSachMonHoc() {
		return danhSachMonHoc;
	}

	public void setDanhSachMonHoc(List<MonHoc> danhSachMonHoc) {
		this.danhSachMonHoc = danhSachMonHoc;
	}

}
