package fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/**
 * @author The persistent class for the quan_ly_thong_tin_du_an database table.
 *
 */

@Entity
@Table(name = "quan_ly_thong_tin_du_an")
public class DuAnKhanhCN implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ma_du_an", nullable = false, length = 30)
	@NotEmpty
	String maDAn;

	@Column(name = "ten_du_an", nullable = false, length = 255)
	@NotEmpty
	String tenDuAn;


	public String getTenDuAn() {
		return tenDuAn;
	}

	public String getMaDAn() {
		return maDAn;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setMaDAn(String maDAn) {
		this.maDAn = maDAn;
	}

	public void setTenDuAn(String tenDuAn) {
		this.tenDuAn = tenDuAn;
	}


}
