package fasttrack.entity;

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
@Table(name = "diemhocsinh")

public class DiemHocSinh implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "maSV")
	private String maSV;

	@ManyToOne(optional=false)
	@JoinColumn(name = "maSV", referencedColumnName = "maSV",  insertable=false ,updatable=false)
	private HocSinh hocSinh;

	@Column(name = "tenMH")
	private String tenMH;

	@Column(name = "diem")
	private String diem;

	@Column(name = "IS")
	private String IS;

	public DiemHocSinh(int id, String tenMH, String diem, String IS) {
		super();
		this.id = id;

		this.tenMH = tenMH;
		this.diem = diem;
		this.IS = IS;
	}

	public DiemHocSinh() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenMH() {
		return tenMH;
	}

	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}

	public String getDiem() {
		return diem;
	}

	public void setDiem(String diem) {
		this.diem = diem;
	}

	public String getIS() {
		return IS;
	}

	public void setIS(String IS) {
		this.IS = IS;
	}
}
