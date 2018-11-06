package quanlysinhvien.entity;

public class TinhThanh {

	int maTinhThanh;
	String tenTinhThanh;

	public TinhThanh() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TinhThanh(int maTinhThanh, String tenTinhThanh) {
		super();
		this.maTinhThanh = maTinhThanh;
		this.tenTinhThanh = tenTinhThanh;
	}

	public int getMaTinhThanh() {
		return maTinhThanh;
	}

	public void setMaTinhThanh(int maTinhThanh) {
		this.maTinhThanh = maTinhThanh;
	}

	public String getTenTinhThanh() {
		return tenTinhThanh;
	}

	public void setTenTinhThanh(String tenTinhThanh) {
		this.tenTinhThanh = tenTinhThanh;
	}

	
}
