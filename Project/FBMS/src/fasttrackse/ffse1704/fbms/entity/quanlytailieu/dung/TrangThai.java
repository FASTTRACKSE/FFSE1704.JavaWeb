package fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "trang_thai_tai_lieu")
public class TrangThai implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6931934795016309418L;

	@OneToMany(mappedBy="maTrangThai")
	private List<Document> Document;
	public List<Document> getDocument() {
		return Document;
	}
	public void setDocument(List<Document> document) {
		Document = document;
	}
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "ma_trang_thai")
	private String maTrangThai;
	
	@Column(name = "ten_trang_thai")
	private String tenTrangThai;

	//
	
	//
	public int getId() {
		return id;
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
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
