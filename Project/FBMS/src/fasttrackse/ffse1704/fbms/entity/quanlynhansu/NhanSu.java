package fasttrackse.ffse1704.fbms.entity.quanlynhansu;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.fromqlda.PhanCongNhiemVuNS;
import fasttrackse.ffse1704.fbms.entity.security.ChucDanh;
import fasttrackse.ffse1704.fbms.entity.security.PhongBan;

@Entity
@Table(name = "ho_so_nhan_su")
public class NhanSu implements Serializable {
	private static final long serialVersionUID = 1L;

	public NhanSu() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@NotEmpty(message = "Vui Lòng Nhập Mã nhân viên")
	@Column(name = "ma_nhan_vien", nullable = false)
	private String maNhanVien;

	@ManyToOne
	@JoinColumn(name = "ma_phong_ban", nullable = false)
	@NotNull
	private PhongBan phongBan;

	@ManyToOne
	@JoinColumn(name = "ma_chuc_danh", nullable = false)
	private ChucDanh chucDanh;

	@NotEmpty(message = "Vui Lòng Nhập họ hót của nhân viên")
	@Column(name = "ho_dem", nullable = false)
	private String hoLot;

	@NotEmpty(message = "Vui Lòng Nhập tên nhân viên")
	@Column(name = "ten", nullable = false)
	private String ten;

