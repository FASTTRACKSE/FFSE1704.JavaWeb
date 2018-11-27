package fasttrackse.ffse1704.fbms.dao.security;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.security.ChucNang;

public interface ChucNangDao {
	
	public void save(ChucNang cn);

	public void update(ChucNang cn);

	public void delete(String ma_chuc_nang);

	public void active(String ma_chuc_nang);

	public ChucNang getChucNangByCode(String ma_chuc_nang);
	
	public ChucNang findByMaChucNang(String ma_chuc_nang);
	
	public List<ChucNang> findAll();
	
	public List<ChucNang> findAll(int iDisplayStart, int iDisplayLength, String sql);
	
	public String getRecordsTotal();
	
	public String getRecordsFiltered(String sql);
}
