package quanlyhocsinh.entity.HeDaoTao;

import java.util.List;

import quanlyhocsinh.entity.MonHoc.MonHoc;

public class HeDaoTaoLienKetCD implements HeDaoTao {
	
	@Override
	public String getMaHeDaoTao() {
		return "FFSECDCN";
	}

	@Override
	public String getThongTinHeDaoTao() {
		return "Đào tạo dài hạn + cao đẳng 2 năm trời thương nhớ";
	}

	@Override
	public List<MonHoc> getDanhSachMonHoc() {
		// TODO Auto-generated method stub
		return null;
	}
}