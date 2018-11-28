package fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.thachmh;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loai_nghi_phep")
public class LyDo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "ma_nghi_phep")
	private String maNghiPhep;

	@Column(name = "ten_nghi_phep")
	private String tenNghiPhep;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaNghiPhep() {
		return maNghiPhep;
	}

	public void setMaNghiPhep(String maNghiPhep) {
		this.maNghiPhep = maNghiPhep;
	}

	public String getTenNghiPhep() {
		return tenNghiPhep;
	}

	public void setTenNghiPhep(String tenNghiPhep) {
		this.tenNghiPhep = tenNghiPhep;
	}
}
