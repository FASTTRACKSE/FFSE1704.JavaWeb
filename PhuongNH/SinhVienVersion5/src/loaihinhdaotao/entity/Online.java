package loaihinhdaotao.entity;

public class Online implements LoaiHinhDaoTao {
	public String loaiHinh = "Học online" ;
	public String thoiGian = "24/7" ;
	public String diaDiem = "www.fasttrackse.edu.vn";
	public Online(String loaihinh, String thoiGian, String diaDiem) {
		super();
		this.loaiHinh = loaihinh;
		this.thoiGian = thoiGian;
		this.diaDiem = diaDiem;
	}
	public Online() {
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

