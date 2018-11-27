package ffse1704.model;

import java.util.List;

import ffse1704.entity.BangDiem;
import ffse1704.entity.SinhVien;

public interface SinhVienDAO  {

	public void addSV(SinhVien p);

	public void update(SinhVien p);

	public void delete(int id);

	public SinhVien getSinhVienById(int id);

	public List<BangDiem> getDiemSV(String maSV);

	public List<SinhVien> getEmployeesByPage(int pageid, int total);

	public long countSV();
}
