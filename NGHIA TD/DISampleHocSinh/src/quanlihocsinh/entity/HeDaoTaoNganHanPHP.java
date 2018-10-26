package quanlihocsinh.entity;

<<<<<<< HEAD
public class HeDaoTaoNganHanPHP implements HeDaoTao{
	String maHeDaoTao = "FFSENHJ";
	String thongTinHeDaoTao = "Đào tạo dài hạn ngắn hạn PHP & MySQL 6 tháng";
	public HeDaoTaoNganHanPHP(String maHeDaoTao, String thongTinHeDaoTao) {
		super();
		this.maHeDaoTao = maHeDaoTao;
		this.thongTinHeDaoTao = thongTinHeDaoTao;
	}
	public HeDaoTaoNganHanPHP() {
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
=======
import java.util.List;

import quanlihocsinh.monhoc.MonHoc;

public class HeDaoTaoNganHanPHP implements HeDaoTao{
	List<MonHoc> dsMonHoc;
	@Override
	public String getMaHeDaoTao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getThongTinHeDaoTao() {
		// TODO Auto-generated method stub
		return null;
	}


	public List<MonHoc> getDsMonHoc() {
		return dsMonHoc;
	}

	public void setDsMonHoc(List<MonHoc> dsMonHoc) {
		this.dsMonHoc = dsMonHoc;
	}
	

>>>>>>> c815716f8d2212d969eef3865790586a577fadc5
}
