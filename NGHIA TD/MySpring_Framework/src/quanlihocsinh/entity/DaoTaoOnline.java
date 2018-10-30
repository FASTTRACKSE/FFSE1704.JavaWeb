package quanlihocsinh.entity;

public class DaoTaoOnline implements LoaiDaoTao{

	 String MaLoaiDaoTao="hihihaha";
	 String thongTinLoaiDaoTao="Đào tạo online:\r\n" + 
	 		"o	Thời gian: 24/24\r\n" + 
	 		"o	Địa chỉ: trang web LMS.FASTTRACK.EDU.VN";
	public DaoTaoOnline() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DaoTaoOnline(String maLoaiDaoTao, String thongTinLoaiDaoTao) {
		super();
		MaLoaiDaoTao = maLoaiDaoTao;
		this.thongTinLoaiDaoTao = thongTinLoaiDaoTao;
	}
	public String getMaLoaiDaoTao() {
		return MaLoaiDaoTao;
	}
	public void setMaLoaiDaoTao(String maLoaiDaoTao) {
		MaLoaiDaoTao = maLoaiDaoTao;
	}
	public String getThongTinLoaiDaoTao() {
		return thongTinLoaiDaoTao;
	}
	public void setThongTinLoaiDaoTao(String thongTinLoaiDaoTao) {
		this.thongTinLoaiDaoTao = thongTinLoaiDaoTao;
	}

}
