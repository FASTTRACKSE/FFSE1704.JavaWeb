package fasttrackse.ffse1704.fbms.dao.quanlynhansu;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ThongTinGiaDinh;

public interface ThongTinGiaDinhDao {
	public void addTT(ThongTinGiaDinh tt);

	public void updateTT(ThongTinGiaDinh tt);

	public ThongTinGiaDinh getThongTinById(int id);

	public void deleteTT(ThongTinGiaDinh tt);

	public List<ThongTinGiaDinh> getThongTinByPage(int pageid, int total);

	public long countTT();
}
