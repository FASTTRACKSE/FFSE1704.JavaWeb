package fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "minhtq_loai_ngay_nghi")
public class LoaiNgayNghiMinhtq implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "ma_loai_ngay_nghi")
	private String maNgayNghi;

	@Column(name = "ten_loai_ngay_nghi")
	private String tenLoaiNgayNghi;

	@OneToMany(mappedBy = "loaiNgayNghi")
	private Collection<DonNghiPhepMinhtq> donNghiPhepMinhtq;

	public Collection<DonNghiPhepMinhtq> getDonNghiPhepMinhtq() {
		return donNghiPhepMinhtq;
	}

	public void setDonNghiPhepMinhtq(Collection<DonNghiPhepMinhtq> donNghiPhepMinhtq) {
		this.donNghiPhepMinhtq = donNghiPhepMinhtq;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaNgayNghi() {
		return maNgayNghi;
	}

	public void setMaNgayNghi(String maNgayNghi) {
		this.maNgayNghi = maNgayNghi;
	}

	public String getTenLoaiNgayNghi() {
		return tenLoaiNgayNghi;
	}

	public void setTenLoaiNgayNghi(String tenLoaiNgayNghi) {
		this.tenLoaiNgayNghi = tenLoaiNgayNghi;
	}

	public LoaiNgayNghiMinhtq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoaiNgayNghiMinhtq(int id, String maNgayNghi, String tenLoaiNgayNghi,
			Collection<DonNghiPhepMinhtq> donNghiPhepMinhtq) {
		super();
		this.id = id;
		this.maNgayNghi = maNgayNghi;
		this.tenLoaiNgayNghi = tenLoaiNgayNghi;
		this.donNghiPhepMinhtq = donNghiPhepMinhtq;
	}

	
}