	@Column(name = "anh_dai_dien", nullable = false, length = 100)
	private String anhDaiDien;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "nam_sinh", nullable = false)
	@NotNull
	private Date namSinh;

	@Column(name = "gioi_tinh")
	@NotNull
	private Integer gioiTinh;
	
	@ManyToOne
	@JoinColumn(name="ThanhPho_TinhThanh",referencedColumnName="matp",nullable = false)
	@NotNull
	private ThanhPho thanhPho;
	
	@ManyToOne
	@JoinColumn(name="Quan_Huyen",referencedColumnName="maqh",nullable = false)
	@NotNull
	private QuanHuyen quanHuyen;
	
	@ManyToOne
	@JoinColumn(name="Phuong_xa_thitran",referencedColumnName="xaid",nullable = false)
	@NotNull
	private XaPhuong xaPhuong;

	public ThanhPho getThanhPho() {
		return thanhPho;
	}

	public void setThanhPho(ThanhPho thanhPho) {
		this.thanhPho = thanhPho;
	}

	public QuanHuyen getQuanHuyen() {
		return quanHuyen;
	}

	public void setQuanHuyen(QuanHuyen quanHuyen) {
		this.quanHuyen = quanHuyen;
	}

	public XaPhuong getXaPhuong() {
		return xaPhuong;
	}

	public void setXaPhuong(XaPhuong xaPhuong) {
		this.xaPhuong = xaPhuong;
	}

	@NotEmpty(message = "Vui Lòng Nhập quê quán nhân viên")
	@Column(name = "que_quan")
	private String queQuan;

	@NotEmpty(message = "Vui Lòng Nhập dân tộc nhân viên")
	@Column(name = "dan_toc")
	private String danToc;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_quoc_tich", referencedColumnName = "ma_quoc_tich", nullable = false, updatable = false)
	@NotNull
	private QuocTich quocTich;

	@NotEmpty(message = "Vui Lòng Nhập nơi tạm trú")
	@Column(name = "noi_tam_tru")
	private String noiTamTru;

	@Column(name = "so_dien_thoai")
	@Pattern(regexp = "(^$|[0-9]{11})", message = "Số diện thoại không đúng")
	private String soDienThoai;

	@Column(name = "email")
	@Pattern(regexp = ".+@.+\\..+", message = "Định dạng email không đúng")
	private String email;

	@NotEmpty(message = "Vui Lòng Nhập số chứng minh thư")
	@Column(name = "so_cmnd")
	private String soCMND;

	@Column(name = "noi_cap_cmnd")
	@NotEmpty(message = "Vui Lòng Nhập nơi cấp")
	private String noiCap;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ngay_cap_cmnd")
	@NotNull
	private Date ngayCap;

	@Column(name = "trang_thai")
	@NotNull
	private Integer trangThai;

	@OneToMany(mappedBy = "nhanSu", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<BangCap> listBangCap;

	@OneToMany(mappedBy = "nhanSu", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<ThongTinGiaDinh> listGiaDinh;

	@OneToMany(mappedBy = "nhanSu", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval=true)
	@Fetch(value = FetchMode.SUBSELECT)
	public List<ThongTinHopDong> listHopDong;

	@OneToMany(mappedBy = "nhanSu", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<ChungChi> listChungChi;
	
	@OneToMany(mappedBy = "nhanSu", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<PhanCongNhiemVuNS> listPhanCongNhiemVuNS ;
	
	@OneToMany(mappedBy = "nhanSu", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<SoNgayNghiNhanVien> listNgayNghi;
	
	public List<SoNgayNghiNhanVien> getListNgayNghi() {
		return listNgayNghi;
	}

	public void setListNgayNghi(List<SoNgayNghiNhanVien> listNgayNghi) {
		this.listNgayNghi = listNgayNghi;
	}

	public List<PhanCongNhiemVuNS> getListPhanCongNhiemVuNS() {
		return listPhanCongNhiemVuNS;
	}

	public void setListPhanCongNhiemVuNS(List<PhanCongNhiemVuNS> listPhanCongNhiemVuNS) {
		this.listPhanCongNhiemVuNS = listPhanCongNhiemVuNS;
	}

	public List<ChungChi> getListChungChi() {
		return listChungChi;
	}

	public void setListChungChi(List<ChungChi> listChungChi) {
		this.listChungChi = listChungChi;
	}

	public List<ThongTinHopDong> getListHopDong() {
		return listHopDong;
	}

	public void setListHopDong(List<ThongTinHopDong> listHopDong) {
		this.listHopDong = listHopDong;
	}

	public List<ThongTinGiaDinh> getListGiaDinh() {
		return listGiaDinh;
	}

	public void setListGiaDinh(List<ThongTinGiaDinh> listGiaDinh) {
		this.listGiaDinh = listGiaDinh;
	}

	public List<BangCap> getListBangCap() {
		return listBangCap;
	}

	public void setListBangCap(List<BangCap> listBangCap) {
		this.listBangCap = listBangCap;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getHoLot() {
		return hoLot;
	}

	public void setHoLot(String hoLot) {
		this.hoLot = hoLot;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getAnhDaiDien() {
		return anhDaiDien;
	}

	public void setAnhDaiDien(String anhDaiDien) {
		this.anhDaiDien = anhDaiDien;
	}

	public Date getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(Date namSinh) {
		this.namSinh = namSinh;
	}

	public Integer getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(Integer gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getQueQuan() {
		return queQuan;
	}

	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}

	public String getDanToc() {
		return danToc;
	}

	public void setDanToc(String danToc) {
		this.danToc = danToc;
	}

	public String getNoiTamTru() {
		return noiTamTru;
	}

	public void setNoiTamTru(String noiTamTru) {
		this.noiTamTru = noiTamTru;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoCMND() {
		return soCMND;
	}

	public void setSoCMND(String soCMND) {
		this.soCMND = soCMND;
	}

	public String getNoiCap() {
		return noiCap;
	}

	public void setNoiCap(String noiCap) {
		this.noiCap = noiCap;
	}

	public Date getNgayCap() {
		return ngayCap;
	}

	public void setNgayCap(Date ngayCap) {
		this.ngayCap = ngayCap;
	}

	public Integer getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(Integer trangThai) {
		this.trangThai = trangThai;
	}

	public PhongBan getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}

	public ChucDanh getChucDanh() {
		return chucDanh;
	}

	public void setChucDanh(ChucDanh chucDanh) {
		this.chucDanh = chucDanh;
	}

	public QuocTich getQuocTich() {
		return quocTich;
	}

	public void setQuocTich(QuocTich quocTich) {
		this.quocTich = quocTich;
	}

}
