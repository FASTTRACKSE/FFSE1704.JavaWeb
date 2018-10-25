package quanlyhocsinh.entity.hedaotao;

import java.util.List;

import quanlyhocsinh.entity.monhoc.MonHoc;

public class HeDaoTaoLienKetCD implements HeDaoTao {
	List<MonHoc> dsMonHoc;

	public List<MonHoc> getDsMonHoc() {
		return dsMonHoc;
	}

	public void setDsMonHoc(List<MonHoc> dsMonHoc) {
		this.dsMonHoc = dsMonHoc;
	}

	@Override
	public String getMaHeDaoTao() {
		// TODO Auto-generated method stub
		return "FFSE-CDCN";
	}

	@Override
	public String getThongTinHeDaoTao() {
		// TODO Auto-generated method stub
		return "Đào tạo dài hạn + cao đẳng 2 năm trời thương nhớ";
	}

	@Override
	public List<MonHoc> getDanhSachMonHoc() {
		// TODO Auto-generated method stub
		return dsMonHoc;
	}
}
