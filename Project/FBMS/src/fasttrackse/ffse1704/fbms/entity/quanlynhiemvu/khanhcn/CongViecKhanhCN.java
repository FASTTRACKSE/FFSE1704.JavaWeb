package fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name = "tencongviec")
public class CongViecKhanhCN {

	@Id
	@Column(name = "id")
	@NotNull
	private int id;

	@Column(name = "ma_du_an")
	@NotEmpty
	private String maDuAn;

	@Column(name = "ma_loai_congviec")
	@NotEmpty
	private String maLoaiCongViec;

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

	@Column(name = "nguoi_duoc_phan_cong")
	@NotEmpty
	private String nguoiDuocPhanCong;

	@Column(name = "thoigian_dukien_hoanthanh")
	@NotEmpty
	private String thoiGianDuKienHoanThanh;

	public CongViecKhanhCN() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getMaLoaiCongViec() {
		return maLoaiCongViec;
	}

	public void setMaLoaiCongViec(String maLoaiCongViec) {
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

	


	public CongViecKhanhCN(int id, @NotEmpty String maDuAn, @NotEmpty String maLoaiCongViec,
			@NotEmpty String tenCongViec, @NotEmpty String moTa, @NotEmpty String thoiGianBatDau,
			@NotEmpty String thoiGianKetThuc, @NotEmpty String nguoiDuocPhanCong,
			@NotEmpty String thoiGianDuKienHoanThanh) {
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



	public String getNguoiDuocPhanCong() {
		return nguoiDuocPhanCong;
	}

	public void setNguoiDuocPhanCong(String nguoiDuocPhanCong) {
		this.nguoiDuocPhanCong = nguoiDuocPhanCong;
	}

	public String getThoiGianDuKienHoanThanh() {
		return thoiGianDuKienHoanThanh;
	}

	public void setThoiGianDuKienHoanThanh(String thoiGianDuKienHoanThanh) {
		this.thoiGianDuKienHoanThanh = thoiGianDuKienHoanThanh;
	}

}
