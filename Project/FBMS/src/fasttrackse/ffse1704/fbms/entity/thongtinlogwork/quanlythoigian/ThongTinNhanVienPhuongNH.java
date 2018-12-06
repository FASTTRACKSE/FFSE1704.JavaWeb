package fasttrackse.ffse1704.fbms.entity.thongtinlogwork.quanlythoigian;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ho_so_nhan_vien")
public class ThongTinNhanVienPhuongNH {
	@Id
	@Column(name = "ma_nhan_vien")
	int maNVien;

	@Column(name = "ho_dem")
	String hoDem;

	@Column(name = "ten")
	String ten;
	
	@OneToMany(mappedBy = "nhanVien")
	private Collection<ThongTinLogwork> logworks;

	public int getMaNVien() {
		return maNVien;
	}

	public void setMaNVien(int maNVien) {
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

	public Collection<ThongTinLogwork> getLogworks() {
		return logworks;
	}

	public void setLogworks(Collection<ThongTinLogwork> logworks) {
		this.logworks = logworks;
	}
	public String getTenNhanVien() {
		return hoDem + ten ;
	}
	
}