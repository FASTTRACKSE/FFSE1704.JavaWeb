package ffse1704.jsfstaff.entity;

import javax.faces.bean.ManagedBean;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@ManagedBean
public class Staff {
	int id;
	
	@NotNull(message = "Tên không được để trống")
	@Size(min=1, message = "Tên không được để trống")
	String hoTen;
	
	@NotNull(message = "Năm sinh không được để trống")
	@Range (min=1900, max=2000, message = "Năm sinh từ 1900 - 2000")
	int namSinh;
	
	int gioiTinh;
	int hoKhauId;
	String anhThe;
	public Staff() {
		super();
	}

	public Staff(int id, String hoTen, int namSinh, int gioiTinh, int hoKhauId, String anhThe) {
		super();
		this.id = id;
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.gioiTinh = gioiTinh;
		this.hoKhauId = hoKhauId;
		this.anhThe = anhThe;
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

	public int getHoKhauId() {
		return hoKhauId;
	}

	public void setHoKhauId(int hoKhauId) {
		this.hoKhauId = hoKhauId;
	}

	public String getAnhThe() {
		return anhThe;
	}

	public void setAnhThe(String anhThe) {
		this.anhThe = anhThe;
	}
	
}
