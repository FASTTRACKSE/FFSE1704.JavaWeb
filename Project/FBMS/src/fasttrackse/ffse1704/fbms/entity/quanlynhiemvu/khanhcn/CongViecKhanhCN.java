package fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name = "thong_tin_cong_viec")
public class CongViecKhanhCN implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@NotNull
	private int id;

	@ManyToOne
	@JoinColumn(name = "ma_du_an", nullable = false, referencedColumnName = "ma_du_an", insertable = false, updatable = false)
	private DuAnKhanhCN duAnKhanhCN;

	@Column(name = "ma_du_an")
	
	private String maDuAn;

	public String getMaDuAn() {
		return maDuAn;
	}

	public void setMaDuAn(String maDuAn) {
		this.maDuAn = maDuAn;
	}

	@ManyToOne
	@JoinColumn(name = "ma_loai_congviec", nullable = false, referencedColumnName = "ma_loai_congviec", insertable = false, updatable = false)
	private LoaiCongViec loaiCongViec;

	@Column(name = "ma_loai_congviec")

	private String maLoaiCongViec;

	public String getMaLoaiCongViec() {
		return maLoaiCongViec;
	}

	public void setMaLoaiCongViec(String maLoaiCongViec) {
		this.maLoaiCongViec = maLoaiCongViec;
	}

	@Column(name = "ten_cong_viec")
	@NotEmpty
	private String tenCongViec;

	@Column(name = "mo_ta")
	private String moTa;

	@Column(name = "thoigian_batdau")
	@NotEmpty
	private String thoiGianBatDau;

	@Column(name = "thoigian_ketthuc")
	@NotEmpty
	private String thoiGianKetThuc;

	@ManyToOne
	@JoinColumn(name = "nguoi_duoc_phan_cong", nullable = false, referencedColumnName = "ma_nhan_vien", insertable = false, updatable = false)
	private NhanVienDuAn nhanVienDuAn;

	@Column(name = "nguoi_duoc_phan_cong")
	private String nguoiPhanCong;

	public String getNguoiPhanCong() {
		return nguoiPhanCong;
	}

	public void setNguoiPhanCong(String nguoiPhanCong) {
		this.nguoiPhanCong = nguoiPhanCong;
	}

	@Column(name = "thoigian_dukien_hoanthanh")

	private String thoiGianDuKienHoanThanh;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "trang_thai", referencedColumnName = "ma_trangthai", insertable = false, updatable = false, nullable = false)
	private TrangThaiKhanhCN trangThaiKhanhCN; // không phải cái này được lưu

	@Column(name = "trang_thai")
	@NotNull
	private int trangThai; // -> cái này cần lưu, jsp path để trỏ đến thuộc tính nay

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DuAnKhanhCN getDuAnKhanhCN() {
		return duAnKhanhCN;
	}

	public void setDuAnKhanhCN(DuAnKhanhCN duAnKhanhCN) {
		this.duAnKhanhCN = duAnKhanhCN;
	}

	public LoaiCongViec getLoaiCongViec() {
		return loaiCongViec;
	}

	public void setLoaiCongViec(LoaiCongViec loaiCongViec) {
		this.loaiCongViec = loaiCongViec;
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

	public String getThoiGianDuKienHoanThanh() {
		return thoiGianDuKienHoanThanh;
	}

	public void setThoiGianDuKienHoanThanh(String thoiGianDuKienHoanThanh) {
		this.thoiGianDuKienHoanThanh = thoiGianDuKienHoanThanh;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public CongViecKhanhCN() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NhanVienDuAn getNhanVienDuAn() {
		return nhanVienDuAn;
	}

	public void setNhanVienDuAn(NhanVienDuAn nhanVienDuAn) {
		this.nhanVienDuAn = nhanVienDuAn;
	}

	public TrangThaiKhanhCN getTrangThaiKhanhCN() {
		return trangThaiKhanhCN;
	}

	public void setTrangThaiKhanhCN(TrangThaiKhanhCN trangThaiKhanhCN) {
		this.trangThaiKhanhCN = trangThaiKhanhCN;
	}

	public CongViecKhanhCN(int id, DuAnKhanhCN duAnKhanhCN, LoaiCongViec loaiCongViec, @NotEmpty String tenCongViec,
			String moTa, @NotEmpty String thoiGianBatDau, @NotEmpty String thoiGianKetThuc, NhanVienDuAn nhanVienDuAn,
			@NotEmpty String thoiGianDuKienHoanThanh, TrangThaiKhanhCN trangThaiKhanhCN, int trangThai) {
		super();
		this.id = id;
		this.duAnKhanhCN = duAnKhanhCN;
		this.loaiCongViec = loaiCongViec;
		this.tenCongViec = tenCongViec;
		this.moTa = moTa;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.nhanVienDuAn = nhanVienDuAn;
		this.thoiGianDuKienHoanThanh = thoiGianDuKienHoanThanh;
		this.trangThaiKhanhCN = trangThaiKhanhCN;
		this.trangThai = trangThai;
	}

}
