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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import fasttrackse.ffse1704.fbms.entity.quanlyduan.technical.Technical;

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

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "maKhachHang", referencedColumnName = "maKhachHang",
	 * nullable = false) private KhachHang khachHang;
	 */

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

	/*@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "technical_du_an", joinColumns = { @JoinColumn(name = "ma_du_an") }, inverseJoinColumns = {
			@JoinColumn(name = "ma_technical") })
	Set<Technical> technical = new HashSet<>();*/

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
}
