package fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name = "trangthai")
public class TrangThaiKhanhCN implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@NotNull
	private int id;

	@Column(name = "ma_trangthai")
	@NotEmpty
	private int maTrangThai;

	@Column(name = "ten_TrangThai")
	@NotEmpty
	private String tenTrangThai;

	@OneToMany(mappedBy = "maTrangThai")
	private Collection<CongViecKhanhCN> khanhCNs;

	public TrangThaiKhanhCN() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMaTrangThai() {
		return maTrangThai;
	}

	public void setMaTrangThai(int maTrangThai) {
		this.maTrangThai = maTrangThai;
	}

	public String getTenTrangThai() {
		return tenTrangThai;
	}

	public void setTenTrangThai(String tenTrangThai) {
		this.tenTrangThai = tenTrangThai;
	}

	public Collection<CongViecKhanhCN> getKhanhCNs() {
		return khanhCNs;
	}

	public void setKhanhCNs(Collection<CongViecKhanhCN> khanhCNs) {
		this.khanhCNs = khanhCNs;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
