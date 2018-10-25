package entity;

public class HeDaoTaoLienKetCD implements HeDaoTao {
	String maHeDaoTao = "FFSECDCN";
	String thongTinHeDaoTao = "�?ào tạo dài hạn + cao đẳng 2 năm tr�?i thương nhớ";

	public HeDaoTaoLienKetCD() {
		super();
	}
	
	public HeDaoTaoLienKetCD(String maHeDaoTao, String thongTinHeDaoTao) {
		super();
		this.maHeDaoTao = maHeDaoTao;
		this.thongTinHeDaoTao = thongTinHeDaoTao;
	}

	public String getTenMonHoc() {
		return  " Tin h�?c văn phòng"
				+ " Lập trình cơ bản"
				+ " Lập trình Web frontend "
				+ " Lập trình Web PHP & MySQL "
				+ " Lập trình Java Cơ bản "
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
