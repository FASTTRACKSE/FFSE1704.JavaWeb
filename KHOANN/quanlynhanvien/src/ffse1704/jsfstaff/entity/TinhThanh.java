package ffse1704.jsfstaff.entity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class TinhThanh {
	protected int hoKhau;
	protected String thanhPho;

	public TinhThanh() {
		super();
	}

	public TinhThanh(int hoKhau, String thanhPho) {
		super();
		this.hoKhau = hoKhau;
		this.thanhPho = thanhPho;
	}

	public int getHoKhau() {
		return hoKhau;
	}

	public void setHoKhau(int i) {
		this.hoKhau = i;
	}

	public String getThanhPho() {
		return thanhPho;
	}

	public void setThanhPho(String thanhPho) {
		this.thanhPho = thanhPho;
	}
}
