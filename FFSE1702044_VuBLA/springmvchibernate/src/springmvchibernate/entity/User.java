package springmvchibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "quanlisinhvien")
public class User {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@SuppressWarnings("deprecation")
	@Column(name = "dia_chi")
	@NotEmpty
	private String diaChi;

	@Column(name = "avatar")
	private String avatar;

	@SuppressWarnings("deprecation")
	@Column(name = "lop_hoc")
	@NotEmpty
	private String lopHoc;

	@SuppressWarnings("deprecation")
	@Column(name = "nam_sinh")
	@NotEmpty
	private int namSinh;

	@SuppressWarnings("deprecation")
	@Column(name = "ten_SV")
	@NotEmpty
	private String tenSV;

	@SuppressWarnings("deprecation")
	@Column(name = "ma_SV")
	@NotEmpty
	private String maSV;

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public User() {
		super();
	}

	public User(int id, String diaChi, String lopHoc, String avatar, int namSinh, String maSV, String tenSV) {
		super();
		this.id = id;
		this.diaChi = diaChi;
		this.lopHoc = lopHoc;
		this.avatar = avatar;
		this.namSinh = namSinh;
		this.maSV = maSV;
		this.tenSV = tenSV;
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

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
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
