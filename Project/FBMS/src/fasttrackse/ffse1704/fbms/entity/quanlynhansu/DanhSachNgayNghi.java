package fasttrackse.ffse1704.fbms.entity.quanlynhansu;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "danh_sach_ngay_nghi")
public class DanhSachNgayNghi implements Serializable {
	/**
	 * 	
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "ma_ngay_nghi")
	private String maNgayNghi;
	
	@Column(name = "ten_ngay_nghi")
	private String tenNgayNghi;
	

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

	public String getTenNgayNghi() {
		return tenNgayNghi;
	}

	public void setTenNgayNghi(String tenNgayNghi) {
		this.tenNgayNghi = tenNgayNghi;
	}
}
