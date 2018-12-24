package fasttrackse.ffse1704.fbms.dao.quanlynhiemvu.khanhcn;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn.CongViecKhanhCN;
import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn.DuAnKhanhCN;
import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn.LoaiCongViec;
import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn.NhanVienDuAn;
import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn.NhanVienKhanhCN;
import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn.TrangThaiKhanhCN;

public interface QuanLyNhiemVuDao {

	public List<CongViecKhanhCN> congViec();

	public CongViecKhanhCN findByID(int id);

	public void addCongViec(CongViecKhanhCN cv);

	public void updateCongViec(CongViecKhanhCN cv);

	public void deleteCongViec(int id);

	public List<TrangThaiKhanhCN> trangThai();

	public List<LoaiCongViec> loaiCongViec();

	public List<DuAnKhanhCN> duAn();
	
	public List<NhanVienDuAn> nhanVienDuAn();

	public List<NhanVienKhanhCN> nhanVien();

	
}
