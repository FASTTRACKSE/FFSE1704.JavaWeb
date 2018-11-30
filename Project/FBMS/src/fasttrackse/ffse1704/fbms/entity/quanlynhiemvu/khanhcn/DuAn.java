package fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import fasttrackse.ffse1704.fbms.entity.quanlyduan.khachhang.KhachHang;

/**
 * @author The persistent class for the quan_ly_thong_tin_du_an database table.
 *
 */

@Entity
@Table(name = "quan_ly_thong_tin_du_an")
public class DuAn implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, length = 11)
	private int id;
	
	@Column(name = "ma_du_an", nullable = false, length = 30)
	@NotEmpty
	private String 	maDuAn;

	@Column(name = "ten_du_an", nullable = false, length = 255)
	@NotEmpty
	private String tenDuAn;
	
	/*@ManyToOne
	@JoinColumn(name = "maKhachHang", referencedColumnName = "maKhachHang", nullable = false)
	private KhachHang khachHang;*/
	
	@Column(name = "ma_khach_hang", nullable = false, length = 30)
	@NotEmpty
	private String maKhachHang;
	
	@Column(name = "mo_ta", nullable = true, length = 255)
	@NotEmpty
	private String moTa;
	
	@Column(name = "phong_du_an", nullable = true, length = 30)
	@NotEmpty
	private String phongDuAn;
	
	@Column(name = "PM", nullable = true, length = 30)
	@NotEmpty
	private String pM;
	
	@Column(name = "start_date", nullable = true)
	@NotEmpty
	private Date startDate;
	
	@Column(name = "end_date", nullable = true)
	@NotEmpty
	private Date endDate;
	
	@Column(name = "domain", nullable = false, length = 30)
	@NotEmpty
	private String domain;
	
	@Column(name = "framework", nullable = false, length = 30)
	@NotEmpty
	private String framework;
	
	@Column(name = "database", nullable = false, length = 30)
	@NotEmpty
	private String database;
	
	
	
	@Column(name = "programming_language", nullable = false, length = 30)
	@NotEmpty
	private String programmingLanguage;
	
	@Column(name = "trang_thai", nullable = false, length = 30)
	@NotEmpty
	private String trang_thai;
	
	public DuAn() {
		super();
	}

	public DuAn(int id, String maDuAn, String tenDuAn, String maKhachHang, String moTa, String phongDuAn, String pM, Date startDate, Date endDate, String domain, String framework, String database, String programmingLanguage, String trang_thai) {
		super();
		this.id = id;
		this.maDuAn = maDuAn;
		this.tenDuAn = tenDuAn;
		this.maKhachHang = maKhachHang;
		this.moTa = moTa;
		this.phongDuAn = phongDuAn;
		this.pM = pM;
		this.startDate = startDate;
		this.endDate = endDate;
		this.domain = domain;
		this.framework = framework;
		this.database = database;
		this.programmingLanguage = programmingLanguage;
		this.trang_thai = trang_thai;
	}
}

