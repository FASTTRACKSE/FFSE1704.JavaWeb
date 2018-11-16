package ffse1704.quanlysinhvien.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sinhvien")
public class SinhVien {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "tenSinhVien")
	private String tenSinhVien;

	@Column(name = "tuoiSinhVien")
	private int tuoiSinhVien;

	@Column(name = "diaChi")
	private String diaChi;

	@Column(name = "avatar")
	private String avatar;

	@Column(name = "email")
	private String email;

	@OneToMany
	@JoinColumn(name = "id")
	private DiemSinhVien diemSinhVien;
	
	public DiemSinhVien getDiemSinhVien() {
		return diemSinhVien;
	}

	public void setDiemSinhVien(DiemSinhVien diemSinhVien) {
		this.diemSinhVien = diemSinhVien;
	}

	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SinhVien(int id, String tenSinhVien, int tuoiSinhVien, String diaChi, String avatar, String email) {
		super();
		this.id = id;
		this.tenSinhVien = tenSinhVien;
		this.tuoiSinhVien = tuoiSinhVien;
		this.diaChi = diaChi;
		this.avatar = avatar;
		this.email = email;
	}

	public int getId() {
		return id;
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

	public int getTuoiSinhVien() {
		return tuoiSinhVien;
	}

	public void setTuoiSinhVien(int tuoiSinhVien) {
		this.tuoiSinhVien = tuoiSinhVien;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

}
