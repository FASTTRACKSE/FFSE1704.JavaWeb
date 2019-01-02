package fasttrackse.ffse1704.fbms.dao.logwork;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.logwork.ThoiGianLamViec;
import fasttrackse.ffse1704.fbms.entity.logwork.VuDuAnLogwork;
import fasttrackse.ffse1704.fbms.entity.logwork.VuPhongBan;
import fasttrackse.ffse1704.fbms.entity.logwork.VuVaiTroDuAn;

public interface QuanLiThoiGianDaoImpl {

	public List<ThoiGianLamViec> findAll();

	public void addNew(ThoiGianLamViec thoiGianLamViec);

	public void update(ThoiGianLamViec thoiGianLamViec);

	public void delete(int id);

	public ThoiGianLamViec findByIdThoiGianLamViec(String id);

	public List<ThoiGianLamViec> findAll(int iDisplayStart, int iDisplayLength, String sql);

	public String getRecordsTotal();

	public String getRecordsFiltered(String sql);

	public List<VuVaiTroDuAn> listVaiTroDuAn();

	public List<VuDuAnLogwork> listDuAn();

	public List<VuPhongBan> listPhongBan();

	public ThoiGianLamViec findByIdLogwork(int id);

	public List<ThoiGianLamViec> listOneMonth(String month);

	public List<ThoiGianLamViec> listTheoTrangThai(int maTrangThai);

}
