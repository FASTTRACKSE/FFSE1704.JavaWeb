package fasttrackse.ffse1704.fbms.entity.quanlynhansu;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "tinhthanhpho")
public class ThanhPho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "matp", unique = true, nullable = false, length = 5)
	private String matp;

	@Column(name = "name", nullable = false, length = 100)
	private String name;

	@Column(name = "type", nullable = false, length = 30)
	private String type;

	@OneToMany(mappedBy = "thanhPho", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<NhanSu> listNhanSuTP;

	public String getMatp() {
		return matp;
	}

	public void setMatp(String matp) {
		this.matp = matp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<NhanSu> getListNhanSuTP() {
		return listNhanSuTP;
	}

	public void setListNhanSuTP(List<NhanSu> listNhanSuTP) {
		this.listNhanSuTP = listNhanSuTP;
	}

}
