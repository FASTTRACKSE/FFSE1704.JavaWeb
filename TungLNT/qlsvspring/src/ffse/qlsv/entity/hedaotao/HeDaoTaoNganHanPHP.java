package ffse.qlsv.entity.hedaotao;

import java.util.List;

import ffse.qlsv.entity.monhoc.MonHoc;

public class HeDaoTaoNganHanPHP implements HeDaoTao {
	String maHeDaoTao = "FFSENHP";
	String thongTinHeDaoTao = "Đào tạo dài hạn ngắn hạn PHP & MySQL 6 tháng";
	
	List<MonHoc> dsMonHoc;

	public List<MonHoc> getDsMonHoc() {
		return dsMonHoc;
	}

	public HeDaoTaoNganHanPHP() {
		super();
	}
	
	public HeDaoTaoNganHanPHP(String maHeDaoTao, String thongTinHeDaoTao) {
		super();
		this.maHeDaoTao = maHeDaoTao;
		this.thongTinHeDaoTao = thongTinHeDaoTao;
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
	public List<MonHoc> getDanhSachMonHoc() {
		// TODO Auto-generated method stub
		return dsMonHoc;
	}

	public void setDsMonHoc(List<MonHoc> dsMonHoc) {
		this.dsMonHoc = dsMonHoc;
	}
}