package loaihinhdaotao;

public class LoaiHinhDaoTaoOnline implements  LoaiHinhDaoTao{
	String maLoaiHinhDaoTao ="OL";
	String thongTinLoaiHinhDaoTao="Đào tạo online";

	public LoaiHinhDaoTaoOnline() {
		super();
		// TODO Auto-generated constructor stub
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
