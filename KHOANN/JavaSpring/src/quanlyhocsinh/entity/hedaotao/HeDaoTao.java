package quanlyhocsinh.entity.hedaotao;

import java.util.List;

import quanlyhocsinh.entity.monhoc.MonHoc;

public interface HeDaoTao {
	public String getMaHeDaoTao();

	public String getThongTinHeDaoTao();
	
	public List<MonHoc> getDanhSachMonHoc();
}