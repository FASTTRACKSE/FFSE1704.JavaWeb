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

@Entity
@Table(name = "loai_cong_viec")
public class LoaiCongViec implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ma_loai_congviec")
	@NotEmpty
	int maLoaiCongViec;

	@Column(name = "loai_congviec")
	@NotEmpty
	private String loaiCongViec;

	
	public LoaiCongViec() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getMaLoaiCongViec() {
		return maLoaiCongViec;
	}

	public void setMaLoaiCongViec(int maLoaiCongViec) {
		this.maLoaiCongViec = maLoaiCongViec;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getLoaiCongViec() {
		return loaiCongViec;
	}

	public void setLoaiCongViec(String loaiCongViec) {
		this.loaiCongViec = loaiCongViec;
	}
}
