package fasttrack.entity;



import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.internal.NotNull;

public class SinhVien  {
	private int id;
	@NotNull
	private String name;
	@NotNull
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date birthday;
	@NotNull
	private String email;
	@NotNull
	private String address;
	@NotNull
	private String classsv;
	private String image;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SinhVien(int id, String name, Date birthday, String email, String address, String classsv, String image) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.email = email;
		this.address = address;
		this.classsv = classsv;
		this.image = image;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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

	public String getClasssv() {
		return classsv;
	}

	public void setClasssv(String classsv) {
		this.classsv = classsv;
	}
}
