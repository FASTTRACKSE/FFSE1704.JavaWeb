package fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.tunglnt;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ffse1704_tunglnt_loaicongviec")
public class TunglntLoaiCongViec {

	@Id
	@Column(name = "id_congviec")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int macongviec;

	@Column(name = "loaicongviec")
	private String loaicongviec;

	public TunglntLoaiCongViec() {
		super();
	}

	

	public TunglntLoaiCongViec(int macongviec, String loaicongviec) {
		super();
		this.macongviec = macongviec;
		this.loaicongviec = loaicongviec;
	}



	public int getMacongviec() {
		return macongviec;
	}



	public void setMacongviec(int macongviec) {
		this.macongviec = macongviec;
	}



	public String getLoaicongviec() {
		return loaicongviec;
	}

	public void setLoaicongviec(String loaicongviec) {
		this.loaicongviec = loaicongviec;
	}
}
