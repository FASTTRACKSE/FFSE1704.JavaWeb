package ffse1704.jsfstaff.entity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@ManagedBean
@SessionScoped
public class Staff {

	int id;

	@NotNull(message = "Tên không được để trống")
	@Size(min = 1, message = "Tên không được để trống")
	String hoTen;

	@NotNull(message = "Năm sinh không được để trống")
	@Range(min = 1900, max = 2000, message = "Năm sinh từ 1900 - 2000")
	int namSinh;

	int gioiTinh;
	int hoKhau;
	String tenTinh;

	String anh;

	public Staff() {
		super();
	}

	public Staff(int id, String hoTen, int gioiTinh, int namSinh, int hoKhau, String anh) {
		super();
		this.id = id;
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.gioiTinh = gioiTinh;
		this.hoKhau = hoKhau;
		this.anh = anh;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
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

	public int getHoKhau() {
		return hoKhau;
	}

	public void setHoKhau(int hoKhau) {
		this.hoKhau = hoKhau;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public String getTenTinh() {
		return tenTinh;
	}

	public void setTenTinh(String tenTinh) {
		this.tenTinh = tenTinh;
	}

}