package quanlyhocsinh.entity.hedaotao;

import java.util.List;

import quanlyhocsinh.entity.monhoc.MonHoc;

public class DaoTaoDaiHan implements HeDaoTao {
	List<MonHoc> dsMonHoc;

	public DaoTaoDaiHan() {
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
		return "FFSE-DH";
	}

	@Override
	public String getThongTinHeDaoTao() {
		// TODO Auto-generated method stub
		return "Hệ đào tạo dài hạn 16 tháng";
	}

	@Override
	public List<MonHoc> getDanhSachMonHoc() {
		// TODO Auto-generated method stub
		return dsMonHoc;
	}

}