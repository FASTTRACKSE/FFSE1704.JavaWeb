package fasttrackse.ffse1704.fbms.entity.quanlynhansu;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
	@NotNull(message = "Vui Lòng Nhập ngày sinh")
	private Date namSinh;

	@Column(name = "gioi_tinh")
	@NotNull(message = "Vui Lòng Nhập giới tính")
	private Integer gioiTinh;
	
	@ManyToOne
	@JoinColumn(name="ThanhPho_TinhThanh",referencedColumnName="matp", insertable = false, updatable = false, nullable = false)
	private ThanhPho thanhPho;
	
	@Column(name="ThanhPho_TinhThanh")
	private String tinhThanhPho;
	
	@ManyToOne
	@JoinColumn(name="Quan_Huyen",referencedColumnName="maqh", insertable = false, updatable = false,nullable = false)
	private QuanHuyen quanHuyen;
	
	@Column(name="Quan_Huyen")
	private String maQuanHuyen;
	
	@ManyToOne
	@JoinColumn(name="Phuong_xa_thitran",referencedColumnName="xaid", insertable = false, updatable = false,nullable = false)
	private XaPhuong xaPhuong;
	
	@Column(name="Phuong_xa_thitran")
	private String maXaPhuong;

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
	
	
	@Column(name = "ma_phong_ban")
	private String maPhongBan;
	
	
	@Column(name = "ma_chuc_danh")
	private String maChucDanh;
	
	@ManyToOne
	@JoinColumn(name = "ma_phong_ban", referencedColumnName = "ma_phong_ban",insertable = false, nullable = true, updatable = false)
	private PhongBan phongBan;
	
	@ManyToOne
	@JoinColumn(name = "ma_chuc_danh", referencedColumnName = "ma_chuc_danh",insertable = false, nullable = true, updatable = false)
	private ChucDanh chucDanh;

	public String getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	public String getMaChucDanh() {
		return maChucDanh;
	}

	public void setMaChucDanh(String maChucDanh) {
		this.maChucDanh = maChucDanh;
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

	@NotEmpty(message = "Vui Lòng Nhập dân tộc nhân viên")
	@Column(name = "dan_toc")
	private String danToc;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_quoc_tich", referencedColumnName = "ma_quoc_tich",insertable = false, nullable = false, updatable = false)
	private QuocTich quocTich;
	
	@Column(name="ma_quoc_tich")
	private String maQuocTich;

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
	@NotNull(message = "Vui Lòng Nhập ngày cấp")
	private Date ngayCap;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "trang_thai", referencedColumnName = "id_trang_thai",insertable = false, nullable = false, updatable = false)
	private TrangThaiNhanSu trangThaiNS;
	
	@Column(name = "trang_thai")
	private Integer idTrangThai;

	@OneToMany(mappedBy = "nhanSu", fetch = FetchType.EAGER)
	private List<BangCap> listBangCap;

	@OneToMany(mappedBy = "nhanSu", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<ThongTinGiaDinh> listGiaDinh;

	@OneToMany(mappedBy = "nhanSu", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	public List<ThongTinHopDong> listHopDong;

	@OneToMany(mappedBy = "nhanSu", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<ChungChi> listChungChi;
	
	@OneToMany(mappedBy = "nhanSu", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<PhanCongNhiemVuNS> listPhanCongNhiemVuNS ;
	
	@OneToMany(mappedBy = "nhanSu", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<QuanLySoNgayNghi> listNgayNghi;

	public List<QuanLySoNgayNghi> getListNgayNghi() {
		return listNgayNghi;
	}

	public void setListNgayNghi(List<QuanLySoNgayNghi> listNgayNghi) {
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

	public String getMaQuanHuyen() {
		return maQuanHuyen;
	}

	public void setMaQuanHuyen(String maQuanHuyen) {
		this.maQuanHuyen = maQuanHuyen;
	}

	public String getMaXaPhuong() {
		return maXaPhuong;
	}

	public void setMaXaPhuong(String maXaPhuong) {
		this.maXaPhuong = maXaPhuong;
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


	public QuocTich getQuocTich() {
		return quocTich;
	}

	public void setQuocTich(QuocTich quocTich) {
		this.quocTich = quocTich;
	}

	public String getTinhThanhPho() {
		return tinhThanhPho;
	}

	public void setTinhThanhPho(String tinhThanhPho) {
		this.tinhThanhPho = tinhThanhPho;
	}

	public String getMaQuocTich() {
		return maQuocTich;
	}

	public void setMaQuocTich(String maQuocTich) {
		this.maQuocTich = maQuocTich;
	}

	public TrangThaiNhanSu getTrangThaiNS() {
		return trangThaiNS;
	}

	public void setTrangThaiNS(TrangThaiNhanSu trangThaiNS) {
		this.trangThaiNS = trangThaiNS;
	}

	public Integer getIdTrangThai() {
		return idTrangThai;
	}

	public void setIdTrangThai(Integer idTrangThai) {
		this.idTrangThai = idTrangThai;
	}

}
