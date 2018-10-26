package quanlyhocsinh.entity;

public class DaoTaoOffline implements LoaiHinhDaoTao{

	String thoiGian = "Sáng từ 8h00, chiều từ 13h30, tối từ 18h30";
	String diaChi = "Toà nhà FPT, KCN An Đồn";
	
	public DaoTaoOffline() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DaoTaoOffline(String thoiGian, String diaChi) {
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
