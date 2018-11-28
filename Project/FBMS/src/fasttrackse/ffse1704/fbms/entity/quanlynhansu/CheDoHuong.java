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

	@Column(name = "id_che_do", nullable = false, length = 11)
	private int id_che_do;

	@Column(name = "luong", nullable = false, length = 255)
	private String luong;

	public CheDoHuong(int id, int id_che_do, String luong) {
		super();
		this.id = id;
		this.id_che_do = id_che_do;
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

	public int getId_che_do() {
		return id_che_do;
	}

	public void setId_che_do(int id_che_do) {
		this.id_che_do = id_che_do;
	}

	public String getLuong() {
		return luong;
	}

	public void setLuong(String luong) {
		this.luong = luong;
	}

}
