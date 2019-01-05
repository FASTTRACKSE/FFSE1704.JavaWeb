package fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "phong_ban")
public class PhongBanMinhtq implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ma_phong_ban")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	String maPhongBan;

	@Column(name = "ten_phong_ban", nullable = false)
	String tenPhongBan;

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

	@OneToMany(mappedBy = "phongBan")
	private Collection<DonNghiPhepMinhtq> donNghiPhepMinhtq;

	public Collection<DonNghiPhepMinhtq> getDonNghiPhepMinhtq() {
		return donNghiPhepMinhtq;
	}

	public void setDonNghiPhepMinhtq(Collection<DonNghiPhepMinhtq> donNghiPhepMinhtq) {
		this.donNghiPhepMinhtq = donNghiPhepMinhtq;
	}

	public PhongBanMinhtq(String maPhongBan, String tenPhongBan, Collection<DonNghiPhepMinhtq> donNghiPhepMinhtq) {
		super();
		this.maPhongBan = maPhongBan;
		this.tenPhongBan = tenPhongBan;
		this.donNghiPhepMinhtq = donNghiPhepMinhtq;
	}

	public PhongBanMinhtq() {
		super();
		// TODO Auto-generated constructor stub
	}

}