package ffse1704.jsfsatff.entity;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class TinhThanh {
	private String maTinh;
	private String tenTinh;

	public TinhThanh(String maTinh, String tenTinh) {
		super();
		this.maTinh = maTinh;
		this.tenTinh = tenTinh;
	}

	public TinhThanh() {
		super();
	}

	public String getMaTinh() {
		return maTinh;
	}

	public void setMaTinh(String maTinh) {
		this.maTinh = maTinh;
	}

	public String getTenTinh() {
		return tenTinh;
	}

	public void setTenTinh(String tenTinh) {
		this.tenTinh = tenTinh;
	}

}
