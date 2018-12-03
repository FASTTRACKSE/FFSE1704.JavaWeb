package fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.khoann;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="khoann_loai_hinh_nghi_phep")
public class LoaiHinhNghiPhepKhoann {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, length = 11)
	private int id;
	
	@Column(name = "ma_nghi_phep")
	private int maNghiPhep;
	
	@Column(name = "ten_nghi_phep")
	private String tenNghiPhep;

}
