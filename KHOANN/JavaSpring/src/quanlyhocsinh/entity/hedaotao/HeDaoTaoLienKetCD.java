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
		return "�?ào tạo dài hạn + cao đẳng 2 năm tr�?i thương nhớ";
	}

	@Override
	public List<MonHoc> getDanhSachMonHoc() {
		// TODO Auto-generated method stub
		return null;
	}
}