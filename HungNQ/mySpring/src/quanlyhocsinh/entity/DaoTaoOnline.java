package quanlyhocsinh.entity;

public class DaoTaoOnline implements LoaiDaoTao{
	String loaiHinhDaoTao = "Online";
	String thoiGian = "24/24";
	String diaChi = "trang web LMS.FASTTRACK.EDU.VN";

	public DaoTaoOnline() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DaoTaoOnline(String loaiHinhDaoTao, String thoiGian, String diaChi) {
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
