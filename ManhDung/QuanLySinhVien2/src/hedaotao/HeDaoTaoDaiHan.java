package hedaotao;

import java.util.List;

import monhoc.MonHoc;

public class HeDaoTaoDaiHan implements HeDaoTao {
	String maHeDaoTao = "FFSEDH";
	String thongTinHeDaoTao = "Đào tạo dài hạn 16 tháng full các môn học";
	List<MonHoc> danhsachmonhoc;
	public HeDaoTaoDaiHan() {
		super();
	}
	
	public HeDaoTaoDaiHan(String maHeDaoTao, String thongTinHeDaoTao) {
		super();
		this.maHeDaoTao = maHeDaoTao;
		this.thongTinHeDaoTao = thongTinHeDaoTao;
	}

	
	
	public List<MonHoc> getDanhsachmonhoc() {
		return danhsachmonhoc;
	}

	public void setDanhsachmonhoc(List<MonHoc> danhsachmonhoc) {
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
	
}
