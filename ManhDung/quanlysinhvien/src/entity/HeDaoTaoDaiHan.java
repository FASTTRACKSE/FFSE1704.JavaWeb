package entity;

public class HeDaoTaoDaiHan implements HeDaoTao {
	String maHeDaoTao = "FFSEDH";
	String thongTinHeDaoTao = "Đào tạo dài hạn 16 tháng full các môn học";

	public HeDaoTaoDaiHan() {
		super();
	}
	
	public HeDaoTaoDaiHan(String maHeDaoTao, String thongTinHeDaoTao) {
		super();
		this.maHeDaoTao = maHeDaoTao;
		this.thongTinHeDaoTao = thongTinHeDaoTao;
	}

	public String getTenMonHoc() {
		return " Tin học văn phòng" 
				+ " Lập trình cơ bản"
				+ " Lập trình Web frontend "
				+ " Lập trình Web PHP & MySQL "
				+ " Lập trình Java cơ bản "
				+ " Lập trình Java Web "
				+ " Quy trình dự án ";
				
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
}
