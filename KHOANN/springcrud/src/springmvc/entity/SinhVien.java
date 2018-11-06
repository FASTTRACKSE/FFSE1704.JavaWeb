package springmvc.entity;

public class SinhVien {
	private String id;
	private String name;
	private String year;
	private String gender;

	public SinhVien(String id, String name, String year, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.gender = gender;
	}

	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
