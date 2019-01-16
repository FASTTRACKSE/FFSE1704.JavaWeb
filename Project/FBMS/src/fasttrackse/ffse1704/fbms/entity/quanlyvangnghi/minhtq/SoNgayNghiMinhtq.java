package fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private int tongNgayDuocNghi;

	@Column(name = "so_ngay_da_nghi")
	private int soNgayDaNghi;

	@ManyToOne
	@JoinColumn(name = "ma_ngay_nghi", referencedColumnName = "ma_ngay_nghi", insertable = false, updatable = false, nullable = false)
	private LoaiNgayNghiMinhtq loaiNgayNghiPhepDNP;

	public LoaiNgayNghiMinhtq getLoaiNgayNghiPhepDNP() {
		return loaiNgayNghiPhepDNP;
	}

	public void setLoaiNgayNghiPhepDNP(LoaiNgayNghiMinhtq loaiNgayNghiPhepDNP) {
		this.loaiNgayNghiPhepDNP = loaiNgayNghiPhepDNP;
	}

	// liên kết với bảng số ngày nghỉ
	@OneToMany(mappedBy = "soNgayNghiDNP")
	private Collection<DonNghiPhepMinhtq> donNghiPhepMinhtq;

	public SoNgayNghiMinhtq(int id, String maNhanVien, String maNgayNghi, int tongNgayDuocNghi, int soNgayDaNghi,
			LoaiNgayNghiMinhtq loaiNgayNghiPhepDNP, Collection<DonNghiPhepMinhtq> donNghiPhepMinhtq) {
		super();
		this.id = id;
		this.maNhanVien = maNhanVien;
		this.maNgayNghi = maNgayNghi;
		this.tongNgayDuocNghi = tongNgayDuocNghi;
		this.soNgayDaNghi = soNgayDaNghi;
		this.loaiNgayNghiPhepDNP = loaiNgayNghiPhepDNP;
		this.donNghiPhepMinhtq = donNghiPhepMinhtq;
	}

	public Collection<DonNghiPhepMinhtq> getDonNghiPhepMinhtq() {
		return donNghiPhepMinhtq;
	}

	public void setDonNghiPhepMinhtq(Collection<DonNghiPhepMinhtq> donNghiPhepMinhtq) {
		this.donNghiPhepMinhtq = donNghiPhepMinhtq;
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

	public int getTongNgayDuocNghi() {
		return tongNgayDuocNghi;
	}

	public void setTongNgayDuocNghi(int tongNgayDuocNghi) {
		this.tongNgayDuocNghi = tongNgayDuocNghi;
	}

	public int getSoNgayDaNghi() {
		return soNgayDaNghi;
	}

	public void setSoNgayDaNghi(int soNgayDaNghi) {
		this.soNgayDaNghi = soNgayDaNghi;
	}

}
