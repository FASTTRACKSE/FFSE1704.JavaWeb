package entity;

import ffse1704.spring.entity.loaihinhdaotao.LoaiHinhDaoTao;

public class LoaiHinhDaoTaoOnline implements LoaiHinhDaoTao {
private String maLoaiHinhDaoTao = "FFSE Online";
	private String thongTinLoaiHinhDaoTao = "Chương trình đào tạo online";

	public LoaiHinhDaoTaoOnline() {
		super();
	}

	public LoaiHinhDaoTaoOnline(String maLoaiHinhDaoTao, String thongTinLoaiHinhDaoTao) {
		super();
		this.maLoaiHinhDaoTao = maLoaiHinhDaoTao;
		this.thongTinLoaiHinhDaoTao = thongTinLoaiHinhDaoTao;
	}

	public String getMaLoaiHinhDaoTao() {
		return maLoaiHinhDaoTao;
	}

	public void setMaLoaiHinhDaoTao(String maLoaiHinhDaoTao) {
		this.maLoaiHinhDaoTao = maLoaiHinhDaoTao;
	}

	public String getThongTinLoaiHinhDaoTao() {
		return thongTinLoaiHinhDaoTao;
	}

	public void setThongTinLoaiHinhDaoTao(String thongTinLoaiHinhDaoTao) {
		this.thongTinLoaiHinhDaoTao = thongTinLoaiHinhDaoTao;
	}
}
