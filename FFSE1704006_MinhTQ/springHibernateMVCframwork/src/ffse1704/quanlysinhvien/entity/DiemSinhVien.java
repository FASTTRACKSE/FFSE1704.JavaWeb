package ffse1704.quanlysinhvien.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "diemsinhvien")
public class DiemSinhVien {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "idSinhVien")
	private String idSinhVien;

	@Column(name = "maMonHoc")
	private String maMonHoc;

	@Column(name = "diem")
	private int diem;

	@Column(name = "isDelete")
	private int isDelete;

	@ManyToOne
	@JoinColumn(name = "idSinhVien", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
	private SinhVien sinhVien;

	public SinhVien getSinhVien() {
		return sinhVien;
	}

	public void setSinhVien(SinhVien sinhVien) {
		this.sinhVien = sinhVien;
	}

	public DiemSinhVien() {
		super();

	}

	public DiemSinhVien(int id, String idSinhVien, String maMonHoc, int diem, int isDelete) {
		super();
		this.id = id;
		this.idSinhVien = idSinhVien;
		this.maMonHoc = maMonHoc;
		this.diem = diem;
		this.isDelete = isDelete;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdSinhVien() {
		return idSinhVien;
	}

	public void setIdSinhVien(String idSinhVien) {
		this.idSinhVien = idSinhVien;
	}

	public String getMaMonHoc() {
		return maMonHoc;
	}

	public void setMaMonHoc(String maMonHoc) {
		this.maMonHoc = maMonHoc;
	}

	public int getDiem() {
		return diem;
	}

	public void setDiem(int diem) {
		this.diem = diem;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

}
