package ffse1704.jsfsatff.entity;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class NhanVien {
	private String maNhanVien;
	private String tenNhanVien;
	private String namSinh;
	private String gioiTinh;
	private String hoKhau;
	private String images;

	

	public NhanVien(String maNhanVien, String tenNhanVien, String namSinh, String gioiTinh, String hoKhau, String images) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.namSinh = namSinh;
		this.gioiTinh = gioiTinh;
		this.hoKhau = hoKhau;
		this.images = images;
	}

	public NhanVien() {
		super();
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
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

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}
}
