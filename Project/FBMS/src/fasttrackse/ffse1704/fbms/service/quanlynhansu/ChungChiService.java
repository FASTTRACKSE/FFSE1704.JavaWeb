package fasttrackse.ffse1704.fbms.service.quanlynhansu;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.BangCap;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ChungChi;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.NhanSu;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.TrinhDo;

public interface ChungChiService {
	public List<ChungChi> viewAll();

	public void addChungChi(ChungChi cc);

	public List<ChungChi> GetListChungChiByPage(int start, int total);

	public long CountChungChi();

	public NhanSu getChungChiByID(String id);

	public void update(ChungChi cc);

	public void delete(int id);

	public boolean checkExistMa(String maNS);

	public ChungChi getChungChiUpdate(int id);
	
	public List<TrinhDo> listTrinhDo();
	public List<BangCap> findMaBangByMaTrinhDo(int IdtrinhDo);
	public TrinhDo findTenTrinhDoByMaTrinhDo(int maTrinhDo);
}
