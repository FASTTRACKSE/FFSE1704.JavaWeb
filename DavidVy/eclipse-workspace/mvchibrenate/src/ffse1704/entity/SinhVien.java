package ffse1704.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dssinhvien")
public class SinhVien {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@Column(name="masv")
	private String masv;
	
	@Column(name="tensv")
	private String tensv;
	
	@Column(name="images")
	private String images;
	
	@Column(name="namsinh")
	private int namsinh;
	
	@Column(name="email")
	private String email;
	
	@Column(name="diaChi")
	private String diaChi;
	
	@Column(name="lopHoc")
	private String lopHoc;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMasv() {
		return masv;
	}

	public void setMasv(String masv) {
		this.masv = masv;
	}

	public String getTensv() {
		return tensv;
	}

	public void setTensv(String tensv) {
		this.tensv = tensv;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public int getNamsinh() {
		return namsinh;
	}

	public void setNamsinh(int namsinh) {
		this.namsinh = namsinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getLopHoc() {
		return lopHoc;
	}

	public void setLopHoc(String lopHoc) {
		this.lopHoc = lopHoc;
	}

	public SinhVien(int id, String masv, String tensv, String images, int namsinh, String email, String diaChi,
			String lopHoc) {
		super();
		this.id = id;
		this.masv = masv;
		this.tensv = tensv;
		this.images = images;
		this.namsinh = namsinh;
		this.email = email;
		this.diaChi = diaChi;
		this.lopHoc = lopHoc;
	}

	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
