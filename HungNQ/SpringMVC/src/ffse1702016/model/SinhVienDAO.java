package ffse1702016.model;

import java.util.List;

import ffse1702016.entity.SinhVien;

public interface SinhVienDAO  {

	public void addSV(SinhVien p);

	public void update(SinhVien p);

	public void delete(int id);

	public SinhVien getSinhVienById(int id);

	public List<SinhVien> getEmployeesByPage(int pageid, int total);

	public long countSV();
}