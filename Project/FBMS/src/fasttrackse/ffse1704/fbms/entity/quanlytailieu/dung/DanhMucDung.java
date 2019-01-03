package fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fasttrackse.ffse1704.fbms.entity.security.PhongBan;

@Entity
@Table(name = "danh_muc_tai_lieu")
public class DanhMucDung implements Serializable {
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "maDanhMuc")
	private List<DocumentDung> DocumentDung;

	public List<DocumentDung> getDocument() {
		return DocumentDung;
	}

	public void setDocument(List<DocumentDung> documentDung) {
		DocumentDung = documentDung;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "ten_danh_muc")
	private String tenDanhMuc;

	@Column(name = "ma_danh_muc")
	private String maDanhMuc;
	
	@ManyToOne
	@JoinColumn(name = "ma_phong_ban", referencedColumnName = "ma_phong_ban")
	private PhongBan maPhongBan;



	public PhongBan getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(PhongBan maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenDanhMuc() {
		return tenDanhMuc;
	}

	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}

	public String getMaDanhMuc() {
		return maDanhMuc;
	}

	public void setMaDanhMuc(String maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}

	public DanhMucDung() {
		super();
	}

}
