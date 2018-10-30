package springmvc.entity;

public class SinhVien {
	private int id;
	private String name;
	private int year;
	private String gender;

	public SinhVien(int id, String name, int year, String gender) {
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
