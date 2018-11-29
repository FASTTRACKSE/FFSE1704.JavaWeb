package fasttrackse.ffse1704.fbms.entity.quanlynhansu;

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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import fasttrackse.ffse1704.fbms.entity.security.ChucDanh;
import fasttrackse.ffse1704.fbms.entity.security.PhongBan;

@Entity
@Table(name = "ho_so_nhan_su")
public class NhanSu implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@NotEmpty(message = "Vui Lòng Nhập Mã nhân viên")
	@Column(name = "ma_nhan_vien", nullable = false)
	private String maNhanVien;

	@Column(name = "ma_phong_ban", nullable = false)
	@NotNull
	private String maPhongBan;

	@Column(name = "ma_chuc_danh", nullable = false)
	private String maChucDanh;

	@NotEmpty(message = "Vui Lòng Nhập họ hót của nhân viên")
	@Column(name = "ho_dem", nullable = false)
	private String hoLot;

	@NotEmpty(message = "Vui Lòng Nhập tên nhân viên")
	@Column(name = "ten", nullable = false)
	private String ten;

	@Column(name = "anh_dai_dien", nullable = false, length = 100)
	private String anhDaiDien;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "nam_sinh", nullable = false)
	@NotNull
	private Date namSinh;

	@Column(name = "gioi_tinh")
	@NotNull
	private int gioiTinh;

	@NotEmpty(message = "Vui Lòng Nhập quê quán nhân viên")
	@Column(name = "que_quan")
	private String queQuan;

	@NotEmpty(message = "Vui Lòng Nhập dân tộc nhân viên")
	@Column(name = "dan_toc")
	private String danToc;

	@Column(name = "ma_quoc_tich")
	@NotNull
	private String maQuocTich;

	
	@NotEmpty(message = "Vui Lòng Nhập nơi tạm trú")
	@Column(name = "noi_tam_tru")
	private String noiTamTru;

	@Column(name = "so_dien_thoai")
	@Pattern(regexp = "(^$|[0-9]{11})", message = "Số diện thoại không đúng")
	private String soDienThoai;

	@Column(name = "email")
	@Pattern(regexp = ".+@.+\\..+", message = "Định dạng email không đúng")
	private String email;

	@NotEmpty(message = "Vui Lòng Nhập số chứng minh thư")
	@Column(name = "so_cmnd")
	private String soCMND;

	@Column(name = "noi_cap_cmnd")
	@NotEmpty(message = "Vui Lòng Nhập nơi cấp")
	private String noiCap;

	@Column(name = "ngay_cap_cmnd")
	@NotNull
	private Date ngayCap;

	@Column(name = "trang_thai")
	@NotNull
	private int trangThai;

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

	public String getMaChucDanh() {
		return maChucDanh;
	}

	public void setMaChucDanh(String maChucDanh) {
		this.maChucDanh = maChucDanh;
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

	public int getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(int gioiTinh) {
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

	public String getMaQuocTich() {
		return maQuocTich;
	}

	public void setMaQuocTich(String maQuocTich) {
		this.maQuocTich = maQuocTich;
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

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public NhanSu(int id, @NotEmpty(message = "Vui Lòng Nhập Mã nhân viên") String maNhanVien,
			@NotNull String maPhongBan, String maChucDanh,
			@NotEmpty(message = "Vui Lòng Nhập họ hót của nhân viên") String hoLot,
			@NotEmpty(message = "Vui Lòng Nhập tên nhân viên") String ten, String anhDaiDien, @NotNull Date namSinh,
			@NotNull int gioiTinh, @NotEmpty(message = "Vui Lòng Nhập quê quán nhân viên") String queQuan,
			@NotEmpty(message = "Vui Lòng Nhập dân tộc nhân viên") String danToc, @NotNull String maQuocTich,
			@NotEmpty(message = "Vui Lòng Nhập nơi tạm trú") String noiTamTru,
			@Pattern(regexp = "(^$|[0-9]{11})", message = "Số diện thoại không đúng") String soDienThoai,
			@Pattern(regexp = ".+@.+\\..+", message = "Định dạng email không đúng") String email,
			@NotEmpty(message = "Vui Lòng Nhập số chứng minh thư") String soCMND,
			@NotEmpty(message = "Vui Lòng Nhập nơi cấp") String noiCap, @NotNull Date ngayCap, @NotNull int trangThai) {
		super();
		this.id = id;
		this.maNhanVien = maNhanVien;
		this.maPhongBan = maPhongBan;
		this.maChucDanh = maChucDanh;
		this.hoLot = hoLot;
		this.ten = ten;
		this.anhDaiDien = anhDaiDien;
		this.namSinh = namSinh;
		this.gioiTinh = gioiTinh;
		this.queQuan = queQuan;
		this.danToc = danToc;
		this.maQuocTich = maQuocTich;
		this.noiTamTru = noiTamTru;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.soCMND = soCMND;
		this.noiCap = noiCap;
		this.ngayCap = ngayCap;
		this.trangThai = trangThai;
	}

	public NhanSu() {
		super();
		// TODO Auto-generated constructor stub
	}


}
