package fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.tunglnt;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ffse1704_tunglnt_trangthai")
public class TunglntTrangThai {

	@Id
	@Column(name = "matrangthai")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int matrangthai;

	@Column(name = "tentrangthai")
	private String tentrangthai;

	public TunglntTrangThai() {
		super();
	}

	public TunglntTrangThai(int matrangthai, String tentrangthai) {
		super();
		this.matrangthai = matrangthai;
		this.tentrangthai = tentrangthai;
	}

	public int getMatrangthai() {
		return matrangthai;
	}

	public void setMatrangthai(int matrangthai) {
		this.matrangthai = matrangthai;
	}

	public String getTentrangthai() {
		return tentrangthai;
	}

	public void setTentrangthai(String tentrangthai) {
		this.tentrangthai = tentrangthai;
	}

}
