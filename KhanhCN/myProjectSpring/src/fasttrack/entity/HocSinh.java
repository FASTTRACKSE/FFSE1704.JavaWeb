package fasttrack.entity;

public class HocSinh {
	int id;
	String nameStudent;
	String classStudent;
	String gender;
	String address;
	String avatar;

	public HocSinh() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HocSinh(int id, String nameStudent, String classStudent, String gender, String address, String avatar) {
		super();
		this.id = id;
		this.nameStudent = nameStudent;
		this.classStudent = classStudent;
		this.gender = gender;
		this.address = address;
		this.avatar = avatar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameStudent() {
		return nameStudent;
	}

	public void setNameStudent(String nameStudent) {
		this.nameStudent = nameStudent;
	}

	public String getClassStudent() {
		return classStudent;
	}

	public void setClassStudent(String classStudent) {
		this.classStudent = classStudent;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	

}
