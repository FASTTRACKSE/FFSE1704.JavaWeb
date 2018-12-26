package fasttrackse.ffse1704.fbms.entity.quanlynhansu;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "thong_tin_hop_dong")
public class ThongTinHopDong implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", unique = true, nullable = false, length = 11)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "ma_nhan_vien", referencedColumnName = "ma_nhan_vien", insertable = false, updatable = false, nullable = false)
	private NhanSu nhanSu;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "ma_cong_viec", referencedColumnName = "ma_vai_tro", insertable = false, updatable = false, nullable = false)
	private DanhSachCongViec congViec;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "ma_dia_diem_lam_viec", referencedColumnName = "id_dia_diem", insertable = false, updatable = false, nullable = false)
	private DiaDiemLamViec diaDiem;
	
	@Column(name = "ma_nhan_vien")
	@NotNull
	private String maNhanVien;
	
	@Column(name = "ma_hop_dong")
	private String maHopDong;
	
	@Column(name = "luong_thang_13")
	private String luongThang13;

	@Column(name = "ma_cong_viec")
	private String maCongViec;
	
	@Column(name = "ma_dia_diem_lam_viec")
	private String maDiaDiemLamViec;
	
	@Column(name = "muc_luong_ban_dau")
	@NotNull
	private int mucLuongBanDau;
	
	@Column(name = "so_ngay_nghi_trong_nam")
	@NotNull
	private int soNgayNghiTrongNam;
	
	@Column(name = "ngay_nghi_dac_biet")
	private String ngayNghiDacBiet;
	
	@Column(name = "hinh_thuc_tra_luong")
	private int hinhThucTraLuong;
	
	@Column(name = "thoi_gian_bat_dau_lam_viec")
	private String thoiGianBatDauLamViec;
	
	@Column(name = "thoi_gian_ket_thuc_lam_viec")
	private String thoiGianKetThucLamViec;
	
	public DanhSachCongViec getCongViec() {
		return congViec;
	}

	public void setCongViec(DanhSachCongViec congViec) {
		this.congViec = congViec;
	}

	public DiaDiemLamViec getDiaDiem() {
		return diaDiem;
	}

	public void setDiaDiem(DiaDiemLamViec diaDiem) {
		this.diaDiem = diaDiem;
	}

	public String getMaCongViec() {
		return maCongViec;
	}

	public void setMaCongViec(String maCongViec) {
		this.maCongViec = maCongViec;
	}

	public String getMaDiaDiemLamViec() {
		return maDiaDiemLamViec;
	}

	public void setMaDiaDiemLamViec(String maDiaDiemLamViec) {
		this.maDiaDiemLamViec = maDiaDiemLamViec;
	}

	public int getMucLuongBanDau() {
		return mucLuongBanDau;
	}

	public void setMucLuongBanDau(int mucLuongBanDau) {
		this.mucLuongBanDau = mucLuongBanDau;
	}

	public int getSoNgayNghiTrongNam() {
		return soNgayNghiTrongNam;
	}

	public void setSoNgayNghiTrongNam(int soNgayNghiTrongNam) {
		this.soNgayNghiTrongNam = soNgayNghiTrongNam;
	}

	public String getNgayNghiDacBiet() {
		return ngayNghiDacBiet;
	}

	public void setNgayNghiDacBiet(String ngayNghiDacBiet) {
		this.ngayNghiDacBiet = ngayNghiDacBiet;
	}

	public int getHinhThucTraLuong() {
		return hinhThucTraLuong;
	}

	public void setHinhThucTraLuong(int hinhThucTraLuong) {
		this.hinhThucTraLuong = hinhThucTraLuong;
	}

	

	public String getThoiGianBatDauLamViec() {
		return thoiGianBatDauLamViec;
	}

	public void setThoiGianBatDauLamViec(String thoiGianBatDauLamViec) {
		this.thoiGianBatDauLamViec = thoiGianBatDauLamViec;
	}

	public String getThoiGianKetThucLamViec() {
		return thoiGianKetThucLamViec;
	}

	public void setThoiGianKetThucLamViec(String thoiGianKetThucLamViec) {
		this.thoiGianKetThucLamViec = thoiGianKetThucLamViec;
	}

	public String getMaHopDong() {
		return maHopDong;
	}

	public void setMaHopDong(String maHopDong) {
		this.maHopDong = maHopDong;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getLuongThang13() {
		return luongThang13;
	}

	public void setLuongThang13(String luongThang13) {
		this.luongThang13 = luongThang13;
	}

	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "ma_hop_dong",referencedColumnName = "ma_hop_dong", nullable = false, insertable = false, updatable = false)
	private HopDong loaihopDong;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ngay_bat_dau", nullable = false)
	private Date ngayBatDau;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ngay_ket_thuc", nullable = false)
	private Date ngayKetThuc;

	
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "luong_thang_13",referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
	private CheDoHuong cheDoHuong;

	public ThongTinHopDong() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public NhanSu getNhanSu() {
		return nhanSu;
	}

	public void setNhanSu(NhanSu nhanSu) {
		this.nhanSu = nhanSu;
	}

	public HopDong getLoaihopDong() {
		return loaihopDong;
	}

	public void setLoaihopDong(HopDong loaihopDong) {
		this.loaihopDong = loaihopDong;
	}

	public Date getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public CheDoHuong getCheDoHuong() {
		return cheDoHuong;
	}

	public void setCheDoHuong(CheDoHuong cheDoHuong) {
		this.cheDoHuong = cheDoHuong;
	}


}
