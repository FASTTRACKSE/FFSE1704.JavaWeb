package ffse1704.quanlysinhvien.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	@Column(name = "monHoc")
	private String monHoc;

	@Column(name = "avatar")
	private String avatar;

	@Column(name = "email")
	private String email;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="sinhVien",cascade = CascadeType.MERGE)
	private List<DiemSinhVien> listDiemSinhVien;

	
	public List<DiemSinhVien> getListDiemSinhVien() {
		return listDiemSinhVien;
	}

	public void setListDiemSinhVien(List<DiemSinhVien> listDiemSinhVien) {
		this.listDiemSinhVien = listDiemSinhVien;
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

	public String getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(String monHoc) {
		this.monHoc = monHoc;
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
