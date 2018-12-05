package fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "minhtq_trang_thai")
public class TrangThaiVangNghiMinhtq {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "ma_trang_thai")
	@NotNull
	private String maTrangThai;

	@Column(name = "ten_trang_thai")
	@NotEmpty
	private String tenTrangThai;

	public TrangThaiVangNghiMinhtq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TrangThaiVangNghiMinhtq(int id, String maTrangThai, String tenTrangThai) {
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

	public String getMaTrangThai() {
		return maTrangThai;
	}

	public void setMaTrangThai(String maTrangThai) {
		this.maTrangThai = maTrangThai;
	}

	public String getTenTrangThai() {
		return tenTrangThai;
	}

	public void setTenTrangThai(String tenTrangThai) {
		this.tenTrangThai = tenTrangThai;
	}

}
