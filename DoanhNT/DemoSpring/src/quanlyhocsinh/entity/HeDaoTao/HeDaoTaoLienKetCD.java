package quanlyhocsinh.entity.hedaotao;

import java.util.List;

import quanlyhocsinh.entity.monhoc.MonHoc;

public class HeDaoTaoLienKetCD implements HeDaoTao {
	
	@Override
	public String getMaHeDaoTao() {
		return "FFSECDCN";
	}

	@Override
	public String getThongTinHeDaoTao() {
		return "Đào tạo nhận bằng Cao đẳng sau 2 năm";
	}

	@Override
	public List<MonHoc> getDanhSachMonHoc() {
		// TODO Auto-generated method stub
		return null;
	}
}