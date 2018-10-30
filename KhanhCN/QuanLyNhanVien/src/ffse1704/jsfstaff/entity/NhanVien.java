package ffse1704.jsfstaff.entity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class NhanVien {
	int id;
	String tenNhanVien;
	int namSinh;
	int gioiTinh;
	String hoKhau;
	String hinhAnh;
	
	public NhanVien(int id, String tenNhanVien, int namSinh, int gioiTinh, String hoKhau, String hinhAnh) {
		super();
		this.id = id;
		this.tenNhanVien = tenNhanVien;
		this.namSinh = namSinh;
		this.gioiTinh = gioiTinh;
		this.hoKhau = hoKhau;
		this.hinhAnh = hinhAnh;
	}

	public NhanVien() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public int getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getHoKhau() {
		return hoKhau;
	}

	public void setHoKhau(String hoKhau) {
		this.hoKhau = hoKhau;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	
	

	

}
