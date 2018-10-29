package fasttrackse.loaihinhdaotao;

public class DaoTaoOnline {
	String maLoaiHinhDaoTao = "FFSEOLN";
	String thongTinLoaiHinhDaoTao = "Ðào tào qua Internet";
	String thoiGian =" 24/24";
	String diaDiem ="trang web LMS.FASTTRACK.EDU.VN";
	public DaoTaoOnline(String maLoaiHinhDaoTao, String thongTinLoaiHinhDaoTao, String thoiGian, String diaDiem) {
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
