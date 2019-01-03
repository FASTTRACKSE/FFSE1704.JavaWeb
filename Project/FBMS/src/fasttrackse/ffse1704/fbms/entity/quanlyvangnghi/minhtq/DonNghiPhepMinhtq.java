package fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq;

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
@Table(name = "minhtq_don_nghi_phep")
public class DonNghiPhepMinhtq {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "ma_nhan_vien")
	private String maNhanVien;

	@Column(name = "ma_phong_ban")
	private String maPhongBan;

	@Column(name = "loai_ngay_nghi")
	private String loaiNgayNghi;

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

	@Column(name = "ghi_chu")
	private String ghiChu;

	@Column(name = "trang_thai")
	private String trangThai;

	// hồ sơ nhân viên
	@ManyToOne
	@JoinColumn(name = "ma_nhan_vien", referencedColumnName = "ma_nhan_vien", insertable = false, updatable = false, nullable = false)
	private HoSoNhanVienMinhtq hoSoNhanVien;

	public HoSoNhanVienMinhtq getHoSoNhanVien() {
		return hoSoNhanVien;
	}

	public void setHoSoNhanVien(HoSoNhanVienMinhtq hoSoNhanVien) {
		this.hoSoNhanVien = hoSoNhanVien;
	}

	// liên kết với bảng phòng ban
	@ManyToOne
	@JoinColumn(name = "ma_phong_ban", referencedColumnName = "ma_phong_ban", insertable = false, updatable = false, nullable = false)
	private PhongBanMinhtq phongBan;

	public PhongBanMinhtq getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(PhongBanMinhtq phongBan) {
		this.phongBan = phongBan;
	}

	// liên kết với bảng loại ngày nghỉ
	@ManyToOne
	@JoinColumn(name = "loai_ngay_nghi", referencedColumnName = "ma_ngay_nghi", insertable = false, updatable = false, nullable = false)
	private LoaiNgayNghiMinhtq loaiNgayNghiPhep;

	public LoaiNgayNghiMinhtq getLoaiNgayNghiPhep() {
		return loaiNgayNghiPhep;
	}

	public void setLoaiNgayNghiPhep(LoaiNgayNghiMinhtq loaiNgayNghiPhep) {
		this.loaiNgayNghiPhep = loaiNgayNghiPhep;
	}

	// liên kết với bảng trạng thái
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

	public String getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	public String getLoaiNgayNghi() {
		return loaiNgayNghi;
	}

	public void setLoaiNgayNghi(String loaiNgayNghi) {
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

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public DonNghiPhepMinhtq(int id, String maNhanVien, String maPhongBan, String loaiNgayNghi, int soLuong,
			Date thoiGianBatDau, Date thoiGianKetThuc, String ghiChu, String trangThai, HoSoNhanVienMinhtq hoSoNhanVien,
			PhongBanMinhtq phongBan, LoaiNgayNghiMinhtq loaiNgayNghiPhep, TrangThaiVangNghiMinhtq trangThaiDNP) {
		super();	
		this.id = id;
		this.maNhanVien = maNhanVien;
		this.maPhongBan = maPhongBan;
		this.loaiNgayNghi = loaiNgayNghi;
		this.soLuong = soLuong;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.ghiChu = ghiChu;
		this.trangThai = trangThai;
		this.hoSoNhanVien = hoSoNhanVien;
		this.phongBan = phongBan;
		this.loaiNgayNghiPhep = loaiNgayNghiPhep;
		this.trangThaiDNP = trangThaiDNP;
	}

	public DonNghiPhepMinhtq() {
		super();
		// TODO Auto-generated constructor stub
	}

}
