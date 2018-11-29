package fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.tunglnt;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ffse1704_tunglnt_duan")
public class DuAn {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "maduan")
	private String maduan;

	@Column(name = "tenduan")
	private String tenduan;

	public DuAn() {
		super();
	}

	public DuAn(int id, String maduan, String tenduan) {
		super();
		this.id = id;
		this.maduan = maduan;
		this.tenduan = tenduan;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaduan() {
		return maduan;
	}

	public void setMaduan(String maduan) {
		this.maduan = maduan;
	}

	public String getTenduan() {
		return tenduan;
	}

	public void setTenduan(String tenduan) {
		this.tenduan = tenduan;
	}
}
