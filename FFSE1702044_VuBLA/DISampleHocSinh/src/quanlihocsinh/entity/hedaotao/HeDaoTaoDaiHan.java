package quanlihocsinh.entity.hedaotao;

import java.util.List;

import quanlihocsinh.entity.monhoc.MonHoc;

public class HeDaoTaoDaiHan implements HeDaoTao {
	String maHeDaoTao = "FFSEDH";
	String thongTinHeDaoTao = "Đào tạo dài hạn 16 tháng, full các môn lập trình";
	List<MonHoc> dsMonHoc;
	public HeDaoTaoDaiHan() {
		super();
	}
	
	public HeDaoTaoDaiHan(String maHeDaoTao, String thongTinHeDaoTao) {
		super();
		this.maHeDaoTao = maHeDaoTao;
		this.thongTinHeDaoTao = thongTinHeDaoTao;
	}


	public List<MonHoc> getDsMonHoc() {
		return dsMonHoc;
	}

	public void setDsMonHoc(List<MonHoc> dsMonHoc) {
		this.dsMonHoc = dsMonHoc;
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
	public List<MonHoc> dsMonHoc() {
		// TODO Auto-generated method stub
		return dsMonHoc;
	}
}
