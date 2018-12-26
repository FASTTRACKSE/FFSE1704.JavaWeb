package fasttrackse.ffse1704.fbms.entity.quanlytailieu.synv;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import fasttrackse.ffse1704.fbms.entity.quanlytailieu.synv.CategorySy;
import fasttrackse.ffse1704.fbms.entity.quanlytailieu.synv.IconSy;
import fasttrackse.ffse1704.fbms.entity.quanlytailieu.synv.StatusSy;
//import fasttrackse.ffse1704.fbms.entity.security.PhongBan;

@Entity
@Table(name = "tai_lieu_")
public class DocumentSy {
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "ten_tai_lieu")
	@NotEmpty
	private String ten_tai_lieu;
	
	
	@Column(name = "file")
	private String fileName;
	
	
	@Column(name = "mo_ta")
	@NotEmpty
	private String mo_ta;
	
	@Column(name = "ghi_chu")
	@NotEmpty
	private String ghi_chu;
	
	@Column(name = "ma_phong_ban")
	@NotEmpty
	private String ma_phong_ban;

	@ManyToOne
	@JoinColumn(name = "ma_danh_muc", referencedColumnName = "ma_danh_muc")
	private CategorySy maDanhMuc;
	
	
	@ManyToOne
	@JoinColumn(name = "ma_trang_thai", referencedColumnName = "ma_trang_thai")
	private StatusSy maTrangThai;
	
	@ManyToOne
	@JoinColumn(name = "ma_icon", referencedColumnName = "ma_icon")
	private IconSy maIcon;
	
	public int getId() {
		return id;
	}

	public DocumentSy(@NotNull int id, @NotEmpty String ten_tai_lieu, String fileName, @NotEmpty String mo_ta,
			@NotEmpty String ghi_chu, @NotEmpty String ma_phong_ban, CategorySy maDanhMuc, StatusSy maTrangThai,
			IconSy maIcon) {
		super();
		this.id = id;
		this.ten_tai_lieu = ten_tai_lieu;
		this.fileName = fileName;
		this.mo_ta = mo_ta;
		this.ghi_chu = ghi_chu;
		this.ma_phong_ban = ma_phong_ban;
		this.maDanhMuc = maDanhMuc;
		this.maTrangThai = maTrangThai;
		this.maIcon = maIcon;
	}

	public DocumentSy() {
		// TODO Auto-generated constructor stub
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
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

	public CategorySy getMaDanhMuc() {
		return maDanhMuc;
	}

	public void setMaDanhMuc(CategorySy maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}

	public StatusSy getMaTrangThai() {
		return maTrangThai;
	}

	public void setMaTrangThai(StatusSy maTrangThai) {
		this.maTrangThai = maTrangThai;
	}

	public IconSy getMaIcon() {
		return maIcon;
	}

	public void setMaIcon(IconSy maIcon) {
		this.maIcon = maIcon;
	}

	
	
//	@ManyToOne
//	@JoinColumn(name = "ma_phong_ban", referencedColumnName = "ma_phong_ban")
//	private PhongBan maPhongBan;
	
	/*public Document (int id, String ten_tai_lieu, String ma_danh_muc, String fileName, String ma_trang_thai, String mo_ta, String ghi_chu, String ma_phong_ban) {
		super();
		this.id = id;
		this.ten_tai_lieu = ten_tai_lieu;
		this.ma_danh_muc = ma_danh_muc;
		this.fileName = fileName;
		this.ma_trang_thai = ma_trang_thai;
		this.mo_ta = mo_ta;
		this.ghi_chu = ghi_chu;
		this.ma_phong_ban = ma_phong_ban;
	}*/
	



}