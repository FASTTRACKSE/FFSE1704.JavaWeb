package fasttrackse.ffse1704.fbms.entity.quanlythoigian;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name = "qltg_logwork")
public class Logwork {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, length = 11)
	private int id;

	@Column(name = "ma_du_an", nullable = true, length = 11)
	private int maDuAn;

	@Column(name = "ma_nhan_vien", nullable = true, length = 11)
	private int maNhanVien;

	@Column(name = "ma_vai_tro", nullable = true, length = 11)
	private int maVaiTro;

	@Column(name = "ma_phong_ban", nullable = true, length = 11)
	private int maPhongBan;

	@Column(name = "ten_cong_viec", nullable = true, length = 11)
	private String tenCongViec;

	@Column(name = "mo_ta", nullable = true, length = 11)
	private String moTa;

	@Column(name = "trang_thai", nullable = true, length = 11)
	private String trangThai;

	@Column(name = "thoi_gian_bat_dau", nullable = true, length = 11)
	private String thoiGianBatDau;

	@Column(name = "thoi_gian_ket_thuc", nullable = true, length = 11)
	private String thoiGianKetThuc;

	@Column(name = "nhan_xet_PM", nullable = true, length = 11)
	private String nhanXetPM;

	@Column(name = "nhan_xet_tpp", nullable = true, length = 11)
	private String nhanXetTPP;

	public Logwork(int id, int maDuAn, int maNhanVien, int maVaiTro, int maPhongBan, String tenCongViec, String moTa,
			String trangThai, String thoiGianBatDau, String thoiGianKetThuc, String nhanXetPM, String nhanXetTPP) {
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

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getThoiGianBatDau() {
		return thoiGianBatDau;
	}

	public void setThoiGianBatDau(String thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}

	public String getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}

	public void setThoiGianKetThuc(String thoiGianKetThuc) {
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
}