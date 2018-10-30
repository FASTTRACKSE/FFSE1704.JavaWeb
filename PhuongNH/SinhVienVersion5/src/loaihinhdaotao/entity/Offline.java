package loaihinhdaotao.entity;

public class Offline implements LoaiHinhDaoTao {
	public String loaiHinh = "Học online" ;
	public String thoiGian = "24/7" ;
	public String diaDiem = "tòa nhà FPT";
	public Offline(String loaihinh, String thoiGian, String diaDiem) {
		super();
		this.loaiHinh = loaihinh;
		this.thoiGian = thoiGian;
		this.diaDiem = diaDiem;
	}
	public Offline() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getLoaiHinh() {
		return loaiHinh;
	}
	public void setLoaihinh(String loaihinh) {
		this.loaiHinh = loaihinh;
	}
	public String getThoiGian() {
		return thoiGian;
	}
	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}
	public String getDiaDiem() {
		return diaDiem;
	}
	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}


}
