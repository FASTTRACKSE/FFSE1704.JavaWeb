package quanlihocsinh.entity;

<<<<<<< HEAD
public class HeDaoTaoDaiHan implements HeDaoTao {
	
	String maHeDaoTao= "MA0127";
	String thongTinHeDaoTao="Đào tạo dài hạn 16 tháng, full các môn lập trình";
	MonHoc monHoc;
=======
import java.util.List;

import quanlihocsinh.monhoc.MonHoc;

public class HeDaoTaoDaiHan implements HeDaoTao {
	List<MonHoc> dsMonHoc;
	
>>>>>>> c815716f8d2212d969eef3865790586a577fadc5
	public HeDaoTaoDaiHan() {
		super();
		// TODO Auto-generated constructor stub
	}
<<<<<<< HEAD
	public HeDaoTaoDaiHan(String maHeDaoTao, String thongTinHeDaoTao, MonHoc monHoc) {
		super();
		this.maHeDaoTao = maHeDaoTao;
		this.thongTinHeDaoTao = thongTinHeDaoTao;
		this.monHoc = monHoc;
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
	public MonHoc getMonHoc() {
		return monHoc;
	}
	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}
=======

	@Override
	public String getMaHeDaoTao() {
		// TODO Auto-generated method stub
		return "ê3";
	}

	@Override
	public String getThongTinHeDaoTao() {
		// TODO Auto-generated method stub
		return "Dai hạn";
	}


	public List<MonHoc> getDsMonHoc() {
		return dsMonHoc;
	}

	public void setDsMonHoc(List<MonHoc> dsMonHoc) {
		this.dsMonHoc = dsMonHoc;
	}

	

	
	


>>>>>>> c815716f8d2212d969eef3865790586a577fadc5
	
}
