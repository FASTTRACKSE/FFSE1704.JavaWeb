package fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fasttrackse.ffse1704.fbms.entity.security.PhongBan;


@Entity
@Table(name = "tai_lieu_dung")
public class Document {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "ten_tai_lieu")
	private String tenTaiLieu;
	

	public String getTenTaiLieu() {
		return tenTaiLieu;
	}

	public void setTenTaiLieu(String tenTaiLieu) {
		this.tenTaiLieu = tenTaiLieu;
	}


	@Column(name = "file")
	private String file;
	
	@Column(name = "mo_ta")
	private String moTa;

	@Column(name = "ghi_chu")
	private String ghiChu;
	
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


	@ManyToOne
	@JoinColumn(name = "ma_phong_ban", referencedColumnName = "ma_phong_ban")
	private PhongBan maPhongBan;



	public PhongBan getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(PhongBan maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	public DanhMuc getMaDanhMuc() {
		return maDanhMuc;
	}

	public void setMaDanhMuc(DanhMuc maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}


	@ManyToOne
	@JoinColumn(name = "ma_danh_muc", referencedColumnName = "ma_danh_muc")
	private DanhMuc maDanhMuc;
	
	
	@ManyToOne
	@JoinColumn(name = "ma_trang_thai", referencedColumnName = "ma_trang_thai")
	private TrangThai maTrangThai;

	

	
	public TrangThai getMaTrangThai() {
		return maTrangThai;
	}

	public void setMaTrangThai(TrangThai maTrangThai) {
		this.maTrangThai = maTrangThai;
	}


	@ManyToOne
	@JoinColumn(name = "ma_icon", referencedColumnName = "ma_icon")
	private Icon maIcon;
	
	// getter and setter
	 
	
	public Icon getMaIcon() {
		return maIcon;
	}

	public void setMaIcon(Icon maIcon) {
		this.maIcon = maIcon;
	}


	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

}
