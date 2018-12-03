package fasttrackse.ffse1704.fbms.dao.quanlynhiemvu.khanhcn;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn.CongViecKhanhCN;
import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn.DuAnKhanhCN;

public interface QuanLyNhiemVuDao {

	public List<DuAnKhanhCN> duAn();

	public List<CongViecKhanhCN> congViec();
	
	public void addCongViec(CongViecKhanhCN cv);
}
