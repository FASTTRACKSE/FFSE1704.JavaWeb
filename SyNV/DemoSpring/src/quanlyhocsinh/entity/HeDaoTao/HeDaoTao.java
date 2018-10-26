package quanlyhocsinh.entity.HeDaoTao;

import java.util.List;

import quanlyhocsinh.entity.MonHoc.MonHoc;

public interface HeDaoTao {
	public String getMaHeDaoTao();

	public String getThongTinHeDaoTao();
	
	public List<MonHoc> getDanhSachMonHoc();
}