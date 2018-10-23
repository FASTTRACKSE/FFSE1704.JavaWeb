package ffse1704.jsfstaff.entity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ManagedBean
@RequestScoped
public class Staff {
	@NotNull(message = "Họ Tên Không được để trống")
	private String hoTen;
	private String image;
	@Min(1900)
	@Max(2018)
	private int namSinh;
	private int diaChi,gender,id;
	private String tenTinh;

	public String getTenTinh() {
		return tenTinh;
	}

	public void setTenTinh(String tenTinh) {
		this.tenTinh = tenTinh;
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

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(int diaChi) {
		this.diaChi = diaChi;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public Staff(int id, String hoTen, int namSinh, int gender, int diaChi, String image) {
		super();
		this.id = id;
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.gender = gender;
		this.diaChi = diaChi;
		this.image = image;
	}
	public Staff() {
		super();
	}
}
