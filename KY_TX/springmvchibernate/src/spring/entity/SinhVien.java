package spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@SuppressWarnings("deprecation")
@Entity
@Table(name = "sinhvien")
public class SinhVien {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column(name = "name", nullable = false)
	@NotEmpty
	String name;
	@Column(name = "email", nullable = false)
	@NotEmpty
	String email;
	
	@Column(name = "birth", nullable = false)
	int birth;
	
	@Column(name = "address", nullable = false)
	int address;
	@Column(name = "nameClass", nullable = false)
	@NotEmpty
	String nameClass;

	@Column(name = "image", nullable = false)
	String image;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SinhVien(int id, String name, String email, int birth, int address, String nameClass) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.birth = birth;
		this.address = address;
		this.nameClass = nameClass;
	}

	public String getName() {
		return name;
	}

	public SinhVien() {
		super();
	}

	public SinhVien(int id, String name, String email, int birth, int address, String nameClass, String image) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.birth = birth;
		this.address = address;
		this.nameClass = nameClass;
		this.image = image;
		
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBirth() {
		return birth;
	}

	public void setBirth(int birth) {
		this.birth = birth;
	}

	public int getAddress() {
		return address;
	}

	public void setAddress(int address) {
		this.address = address;
	}

	public String getNameClass() {
		return nameClass;
	}

	public void setNameClass(String nameClass) {
		this.nameClass = nameClass;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
