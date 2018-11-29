package fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name = "loaicongviec")
public class LoaiCongViec {

	@Id
	@Column(name = "id")
	@NotNull
	private int id;

	@Column(name = "ma_loai_congviec")
	@NotEmpty
	private String maLoaiCongViec;

	@Column(name = "loai_congviec")
	@NotEmpty
	private String loaiCongViec;
	
	

	public LoaiCongViec() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoaiCongViec(int id, @NotEmpty String maLoaiCongViec, @NotEmpty String loaiCongViec) {
		super();
		this.id = id;
		this.maLoaiCongViec = maLoaiCongViec;
		this.loaiCongViec = loaiCongViec;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaLoaiCongViec() {
		return maLoaiCongViec;
	}

	public void setMaLoaiCongViec(String maLoaiCongViec) {
		this.maLoaiCongViec = maLoaiCongViec;
	}

	public String getLoaiCongViec() {
		return loaiCongViec;
	}

	public void setLoaiCongViec(String loaiCongViec) {
		this.loaiCongViec = loaiCongViec;
	}

}
