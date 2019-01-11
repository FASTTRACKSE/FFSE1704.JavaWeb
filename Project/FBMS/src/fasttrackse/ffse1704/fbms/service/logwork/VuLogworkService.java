package fasttrackse.ffse1704.fbms.service.logwork;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.logwork.ThoiGianLamViec;
import fasttrackse.ffse1704.fbms.entity.logwork.VuDuAnLogwork;
import fasttrackse.ffse1704.fbms.entity.logwork.VuPhongBan;
import fasttrackse.ffse1704.fbms.entity.logwork.VuVaiTroDuAn;

public interface VuLogworkService {

	public void create(ThoiGianLamViec thoiGianLamViec);

	public List<VuPhongBan> listPhongBan();

	public List<VuDuAnLogwork> listDuAn();

	public List<VuVaiTroDuAn> listVaiTroDuAn();

	public List<ThoiGianLamViec> findAll();

	public void addNew(ThoiGianLamViec logwork);

	public void update(ThoiGianLamViec logwork);

	public void delete(int id);

	public ThoiGianLamViec findByIdLogwork(int id);

	public List<ThoiGianLamViec> findAll(int iDisplayStart, int iDisplayLength, String sql);

	public String getRecordsTotal();

	public String getRecordsFiltered(String sql);

	public List<ThoiGianLamViec> listOneMonth(String month);

	public List<ThoiGianLamViec> listTheoTrangThai(int maTrangThai);

	public List<ThoiGianLamViec> baoCaoTheoMaNV(String maNhanVien);

	public List<ThoiGianLamViec> logworkTheoPB(String maPhongBan);

}
