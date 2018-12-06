package fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "minhtq_loai_ngay_nghi")
public class LoaiNgayNghiMinhtq {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "ma_loai_ngay_nghi")
	private int maNgayNghi;

	@Column(name = "ten_loai_ngay_nghi")
	private String tenNgayNghi;

	public LoaiNgayNghiMinhtq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoaiNgayNghiMinhtq(int id, int maNgayNghi, String tenNgayNghi) {
		super();
		this.maNgayNghi = maNgayNghi;
		this.tenNgayNghi = tenNgayNghi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMaNgayNghi() {
		return maNgayNghi;
	}

	public void setMaNgayNghi(int maNgayNghi) {
		this.maNgayNghi = maNgayNghi;
	}

	public String getTenNgayNghi() {
		return tenNgayNghi;
	}

	public void setTenNgayNghi(String tenNgayNghi) {
		this.tenNgayNghi = tenNgayNghi;
	}

}
