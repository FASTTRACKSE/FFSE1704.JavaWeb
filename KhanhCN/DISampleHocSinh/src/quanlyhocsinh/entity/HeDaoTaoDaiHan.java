package quanlyhocsinh.entity;

import java.util.List;

import quanlyhocsinh.monhoc.*;

public class HeDaoTaoDaiHan implements HeDaoTao {
	String maHeDaoTao = "FFSE1704";
	String thongTinDaoTao = "Đào tạo dài hạn 16 tháng full các môn lập trình. ";
	List<MonHoc> danhSachMonHoc;

	public HeDaoTaoDaiHan(String maHeDaoTao, String thongTinDaoTao, List<MonHoc> danhSachMonHoc) {
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

	public HeDaoTaoDaiHan() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
