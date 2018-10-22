package ffse1704.jsfsatff.entity;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class tinhThanh {
	private String maTinh;
	private String tenTinh;

	public tinhThanh(String maTinh, String tenTinh) {
		super();
		this.maTinh = maTinh;
		this.tenTinh = tenTinh;
	}

	public tinhThanh() {

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
