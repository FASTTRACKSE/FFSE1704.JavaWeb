package fasttrackse.ffse1704.fbms.entity.quanlythoigian;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ho_so_nhan_su")
public class NhanVienLogwork {
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
	private Collection<Logwork> logworks;

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

	public Collection<Logwork> getLogworks() {
		return logworks;
	}

	public void setLogworks(Collection<Logwork> logworks) {
		this.logworks = logworks;
	}
	
	public String getFullName() {
		return hoDem + " " + ten ;
	}
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	  @JoinTable(name = "phan_cong_nhiem_vu", 
	    joinColumns = { @JoinColumn(name = "ma_nhan_vien") }, 
	    inverseJoinColumns = {@JoinColumn(name = "ma_du_an") })
	  private Set<DuAnLogwork> products = new HashSet<>();

	public Set<DuAnLogwork> getProducts() {
		return products;
	}

	public void setProducts(Set<DuAnLogwork> products) {
		this.products = products;
	}
	
}
