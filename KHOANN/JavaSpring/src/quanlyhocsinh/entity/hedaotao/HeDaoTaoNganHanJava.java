package quanlyhocsinh.entity.hedaotao;

import java.util.List;

import quanlyhocsinh.entity.monhoc.MonHoc;

public class HeDaoTaoNganHanJava implements HeDaoTao {

	@Override
	public String getMaHeDaoTao() {
		return "FFSENHJ";
	}

	@Override
	public String getThongTinHeDaoTao() {
		return "�?ào tạo dài hạn ngắn hạn Java 6 tháng";
	}

	List<MonHoc> danhSachMonHoc;

	public List<MonHoc> getDsMonHoc() {
		return danhSachMonHoc;
	}

	public void setDsMonHoc(List<MonHoc> danhSachMonHoc) {
		this.danhSachMonHoc = danhSachMonHoc;
	}

	@Override
	public List<MonHoc> getDanhSachMonHoc() {
		// TODO Auto-generated method stub
		return danhSachMonHoc;
	}
}