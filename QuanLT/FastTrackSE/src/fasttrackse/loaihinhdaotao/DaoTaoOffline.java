package fasttrackse.loaihinhdaotao;

public class DaoTaoOffline {
	String maLoaiHinhDaoTao = "FFSEOFN";
	String thongTinLoaiHinhDaoTao = "Đào tào tập trung";
	String thoiGian ="sáng từ 8h00, chiều từ 13h30, tối từ 18h30";
	String diaDiem ="Toà nhà FPT, KCN An Đồn";
	
	public DaoTaoOffline(String maLoaiHinhDaoTao, String thongTinLoaiHinhDaoTao, String thoiGian, String diaDiem) {
		super();
		this.maLoaiHinhDaoTao = maLoaiHinhDaoTao;
		this.thongTinLoaiHinhDaoTao = thongTinLoaiHinhDaoTao;
		this.thoiGian = thoiGian;
		this.diaDiem = diaDiem;
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
	public String getThoiGian() {
		return thoiGian;
	}
	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}
	public String getDiaDiem() {
		return diaDiem;
	}
	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}
}
