package fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="minhtq_loai_ngay_nghi")
public class LoaiNgayNghiMinhtq {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "ma_loai_ngay_nghi")
	private int maLoaiNgayNghi;
	
	@Column(name = "ten_loai_ngay_nghi")
	private String  tenLoaiNgayNghi;

	public LoaiNgayNghiMinhtq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoaiNgayNghiMinhtq(int id, int maLoaiNgayNghi, String tenLoaiNgayNghi) {
		super();
		this.id = id;
		this.maLoaiNgayNghi = maLoaiNgayNghi;
		this.tenLoaiNgayNghi = tenLoaiNgayNghi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMaLoaiNgayNghi() {
		return maLoaiNgayNghi;
	}

	public void setMaLoaiNgayNghi(int maLoaiNgayNghi) {
		this.maLoaiNgayNghi = maLoaiNgayNghi;
	}

	public String getTenLoaiNgayNghi() {
		return tenLoaiNgayNghi;
	}

	public void setTenLoaiNgayNghi(String tenLoaiNgayNghi) {
		this.tenLoaiNgayNghi = tenLoaiNgayNghi;
	}
	
	
	
}
