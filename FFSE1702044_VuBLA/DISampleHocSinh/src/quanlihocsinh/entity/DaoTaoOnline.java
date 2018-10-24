package quanlihocsinh.entity;

public class DaoTaoOnline implements BuoiHoc{
	String loaiDaoTao = "Dao Tao Online";
	String thoiGianHoc = "24/24,Địa chỉ: trang web LMS.FASTTRACK.EDU.VN";
	public DaoTaoOnline() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DaoTaoOnline(String loaiDaoTao, String thoiGianHoc) {
		super();
		this.loaiDaoTao = loaiDaoTao;
		this.thoiGianHoc = thoiGianHoc;
	}
	public String getLoaiDaoTao() {
		return loaiDaoTao;
	}
	public void setLoaiDaoTao(String loaiDaoTao) {
		this.loaiDaoTao = loaiDaoTao;
	}
	public String getThoiGianHoc() {
		return thoiGianHoc;
	}
	public void setThoiGianHoc(String thoiGianHoc) {
		this.thoiGianHoc = thoiGianHoc;
	}
	
}
