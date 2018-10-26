package quanlyhocsinh.entity;

public class DaoTaoOnline implements LoaiHinhDaoTao{
	String thoiGian = "24/24";
	String diaChi = "Trang web LMS.FASTTRACK.EDU.VN";
	public DaoTaoOnline() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DaoTaoOnline(String thoiGian, String diaChi) {
		super();
		this.thoiGian = thoiGian;
		this.diaChi = diaChi;
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
