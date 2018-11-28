package fasttrackse.ffse1704.fbms.entity.quanlynhansu;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "quoc_tich")
public class QuocTich implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ma_quoc_tich", unique = true, nullable = false, length = 11)
	private int maQuocTich;

	@Column(name = "ten_quoc_tich", nullable = false, length = 50)
	private String tenQuocTich;

	public QuocTich() {
	}

	public QuocTich(int maQuocTich, String tenQuocTich) {
		super();
		this.maQuocTich = maQuocTich;
		this.tenQuocTich = tenQuocTich;
	}

	public int getMaQuocTich() {
		return maQuocTich;
	}

	public void setMaQuocTich(int maQuocTich) {
		this.maQuocTich = maQuocTich;
	}

	public String getTenQuocTich() {
		return tenQuocTich;
	}

	public void setTenQuocTich(String tenQuocTich) {
		this.tenQuocTich = tenQuocTich;
	}

}
