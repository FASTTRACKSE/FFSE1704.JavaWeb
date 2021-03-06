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
@Table(name = "framework")
public class FrameworkNS implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, length = 11)
	private int id;
	
	@Column(name = "ma_framework", nullable = false, length = 30)
	@NotEmpty
	private String maFramework;
	
	@Column(name = "ten_framework", nullable = false, length = 30)
	@NotEmpty
	private String tenFramework;
	
	@Column(name = "ghi_chu", nullable = false, length = 30)
	@NotEmpty
	private String ghiChu;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaFramework() {
		return maFramework;
	}

	public void setMaFramework(String maFramework) {
		this.maFramework = maFramework;
	}

	public String getTenFramework() {
		return tenFramework;
	}

	public void setTenFramework(String tenFramework) {
		this.tenFramework = tenFramework;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
}
