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
@Table(name = "danh_muc_tai_lieu")
public class DanhMuc implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8800040796985248779L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@OneToMany(mappedBy="ma_danh_muc")
	private List<Document> Document;
	public List<Document> getDocument() {
		return Document;
	}
	public void setDocument(List<Document> document) {
		Document = document;
	}

	@Column(name = "ten_danh_muc")
	private String ten_danh_muc;

	@Column(name = "ma_danh_muc")
	private String ma_danh_muc;

	public String getTen_danh_muc() {
		return ten_danh_muc;
	}

	public void setTen_danh_muc(String ten_danh_muc) {
		this.ten_danh_muc = ten_danh_muc;
	}

	public String getMa_danh_muc() {
		return ma_danh_muc;
	}

	public void setMa_danh_muc(String ma_danh_muc) {
		this.ma_danh_muc = ma_danh_muc;
	}
	
}
