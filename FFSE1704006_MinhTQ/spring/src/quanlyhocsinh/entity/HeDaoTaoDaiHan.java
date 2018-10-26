package quanlyhocsinh.entity;

import java.util.List;

import monhoc.MonHoc;

public class HeDaoTaoDaiHan implements HeDaoTao {
	String maHeDaoTao = "FFSEDTDH";
	String thongTinHeDaoTao = "full các môn lập trình ";
	List<MonHoc> danhsachmonhoc;

	public HeDaoTaoDaiHan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HeDaoTaoDaiHan(String maHeDaoTao, String thongTinHeDaoTao, List<MonHoc> danhsachmonhoc) {
		super();
		this.maHeDaoTao = maHeDaoTao;
		this.thongTinHeDaoTao = thongTinHeDaoTao;
		this.danhsachmonhoc = danhsachmonhoc;
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

	public List<MonHoc> getDanhsachmonhoc() {
		return danhsachmonhoc;
	}

	public void setDanhsachmonhoc(List<MonHoc> danhsachmonhoc) {
		this.danhsachmonhoc = danhsachmonhoc;
	}

	

	
}
