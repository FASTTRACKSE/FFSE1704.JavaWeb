package fasttrackse.ffse1704.fbms.entity.quanlynhansu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "danh_sach_ngay_nghi")
public class DanhSachNgayNghi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private String maNgayNghi;
	
	@Column(name = "ten_ngay_nghi")
	private String tenNgayNghi;

	public String getMaNgayNghi() {
		return maNgayNghi;
	}

	public void setMaNgayNghi(String maNgayNghi) {
		this.maNgayNghi = maNgayNghi;
	}

	public String getTenNgayNghi() {
		return tenNgayNghi;
	}

	public void setTenNgayNghi(String tenNgayNghi) {
		this.tenNgayNghi = tenNgayNghi;
	}
}
