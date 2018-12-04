package fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.khoann;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "khoann_don_nghi_phep")
public class DonNghiPhepKhoann {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, length = 11)
	private int id;
	
	
	@Column(name = "ma_nhanvien")
	private int maNhanVien;

	@Column(name = "tg_batdau")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date tgBatDau;

	@Column(name = "tg_ketthuc")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date tgKetThuc;

	
	@Column(name = "so_ngay_nghi")
	private int soNgayNghi;
	
	@ManyToOne
	@JoinColumn(name = "loai_nghi_phep")
	private LoaiHinhNghiPhepKhoann loaihinhentity;

	public LoaiHinhNghiPhepKhoann getLoaihinhentity() {
		return loaihinhentity;
	}

	public void setLoaihinhentity(LoaiHinhNghiPhepKhoann loaihinhentity) {
		this.loaihinhentity = loaihinhentity;
	}

	@Column(name = "trang_thai")
	private int trangThai;
	
	
	

	



	

	public DonNghiPhepKhoann(int id, int maNhanVien, Date tgBatDau, Date tgKetThuc, int soNgayNghi,
			LoaiHinhNghiPhepKhoann loaihinhentity, int trangThai) {
		super();
		this.id = id;
		this.maNhanVien = maNhanVien;
		this.tgBatDau = tgBatDau;
		this.tgKetThuc = tgKetThuc;
		this.soNgayNghi = soNgayNghi;
		this.loaihinhentity = loaihinhentity;
		this.trangThai = trangThai;
	}

	public DonNghiPhepKhoann() {
		super();
		// TODO Auto-generated constructor stub
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

	

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

}
