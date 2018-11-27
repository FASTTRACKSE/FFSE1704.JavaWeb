package fasttrackse.ffse1704.fbms.entity.security;

import java.io.Serializable;
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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * The persistent class for the ho_so_nhan_vien database table.
 * 
 */
@Entity
@Table(name = "ho_so_nhan_vien")
public class HoSoNhanVien implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ma_nhan_vien", unique = true, nullable = false)
	private int maNhanVien;

	@Column(name = "anh_dai_dien", nullable = false, length = 100)
	private String anhDaiDien;

	@Column(nullable = false, length = 50)
	@NotEmpty
	@Email
	private String email;

	@Column(name = "gioi_tinh", nullable = false)
	@NotNull
	private Integer gioiTinh;

	@Column(name = "ho_dem", nullable = false, length = 50)
	@NotEmpty
	private String hoDem;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "nam_sinh", nullable = false)
	@NotNull
	private Date namSinh;

	@Column(name = "so_dien_thoai", nullable = false, length = 11)
	@Size(min = 10, max = 11)
	private String soDienThoai;

	@Column(nullable = false, length = 20)
	@NotEmpty
	private String ten;

	@Column(name = "trang_thai", nullable = false)
	@NotNull
	private Integer trangThai;

	// bi-directional many-to-one association to PhongBan
	@ManyToOne
	@JoinColumn(name = "ma_phong_ban", nullable = false)
	@NotNull
	private PhongBan phongBan;

	// bi-directional many-to-one association to ChucDanh
	@ManyToOne
	@JoinColumn(name = "ma_chuc_danh", nullable = false)
	@NotNull
	private ChucDanh chucDanh;

	public HoSoNhanVien() {
	}

	public int getMaNhanVien() {
		return this.maNhanVien;
	}

	public void setMaNhanVien(int maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getAnhDaiDien() {
		return this.anhDaiDien;
	}

	public void setAnhDaiDien(String anhDaiDien) {
		this.anhDaiDien = anhDaiDien;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getGioiTinh() {
		return this.gioiTinh;
	}

	public void setGioiTinh(Integer gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getHoDem() {
		return this.hoDem;
	}

	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}

	public Date getNamSinh() {
		return this.namSinh;
	}

	public void setNamSinh(Date namSinh) {
		this.namSinh = namSinh;
	}

	public String getSoDienThoai() {
		return this.soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getTen() {
		return this.ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public PhongBan getPhongBan() {
		return this.phongBan;
	}

	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}

	public ChucDanh getChucDanh() {
		return this.chucDanh;
	}

	public void setChucDanh(ChucDanh chucDanh) {
		this.chucDanh = chucDanh;
	}

	public Integer getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(Integer trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return "HoSoNhanVien [maNhanVien=" + maNhanVien + ", anhDaiDien=" + anhDaiDien 
				+ ", email=" + email + ", gioiTinh=" + gioiTinh + ", hoDem=" + hoDem + ", namSinh=" + namSinh
				+ ", soDienThoai=" + soDienThoai + ", ten=" + ten + ", trangThai=" + trangThai
				+ ", phongBan=" + phongBan + ", chucDanh=" + chucDanh + "]";
	}

}