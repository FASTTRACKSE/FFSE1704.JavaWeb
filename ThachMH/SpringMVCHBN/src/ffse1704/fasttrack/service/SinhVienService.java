package ffse1704.fasttrack.service;

import java.util.List;

import ffse1704.fasttrack.entity.SinhVien;

public interface SinhVienService {
	public List<SinhVien> getAllSinhViens();
	public void saveSV(SinhVien v);
	public SinhVien getSinhVien(int theId);
	public void deleteSV(int theId);
}
