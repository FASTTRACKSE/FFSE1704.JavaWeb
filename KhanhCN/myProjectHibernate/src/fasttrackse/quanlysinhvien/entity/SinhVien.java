package fasttrackse.quanlysinhvien.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sinhvien")
public class SinhVien {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nameStudent")
	private String nameStudent;

	@Column(name = "classStudent")
	private String classStudent;

	@Column(name = "gender")
	private String gender;

	@Column(name = "address")
	private String address;

	@Column(name = "avatar")
	private String avatar;

	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SinhVien(int id, String nameStudent, String classStudent, String gender, String address, String avatar) {
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
