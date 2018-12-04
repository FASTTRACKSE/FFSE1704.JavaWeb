package fasttrackse.ffse1704.fbms.entity.quanlythoigian;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "phong_ban")
public class PhongBanLogwork {
	@Id
	@Column(name = "ma_phong_ban")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	String maPBan;
	
	@Column(name = "ten_phong_ban", nullable = false)
	@NotEmpty
	String tenPhongBan;
	
	public String getMaPBan() {
		return maPBan;
	}
	public void setMaPBan(String maPBan) {
		this.maPBan = maPBan;
	}
	public String getTenPhongBan() {
		return tenPhongBan;
	}
	public void setTenPhongBan(String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
	}
	
	

}