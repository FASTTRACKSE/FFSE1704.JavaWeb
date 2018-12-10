package fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "minhtq_don_nghi_phep")
public class DonNghiPhepMinhtq {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "ma_nhan_vien")
	private String maNhanVien;

	@Column(name = "loai_ngay_nghi")
	private int loaiNgayNghi;

	@Column(name = "so_luong")
	private int soLuong;

	@Column(name = "thoi_gian_bat_dau")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date thoiGianBatDau;

	@Column(name = "thoi_gian_ket_thuc")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date thoiGianKetThuc;

	@Column(name = "trang_thai")
	private int trangThai;

	@ManyToOne
	@JoinColumn(name = "trang_thai", referencedColumnName = "ma_trang_thai", insertable = false, updatable = false, nullable = false)
	private TrangThaiVangNghiMinhtq trangThaiDNP;

	public TrangThaiVangNghiMinhtq getTrangThaiDNP() {
		return trangThaiDNP;
	}

	public void setTrangThaiDNP(TrangThaiVangNghiMinhtq trangThaiDNP) {
		this.trangThaiDNP = trangThaiDNP;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public int getLoaiNgayNghi() {
		return loaiNgayNghi;
	}

	public void setLoaiNgayNghi(int loaiNgayNghi) {
		this.loaiNgayNghi = loaiNgayNghi;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
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

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public DonNghiPhepMinhtq(int id, String maNhanVien, int loaiNgayNghi, int soLuong, Date thoiGianBatDau,
			Date thoiGianKetThuc, int trangThai, TrangThaiVangNghiMinhtq trangThaiDNP) {
		super();
		this.id = id;
		this.maNhanVien = maNhanVien;
		this.loaiNgayNghi = loaiNgayNghi;
		this.soLuong = soLuong;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.trangThai = trangThai;
		this.trangThaiDNP = trangThaiDNP;
	}

	public DonNghiPhepMinhtq() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
	
}
