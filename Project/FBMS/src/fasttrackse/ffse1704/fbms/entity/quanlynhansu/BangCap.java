package fasttrackse.ffse1704.fbms.entity.quanlynhansu;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "thong_tin_bang_cap")
public class BangCap {

	public BangCap() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ma_nhan_vien", referencedColumnName = "ma_nhan_vien", insertable = false, updatable = false, nullable = false)
	private NhanSu nhanSu;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ma_nhan_vien", referencedColumnName = "ma_nhan_vien", insertable = false, updatable = false, nullable = false)
	private NhanSu nhanSuBC;
	
	
	public NhanSu getNhanSuBC() {
		return nhanSuBC;
	}

	public void setNhanSuBC(NhanSu nhanSuBC) {
		this.nhanSuBC = nhanSuBC;
	}

	@Column(name = "ma_nhan_vien")
	private String maNhanVien;

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	@ManyToOne
	@JoinColumn(name = "id_trinh_do", referencedColumnName = "id_trinh_do", insertable = false, updatable = false, nullable = false)
	private TrinhDo trinhDo;

	@Column(name = "id_trinh_do", nullable = false)
	private int IdtrinhDo;

	public int getIdtrinhDo() {
		return IdtrinhDo;
	}

	public void setIdtrinhDo(int idtrinhDo) {
		IdtrinhDo = idtrinhDo;
	}

	@Column(name = "ten_nganh", nullable = false)
	private String tenNganh;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "thoi_gian_bat_dau", nullable = false)
	private Date batDau;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "thoi_gian_ket_thuc", nullable = false)
	private Date ketThuc;

	@Column(name = "xep_loai", nullable = false)
	private String xepLoai;

	@Column(name = "noi_cap", nullable = false)
	private String noiCap;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public NhanSu getNhanSu() {
		return nhanSu;
	}

	public void setNhanSu(NhanSu nhanSu) {
		this.nhanSu = nhanSu;
	}

	public TrinhDo getTrinhDo() {
		return trinhDo;
	}

	public void setTrinhDo(TrinhDo trinhDo) {
		this.trinhDo = trinhDo;
	}

	public String getTenNganh() {
		return tenNganh;
	}

	public void setTenNganh(String tenNganh) {
		this.tenNganh = tenNganh;
	}

	public String getXepLoai() {
		return xepLoai;
	}

	public void setXepLoai(String xepLoai) {
		this.xepLoai = xepLoai;
	}

	public String getNoiCap() {
		return noiCap;
	}

	public void setNoiCap(String noiCap) {
		this.noiCap = noiCap;
	}

	public Date getBatDau() {
		return batDau;
	}

	public void setBatDau(Date batDau) {
		this.batDau = batDau;
	}

	public Date getKetThuc() {
		return ketThuc;
	}

	public void setKetThuc(Date ketThuc) {
		this.ketThuc = ketThuc;
	}
}
