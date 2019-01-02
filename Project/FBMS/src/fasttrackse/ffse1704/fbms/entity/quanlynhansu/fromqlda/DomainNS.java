package fasttrackse.ffse1704.fbms.entity.quanlynhansu.fromqlda;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "domain")
public class DomainNS implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, length = 11)
	private int id;
	
	@Column(name = "ma_domain", nullable = false, length = 30)
	@NotEmpty
	private String maDomain;
	
	@Column(name = "ten_domain", nullable = false, length = 30)
	@NotEmpty
	private String tenDomain;
	
	@Column(name = "ghi_chu", nullable = false, length = 30)
	@NotEmpty
	private String ghiChu;

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
