package quanlyhocsinh.entity.hedaotao;
import java.util.List;

import quanlyhocsinh.entity.monhoc.MonHoc;

public class DaoTaoCapTocPHP implements HeDaoTao{

List<MonHoc> dsMonHoc;
	
	public DaoTaoCapTocPHP() {
		super();
	}

	public List<MonHoc> getDsMonHoc() {
		return dsMonHoc;
	}

	public void setDsMonHoc(List<MonHoc> dsMonHoc) {
		this.dsMonHoc = dsMonHoc;
	}

	@Override
	public String getMaHeDaoTao() {
		// TODO Auto-generated method stub
		return "FFSE-NHPHP";
	}

	@Override
	public String getThongTinHeDaoTao() {
		// TODO Auto-generated method stub
		return "Đào tạo dài hạn ngắn hạn PHP & MySQL 6 tháng";
	}

	@Override
	public List<MonHoc> getDanhSachMonHoc() {
		// TODO Auto-generated method stub
		return dsMonHoc;
	}
}
