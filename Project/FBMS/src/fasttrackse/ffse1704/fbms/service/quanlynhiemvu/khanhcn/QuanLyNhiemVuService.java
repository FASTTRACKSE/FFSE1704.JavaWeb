package fasttrackse.ffse1704.fbms.service.quanlynhiemvu.khanhcn;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn.CongViecKhanhCN;
import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn.DuAnKhanhCN;

public interface QuanLyNhiemVuService {

	public List<DuAnKhanhCN> duAn();

	public List<CongViecKhanhCN> congViec();

	public void addCongViec(CongViecKhanhCN cv);
}
