package fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.khoann;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="khoann_loai_hinh_nghi_phep")
public class LoaiHinhNghiPhepKhoann {
	
	@OneToMany(mappedBy = "loaihinhentity")
	
	private List<DonNghiPhepKhoann> DonNghiPhepKhoann;
	
	public int getId() {
		return id;
	}

	public List<DonNghiPhepKhoann> getDonNghiPhepKhoann() {
		return DonNghiPhepKhoann;
	}

	public void setDonNghiPhepKhoann(List<DonNghiPhepKhoann> donNghiPhepKhoann) {
		DonNghiPhepKhoann = donNghiPhepKhoann;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMaNghiPhep() {
		return maNghiPhep;
	}

	public void setMaNghiPhep(int maNghiPhep) {
		this.maNghiPhep = maNghiPhep;
	}

	public String getTenNghiPhep() {
		return tenNghiPhep;
	}

	public void setTenNghiPhep(String tenNghiPhep) {
		this.tenNghiPhep = tenNghiPhep;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, length = 11)
	private int id;
	
	@Column(name = "ma_nghi_phep")
	private int maNghiPhep;
	
	@Column(name = "ten_nghi_phep")
	private String tenNghiPhep;

}
