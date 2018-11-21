package ffse1704.model;

import java.util.List;

import ffse1704.entity.SinhVien;

public interface SinhVienDao {
	
	public void addSV(SinhVien p);

	public void update(SinhVien p);

	public void delete(int id);

	public SinhVien getSinhVienById(int id);

	public List<SinhVien> getAllSinhVien();

	/*public List<SinhVien> getEmployeesByPage(int pageid, int total);

	public int countSV();*/



}
