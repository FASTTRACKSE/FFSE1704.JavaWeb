package fasttrackse.ffse1704.fbms.entity.quanlytailieu.synv;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trang_thai_")
public class StatusSy {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "ma_trang_thai")
	private String ma_trang_thai;
	
	@Column(name = "ten_trang_thai")
	private String ten_trang_thai;

	public String getMa_trang_thai() {
		return ma_trang_thai;
	}

	public void setMa_trang_thai(String ma_trang_thai) {
		this.ma_trang_thai = ma_trang_thai;
	}

	//
	public String getTen_trang_thai() {
		return ten_trang_thai;
	}

	public void setTen_trang_thai(String ten_trang_thai) {
		this.ten_trang_thai = ten_trang_thai;
	}
	//
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public StatusSy() {
		super();
	}
	
	public StatusSy (int id, String ma_trang_thai, String ten_trang_thai) {
		super();
		this.id = id;
		this.ma_trang_thai = ma_trang_thai;
		this.ten_trang_thai = ten_trang_thai;
	}
	
	
}