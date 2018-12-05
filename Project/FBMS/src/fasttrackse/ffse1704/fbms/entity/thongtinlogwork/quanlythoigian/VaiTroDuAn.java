package fasttrackse.ffse1704.fbms.entity.thongtinlogwork.quanlythoigian;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "vai_tro_thanh_vien")
public class VaiTroDuAn {
	@Id
	@Column(name = "ma_vai_tro")
	@NotEmpty
	int maVaiTro;

	@Column(name = "ten_vai_tro", nullable = false)
	@NotEmpty
	String tenVaiTro;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vaiTro")
	private Collection<ThongTinLogwork> listVaiTro ;

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

	public Collection<ThongTinLogwork> getListVaiTro() {
		return listVaiTro;
	}

	public void setListVaiTro(Collection<ThongTinLogwork> listVaiTro) {
		this.listVaiTro = listVaiTro;
	}



}
