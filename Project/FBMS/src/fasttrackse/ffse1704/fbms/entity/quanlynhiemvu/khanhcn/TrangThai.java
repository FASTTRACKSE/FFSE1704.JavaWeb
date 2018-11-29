package fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name = "trangthai")
public class TrangThai {
	@Id
	@Column(name = "id")
	@NotNull
	private int id;

	@Column(name = "ma_trangthai")
	@NotEmpty
	private String maTrangThai;

	@Column(name = "ten_TrangThai")
	@NotEmpty
	private String tenTrangThai;

	public TrangThai() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TrangThai(int id, @NotEmpty String maTrangThai, @NotEmpty String tenTrangThai) {
		super();
		this.id = id;
		this.maTrangThai = maTrangThai;
		this.tenTrangThai = tenTrangThai;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaTrangThai() {
		return maTrangThai;
	}

	public void setMaTrangThai(String maTrangThai) {
		this.maTrangThai = maTrangThai;
	}

	public String getTenTrangThai() {
		return tenTrangThai;
	}

	public void setTenTrangThai(String tenTrangThai) {
		this.tenTrangThai = tenTrangThai;
	}
	
	

}
