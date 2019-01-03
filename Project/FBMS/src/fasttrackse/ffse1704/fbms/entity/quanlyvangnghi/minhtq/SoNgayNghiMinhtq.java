package fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "quan_ly_so_ngay_nghi")
public class SoNgayNghiMinhtq implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "ma_nhan_vien")
	private String maNhanVien;

	@Column(name = "ma_ngay_nghi")
	private String maNgayNghi;

	@Column(name = "tong_ngay_duoc_nghi")
	private String tongNgayDuocNghi;

	@Column(name = "so_ngay_duoc_nghi")
	private String soNgayDuocNghi;

	@ManyToOne
	@JoinColumn(name = "ma_ngay_nghi", referencedColumnName = "ma_ngay_nghi", insertable = false, updatable = false, nullable = false)
	private LoaiNgayNghiMinhtq loaiNgayNghiDNP;

	public LoaiNgayNghiMinhtq getLoaiNgayNghiDNP() {
		return loaiNgayNghiDNP;
	}

	public void setLoaiNgayNghiDNP(LoaiNgayNghiMinhtq loaiNgayNghiDNP) {
		this.loaiNgayNghiDNP = loaiNgayNghiDNP;
	}

	
	public SoNgayNghiMinhtq(int id, String maNhanVien, String maNgayNghi, String tongNgayDuocNghi,
			String soNgayDuocNghi, LoaiNgayNghiMinhtq loaiNgayNghiDNP) {
		super();
		this.id = id;
		this.maNhanVien = maNhanVien;
		this.maNgayNghi = maNgayNghi;
		this.tongNgayDuocNghi = tongNgayDuocNghi;
		this.soNgayDuocNghi = soNgayDuocNghi;
		this.loaiNgayNghiDNP = loaiNgayNghiDNP;
	}

	public SoNgayNghiMinhtq() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getMaNgayNghi() {
		return maNgayNghi;
	}

	public void setMaNgayNghi(String maNgayNghi) {
		this.maNgayNghi = maNgayNghi;
	}

	public String getTongNgayDuocNghi() {
		return tongNgayDuocNghi;
	}

	public void setTongNgayDuocNghi(String tongNgayDuocNghi) {
		this.tongNgayDuocNghi = tongNgayDuocNghi;
	}

	public String getSoNgayDuocNghi() {
		return soNgayDuocNghi;
	}

	public void setSoNgayDuocNghi(String soNgayDuocNghi) {
		this.soNgayDuocNghi = soNgayDuocNghi;
	}

}
