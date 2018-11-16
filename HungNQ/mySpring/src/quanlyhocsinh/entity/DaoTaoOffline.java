package quanlyhocsinh.entity;

public class DaoTaoOffline implements LoaiDaoTao {
	String loaiHinhDaoTao = "Offline";
	String thoiGian = "sáng từ 8h00, chiều từ 13h30, tối từ 18h30";
	String diaChi = "Toà nhà FPT, KCN An Đồn";

	public DaoTaoOffline() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DaoTaoOffline(String loaiHinhDaoTao,String thoiGian, String diaChi) {
		super();
		this.loaiHinhDaoTao = loaiHinhDaoTao;
		this.thoiGian = thoiGian;
		this.diaChi = diaChi;
	}

	public String getLoaiHinhDaoTao() {
		return loaiHinhDaoTao;
	}

	public void setLoaiHinhDaoTao(String loaiHinhDaoTao) {
		this.loaiHinhDaoTao = loaiHinhDaoTao;
	}

	public String getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

}
