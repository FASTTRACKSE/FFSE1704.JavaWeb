package fasttrackse.ffse1704.fbms.dao.logwork;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.logwork.ThoiGianLamViec;

public interface QuanLiThoiGianDaoImpl {

	public List<ThoiGianLamViec> findAll();

	public void addNew(ThoiGianLamViec thoiGianLamViec);

	public void update(ThoiGianLamViec thoiGianLamViec);

	public void delete(String id);

	public ThoiGianLamViec findByIdThoiGianLamViec(String id);

	public List<ThoiGianLamViec> findAll(int iDisplayStart, int iDisplayLength, String sql);

	public String getRecordsTotal();

	public String getRecordsFiltered(String sql);

}
