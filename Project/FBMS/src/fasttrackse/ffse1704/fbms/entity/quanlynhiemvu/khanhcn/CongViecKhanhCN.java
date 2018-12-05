package fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.internal.NotNull;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.NhanSu;

@Entity
@Table(name = "tencongviec")
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
	@JoinColumn(name = "ma_du_an", nullable = false, referencedColumnName = "ma_du_an")
	private DuAnKhanhCN maDuAn;

	@ManyToOne
	@JoinColumn(name = "ma_loai_congviec", nullable = false, referencedColumnName = "ma_loai_congviec")
	@NotNull
	private LoaiCongViec maLoaiCongViec;

	@Column(name = "ten_cong_viec")
	@NotEmpty
	private String tenCongViec;

	@Column(name = "mo_ta")
	@NotEmpty
	private String moTa;

	@Column(name = "thoigian_batdau")
	@NotEmpty
	private String thoiGianBatDau;

	@Column(name = "thoigian_ketthuc")
	@NotEmpty
	private String thoiGianKetThuc;

	@ManyToOne
	@JoinColumn(name = "nguoi_duoc_phan_cong", nullable = false, referencedColumnName = "ma_nhan_vien", insertable = false, updatable = false)
	private NhanVienKhanhCN nguoiDuocPhanCong;

	@Column(name = "thoigian_dukien_hoanthanh")
	@NotEmpty
	private String thoiGianDuKienHoanThanh;

	@ManyToOne
	@JoinColumn(name = "trang_thai", nullable = false, referencedColumnName = "ma_trangthai", insertable = false, updatable = false)
	@NotNull
	private TrangThaiKhanhCN maTrangThai;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DuAnKhanhCN getMaDuAn() {
		return maDuAn;
	}

	public void setMaDuAn(DuAnKhanhCN maDuAn) {
		this.maDuAn = maDuAn;
	}

	public LoaiCongViec getMaLoaiCongViec() {
		return maLoaiCongViec;
	}

	public void setMaLoaiCongViec(LoaiCongViec maLoaiCongViec) {
		this.maLoaiCongViec = maLoaiCongViec;
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

	public NhanVienKhanhCN getNguoiDuocPhanCong() {
		return nguoiDuocPhanCong;
	}

	public void setNguoiDuocPhanCong(NhanVienKhanhCN nguoiDuocPhanCong) {
		this.nguoiDuocPhanCong = nguoiDuocPhanCong;
	}

	public String getThoiGianDuKienHoanThanh() {
		return thoiGianDuKienHoanThanh;
	}

	public void setThoiGianDuKienHoanThanh(String thoiGianDuKienHoanThanh) {
		this.thoiGianDuKienHoanThanh = thoiGianDuKienHoanThanh;
	}

	public TrangThaiKhanhCN getMaTrangThai() {
		return maTrangThai;
	}

	public void setMaTrangThai(TrangThaiKhanhCN maTrangThai) {
		this.maTrangThai = maTrangThai;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public CongViecKhanhCN() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CongViecKhanhCN(int id, DuAnKhanhCN maDuAn, LoaiCongViec maLoaiCongViec, @NotEmpty String tenCongViec,
			@NotEmpty String moTa, @NotEmpty String thoiGianBatDau, @NotEmpty String thoiGianKetThuc,
			NhanVienKhanhCN nguoiDuocPhanCong, @NotEmpty String thoiGianDuKienHoanThanh, TrangThaiKhanhCN maTrangThai) {
		super();
		this.id = id;
		this.maDuAn = maDuAn;
		this.maLoaiCongViec = maLoaiCongViec;
		this.tenCongViec = tenCongViec;
		this.moTa = moTa;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.nguoiDuocPhanCong = nguoiDuocPhanCong;
		this.thoiGianDuKienHoanThanh = thoiGianDuKienHoanThanh;
		this.maTrangThai = maTrangThai;
	}

}
