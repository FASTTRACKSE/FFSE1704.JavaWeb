/**
 * 
 */
package fasttrackse.ffse1704.fbms.entity.quanlyduan.thongtinduan;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import fasttrackse.ffse1704.fbms.entity.quanlyduan.database.Database;
import fasttrackse.ffse1704.fbms.entity.quanlyduan.domain.Domain;
import fasttrackse.ffse1704.fbms.entity.quanlyduan.framework.Framework;
import fasttrackse.ffse1704.fbms.entity.quanlyduan.khachhang.KhachHang;
import fasttrackse.ffse1704.fbms.entity.quanlyduan.programminglanguage.ProgrammingLanguage;
import fasttrackse.ffse1704.fbms.entity.quanlyduan.technical.Technical;
import fasttrackse.ffse1704.fbms.entity.quanlyduan.trangthaiduan.TrangThaiDuAn;
import fasttrackse.ffse1704.fbms.entity.quanlyduan.vendor.Vendor;

/**
 * @author The persistent class for the quan_ly_thong_tin_du_an database table.
 *
 */

@Entity
@Table(name = "quan_ly_thong_tin_du_an")
public class ThongTinDuAn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, length = 11)
	private int id;

	@Column(name = "ma_du_an", nullable = false, length = 30)
	@NotEmpty
	private String maDuAn;

	@Column(name = "ten_du_an", nullable = false, length = 255)
	@NotEmpty
	private String tenDuAn;

	@Column(name = "ma_khach_hang", nullable = false, length = 30)
	@NotEmpty
	private String maKhachHang;

	@Column(name = "mo_ta", nullable = true, length = 255)
	@NotEmpty
	private String moTa;

	@Column(name = "phong_du_an", nullable = true, length = 30)
	@NotEmpty
	private String phongDuAn;

	@Column(name = "PM", nullable = true, length = 255)
	@NotEmpty
	private String pM;

	@Column(name = "start_date", nullable = true)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotEmpty
	private Date startDate;

	@Column(name = "end_date", nullable = true)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotEmpty
	private Date endDate;

	@Column(name = "ma_domain", nullable = false, length = 30)
	@NotEmpty
	private String maDomain;

	@Column(name = "ma_framework", nullable = false, length = 30)
	@NotEmpty
	private String maFramework;

	@Column(name = "ma_database", nullable = false, length = 30)
	@NotEmpty
	private String maDatabase;

	@Column(name = "ma_programming_language", nullable = false, length = 30)
	@NotEmpty
	private String maProgrammingLanguage;

	@Column(name = "ma_trang_thai", nullable = false, length = 30)
	@NotEmpty
	private String maTrangThai;

	/*
	 * 
	 * Many to one
	 * 
	 */
	// bi-directional many-to-one association to KhachHang
	@ManyToOne
	@JoinColumn(name = "ma_khach_hang", referencedColumnName = "ma_khach_hang", insertable = false, updatable = false, nullable = false)
	private KhachHang khachHang;

	// bi-directional many-to-one association to Framework
	@ManyToOne
	@JoinColumn(name = "ma_framework", referencedColumnName = "ma_framework", insertable = false, updatable = false, nullable = false)
	@NotEmpty
	private Framework framework;

	// bi-directional many-to-one association to Database
	@ManyToOne
	@JoinColumn(name = "ma_database", referencedColumnName = "ma_database", insertable = false, updatable = false, nullable = false)
	@NotEmpty
	private Database database;

	// bi-directional many-to-one association to TrangThaiDuAn
	@ManyToOne
	@JoinColumn(name = "ma_trang_thai", referencedColumnName = "ma_trang_thai", insertable = false, updatable = false, nullable = false)
	@NotEmpty
	private TrangThaiDuAn trangThaiDuAn;

	// bi-directional many-to-one association to Domain
	@ManyToOne
	@JoinColumn(name = "ma_domain", referencedColumnName = "ma_domain", insertable = false, updatable = false, nullable = false)
	private Domain domain;

	// bi-directional many-to-one association to ProgrammingLanguage
	@ManyToOne
	@JoinColumn(name = "ma_programming_language", referencedColumnName = "ma_programming_language", insertable = false, updatable = false, nullable = false)
	private ProgrammingLanguage programmingLanguage;

	/*
	 * 
	 * 
	 * Many to Many
	 * 
	 * 
	 */
	// bi-directional many-to-one association to Vendor
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "vendor_du_an", joinColumns = { @JoinColumn(name = "ma_du_an") }, inverseJoinColumns = {
			@JoinColumn(name = "ma_vendor") })
	Set<Vendor> vendor = new HashSet<>();

	// bi-directional many-to-one association to Technical
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "technical_du_an", joinColumns = { @JoinColumn(name = "ma_du_an") }, inverseJoinColumns = {
			@JoinColumn(name = "ma_technical") })
	Set<Technical> technical = new HashSet<>();

	public ThongTinDuAn() {
		super();
	}

	public ThongTinDuAn(int id, String maDuAn, String tenDuAn, String maKhachHang, String moTa, String phongDuAn,
			String pM, Date startDate, Date endDate, String maDomain, String maFramework, String maDatabase,
			String maProgrammingLanguage, String maTrangThai) {
		super();
		this.id = id;
		this.maDuAn = maDuAn;
		this.tenDuAn = tenDuAn;
		this.maKhachHang = maKhachHang;
		this.moTa = moTa;
		this.phongDuAn = phongDuAn;
		this.pM = pM;
		this.startDate = startDate;
		this.endDate = endDate;
		this.maDomain = maDomain;
		this.maFramework = maFramework;
		this.maDatabase = maDatabase;
		this.maProgrammingLanguage = maProgrammingLanguage;
		this.maTrangThai = maTrangThai;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaDuAn() {
		return maDuAn;
	}

	public void setMaDuAn(String maDuAn) {
		this.maDuAn = maDuAn;
	}

	public String getTenDuAn() {
		return tenDuAn;
	}

	public void setTenDuAn(String tenDuAn) {
		this.tenDuAn = tenDuAn;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getPhongDuAn() {
		return phongDuAn;
	}

	public void setPhongDuAn(String phongDuAn) {
		this.phongDuAn = phongDuAn;
	}

	public String getpM() {
		return pM;
	}

	public void setpM(String pM) {
		this.pM = pM;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getMaDomain() {
		return maDomain;
	}

	public void setMaDomain(String maDomain) {
		this.maDomain = maDomain;
	}

	public String getMaFramework() {
		return maFramework;
	}

	public void setMaFramework(String maFramework) {
		this.maFramework = maFramework;
	}

	public String getMaDatabase() {
		return maDatabase;
	}

	public void setMaDatabase(String maDatabase) {
		this.maDatabase = maDatabase;
	}

	public String getMaProgrammingLanguage() {
		return maProgrammingLanguage;
	}

	public void setMaProgrammingLanguage(String maProgrammingLanguage) {
		this.maProgrammingLanguage = maProgrammingLanguage;
	}

	public String getMaTrangThai() {
		return maTrangThai;
	}

	public void setMaTrangThai(String maTrangThai) {
		this.maTrangThai = maTrangThai;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
}
