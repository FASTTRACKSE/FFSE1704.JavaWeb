package fasttrackse.ffse1704.fbms.entity.quanlynhansu;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trang_thai_hop_dong")
public class TrangThaiHopDong implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", unique = true, nullable = false, length = 11)
	private int id;
	
	@Column(name = "ma_trang_thai", nullable = false)
	private String maTrangThai;
	
	@Column(name = "ten_trang_thai", nullable = false)
	private String tenTrangThai;

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
