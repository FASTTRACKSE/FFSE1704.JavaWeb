package quanlyhocsinh.entity;

import java.util.List;

import monhoc.MonHoc;

public class HeDaoTaoNganHanPHP implements HeDaoTao {
	String maHeDaoTao = "FFSEDTDTNHPHP";
	String thongTinHeDaoTao = "Đào tạo Php ngắn hạn 6 tháng ,full môn lập trình php không che ";
	List<MonHoc> danhsachmonhoc;

	public HeDaoTaoNganHanPHP() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HeDaoTaoNganHanPHP(String maHeDaoTao, String thongTinHeDaoTao, List<MonHoc> danhsachmonhoc) {
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
