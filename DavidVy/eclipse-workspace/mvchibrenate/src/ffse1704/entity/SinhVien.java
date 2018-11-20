package ffse1704.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dssinhvien")
public class SinhVien {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "masv")
	private String masv;

	@Column(name = "tensv")
	private String tensv;

	@Column(name = "lopHoc")
	private String lopHoc;

	@Column(name = "namsinh")
	private int namsinh;

	@Column(name = "diaChi")
	private String diaChi;

	@Column(name = "email")
	private String email;

	@Column(name = "images")
	private String images;

	public SinhVien(int id, String masv, String tensv, String lopHoc, int namsinh, String diaChi, String email,
			String images) {
		super();
		this.id = id;
		this.masv = masv;
		this.tensv = tensv;
		this.lopHoc = lopHoc;
		this.namsinh = namsinh;
		this.diaChi = diaChi;
		this.email = email;
		this.images = images;
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

}
