package fasttrackse.ffse1704.fbms.service.quanlynhansu;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.NhanSu;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ThongTinGiaDinh;

public interface ThongTinGiaDinhService {
	public List<ThongTinGiaDinh> viewAll();

	public void addThongTinGiaDinh(ThongTinGiaDinh tt);

	public List<ThongTinGiaDinh> GetListThongTinGiaDinhByPage(int start, int total);

	public long CountThongTinGiaDinh();

	public NhanSu getThongTinGiaDinhByID(String id);

	public void update(ThongTinGiaDinh tt);

	public void delete(int id);

	public boolean checkExistMa(String maNS);

	public ThongTinGiaDinh getThongTinGiaDinhUpdate(int id);
}
