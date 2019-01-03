package fasttrackse.ffse1704.fbms.entity.quanlythoigian;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.util.Date;

import javax.persistence.Column;

@Entity
@Table(name = "qltg_logwork")
public class Logwork {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, length = 11)
	private int id;

	@ManyToOne()
	@JoinColumn(name = "ma_du_an")
	private DuAnLogwork maDuAn;

	public DuAnLogwork getMaDuAn() {
		return maDuAn;
	}

	@ManyToOne
	@JoinColumn(name = "ma_nhan_vien", nullable = false, referencedColumnName = "ma_nhan_vien")
	private NhanVienLogwork maNhanVien;

	public VaiTroDuAnLogwork getMaVaiTroDuAn() {
		return maVaiTroDuAn;
	}

	public void setMaVaiTroDuAn(VaiTroDuAnLogwork maVaiTroDuAn) {
		this.maVaiTroDuAn = maVaiTroDuAn;
	}

	@ManyToOne
	@JoinColumn(name = "ma_vai_tro", nullable = false, referencedColumnName = "ma_vai_tro")
	private VaiTroDuAnLogwork maVaiTroDuAn;
	
	public void setMaVaiTro(VaiTroDuAnLogwork maVaiTro) {
		this.maVaiTroDuAn = maVaiTro;
	}

	@ManyToOne
	@JoinColumn(name = "ma_phong_ban", nullable = false, referencedColumnName = "ma_phong_ban")
	private PhongBanLogwork maPhongBan;
	
	@ManyToOne
	@JoinColumn(name = "trang_thai", nullable = false, referencedColumnName = "id_trang_thai")
	private TrangThaiLogwork trangThaiLogwork;
	
	public NhanVienLogwork getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(NhanVienLogwork maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	@Column(name = "ten_cong_viec", nullable = true, length = 255)
	private String tenCongViec;

	@Column(name = "mo_ta", nullable = true, length = 11)
	private String moTa;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	@Column(name = "thoi_gian_bat_dau", nullable = true)
	@NotNull	
	private Date thoiGianBatDau;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	@Column(name = "thoi_gian_ket_thuc", nullable = true)
	@NotNull
	private Date thoiGianKetThuc;

	@Column(name = "nhan_xet_PM", nullable = true)
	private String nhanXetPM;

	@Column(name = "nhan_xet_tpp", nullable = true)
	private String nhanXetTPP;

	public TrangThaiLogwork getTrangThaiLogwork() {
		return trangThaiLogwork;
	}

	public void setTrangThaiLogwork(TrangThaiLogwork trangThaiLogwork) {
		this.trangThaiLogwork = trangThaiLogwork;
	}

	public Logwork() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	

	public Logwork(int id, DuAnLogwork maDuAn, NhanVienLogwork maNhanVien, VaiTroDuAnLogwork maVaiTroDuAn,
			PhongBanLogwork maPhongBan, TrangThaiLogwork trangThaiLogwork, String tenCongViec, String moTa,
			Date thoiGianBatDau, Date thoiGianKetThuc, String nhanXetPM, String nhanXetTPP) {
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

	public PhongBanLogwork getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(PhongBanLogwork maPhongBan) {
		this.maPhongBan = maPhongBan;
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


	public Date getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}

	public void setThoiGianKetThuc(Date thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}

	public void setThoiGianBatDau(Date thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
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

	public void setMaDuAn(DuAnLogwork maDuAn) {
		this.maDuAn = maDuAn;
	}
}