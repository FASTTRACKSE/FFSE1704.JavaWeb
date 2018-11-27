package ffse1704.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "sinhvien")
public class SinhVien implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty(message = "Mã không được để trống")
	@Size(min = 3, message = "Mã SV phải ít nhất 3 kí từ ")
	private String maSV;

	@NotEmpty(message = "Mã không được để trống")
	@Size(min = 5, message = "tên SV phải ít nhất 5 kí từ ")
	private String tenSV;

	private String images;

	
	@Range(min = 1990, max = 2000, message = "Năm sinh phải từ 1990-2000")
	private int namSinh;

	@Email(message = "Email không được để trống")
	private String email;

	@NotEmpty(message = "Địa chỉ không được để trống")
	private String diaChi;
	
	@NotEmpty(message = "Lớp học không được để trống")
	private String lopHoc;

	@OneToMany(mappedBy="sinhVien")
	private List<BangDiem> 	listScore = new ArrayList<BangDiem>();
	
	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SinhVien(int id, String maSV, String tenSV, String images, int namSinh, String email, String diaChi,
			String lopHoc) {
		super();
		this.id = id;
		this.maSV = maSV;
		this.tenSV = tenSV;
		this.images = images;
		this.namSinh = namSinh;
		this.email = email;
		this.diaChi = diaChi;
		this.lopHoc = lopHoc;
	}

	public SinhVien(String maSV, String tenSV, String images, int namSinh, String email, String diaChi, String lopHoc) {

		this.maSV = maSV;
		this.tenSV = tenSV;
		this.images = images;
		this.namSinh = namSinh;
		this.email = email;
		this.diaChi = diaChi;
		this.lopHoc = lopHoc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getTenSV() {
		return tenSV;
	}

	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
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
