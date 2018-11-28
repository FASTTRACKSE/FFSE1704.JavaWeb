package fasttrackse.ffse1704.fbms.entity.logwork;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="thoi_gian_cong_viec")
public class ThoiGianLamViec {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, length = 11)
	private int id;
	
	@Column(name="ma_du_an" ,nullable = true,length = 11)
	private int maDuAn;
	
	@Column(name="ma_nhan_vien", nullable = true,length = 11)
	private int maNhanVien;
	
	@Column(name="ma_vai_tro", nullable = true,length = 11)
	private int maVaiTro;
	
	@Column(name="ma_phong_ban",nullable = true,length = 11)
	private int maPhongBan;
	
	
	@Column(name="ten_cong_viec", nullable = true)
	private String tenCongViec;
	
	@Column(name="mo_ta", nullable = true)
	private String moTa;
	
	@Column(name="trang_thai", nullable = true,length = 11)
	private int trangThai;
	
	@Column(name="thoi_gian_bat_dau", nullable = true)
	private Date thoiGianBatDau;
	
	@Column(name="thoi_gian_ket_thuc", nullable = true)
	private Date thoiGianKetThuc;
	
	@Column(name="nhan_xet_PM", nullable = true)
	private String nhanXetPM;
	
	@Column(name="nhan_xet_tpp", nullable = true)
	private String nhanXetTPP;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public int getMaDuAn() {
		return maDuAn;
	}

	public void setMaDuAn(int maDuAn) {
		this.maDuAn = maDuAn;
	}

	public int getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(int maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public int getMaVaiTro() {
		return maVaiTro;
	}

	public void setMaVaiTro(int maVaiTro) {
		this.maVaiTro = maVaiTro;
	}

	public int getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(int maPhongBan) {
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

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
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

	public ThoiGianLamViec() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ThoiGianLamViec(int id, int maDuAn, int maNhanVien, int maVaiTro, int maPhongBan, String tenCongViec,
			String moTa, int trangThai, Date thoiGianBatDau, Date thoiGianKetThuc, String nhanXetPM,
			String nhanXetTPP) {
		super();
		this.id = id;
		this.maDuAn = maDuAn;
		this.maNhanVien = maNhanVien;
		this.maVaiTro = maVaiTro;
		this.maPhongBan = maPhongBan;
		this.tenCongViec = tenCongViec;
		this.moTa = moTa;
		this.trangThai = trangThai;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.nhanXetPM = nhanXetPM;
		this.nhanXetTPP = nhanXetTPP;
	}

	
	
	
	
}
