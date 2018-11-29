package fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.tunglnt;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ffse1704_tunglnt_trangthai")
public class TrangThai {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "tentrangthai")
	private String tentrangthai;

	public TrangThai() {
		super();
	}

	public TrangThai(int id, String tentrangthai) {
		super();
		this.id = id;
		this.tentrangthai = tentrangthai;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTentrangthai() {
		return tentrangthai;
	}

	public void setTentrangthai(String tentrangthai) {
		this.tentrangthai = tentrangthai;
	}

}
