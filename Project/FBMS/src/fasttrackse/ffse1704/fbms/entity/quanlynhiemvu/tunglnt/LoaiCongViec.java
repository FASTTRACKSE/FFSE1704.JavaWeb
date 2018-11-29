package fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.tunglnt;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ffse1704_tunglnt_loaicongviec")
public class LoaiCongViec {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "loaicongviec")
	private String loaicongviec;

	public LoaiCongViec() {
		super();
	}

	public LoaiCongViec(int id, String loaicongviec) {
		super();
		this.id = id;
		this.loaicongviec = loaicongviec;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoaicongviec() {
		return loaicongviec;
	}

	public void setLoaicongviec(String loaicongviec) {
		this.loaicongviec = loaicongviec;
	}
}
