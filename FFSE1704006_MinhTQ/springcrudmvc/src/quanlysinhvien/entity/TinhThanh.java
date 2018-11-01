package quanlysinhvien.entity;

public class TinhThanh {

	String maTinhThanh;
	String tenTinhThanh;

	public TinhThanh() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TinhThanh(String maTinhThanh, String tenTinhThanh) {
		super();
		this.maTinhThanh = maTinhThanh;
		this.tenTinhThanh = tenTinhThanh;
	}

	public String getMaTinhThanh() {
		return maTinhThanh;
	}

	public void setMaTinhThanh(String maTinhThanh) {
		this.maTinhThanh = maTinhThanh;
	}

	public String getTenTinhThanh() {
		return tenTinhThanh;
	}

	public void setTenTinhThanh(String tenTinhThanh) {
		this.tenTinhThanh = tenTinhThanh;
	}

}
