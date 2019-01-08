package fasttrackse.ffse1704.fbms.entity.quanlynhansu;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trangthai_nhansu")
public class TrangThaiNhanSu implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_trang_thai", unique = true, nullable = false, length = 11)
	private int idTrangThai;

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	public TrangThaiNhanSu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdTrangThai() {
		return idTrangThai;
	}

	public void setIdTrangThai(int idTrangThai) {
		this.idTrangThai = idTrangThai;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
