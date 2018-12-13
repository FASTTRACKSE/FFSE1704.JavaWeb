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
public class DocumentDung {
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

	public DanhMucDung getMaDanhMuc() {
		return maDanhMuc;
	}

	public void setMaDanhMuc(DanhMucDung maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}


	@ManyToOne
	@JoinColumn(name = "ma_danh_muc", referencedColumnName = "ma_danh_muc")
	private DanhMucDung maDanhMuc;
	
	
	@ManyToOne
	@JoinColumn(name = "ma_trang_thai", referencedColumnName = "ma_trang_thai")
	private TrangThaiDung maTrangThai;

	

	
	public TrangThaiDung getMaTrangThai() {
		return maTrangThai;
	}

	public void setMaTrangThai(TrangThaiDung maTrangThai) {
		this.maTrangThai = maTrangThai;
	}

	
	@ManyToOne
	@JoinColumn(name = "ma_icon", referencedColumnName = "ma_icon")
	private IconDung maIcon;
	
	// getter and setter
	 
	
	public IconDung getMaIcon() {
		return maIcon;
	}

	public void setMaIcon(IconDung maIcon) {
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

	public DocumentDung(int id, String tenTaiLieu, String file, String moTa, String ghiChu, PhongBan maPhongBan,
			DanhMucDung maDanhMuc, TrangThaiDung maTrangThai, IconDung maIcon) {
		super();
		this.id = id;
		this.tenTaiLieu = tenTaiLieu;
		this.file = file;
		this.moTa = moTa;
		this.ghiChu = ghiChu;
		this.maPhongBan = maPhongBan;
		this.maDanhMuc = maDanhMuc;
		this.maTrangThai = maTrangThai;
		this.maIcon = maIcon;
	}

	public DocumentDung() {
		// TODO Auto-generated constructor stub
	}

}
