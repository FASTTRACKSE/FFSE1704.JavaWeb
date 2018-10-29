package hedaotao;

import java.util.List;

import monhoc.MonHoc;

public class HeDaoTaoNganHanPHP implements HeDaoTao {
	String maHeDaoTao = "FFSENHP";
	String thongTinHeDaoTao = "Đào tạo dài hạn ngắn hạn PHP & MySQL 6 tháng";
	List<MonHoc> danhsachmonhoc;
	public HeDaoTaoNganHanPHP() {
		super();
	}
	
	public HeDaoTaoNganHanPHP(String maHeDaoTao, String thongTinHeDaoTao) {
		super();
		this.maHeDaoTao = maHeDaoTao;
		this.thongTinHeDaoTao = thongTinHeDaoTao;
	}

	public void getTenMonHoc() {
		
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
