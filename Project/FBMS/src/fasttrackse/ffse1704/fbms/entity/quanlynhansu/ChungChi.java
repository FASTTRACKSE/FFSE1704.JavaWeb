package fasttrackse.ffse1704.fbms.entity.quanlynhansu;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chung_chi")
public class ChungChi implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", unique = true, nullable = false, length = 11)
	private int ID;

	@Column(name = "ma_nhan_vien", nullable = false, length = 255)
	private String maNhanVien;

	@Column(name = "ten_chung_chi", nullable = false, length = 255)
	private String tenChungChi;

	@Column(name = "ngay_cap", nullable = false)
	private Date ngayCap;

	@Column(name = "don_vi_cap", nullable = false, length = 255)
	private String donViCap;

	public ChungChi(int iD, String maNhanVien, String tenChungChi, Date ngayCap, String donViCap) {
		super();
		ID = iD;
		this.maNhanVien = maNhanVien;
		this.tenChungChi = tenChungChi;
		this.ngayCap = ngayCap;
		this.donViCap = donViCap;
	}

	public ChungChi() {
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getTenChungChi() {
		return tenChungChi;
	}

	public void setTenChungChi(String tenChungChi) {
		this.tenChungChi = tenChungChi;
	}

	public Date getNgayCap() {
		return ngayCap;
	}

	public void setNgayCap(Date ngayCap) {
		this.ngayCap = ngayCap;
	}

	public String getDonViCap() {
		return donViCap;
	}

	public void setDonViCap(String donViCap) {
		this.donViCap = donViCap;
	}

}