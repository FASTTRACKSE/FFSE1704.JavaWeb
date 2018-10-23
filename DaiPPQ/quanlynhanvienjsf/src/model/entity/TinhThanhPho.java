package model.entity;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class TinhThanhPho {
	private String matp;
	private String name;

	public TinhThanhPho(String matp, String name) {
		super();
		this.matp = matp;
		this.name = name;
	}
	
	public TinhThanhPho() {

	}

	public String getMatp() {
		return matp;
	}

	public void setMatp(String matp) {
		this.matp = matp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
