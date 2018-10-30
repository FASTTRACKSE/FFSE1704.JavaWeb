package ffse.qlsv.entity.hedaotao;

import java.util.List;

import ffse.qlsv.entity.monhoc.MonHoc;

public class HeDaoTaoHavardFastTrack implements HeDaoTao {
	
	List<MonHoc> dsMonHoc;

	public void setDsMonHoc(List<MonHoc> dsMonHoc) {
		this.dsMonHoc = dsMonHoc;
	}

	public List<MonHoc> getDsMonHoc() {
		return dsMonHoc;
	}

	@Override
	public String getMaHeDaoTao() {
		return "FSEHAVARD";
	}

	@Override
	public String getThongTinHeDaoTao() {
		return "Học Havard tại Đà Nẵng, 14KUSD/tuần";
	}

	@Override
	public List<MonHoc> getDanhSachMonHoc() {
		// TODO Auto-generated method stub
		return dsMonHoc;
	}

}