package fasttrackse.ffse1704.fbms.dao.quanlynhansu;

import java.util.List;


import fasttrackse.ffse1704.fbms.entity.quanlynhansu.CheDoHuong;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.HopDong;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ThongTinHopDong;


public interface HopDongDao {
	public List<HopDong> listHopDong();
	public List<CheDoHuong> listCheDoHuong();
	public void saveHopDongCheDo(ThongTinHopDong thongtinhopdong);
	public void editHopDong(ThongTinHopDong thongtinhopdong);
	public ThongTinHopDong findById(int id);
	public void deleteHopDong(int id);
}
