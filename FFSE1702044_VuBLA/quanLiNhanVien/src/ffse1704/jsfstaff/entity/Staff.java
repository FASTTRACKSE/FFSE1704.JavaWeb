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
	private String gender,diaChi,image;
	@Min(18)
	@Max(28)
	private int namSinh;

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public Staff( String hoTen, int namSinh, String gender, String diaChi, String image) {
		super();
		
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.gender = gender;
		this.diaChi = diaChi;
		this.image = image;
	}
}
