package fasttrackse.ffse1704.fbms.entity.logwork;

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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "thoi_gian_cong_viec")
public class ThoiGianLamViec {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, length = 11)
	private int id;

	@ManyToOne()
	@JoinColumn(name = "ma_du_an")
	private VuDuAnLogwork maDuAn;

	public VuDuAnLogwork getMaDuAn() {
		return maDuAn;
	}

	@ManyToOne
	@JoinColumn(name = "ma_nhan_vien", nullable = false, referencedColumnName = "ma_nhan_vien")
	private VuNhanVien maNhanVien;

	@ManyToOne
	@JoinColumn(name = "ma_vai_tro", nullable = false, referencedColumnName = "ma_vai_tro")
	private VuVaiTroDuAn maVaiTroDuAn;

	@ManyToOne
	@JoinColumn(name = "ma_phong_ban", nullable = false, referencedColumnName = "ma_phong_ban")
	private VuPhongBan maPhongBan;

	@ManyToOne
	@JoinColumn(name = "trang_thai", nullable = false, referencedColumnName = "id_trang_thai")
	private VuTrangThai trangThaiLogwork;

	@Column(name = "ten_cong_viec", nullable = true, length = 255)
	private String tenCongViec;

	@Column(name = "mo_ta", nullable = true, length = 11)
	private String moTa;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	@Column(name = "thoi_gian_bat_dau", nullable = true)
	private Date thoiGianBatDau;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	@Column(name = "thoi_gian_ket_thuc", nullable = true)
	private Date thoiGianKetThuc;
	
	@Transient
	private long tongThoiGian; // = thoiGianKetThuc - thoiGianBatDau

	public long getTongThoiGian() {
		long secs = (this.thoiGianKetThuc.getTime() - this.thoiGianBatDau.getTime()) / 1000;
		long mins = secs / 60;    
		long hours = mins/60;
		return hours;
	}

	public void setTongThoiGian(long tongThoiGian) {
		this.tongThoiGian = tongThoiGian;
	}

	@Column(name = "nhan_xet_PM", nullable = true)
	private String nhanXetPM;

	@Column(name = "nhan_xet_tpp", nullable = true)
	private String nhanXetTPP;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenCongViec() {
		return tenCongViec;
	}

	public void setTenCongViec(String tenCongViec) {
		this.tenCongViec = tenCongViec;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
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

	public String getNhanXetPM() {
		return nhanXetPM;
	}

	public void setNhanXetPM(String nhanXetPM) {
		this.nhanXetPM = nhanXetPM;
	}

	public String getNhanXetTPP() {
		return nhanXetTPP;
	}

	public void setNhanXetTPP(String nhanXetTPP) {
		this.nhanXetTPP = nhanXetTPP;
	}

	public VuNhanVien getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(VuNhanVien maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public VuVaiTroDuAn getMaVaiTroDuAn() {
		return maVaiTroDuAn;
	}

	public void setMaVaiTroDuAn(VuVaiTroDuAn maVaiTroDuAn) {
		this.maVaiTroDuAn = maVaiTroDuAn;
	}

	public VuPhongBan getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(VuPhongBan maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	public VuTrangThai getTrangThaiLogwork() {
		return trangThaiLogwork;
	}

	public void setTrangThaiLogwork(VuTrangThai trangThaiLogwork) {
		this.trangThaiLogwork = trangThaiLogwork; 
	}

	public void setMaDuAn(VuDuAnLogwork maDuAn) {
		this.maDuAn = maDuAn;
	}

	public ThoiGianLamViec() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ThoiGianLamViec(int id, VuDuAnLogwork maDuAn, VuNhanVien maNhanVien, VuVaiTroDuAn maVaiTroDuAn,
			VuPhongBan maPhongBan, VuTrangThai trangThaiLogwork, String tenCongViec, String moTa, Date thoiGianBatDau,
			Date thoiGianKetThuc, String nhanXetPM, String nhanXetTPP) {
		super();
		this.id = id;
		this.maDuAn = maDuAn;
		this.maNhanVien = maNhanVien;
		this.maVaiTroDuAn = maVaiTroDuAn;
		this.maPhongBan = maPhongBan;
		this.trangThaiLogwork = trangThaiLogwork;
		this.tenCongViec = tenCongViec;
		this.moTa = moTa;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.nhanXetPM = nhanXetPM;
		this.nhanXetTPP = nhanXetTPP;
	}

}
