package fasttrackse.ffse1704.fbms.entity.tuanpt.qlvn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loai_phep_tuanpt")
public class LyDo {
	@Id
	@Column(name="id_loai_phep")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int idLoaiPhep;
	
	@Column(name="ten_loai_nghi")
	public String tenLoaiNghi;

	public String getTenLoaiNghi() {
		return tenLoaiNghi;
	}

	public void setTenLoaiNghi(String tenLoaiNghi) {
		this.tenLoaiNghi = tenLoaiNghi;
	}

	
}
