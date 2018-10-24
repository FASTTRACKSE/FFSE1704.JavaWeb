package quanlihocsinh.entity;

public class DaoTaoOffline implements BuoiHoc {
	String loaiDaoTao = "Dao Tao Offline";
	String thoiGianHoc = "sáng từ 8h00, chiều từ 13h30, tối từ 18h30.Địa chỉ: Toà nhà FPT, KCN An Đồn";

	public DaoTaoOffline() {
		super();
	}

	public DaoTaoOffline(String loaiDaoTao, String thoiGianHoc) {
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
