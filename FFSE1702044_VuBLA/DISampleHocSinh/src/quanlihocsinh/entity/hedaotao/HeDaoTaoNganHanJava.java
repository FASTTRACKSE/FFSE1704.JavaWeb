package quanlihocsinh.entity.hedaotao;

import java.util.List;

import quanlihocsinh.entity.monhoc.MonHoc;

public class HeDaoTaoNganHanJava implements HeDaoTao {
	String maHeDaoTao = "FFSENHJV";
	String thongTinHeDaoTao = "Đào tạo ngắn hạn 6 tháng, Lập trình Java";
	List<MonHoc> dsMonHoc;
	public HeDaoTaoNganHanJava() {
		super();
	}
	
	public HeDaoTaoNganHanJava(String maHeDaoTao, String thongTinHeDaoTao) {
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
