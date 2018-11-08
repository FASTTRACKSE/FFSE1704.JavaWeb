package entity;

public class SinhVien {
	private int id;
	private String name;
	private int birth_year;
	private String email;
	private String address;
	private String lop;
	private String gender;

	public SinhVien() {

	}

	public SinhVien(int id, String name, int birth_year, String email, String address, String lop, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.birth_year = birth_year;
		this.email = email;
		this.address = address;
		this.lop = lop;
		this.gender = gender;
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

	public int getBirth_year() {
		return birth_year;
	}

	public void setBirth_year(int birth_year) {
		this.birth_year = birth_year;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
