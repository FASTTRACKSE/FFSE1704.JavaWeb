package fasttrackse.ffse1704.fbms.entity.quanlytailieu.synv;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tai_lieu")
public class Document {
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "ten_tai_lieu")
	@NotEmpty
	private String ten_tai_lieu;
	
	@Column(name = "ma_danh_muc")
	@NotEmpty
	private String ma_danh_muc;
	
	@Column(name = "file")
	private String fileName;
	
	@Column(name = "ma_trang_thai")
	@NotEmpty
	private String ma_trang_thai;
	
	@Column(name = "mo_ta")
	@NotEmpty
	private String mo_ta;
	
	@Column(name = "ghi_chu")
	@NotEmpty
	private String ghi_chu;
	
	@Column(name = "ma_phong_ban")
	@NotEmpty
	private String ma_phong_ban;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTen_tai_lieu() {
		return ten_tai_lieu;
	}

	public void setTen_tai_lieu(String ten_tai_lieu) {
		this.ten_tai_lieu = ten_tai_lieu;
	}

	public String getMa_danh_muc() {
		return ma_danh_muc;
	}

	public void setMa_danh_muc(String ma_danh_muc) {
		this.ma_danh_muc = ma_danh_muc;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getMa_trang_thai() {
		return ma_trang_thai;
	}

	public void setMa_trang_thai(String ma_trang_thai) {
		this.ma_trang_thai = ma_trang_thai;
	}

	public String getMo_ta() {
		return mo_ta;
	}

	public void setMo_ta(String mo_ta) {
		this.mo_ta = mo_ta;
	}

	public String getGhi_chu() {
		return ghi_chu;
	}

	public void setGhi_chu(String ghi_chu) {
		this.ghi_chu = ghi_chu;
	}

	public String getMa_phong_ban() {
		return ma_phong_ban;
	}

	public void setMa_phong_ban(String ma_phong_ban) {
		this.ma_phong_ban = ma_phong_ban;
	}
	public Document() {
		super();
	}
	
	



}