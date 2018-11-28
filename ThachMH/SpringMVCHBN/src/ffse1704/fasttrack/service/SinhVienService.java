package ffse1704.fasttrack.service;

import java.util.List;

import ffse1704.fasttrack.entity.SinhVien;

public interface SinhVienService {
	//public List<SinhVien> getAllSinhViens();
	
	public void addSV(SinhVien v);


	public void saveSV(SinhVien v);

	public SinhVien getSinhVien(int theId);

	public void deleteSV(int theId);
	
	public List<SinhVien> findAll(Integer offset, Integer maxResult);

	public int count();
}
