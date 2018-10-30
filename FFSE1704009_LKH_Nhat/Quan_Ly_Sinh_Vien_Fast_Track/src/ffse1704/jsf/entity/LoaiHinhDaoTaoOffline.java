package ffse1704.jsf.entity;

import ffse1704.jsf.entity.loaihinhdaotao.LoaiHinhDaoTao;

public class LoaiHinhDaoTaoOffline implements LoaiHinhDaoTao {
	private String maLoaiHinhDaoTao = "FFSE Offline";
	private String thongTinLoaiHinhDaoTao = "Chương trình đào tạo offline";

	public LoaiHinhDaoTaoOffline() {
		super();
	}

	public LoaiHinhDaoTaoOffline(String maLoaiHinhDaoTao, String thongTinLoaiHinhDaoTao) {
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
