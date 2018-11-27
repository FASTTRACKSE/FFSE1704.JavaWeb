package springmvchibernate.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "quanlisinhvien")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "dia_chi")
	@NotEmpty
	private String diaChi;
	
	@Column(name = "avatar")
	private String avatar;



	@Column(name = "lop_hoc")
	@NotEmpty
	private String lopHoc;

	@Column(name = "nam_sinh")
	private int namSinh;

	@Column(name = "ten_SV")
	@NotEmpty
	private String tenSV;

	@Column(name = "maSV")
	@NotEmpty
	private String maSV;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "maSV", referencedColumnName = "maSV", insertable=false, updatable=false)
	private DiemSV DiemSV1;
	
	
	
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public User() {
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

	public DiemSV getDiemSV1() {
		return DiemSV1;
	}

	public void setDiemSV1(DiemSV diemSV1) {
		DiemSV1 = diemSV1;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
