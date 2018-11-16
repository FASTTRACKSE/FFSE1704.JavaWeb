package sinhvien.entity;

public class SinhVien {
	private int id;
	private String name;
	private String email;
	private int birth;
	private int address;
	private String nameClass;
	private String nameTinhThanh;
	private String image;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public SinhVien(int id, String name, String email, int birth, int address, String nameClass, String nameTinhThanh) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.birth = birth;
		this.address = address;
		this.nameClass = nameClass;
		this.nameTinhThanh = nameTinhThanh;
	}

	public SinhVien(int id, String name, String email, int birth, int address, String nameClass, String nameTinhThanh,
			String image) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.birth = birth;
		this.address = address;
		this.nameClass = nameClass;
		this.nameTinhThanh = nameTinhThanh;
		this.image = image;
	}

	public String getNameTinhThanh() {
		return nameTinhThanh;
	}

	public void setNameTinhThanh(String nameTinhThanh) {
		this.nameTinhThanh = nameTinhThanh;
	}
	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getEmail() {
		return email;
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

	public void setEmail(String email) {
		this.email = email;
	}
}
