package entity;

public class SinhVien {
	private int id;
	private String name;
	private String birth_year;
	private String email;
	private String address;
	private String lop;
	private String gender;

	public SinhVien() {

	}

	public SinhVien(int id, String name, String birth_year, String email, String address, String lop, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.birth_year = birth_year;
		this.email = email;
		this.address = address;
		this.lop = lop;
		this.gender = gender;
	}

	public String getBirth_year() {
		return birth_year;
	}

	public void setBirth_year(String birth_year) {
		this.birth_year = birth_year;
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
