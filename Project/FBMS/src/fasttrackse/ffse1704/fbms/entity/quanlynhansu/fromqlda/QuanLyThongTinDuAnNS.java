package fasttrackse.ffse1704.fbms.entity.quanlynhansu.fromqlda;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import fasttrackse.ffse1704.fbms.entity.quanlyduan.trangthaiduan.TrangThaiDuAn;

@Entity
@Table(name = "quan_ly_thong_tin_du_an")
public class QuanLyThongTinDuAnNS implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, length = 11)
	private int id;

	@ManyToOne
	@JoinColumn(name = "ma_du_an", referencedColumnName = "ma_du_an", insertable = false, updatable = false, nullable = false)
	@NotEmpty
	private PhanCongNhiemVuNS phanCongNhiemVuNS;

	@Column(name = "ten_du_an", nullable = false, length = 255)
	@NotEmpty
	private String tenDuAn;
	
	@Column(name = "ma_trang_thai", nullable = false, length = 30)
	@NotEmpty
	private String maTrangThai;
	
//	@ManyToOne
//	@JoinColumn(name = "ma_trang_thai", referencedColumnName = "ma_trang_thai", insertable = false, updatable = false, nullable = false)
//	@NotEmpty
//	private TrangThaiDuAnNS trangThaiDuAnNS;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PhanCongNhiemVuNS getPhanCongNhiemVuNS() {
		return phanCongNhiemVuNS;
	}

	public void setPhanCongNhiemVuNS(PhanCongNhiemVuNS phanCongNhiemVuNS) {
		this.phanCongNhiemVuNS = phanCongNhiemVuNS;
	}

	public String getTenDuAn() {
		return tenDuAn;
	}

	public void setTenDuAn(String tenDuAn) {
		this.tenDuAn = tenDuAn;
	}

	public String getMaTrangThai() {
		return maTrangThai;
	}

	public void setMaTrangThai(String maTrangThai) {
		this.maTrangThai = maTrangThai;
	}
}
