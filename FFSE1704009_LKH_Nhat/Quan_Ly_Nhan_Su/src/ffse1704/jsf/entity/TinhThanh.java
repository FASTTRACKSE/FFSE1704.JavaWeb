package ffse1704.jsf.entity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class TinhThanh {
	private String id;
	private String maTinh;
	private String tenTinh;

	public TinhThanh() {
		super();
	}

	public TinhThanh(String id, String maTinh, String tenTinh) {
		super();
		this.id = id;
		this.maTinh = maTinh;
		this.tenTinh = tenTinh;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
