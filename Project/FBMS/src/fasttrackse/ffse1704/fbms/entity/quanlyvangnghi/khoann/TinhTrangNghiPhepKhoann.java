package fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.khoann;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "khoann_trang_thai")
public class TinhTrangNghiPhepKhoann {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, length = 11)
	private int id;
	
	@Column(name = "ma_trang_thai")
	private int maTrangThai;
	
	@Column(name = "ten_trang_thai")
	private String tenTrangThai;
}
