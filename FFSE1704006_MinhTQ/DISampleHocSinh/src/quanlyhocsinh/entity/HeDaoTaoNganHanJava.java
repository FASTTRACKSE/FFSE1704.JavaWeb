package quanlyhocsinh.entity;

import java.util.List;

import monhoc.MonHoc;

public class HeDaoTaoNganHanJava implements HeDaoTao {
	String maHeDaoTao = "FFSEDTNHJV";
	String thongTinHeDaoTao = "Đào tạo java ngắn hạn 6 tháng,full môn java lập trình không che";
	List<MonHoc> danhsachmonhoc;

	public HeDaoTaoNganHanJava() {
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


	public List<MonHoc> getDanhsachmonhoc() {
		return danhsachmonhoc;
	}


	public void setDanhsachmonhoc(List<MonHoc> danhsachmonhoc) {
		this.danhsachmonhoc = danhsachmonhoc;
	}


	public HeDaoTaoNganHanJava(String maHeDaoTao, String thongTinHeDaoTao, List<MonHoc> danhsachmonhoc) {
		super();
		this.maHeDaoTao = maHeDaoTao;
		this.thongTinHeDaoTao = thongTinHeDaoTao;
		this.danhsachmonhoc = danhsachmonhoc;
	}


	
	
}
