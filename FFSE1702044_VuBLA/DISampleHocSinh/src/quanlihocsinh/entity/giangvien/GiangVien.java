package quanlihocsinh.entity.giangvien;

public class GiangVien {
	private String tenGV;
	private String emaiGV;
	public GiangVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GiangVien(String tenGV, String emaiGV) {
		super();
		this.tenGV = tenGV;
		this.emaiGV = emaiGV;
	}
	public String getTenGV() {
		return tenGV;
	}
	public void setTenGV(String tenGV) {
		this.tenGV = tenGV;
	}
	public String getEmaiGV() {
		return emaiGV;
	}
	public void setEmaiGV(String emaiGV) {
		this.emaiGV = emaiGV;
	}
	
}
