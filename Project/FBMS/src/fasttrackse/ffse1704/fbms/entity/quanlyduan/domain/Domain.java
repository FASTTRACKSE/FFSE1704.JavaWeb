package fasttrackse.ffse1704.fbms.entity.quanlyduan.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import fasttrackse.ffse1704.fbms.entity.quanlyduan.thongtinduan.ThongTinDuAn;

@Entity
@Table(name = "domain")
public class Domain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, length = 11)
	private int id;

	@Column(name = "ma_domain", nullable = false, length = 30)
	@NotEmpty
	private String maDomain;
	
	/*@ManyToOne
	@JoinColumn(name = "ma_du_an", referencedColumnName = "ma_du_an", nullable = false)
	private ThongTinDuAn thongTinDuAn;*/

	@Column(name = "ten_domain", nullable = false, length = 255)
	@NotEmpty
	private String tenDomain;

	@Column(name = "ghi_chu", nullable = true, length = 500)
	@NotEmpty
	private String ghiChu;

	public Domain() {
		super();
	}

	public Domain(int id, @NotEmpty String maDomain, @NotEmpty String tenDomain, @NotEmpty String ghiChu) {
		super();
		this.id = id;
		this.maDomain = maDomain;
		this.tenDomain = tenDomain;
		this.ghiChu = ghiChu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaDomain() {
		return maDomain;
	}

	public void setMaDomain(String maDomain) {
		this.maDomain = maDomain;
	}

	public String getTenDomain() {
		return tenDomain;
	}

	public void setTenDomain(String tenDomain) {
		this.tenDomain = tenDomain;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
}
