package fasttrackse.ffse1704.fbms.entity.logwork;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ho_so_nhan_su")
public class VuNhanVien {
	@Id
	@Column(name = "ma_nhan_vien")
	String maNVien;

	@Column(name = "ho_dem")
	String hoDem;

	@Column(name = "ten")
	String ten;
	
	@Transient
	String fullName;
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@OneToMany(mappedBy = "maNhanVien")
	private Collection<ThoiGianLamViec> logworks;

	public String getMaNVien() {
		return maNVien;
	}

	public void setMaNVien(String maNVien) {
		this.maNVien = maNVien;
	}

	public String getHoDem() {
		return hoDem;
	}

	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public Collection<ThoiGianLamViec> getLogworks() {
		return logworks;
	}

	public void setLogworks(Collection<ThoiGianLamViec> logworks) {
		this.logworks = logworks;
	}
	
	public String getFullName() {
		return hoDem + " " + ten ;
	}
	
}
