package quanlyhocsinh.entity;

public class SinhVien {
	String hoTen;
	int namSinh;
	String diachi;
	String dienthoai;
	String email;

	HeDaoTao heDaoTao;

	public String getThongTinSinhVien() {
		return hoTen + " - " + namSinh + " - " + email;

	}
	public String getThongTinHeDaoTao() {
		return heDaoTao.getMaHeDaoTao() + " - " + heDaoTao.getThongTinHeDaoTao();
	}
	public String getHoTen() {
		return hoTen;
	}
	

}
