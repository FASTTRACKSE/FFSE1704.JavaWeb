package quanlihocsinh.entity.hedaotao;

import java.util.List;

import quanlihocsinh.entity.monhoc.MonHoc;

public interface HeDaoTao {
	public String getMaHeDaoTao();

	public String getThongTinHeDaoTao();
	
	public List<MonHoc> dsMonHoc();
}
