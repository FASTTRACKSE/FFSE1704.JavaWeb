package fasttrackse.ffse1704.fbms.entity.quanlyduan.technical;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import fasttrackse.ffse1704.fbms.entity.quanlyduan.thongtinduan.ThongTinDuAn;

@Entity
@Table(name = "technical")
public class Technical implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, length = 11)
	private int id;

	@Column(name = "ma_technical", nullable = false, length = 30)
	@NotEmpty
	private String maTechnical;

	@Column(name = "ten_technical", nullable = false, length = 255)
	@NotEmpty
	private String tenTechnical;

	@Column(name = "ghi_chu", nullable = true, length = 500)
	private String ghiChu;

	@ManyToMany(mappedBy = "technical")
	private Set<ThongTinDuAn> thongTinDuAn = new HashSet<>();

	public Technical() {
		super();
	}

	public Technical(int id, @NotEmpty String maTechnical, @NotEmpty String tenTechnical, @NotEmpty String ghiChu) {
		super();
		this.id = id;
		this.maTechnical = maTechnical;
		this.tenTechnical = tenTechnical;
		this.ghiChu = ghiChu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaTechnical() {
		return maTechnical;
	}

	public void setMaTechnical(String maTechnical) {
		this.maTechnical = maTechnical;
	}

	public String getTenTechnical() {
		return tenTechnical;
	}

	public void setTenTechnical(String tenTechnical) {
		this.tenTechnical = tenTechnical;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public Set<ThongTinDuAn> getThongTinDuAn() {
		return thongTinDuAn;
	}

	public void setThongTinDuAn(Set<ThongTinDuAn> thongTinDuAn) {
		this.thongTinDuAn = thongTinDuAn;
	}
}
