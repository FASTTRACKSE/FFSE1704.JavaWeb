package entity;

import java.util.List;

import monhoc.MonHoc;

public class LoaiHinhDaoTaoOffLine implements LoaiHinhDaoTao {
	
	
	@Override
	public String getMaLoaiHinhDaoTao() {
		return "FFSE offline";
	}

	@Override
	public String getthongtinLoaiHinhDaoTao() {
		return "chương trình đào tạo off line";
	}

	public LoaiHinhDaoTaoOffLine() {
		super();
		// TODO Auto-generated constructor stub
	}
}
