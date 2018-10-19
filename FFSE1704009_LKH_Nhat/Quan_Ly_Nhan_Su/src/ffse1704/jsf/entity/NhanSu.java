package ffse1704.jsf.entity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

@ManagedBean
@RequestScoped
public class NhanSu {
	private String id;

	@NotNull(message = "Tên Nhân Sự không được để trống")
	private String hoTen;

	@NotNull(message = "Năm Sinh không được để trống")
	@Range(min=1900, max=2000, message = "Năm Sinh chỉ từ 1900 đến 2000")
	private String namSinh;

	@NotNull(message = "Giới Tính không được để trống")
	private String gioiTinh;

	@NotNull(message = "Hộ Khẩu không được để trống")
	private String hoKhau;

	@NotNull(message = "Ảnh Đại Diện không được để trống")
	private String avatar;

	private String STT;

	public NhanSu() {
		super();

	}

	public NhanSu(String id) {
		super();
		this.id = id;
	}

	public NhanSu(String id, String hoTen, String namSinh, String gioiTinh, String hoKhau, String avatar, String sTT) {
		super();
		this.id = id;
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.gioiTinh = gioiTinh;
		this.hoKhau = hoKhau;
		this.avatar = avatar;
		this.STT = sTT;
	}
	
	public NhanSu(String id, String hoTen, String namSinh, String gioiTinh, String hoKhau, String avatar) {
		super();
		this.id = id;
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.gioiTinh = gioiTinh;
		this.hoKhau = hoKhau;
		this.avatar = avatar;

	}
	

	public String getSTT() {
		return STT;
	}

	public void setSTT(String sTT) {
		STT = sTT;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(String namSinh) {
		this.namSinh = namSinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getHoKhau() {
		return hoKhau;
	}

	public void setHoKhau(String hoKhau) {
		this.hoKhau = hoKhau;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
}
