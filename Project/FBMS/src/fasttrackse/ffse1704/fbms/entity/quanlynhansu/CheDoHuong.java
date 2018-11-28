package fasttrackse.ffse1704.fbms.entity.quanlynhansu;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "che_do_huong")
public class CheDoHuong implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", unique = true, nullable = false, length = 11)
	private int id;

	@Column(name = "luong", nullable = false, length = 255)
	private String luong;

	public CheDoHuong(int id, String luong) {
		super();
		this.id = id;
		this.luong = luong;
	}

	public CheDoHuong() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLuong() {
		return luong;
	}

	public void setLuong(String luong) {
		this.luong = luong;
	}

}
