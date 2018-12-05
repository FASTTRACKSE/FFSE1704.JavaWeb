/**
 * 
 */
package fasttrackse.ffse1704.fbms.entity.quanlyduan.thongtinduan;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import fasttrackse.ffse1704.fbms.entity.quanlyduan.database.Database;
import fasttrackse.ffse1704.fbms.entity.quanlyduan.domain.Domain;
import fasttrackse.ffse1704.fbms.entity.quanlyduan.framework.Framework;
import fasttrackse.ffse1704.fbms.entity.quanlyduan.khachhang.KhachHang;
import fasttrackse.ffse1704.fbms.entity.quanlyduan.nhanvien.NhanVien;
import fasttrackse.ffse1704.fbms.entity.quanlyduan.nhanvienduan.NhanVienDuAn;
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
	 * One to Many
	 * 
	 */

	@OneToMany(mappedBy = "thongTinDuAn")
	private List<NhanVienDuAn> nhanVienDuAn = new ArrayList<NhanVienDuAn>();
	/*
	 * 
	 * end One to Many
	 * 
	 */

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
	 * end many to one
	 * 
	 */
	
	/*
	 * 
	 * 
	 * Many to Many
	 * 
	 * 
	 */
	// bi-directional many-to-one association to vendor
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "vendor_du_an", joinColumns = { @JoinColumn(name = "ma_du_an") }, inverseJoinColumns = {
			@JoinColumn(name = "ma_vendor") })
	Set<Vendor> vendor = new HashSet<>();

	// bi-directional many-to-one association to Technical
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "technical_du_an", joinColumns = { @JoinColumn(name = "ma_du_an") }, inverseJoinColumns = {
			@JoinColumn(name = "ma_technical") })
	Set<Technical> technical = new HashSet<>();

	// bi-directional many-to-one association to nhanVien
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "nhan_vien_du_an", joinColumns = { @JoinColumn(name = "ma_du_an") }, inverseJoinColumns = {
			@JoinColumn(name = "ma_nhan_vien") })
	Set<NhanVien> nhanVien = new HashSet<>();

	/*
	 * 
	 * end many to many
	 * 
	 */

	public ThongTinDuAn() {
		super();
	}

	public ThongTinDuAn(int id, @NotEmpty String maDuAn, @NotEmpty String tenDuAn, @NotEmpty String maKhachHang,
			@NotEmpty String moTa, @NotEmpty String phongDuAn, @NotEmpty String pM, @NotEmpty Date startDate,
			@NotEmpty Date endDate, @NotEmpty String maDomain, @NotEmpty String maFramework,
			@NotEmpty String maDatabase, @NotEmpty String maProgrammingLanguage, @NotEmpty String maTrangThai,
			List<NhanVienDuAn> nhanVienDuAn, KhachHang khachHang, @NotEmpty Framework framework,
			@NotEmpty Database database, @NotEmpty TrangThaiDuAn trangThaiDuAn, Domain domain,
			ProgrammingLanguage programmingLanguage, Set<Vendor> vendor, Set<Technical> technical,
			Set<NhanVien> nhanVien) {
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
		this.nhanVienDuAn = nhanVienDuAn;
		this.khachHang = khachHang;
		this.framework = framework;
		this.database = database;
		this.trangThaiDuAn = trangThaiDuAn;
		this.domain = domain;
		this.programmingLanguage = programmingLanguage;
		this.vendor = vendor;
		this.technical = technical;
		this.nhanVien = nhanVien;
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

	public Framework getFramework() {
		return framework;
	}

	public void setFramework(Framework framework) {
		this.framework = framework;
	}

	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}

	public TrangThaiDuAn getTrangThaiDuAn() {
		return trangThaiDuAn;
	}

	public void setTrangThaiDuAn(TrangThaiDuAn trangThaiDuAn) {
		this.trangThaiDuAn = trangThaiDuAn;
	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public ProgrammingLanguage getProgrammingLanguage() {
		return programmingLanguage;
	}

	public void setProgrammingLanguage(ProgrammingLanguage programmingLanguage) {
		this.programmingLanguage = programmingLanguage;
	}

	public Set<Vendor> getVendor() {
		return vendor;
	}

	public void setVendor(Set<Vendor> vendor) {
		this.vendor = vendor;
	}

	public Set<Technical> getTechnical() {
		return technical;
	}

	public void setTechnical(Set<Technical> technical) {
		this.technical = technical;
	}

	public List<NhanVienDuAn> getNhanVienDuAn() {
		return nhanVienDuAn;
	}

	public void setNhanVienDuAn(List<NhanVienDuAn> nhanVienDuAn) {
		this.nhanVienDuAn = nhanVienDuAn;
	}

	public Set<NhanVien> getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(Set<NhanVien> nhanVien) {
		this.nhanVien = nhanVien;
	}
}
