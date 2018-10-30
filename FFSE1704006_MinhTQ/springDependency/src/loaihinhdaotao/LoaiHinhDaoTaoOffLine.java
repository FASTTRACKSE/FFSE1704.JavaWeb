package loaihinhdaotao;

public class LoaiHinhDaoTaoOffline implements LoaiHinhDaoTao {
	String maLoaiHinhDaoTao="OF";
	String thongTinLoaiHinhDaoTao="Đào tạo offline";

	public LoaiHinhDaoTaoOffline() {
		super();
		// TODO Auto-generated constructor stub
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
