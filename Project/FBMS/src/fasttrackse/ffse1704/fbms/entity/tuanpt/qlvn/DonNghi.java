package fasttrackse.ffse1704.fbms.entity.tuanpt.qlvn;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;

import java.util.Date;

import javax.persistence.Column;

@Entity
@Table(name = "don_nghi_tuanpt")
public class DonNghi {
	@Id
	@Column(name = "id_don_nghi")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDon;
	
	@Column(name = "id_nhan_vien")
	private int idNhanVien;
	
	@Column(name = "ten_nhan_vien")
	private String tenNhanVien;
	
	@Column(name = "phong_ban")
	private String phongBan;
	
	@Column(name = "ly_do_nghi")
	private String lyDo;
	
	@Column(name = "tg_bat_dau")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date thoiGianBatDau;
	
	@Column(name = "tg_ket_thuc")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date thoiGianKetThuc;
	
	@Column(name = "ghi_chu")
	private String ghiChu;

	@Column(name = "tinh_trang")
	private int tinhTrang;

	public int getIdDon() {
		return idDon;
	}

	public void setIdDon(int idDon) {
		this.idDon = idDon;
	}

	public int getIdNhanVien() {
		return idNhanVien;
	}

	public void setIdNhanVien(int idNhanVien) {
		this.idNhanVien = idNhanVien;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public String getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}

	public String getLyDo() {
		return lyDo;
	}

	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}

	public Date getThoiGianBatDau() {
		return thoiGianBatDau;
	}

	public void setThoiGianBatDau(Date thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}

	public Date getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}

	public void setThoiGianKetThuc(Date thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public int getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	
}
