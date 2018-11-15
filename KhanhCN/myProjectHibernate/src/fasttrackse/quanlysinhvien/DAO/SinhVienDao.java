package fasttrackse.quanlysinhvien.DAO;

import java.util.List;

import fasttrackse.quanlysinhvien.entity.SinhVien;

public interface SinhVienDao {

	public List<SinhVien> listStudent();

	public void addStudent(SinhVien sv);

	public void editStudent(SinhVien sv);

	public void deleteSinhVien(int id);

	public SinhVien getSinhVienById(int id);

	public List<SinhVien> findAll(Integer offset, Integer maxResult);

	public int count();
}
