package fasttrackse.ffse1704.fbms.entity.quanlyduan.nhanvien;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import fasttrackse.ffse1704.fbms.entity.quanlyduan.nhanvienduan.NhanVienDuAn;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.QuocTich;
import fasttrackse.ffse1704.fbms.entity.security.ChucDanh;
import fasttrackse.ffse1704.fbms.entity.security.PhongBan;

@Entity
@Table(name = "ho_so_nhan_su")
public class NhanVien implements Serializable {
	private static final long serialVersionUID = 1L;

	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NhanVien(int id, String maNhanVien, PhongBan phongBan, ChucDanh chucDanh, String hoLot, String ten,
			String anhDaiDien, @NotNull Date namSinh, @NotNull Integer gioiTinh, String queQuan, String danToc,
			QuocTich quocTich, String noiTamTru, String soDienThoai, String email, String soCMND, String noiCap,
			@NotNull Date ngayCap, @NotNull Integer trangThai, List<NhanVienDuAn> nhanVienDuAn) {
		super();
		this.id = id;
		this.maNhanVien = maNhanVien;
		this.phongBan = phongBan;
		this.chucDanh = chucDanh;
		this.hoLot = hoLot;
		this.ten = ten;
		this.anhDaiDien = anhDaiDien;
		this.namSinh = namSinh;
		this.gioiTinh = gioiTinh;
		this.queQuan = queQuan;
		this.danToc = danToc;
		this.quocTich = quocTich;
		this.noiTamTru = noiTamTru;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.soCMND = soCMND;
		this.noiCap = noiCap;
		this.ngayCap = ngayCap;
		this.trangThai = trangThai;
		this.nhanVienDuAn = nhanVienDuAn;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@Column(name = "ma_nhan_vien", nullable = false)
	private String maNhanVien;

	@ManyToOne
	@JoinColumn(name = "ma_phong_ban", nullable = false)
	private PhongBan phongBan;

	@ManyToOne
	@JoinColumn(name = "ma_chuc_danh", nullable = false)
	private ChucDanh chucDanh;

	@Column(name = "ho_dem", nullable = false)
	private String hoLot;

	@Column(name = "ten", nullable = false)
	private String ten;

	@Column(name = "anh_dai_dien", nullable = false, length = 100)
	private String anhDaiDien;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "nam_sinh", nullable = false)
	@NotNull
	private Date namSinh;

	@Column(name = "gioi_tinh")
	@NotNull
	private Integer gioiTinh;

	@Column(name = "que_quan")
	private String queQuan;

	@Column(name = "dan_toc")
	private String danToc;

	@Column(name = "quoc_tich")
	private QuocTich quocTich;

	@Column(name = "noi_tam_tru")
	private String noiTamTru;

	@Column(name = "so_dien_thoai")
	private String soDienThoai;

	@Column(name = "email")
	private String email;

	@Column(name = "so_cmnd")
	private String soCMND;

	@Column(name = "noi_cap_cmnd")
	private String noiCap;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ngay_cap_cmnd")
	@NotNull
	private Date ngayCap;

	@Column(name = "trang_thai")
	@NotNull
	private Integer trangThai;

	@OneToMany(mappedBy = "nhanVien")
	private List<NhanVienDuAn> nhanVienDuAn = new ArrayList<NhanVienDuAn>();

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

	public String getHoLot() {
		return hoLot;
	}

	public void setHoLot(String hoLot) {
		this.hoLot = hoLot;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getAnhDaiDien() {
		return anhDaiDien;
	}

	public void setAnhDaiDien(String anhDaiDien) {
		this.anhDaiDien = anhDaiDien;
	}

	public Date getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(Date namSinh) {
		this.namSinh = namSinh;
	}

	public Integer getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(Integer gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getQueQuan() {
		return queQuan;
	}

	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}

	public String getDanToc() {
		return danToc;
	}

	public void setDanToc(String danToc) {
		this.danToc = danToc;
	}

	public String getNoiTamTru() {
		return noiTamTru;
	}

	public void setNoiTamTru(String noiTamTru) {
		this.noiTamTru = noiTamTru;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoCMND() {
		return soCMND;
	}

	public void setSoCMND(String soCMND) {
		this.soCMND = soCMND;
	}

	public String getNoiCap() {
		return noiCap;
	}

	public void setNoiCap(String noiCap) {
		this.noiCap = noiCap;
	}

	public Date getNgayCap() {
		return ngayCap;
	}

	public void setNgayCap(Date ngayCap) {
		this.ngayCap = ngayCap;
	}

	public Integer getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(Integer trangThai) {
		this.trangThai = trangThai;
	}

	public PhongBan getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}

	public ChucDanh getChucDanh() {
		return chucDanh;
	}

	public void setChucDanh(ChucDanh chucDanh) {
		this.chucDanh = chucDanh;
	}

	public QuocTich getQuocTich() {
		return quocTich;
	}

	public List<NhanVienDuAn> getNhanVienDuAn() {
		return nhanVienDuAn;
	}

	public void setNhanVienDuAn(List<NhanVienDuAn> nhanVienDuAn) {
		this.nhanVienDuAn = nhanVienDuAn;
	}

	public void setQuocTich(QuocTich quocTich) {
		this.quocTich = quocTich;
	}

}
