package fasttrackse.ffse1704.fbms.dao.quanlyduan.vaitrothanhvien;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlyduan.vaitrothanhvien.VaiTroThanhVien;

public interface VaiTroThanhVienDao {

	public void addNew(VaiTroThanhVien vaiTroThanhVien);

	public void update(VaiTroThanhVien vaiTroThanhVien);

	public void delete(String VaiTroThanhVienDao);

	public VaiTroThanhVien getVaiTroThanhVienByIdVaiTroThanhVien(String maVaiTroThanhVienDao);

	public List<VaiTroThanhVien> listVaiTroThanhVien(int iDisPlayStart, int iDinPlayLength);

	public int getRecordsTotal();
}
