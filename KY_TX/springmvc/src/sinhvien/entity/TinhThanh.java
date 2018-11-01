package sinhvien.entity;

public class TinhThanh {
	public TinhThanh(int matp, String nametp) {
		super();
		this.matp = matp;
		this.nametp = nametp;
	}
	public TinhThanh() {
		super();
	}
	int matp;
	String nametp;
	public int getMatp() {
		return matp;
	}
	public void setMatp(int matp) {
		this.matp = matp;
	}
	public String getNametp() {
		return nametp;
	}
	public void setNametp(String nametp) {
		this.nametp = nametp;
	}
	
}
