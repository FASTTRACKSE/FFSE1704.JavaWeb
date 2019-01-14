package fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "trang_thai_cong_viec")
public class TrangThaiKhanhCN implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "ma_trangthai")
	private int maTrangThai;

	@Column(name = "ten_trangThai")
	private String tenTrangThai;

	@OneToMany(mappedBy = "trangThaiKhanhCN")
//	private List<CongViecKhanhCN> congViecKhanhCN = new ArrayList<CongViecKhanhCN>();
	private List<CongViecKhanhCN> congViecKhanhCN;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMaTrangThai() {
		return maTrangThai;
	}

	public void setMaTrangThai(int maTrangThai) {
		this.maTrangThai = maTrangThai;
	}

	public String getTenTrangThai() {
		return tenTrangThai;
	}

	public void setTenTrangThai(String tenTrangThai) {
		this.tenTrangThai = tenTrangThai;
	}

	public List<CongViecKhanhCN> getCongViecKhanhCN() {
		return congViecKhanhCN;
	}

	public void setCongViecKhanhCN(List<CongViecKhanhCN> congViecKhanhCN) {
		this.congViecKhanhCN = congViecKhanhCN;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
