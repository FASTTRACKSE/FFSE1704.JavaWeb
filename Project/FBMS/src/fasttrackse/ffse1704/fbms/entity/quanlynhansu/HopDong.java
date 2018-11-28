package fasttrackse.ffse1704.fbms.entity.quanlynhansu;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hop_dong")
public class HopDong implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", unique = true, nullable = false, length = 11)
	private int id;

	@Column(name = "ma_hop_dong", nullable = false, length = 20)
	private String maHopDong;

	@Column(name = "ten_hop_dong", nullable = false, length = 50)
	private String tenHopDong;

	public HopDong() {
	}

	public HopDong(int id, String maHopDong, String tenHopDong) {
		super();
		this.id = id;
		this.maHopDong = maHopDong;
		this.tenHopDong = tenHopDong;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaHopDong() {
		return maHopDong;
	}

	public void setMaHopDong(String maHopDong) {
		this.maHopDong = maHopDong;
	}

	public String getTenHopDong() {
		return tenHopDong;
	}

	public void setTenHopDong(String tenHopDong) {
		this.tenHopDong = tenHopDong;
	}

}
