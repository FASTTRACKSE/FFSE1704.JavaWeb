package fasttrack.entity;

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
	

	private String name;
	
	
	private String email;
	

	private String birth;
	

	private int address;
	

	private String nameClass;

	
	private String image;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public SinhVien() {
		super();
	}

	public SinhVien(int id, String name, String email, String birth, int address, String nameClass, String image) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.birth = birth;
		this.address = address;
		this.nameClass = nameClass;
		this.image = image;
		
	}
	
	public SinhVien( String name, String email, String birth, int address, String nameClass, String image) {

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

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
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