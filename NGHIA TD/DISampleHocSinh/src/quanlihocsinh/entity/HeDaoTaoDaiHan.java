package quanlihocsinh.entity;

public class HeDaoTaoDaiHan implements HeDaoTao {
	
	String maHeDaoTao= "MA0127";
	String thongTinHeDaoTao="Đào tạo dài hạn 16 tháng, full các môn lập trình";
	MonHoc monHoc;
	public HeDaoTaoDaiHan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HeDaoTaoDaiHan(String maHeDaoTao, String thongTinHeDaoTao, MonHoc monHoc) {
		super();
		this.maHeDaoTao = maHeDaoTao;
		this.thongTinHeDaoTao = thongTinHeDaoTao;
		this.monHoc = monHoc;
	}
	public String getMaHeDaoTao() {
		return maHeDaoTao;
	}
	public void setMaHeDaoTao(String maHeDaoTao) {
		this.maHeDaoTao = maHeDaoTao;
	}
	public String getThongTinHeDaoTao() {
		return thongTinHeDaoTao;
	}
	public void setThongTinHeDaoTao(String thongTinHeDaoTao) {
		this.thongTinHeDaoTao = thongTinHeDaoTao;
	}
	public MonHoc getMonHoc() {
		return monHoc;
	}
	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}
	
}
