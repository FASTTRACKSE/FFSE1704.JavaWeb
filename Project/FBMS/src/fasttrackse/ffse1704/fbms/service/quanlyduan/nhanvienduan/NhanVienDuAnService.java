package fasttrackse.ffse1704.fbms.service.quanlyduan.nhanvienduan;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlyduan.nhanvienduan.NhanVienDuAn;

public interface NhanVienDuAnService {

	public void addNew(NhanVienDuAn nhanVienDuAn);

	public void update(NhanVienDuAn nhanVienDuAn);

	public void delete(String maDuAn, String maNhanVien);

	public NhanVienDuAn getNhanVienDuAnByIdDuAnAndIdNhanVien(String maDuAn, String maNhanVien);

	public List<NhanVienDuAn> listNhanVienDuAn(int iDisPlayStart, int iDinPlayLength);

	public int getRecordsTotal();
}
