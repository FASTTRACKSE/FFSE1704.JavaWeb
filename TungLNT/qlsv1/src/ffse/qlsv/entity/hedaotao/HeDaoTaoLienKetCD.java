
package ffse.qlsv.entity.hedaotao;

import java.util.List;

import ffse.qlsv.entity.monhoc.MonHoc;

public class HeDaoTaoLienKetCD implements HeDaoTao {
	String maHeDaoTao = "FFSECDCN";
	String thongTinHeDaoTao = "Đào tạo dài hạn + cao đẳng 2 năm trời thương nhớ";
	
	public void setDsMonHoc(List<MonHoc> dsMonHoc) {
		this.dsMonHoc = dsMonHoc;
	}

	List<MonHoc> dsMonHoc;

	public List<MonHoc> getDsMonHoc() {
		return dsMonHoc;
	}

	public HeDaoTaoLienKetCD() {
		super();
	}
	
	public HeDaoTaoLienKetCD(String maHeDaoTao, String thongTinHeDaoTao) {
		super();
		this.maHeDaoTao = maHeDaoTao;
		this.thongTinHeDaoTao = thongTinHeDaoTao;
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

	@Override
	public List<MonHoc> getDanhSachMonHoc() {
		// TODO Auto-generated method stub
		return dsMonHoc;
	}
}