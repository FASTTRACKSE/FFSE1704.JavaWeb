package fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.khoann;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="khoann_don_nghi_phep")
public class DonNghiPhepKhoann {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, length = 11)
	private int id;
	
	@Column(name = "ma_nhanvien")
	private int maNhanVien;
	
	@Column(name = "ten_nhanvien")
	private String tenNhanVien;
	
	@Column(name = "tg_batdau")
	private Date tgBatDau;
	
	@Column(name = "tg_ketthuc")
	private Date tgKetThuc;
	
	@Column(name = "so_ngay_nghi")
	private int soNgayNghi;
	
	@Column(name = "loai_nghi_phep")
	private int loaiNghiPhep;
	
	@Column(name = "trang_thai")
	private int trangThai;

	public DonNghiPhepKhoann() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DonNghiPhepKhoann(int id, int maNhanVien, String tenNhanVien, Date tgBatDau, Date tgKetThuc, int soNgayNghi,
			int loaiNghiPhep, int trangThai) {
		super();
		this.id = id;
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.tgBatDau = tgBatDau;
		this.tgKetThuc = tgKetThuc;
		this.soNgayNghi = soNgayNghi;
		this.loaiNghiPhep = loaiNghiPhep;
		this.trangThai = trangThai;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(int maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public Date getTgBatDau() {
		return tgBatDau;
	}

	public void setTgBatDau(Date tgBatDau) {
		this.tgBatDau = tgBatDau;
	}

	public Date getTgKetThuc() {
		return tgKetThuc;
	}

	public void setTgKetThuc(Date tgKetThuc) {
		this.tgKetThuc = tgKetThuc;
	}

	public int getSoNgayNghi() {
		return soNgayNghi;
	}

	public void setSoNgayNghi(int soNgayNghi) {
		this.soNgayNghi = soNgayNghi;
	}

	public int getLoaiNghiPhep() {
		return loaiNghiPhep;
	}

	public void setLoaiNghiPhep(int loaiNghiPhep) {
		this.loaiNghiPhep = loaiNghiPhep;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	
}
