package fasttrackse.quanlysinhvien.service;

import java.util.List;

import fasttrackse.quanlysinhvien.entity.SinhVien;

public interface SinhVienService {

	public List<SinhVien> listStudent();

	public void addStudent(SinhVien sv);

	public void updateStudent(SinhVien sv);

	public void deleteSinhVien(int id);

	public SinhVien getSinhVienById(int id);
	
	public List<SinhVien> findAll(Integer offset, Integer maxResult);

	public int count();
}
