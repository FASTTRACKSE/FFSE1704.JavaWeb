package fasttrackse.ffse1704.fbms.entity.quanlynhansu;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "thong_tin_hop_dong")
public class ThongTinHopDong implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", unique = true, nullable = false, length = 11)
	private int id;

	@Column(name = "ma_nhan_vien", nullable = false, length = 50)
	private String maNhanVien;

	@Column(name = "ma_hop_dong", nullable = false, length = 50)
	private String maHopDong;

	@Column(name = "ngay_bat_dau", nullable = false)
	private Date ngayBatDau;

	@Column(name = "ngay_ket_thuc", nullable = false)
	private Date ngayKetThuc;

	@Column(name = "luong_thang_13", nullable = false, length = 20)
	private int luongThang13;

	public ThongTinHopDong(int id, String maNhanVien, String maHopDong, Date ngayBatDau, Date ngayKetThuc,
			int luongThang13) {
		super();
		this.id = id;
		this.maNhanVien = maNhanVien;
		this.maHopDong = maHopDong;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.luongThang13 = luongThang13;
	}

	public ThongTinHopDong() {
	}

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

	public String getMaHopDong() {
		return maHopDong;
	}

	public void setMaHopDong(String maHopDong) {
		this.maHopDong = maHopDong;
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

	public int getLuongThang13() {
		return luongThang13;
	}

	public void setLuongThang13(int luongThang13) {
		this.luongThang13 = luongThang13;
	}

}
