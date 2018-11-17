package ffsespring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "diem")
public class DiemSinhVien implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "masinhvien")
	private String maSinhVien;

	@ManyToOne
	@JoinColumn(name = "maSinhVien", referencedColumnName = "maSinhVien", nullable = false)
	private SinhVien sinhVien;

	@Column(name = "mamonhoc")
	private String maMonHoc;

	@Column(name = "diem")
	private String diem;

	public DiemSinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DiemSinhVien(Integer id, SinhVien sinhVien, String maMonHoc, String diem) {
		super();
		this.id = id;
		this.sinhVien = sinhVien;
		this.maMonHoc = maMonHoc;
		this.diem = diem;
	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SinhVien getSinhVien() {
		return sinhVien;
	}

	public void setSinhVien(SinhVien sinhVien) {
		this.sinhVien = sinhVien;
	}

	public String getMaMonHoc() {
		return maMonHoc;
	}

	public void setMaMonHoc(String maMonHoc) {
		this.maMonHoc = maMonHoc;
	}

	public String getDiem() {
		return diem;
	}

	public void setDiem(String diem) {
		this.diem = diem;
	}

}
