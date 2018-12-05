package fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.tunglnt;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ffse1704_tunglnt_duan")
public class TunglntDuAn {

	@Id
	@Column(name = "maduan")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maduan;


	@Column(name = "tenduan")
	private String tenduan;

	public TunglntDuAn() {
		super();
	}


	public int getMaduan() {
		return maduan;
	}


	public void setMaduan(int maduan) {
		this.maduan = maduan;
	}


	public TunglntDuAn(int maduan, String tenduan) {
		super();
		this.maduan = maduan;
		this.tenduan = tenduan;
	}


	public String getTenduan() {
		return tenduan;
	}

	public void setTenduan(String tenduan) {
		this.tenduan = tenduan;
	}
}
