package fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "minhtq_trang_thai")
public class TrangThaiVangNghiMinhtq {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "ma_trang_thai")
	private int maTrangThai;

	@Column(name = "ten_trang_thai")
	private String tenTrangThai;

	public TrangThaiVangNghiMinhtq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TrangThaiVangNghiMinhtq(int id, int maTrangThai, String tenTrangThai) {
		super();
		this.id = id;
		this.maTrangThai = maTrangThai;
		this.tenTrangThai = tenTrangThai;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMaTrangThai() {
		return maTrangThai;
	}

	public void setMaTrangThai(int maTrangThai) {
		this.maTrangThai = maTrangThai;
	}

	public String getTenTrangThai() {
		return tenTrangThai;
	}

	public void setTenTrangThai(String tenTrangThai) {
		this.tenTrangThai = tenTrangThai;
	}

}
