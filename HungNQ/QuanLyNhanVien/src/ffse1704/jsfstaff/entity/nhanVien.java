package ffse1704.jsfstaff.entity;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class nhanVien {
	private int id;
	private String hoVaTen;
	private String namSinh;
	private String gioiTinh;
	private String hoKhau;
	private String image;

	public nhanVien() {

	}

	public nhanVien(int id, String hoVaTen, String namSinh, String gioiTinh, String hoKhau, String image) {
		super();
		this.id = id;
		this.hoVaTen = hoVaTen;
		this.namSinh = namSinh;
		this.gioiTinh = gioiTinh;
		this.hoKhau = hoKhau;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public String getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(String namSinh) {
		this.namSinh = namSinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getHoKhau() {
		return hoKhau;
	}

	public void setHoKhau(String hoKhau) {
		this.hoKhau = hoKhau;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
