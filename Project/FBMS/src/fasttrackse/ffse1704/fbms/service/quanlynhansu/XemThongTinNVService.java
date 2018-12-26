package fasttrackse.ffse1704.fbms.service.quanlynhansu;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.NhanSu;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.QuanHuyen;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.XaPhuong;
import fasttrackse.ffse1704.fbms.entity.security.PhongBan;

public interface XemThongTinNVService {
	public List<PhongBan> listPhongBan();
	public List<NhanSu> findByPhongBan(String maPhongBan);
	public List<NhanSu> findAllForPaging(String maPhongBan, int startPosition,int maxResult);
	public NhanSu findByMaNhanVien(String maNhanVien);
	public PhongBan findTenPhongBanByMaPhongBan(String maPhongBan);
	public List<QuanHuyen> findQuanHuyenByIdThanhPho(String maThanhPho);
	public List<XaPhuong> findXaPhuongByIdQuanHuyen(String maQuanHuyen);
}
