package fasttrackse.ffse1704.fbms.entity.quanlythoigian;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "phan_cong_nhiem_vu")
public class PhanCongNhiemVuLogwork {
	@Id
	@Column(name = "ma_du_an")
	String maDuAn;
	
	@Column(name = "ma_nhan_vien")
	String maNhanVien;
	
	@Column(name = "ma_vai_tro")
	int maVaiTro;

	public String getMaDuAn() {
		return maDuAn;
	}

	public void setMaDuAn(String maDuAn) {
		this.maDuAn = maDuAn;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public int getMaVaiTro() {
		return maVaiTro;
	}

	public void setMaVaiTro(int maVaiTro) {
		this.maVaiTro = maVaiTro;
	}
	
}
