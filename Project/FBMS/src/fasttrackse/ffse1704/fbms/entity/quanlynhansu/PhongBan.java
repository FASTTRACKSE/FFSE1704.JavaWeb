package fasttrackse.ffse1704.fbms.entity.quanlynhansu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "phong_ban")
public class PhongBan {
	@Column(name = "ma_phong_ban")
	String maPhongBan;

	@Column(name = "ten_phong_ban")
	String tenPhongBan;

	public PhongBan() {
	}

	public PhongBan(String maPhongBan, String tenPhongBan) {
		super();
		this.maPhongBan = maPhongBan;
		this.tenPhongBan = tenPhongBan;
	}

	public String getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	public String getTenPhongBan() {
		return tenPhongBan;
	}

	public void setTenPhongBan(String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
	}
}
