package ffse1704.jsf.entity;

import java.util.List;

import ffse1704.jsf.entity.hedaotao.HeDaoTao;
import ffse1704.jsf.entity.monhoc.MonHoc;

public class HeDaoTaoJavaCapToc implements HeDaoTao {
	private String maHeDaoTao = "FFSE Java";
	private String thongTinHeDaoTao = "Chương trình đào tạo lập trình Java 6 tháng ";
	List<MonHoc> danhSachMonHoc;

	public HeDaoTaoJavaCapToc() {
		super();
	}

	public HeDaoTaoJavaCapToc(String maHeDaoTao, String thongTinHeDaoTao, List<MonHoc> danhSachMonHoc) {
		super();
		this.maHeDaoTao = maHeDaoTao;
		this.thongTinHeDaoTao = thongTinHeDaoTao;
		this.danhSachMonHoc = danhSachMonHoc;
	}

	public String getMaHeDaoTao() {
		return maHeDaoTao;
	}

	public void setMaHeDaoTao(String maHeDaoTao) {
		this.maHeDaoTao = maHeDaoTao;
	}

	public String getThongTinHeDaoTao() {
		return thongTinHeDaoTao;
	}

	public void setThongTinHeDaoTao(String thongTinHeDaoTao) {
		this.thongTinHeDaoTao = thongTinHeDaoTao;
	}

	public List<MonHoc> getDanhSachMonHoc() {
		return danhSachMonHoc;
	}

	public void setDanhSachMonHoc(List<MonHoc> danhSachMonHoc) {
		this.danhSachMonHoc = danhSachMonHoc;
	}

}
