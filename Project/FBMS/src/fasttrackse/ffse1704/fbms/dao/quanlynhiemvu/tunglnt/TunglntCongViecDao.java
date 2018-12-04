package fasttrackse.ffse1704.fbms.dao.quanlynhiemvu.tunglnt;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.tunglnt.TunglntCongViec;
import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.tunglnt.TunglntDuAn;
import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.tunglnt.TunglntLoaiCongViec;
import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.tunglnt.TunglntTrangThai;
import fasttrackse.ffse1704.fbms.entity.security.HoSoNhanVien;

public interface TunglntCongViecDao {
	
	public List<TunglntCongViec> AllCV();
	
	public List<TunglntTrangThai> trangThai();
 	
 	public List<TunglntLoaiCongViec> loaiCongViec();
 	
 	public List<TunglntDuAn> duAn();
 	
 	public List<HoSoNhanVien> nhanVien();
}
