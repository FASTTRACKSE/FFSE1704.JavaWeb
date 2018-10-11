package model.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class SinhVien {
	private String MASV;
	private String TEN;
	private String PASS;

	public SinhVien(String mASV, String tEN, String pASS) {
		super();
		MASV = mASV;
		TEN = tEN;
		PASS = pASS;
	}

	public String getMASV() {
		return MASV;
	}

	public void setMASV(String mASV) {
		MASV = mASV;
	}

	public String getTEN() {
		return TEN;
	}

	public void setTEN(String tEN) {
		TEN = tEN;
	}

	public String getPASS() {
		return PASS;
	}

	public void setPASS(String pASS) {
		PASS = pASS;
	}

}
