package ffsespring.service;

import java.util.List;

import ffsespring.entity.DiemSinhVien;
import ffsespring.entity.SinhVien;

public interface SVService {
	public void addSinhVien(SinhVien sv);
	public void updateSinhVien(SinhVien sv);
	public List<SinhVien> listSinhVien(int start,int end);
	public SinhVien getSinhVien(String maSinhVien);
	public void deleteSinhVien(int id);
	public int countSinhVien();
	public List<DiemSinhVien> getDiemSinhVien(String maSinhVien);
}
