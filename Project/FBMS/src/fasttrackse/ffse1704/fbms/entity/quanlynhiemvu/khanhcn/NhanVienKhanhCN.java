package fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/**
 * The persistent class for the ho_so_nhan_vien database table.
 * 
 */
@Entity
@Table(name = "ho_so_nhan_vien")
public class NhanVienKhanhCN implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ma_nhan_vien", unique = true, nullable = false)
	private String maNhanVien;

	@Column(name = "ho_dem", nullable = false, length = 50)
	@NotEmpty
	private String hoDem;

	@Column(name = "ten", nullable = false, length = 20)
	@NotEmpty
	private String ten;


	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}