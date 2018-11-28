package fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.thachmh;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trang_thai")
public class TrangThai {

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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "ma_trang_thai")
	private String maTrangThai;

	@Column(name = "ten_trang_thai")
	private String tenTrangThai;
}
