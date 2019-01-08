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
import fasttrackse.ffse1704.fbms.entity.security.PhongBan;


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
	private String tenTaiLieu;
	
	
	@Column(name="name_file")
	private String nameFile;
	
	@Column(name = "link_file")
	private String linkFile;
	
	
	@Column(name = "mo_ta")
	@NotEmpty
	private String moTa;
	
	@Column(name = "ghi_chu")
	@NotEmpty
	private String ghiChu;
	
	@Column(name = "ma_phong_ban")
	@NotEmpty
	private String maPhongBan;

	@ManyToOne
	@JoinColumn(name = "ma_danh_muc", referencedColumnName = "ma_danh_muc")
	private CategorySy maDanhMuc;
	
	
	@ManyToOne
	@JoinColumn(name = "ma_trang_thai", referencedColumnName = "ma_trang_thai")
	private StatusSy maTrangThai;
	
	@ManyToOne
	@JoinColumn(name = "ma_icon", referencedColumnName = "ma_icon")
	private IconSy maIcon;

	@ManyToOne
	@JoinColumn(name = "ma_phong_ban", referencedColumnName = "ma_phong_ban", insertable=false, updatable=false)
	private PhongBan phongBan;


	public PhongBan getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}

	public String getTenTaiLieu() {
		return tenTaiLieu;
	}

	public void setTenTaiLieu(String tenTaiLieu) {
		this.tenTaiLieu = tenTaiLieu;
	}

	public String getNameFile() {
		return nameFile;
	}

	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}

	public String getLinkFile() {
		return linkFile;
	}

	public void setLinkFile(String linkFile) {
		this.linkFile = linkFile;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public String getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
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

	public void setId(int id) {
		this.id = id;
	}

	public DocumentSy(@NotNull int id, @NotEmpty String tenTaiLieu, String nameFile, String linkFile,
			@NotEmpty String moTa, @NotEmpty String ghiChu, @NotEmpty String maPhongBan, CategorySy maDanhMuc,
			StatusSy maTrangThai, IconSy maIcon) {
		super();
		this.id = id;
		this.tenTaiLieu = tenTaiLieu;
		this.nameFile = nameFile;
		this.linkFile = linkFile;
		this.moTa = moTa;
		this.ghiChu = ghiChu;
		this.maPhongBan = maPhongBan;
		this.maDanhMuc = maDanhMuc;
		this.maTrangThai = maTrangThai;
		this.maIcon = maIcon;
	}
	public int getId() {
		return id;
	}

	public DocumentSy() {
		// TODO Auto-generated constructor stub
	}

	


	
	

	
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