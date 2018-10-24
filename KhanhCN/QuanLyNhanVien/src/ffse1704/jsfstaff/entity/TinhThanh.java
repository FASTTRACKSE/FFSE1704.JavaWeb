package ffse1704.jsfstaff.entity;

public class TinhThanh {
	int maTinh;
	String tenTinh;

	public TinhThanh(int maTinh, String tenTinh) {
		super();
		this.maTinh = maTinh;
		this.tenTinh = tenTinh;
	}
	
	public TinhThanh() {
		
	}

	public int getMaTinh() {
		return maTinh;
	}

	public void setMaTinh(int maTinh) {
		this.maTinh = maTinh;
	}

	public String getTenTinh() {
		return tenTinh;
	}

	public void setTenTinh(String tenTinh) {
		this.tenTinh = tenTinh;
	}

}
