package ffse1704.jsfstaff.entity;

import javax.faces.bean.ManagedBean;

public class province {
	private String id, tenTinh;

	public province(String id, String tenTinh) {
		super();
		this.id = id;
		this.tenTinh = tenTinh;
	}

	public province() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String gettenTinh() {
		return tenTinh;
	}

	public void settenTinh(String tenTinh) {
		this.tenTinh = tenTinh;
	}

}
