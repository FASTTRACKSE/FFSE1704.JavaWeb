package hedaotao.entity;

import java.util.List;

import monhoc.entity.MonHoc;

public class HeDaoTaoDaiHan implements HeDaoTao {
	String maHeDaoTao;
	String thongTinHeDaoTao;
	List<MonHoc> DanhSachMonHoc;
	

	public HeDaoTaoDaiHan(String maHeDaoTao, String thongTinHeDaoTao,List<MonHoc> DanhSachMonHoc ) {
		super();
		this.maHeDaoTao = maHeDaoTao;
		this.thongTinHeDaoTao = thongTinHeDaoTao;
		this.DanhSachMonHoc= DanhSachMonHoc;
	}

	public List<MonHoc> getDanhSachMonHoc() {
		return DanhSachMonHoc;
	}

	public void setDanhSachMonHoc(List<MonHoc> danhSachMonHoc) {
		DanhSachMonHoc = danhSachMonHoc;
	}

	public HeDaoTaoDaiHan() {
		super();
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
