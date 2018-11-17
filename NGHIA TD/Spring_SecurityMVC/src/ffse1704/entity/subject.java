package ffse1704.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class subject {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "MaMH")
	private String MaMH;

	public subject(String maMH, String tenMH) {
		super();
		MaMH = maMH;
		TenMH = tenMH;
	}

	public subject() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(name = "TenMH")
	private String TenMH;

	@ManyToOne
	@JoinColumn(name= "student_id")
	private SinhVien sinhVien;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaMH() {
		return MaMH;
	}

	public void setMaMH(String maMH) {
		MaMH = maMH;
	}

	public String getTenMH() {
		return TenMH;
	}

	public void setTenMH(String tenMH) {
		TenMH = tenMH;
	}

	public SinhVien getSinhVien() {
		return sinhVien;
	}

	public void setSinhVien(SinhVien sinhVien) {
		this.sinhVien = sinhVien;
	}
	

}
