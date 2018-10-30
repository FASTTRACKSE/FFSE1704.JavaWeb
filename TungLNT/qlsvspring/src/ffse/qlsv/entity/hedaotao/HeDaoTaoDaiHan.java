package ffse.qlsv.entity.hedaotao;

import java.util.List;

import ffse.qlsv.entity.monhoc.MonHoc;

public class HeDaoTaoDaiHan implements HeDaoTao {
	private  String maHeDaoTao = "FFSEDH";
	private  String thongTinHeDaoTao = "Đào tạo dài hạn 16 tháng, full các môn lập trình";

	List<MonHoc> dsMonHoc;

	public void setDsMonHoc(List<MonHoc> dsMonHoc) {
		this.dsMonHoc = dsMonHoc;
	}

	public List<MonHoc> getDsMonHoc() {
		return dsMonHoc;
	}

	public HeDaoTaoDaiHan() {
		super();
	}

	public HeDaoTaoDaiHan(String maHeDaoTao, String thongTinHeDaoTao) {
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
