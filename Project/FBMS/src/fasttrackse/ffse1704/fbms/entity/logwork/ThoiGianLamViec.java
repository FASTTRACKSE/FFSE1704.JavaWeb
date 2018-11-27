package fasttrackse.ffse1704.fbms.entity.logwork;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="thoi_gian_cong_viec")
public class ThoiGianLamViec {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, length = 11)
	private int id;
	
	@Column(name="ma_du_an" ,nullable = true,length = 11)
	private String maDuAn;
	
	@Column(name="ma_nhan_vien", nullable = true,length = 11)
	private String maNhanVien;
	
	@Column(name="ma_vai_tro", nullable = true,length = 11)
	private int maVaiTro;
	
	@Column(name="ma_phong_ban",nullable = true,length = 11)
	private int maPhongBan;
	
	
	@Column(name="ten_cong_viec", nullable = true)
	private String tenCongViec;
	
	@Column(name="mo_ta", nullable = true)
	private String moTa;
	
	@Column(name="trang_thai", nullable = true,length = 11)
	private int trangThai;
	
	@Column(name="thoi_gian_bat_dau", nullable = true)
	private Date thoiGianBatDau;
	
	@Column(name="thoi_gian_ket_thuc", nullable = true)
	private Date thoiGianKetThuc;
	
	@Column(name="nhan_xet_PM", nullable = true)
	private String nhanXetPM;
	
	@Column(name="nhan_xet_tpp", nullable = true)
	private String nhanXetTPP;
	
	
	
}
