package quanlyhocsinh.entity;

import hedaotao.LoaiHinhDaoTao;

public class LoaiHinhDaoTaoOffLine implements LoaiHinhDaoTao {

	@Override
	public String getMaLoaiHinhDaoTao() {
		// TODO Auto-generated method stub
		return "DTOFL";
	}

	@Override
	public String getThongTinLoaiHinhDaoTao() {
		// TODO Auto-generated method stub
		return "Chương trình đào tạo offline";
	}

	public LoaiHinhDaoTaoOffLine() {
		super();
		// TODO Auto-generated constructor stub
	}

}
