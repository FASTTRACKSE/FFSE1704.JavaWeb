package ffsespring.entity;

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
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "sinhvien")
public class SinhVien implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "tensinhvien")
	@NotEmpty(message = "Tên Sinh Viên không được để trống")
	private String tenSinhVien;

	@NotEmpty(message = "Mã Sinh Viên không được để trống")
	private String maSinhVien;

	@OneToMany(mappedBy = "sinhVien")
	private List<DiemSinhVien> listDiem = new ArrayList<DiemSinhVien>();

	@Column(name = "lop")
	@NotEmpty(message = "Lớp học không được để trống")
	private String lop;

	@Column(name = "tuoi")
	@Range(min = 1970, max = 2000, message = "Tuổi Sinh Viên không được để trống và chỉ từ 1970 đến 2000")
	private String tuoi;

	@Column(name = "gioitinh")
	@NotEmpty(message = "Giới Tính không được để trống")
	private String gioiTinh;

	@Column(name = "diachi")
	@NotEmpty(message = "Địa chỉ không được để trống")
	private String diaChi;

	@Column(name = "sodt")
	@NotEmpty(message = "Số điện Thoại không được để trống")
	private String soDT;

	@Column(name = "email")
	@NotEmpty(message = "Email không được để trống")
	private String email;

	@Column(name = "avatar")
	private String avatar;

	public SinhVien() {
		super();
	}

	public SinhVien(int id, String tenSinhVien, String maSinhVien, List<DiemSinhVien> listDiem, String lop, String tuoi,
			String gioiTinh, String diaChi, String soDT, String email, String avatar) {
		super();
		this.id = id;
		this.tenSinhVien = tenSinhVien;
		this.maSinhVien = maSinhVien;
		this.listDiem = listDiem;
		this.lop = lop;
		this.tuoi = tuoi;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.soDT = soDT;
		this.email = email;
		this.avatar = avatar;
	}

	public int getId() {
		return id;
	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public List<DiemSinhVien> getListDiem() {
		return listDiem;
	}

	public void setListDiem(List<DiemSinhVien> listDiem) {
		this.listDiem = listDiem;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenSinhVien() {
		return tenSinhVien;
	}

	public void setTenSinhVien(String tenSinhVien) {
		this.tenSinhVien = tenSinhVien;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public String getTuoi() {
		return tuoi;
	}

	public void setTuoi(String tuoi) {
		this.tuoi = tuoi;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDT() {
		return soDT;
	}

	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}
