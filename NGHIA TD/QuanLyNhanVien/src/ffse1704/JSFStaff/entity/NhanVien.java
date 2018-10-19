package ffse1704.JSFStaff.entity;

import javax.faces.bean.ManagedBean;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;



@ManagedBean
public class NhanVien {
	
	 int id;
	 
	 @NotNull(message= "Tên không được để trống")
	 @Size(min=1,message= "Tên không được để trống")
	 String name;
	 
	 @NotNull(message= "Năm sinh không được để trống")
	 @Range(min=1990, max=2000, message= "Năm sinh phải từ 1990-2000")
	 int birthDay;
	 
	 int genDer;
	 int address;
	 String images;
	 
	 public NhanVien() {
			super();
		}

	public NhanVien(int id, String name, int birthDay, int genDer, int address, String images) {
		super();
		this.id = id;
		this.name = name;
		this.birthDay = birthDay;
		this.genDer = genDer;
		this.address = address;
		this.images = images;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(int birthDay) {
		this.birthDay = birthDay;
	}

	public int getGenDer() {
		return genDer;
	}

	public void setGenDer(int genDer) {
		this.genDer = genDer;
	}

	public int getAddress() {
		return address;
	}

	public void setAddress(int address) {
		this.address = address;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}
	
}
