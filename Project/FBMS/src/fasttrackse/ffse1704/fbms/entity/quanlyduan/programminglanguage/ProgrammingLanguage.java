package fasttrackse.ffse1704.fbms.entity.quanlyduan.programminglanguage;

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
@Table(name = "programming_language")
public class ProgrammingLanguage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, length = 11)
	private int id;

	@Column(name = "ma_language", nullable = false, length = 30)
	@NotEmpty
	private String maLanguage;
	
	@ManyToOne
	@JoinColumn(name = "ma_du_an", referencedColumnName = "ma_du_an", nullable = false)
	private ThongTinDuAn thongTinDuAn;

	@Column(name = "ten_language", nullable = false, length = 255)
	@NotEmpty
	private String tenLanguage;

	@Column(name = "ghi_chu", nullable = true, length = 255)
	@NotEmpty
	private String ghiChu;

	public ProgrammingLanguage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProgrammingLanguage(int id, @NotEmpty String maLanguage, @NotEmpty String tenLanguage,
			@NotEmpty String ghiChu) {
		super();
		this.id = id;
		this.maLanguage = maLanguage;
		this.tenLanguage = tenLanguage;
		this.ghiChu = ghiChu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaLanguage() {
		return maLanguage;
	}

	public void setMaLanguage(String maLanguage) {
		this.maLanguage = maLanguage;
	}

	public String getTenLanguage() {
		return tenLanguage;
	}

	public void setTenLanguage(String tenLanguage) {
		this.tenLanguage = tenLanguage;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
}
