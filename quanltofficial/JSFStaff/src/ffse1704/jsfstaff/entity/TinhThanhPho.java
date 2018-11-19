package ffse1704.jsfstaff.entity;

public class TinhThanhPho {
	int id;
	String tenTinhThanh;
	public TinhThanhPho() {
		super();
	}
	public TinhThanhPho(int id, String tenTinhThanh) {
		super();
		this.id = id;
		this.tenTinhThanh = tenTinhThanh;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenTinhThanh() {
		return tenTinhThanh;
	}
	public void setTenTinhThanh(String tenTinhThanh) {
		this.tenTinhThanh = tenTinhThanh;
	}
}
