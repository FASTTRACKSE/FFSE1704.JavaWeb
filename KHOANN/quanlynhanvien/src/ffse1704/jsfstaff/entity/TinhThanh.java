package ffse1704.jsfstaff.entity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class TinhThanh {
	protected int id;
	protected String thanhPho;

	public TinhThanh() {
		super();
	}

	public TinhThanh(int id, String thanhPho) {
		super();
		this.id = id;
		this.thanhPho = thanhPho;
	}

	public int getId() {
		return id;
	}

	public void setId(int i) {
		this.id = i;
	}

	public String getThanhPho() {
		return thanhPho;
	}

	public void setThanhPho(String thanhPho) {
		this.thanhPho = thanhPho;
	}
}
