package fasttrackse.ffse1704.fbms.entity.quanlythoigian;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vai_tro_thanh_vien")
public class VaiTroDuAnLogwork {
	@Id
	@Column(name = "ma_vai_tro")
	int maVaiTro;
	
	@Column(name = "ten_vai_tro")
	String tenVaiTro;
	
	@OneToMany(mappedBy = "maVaiTroDuAn")
	private Collection<Logwork> logworks;

	public int getMaVaiTro() {
		return maVaiTro;
	}

	public void setMaVaiTro(int maVaiTro) {
		this.maVaiTro = maVaiTro;
	}

	public String getTenVaiTro() {
		return tenVaiTro;
	}

	public void setTenVaiTro(String tenVaiTro) {
		this.tenVaiTro = tenVaiTro;
	}

	public Collection<Logwork> getLogworks() {
		return logworks;
	}

	public void setLogworks(Collection<Logwork> logworks) {
		this.logworks = logworks;
	}
	
}
