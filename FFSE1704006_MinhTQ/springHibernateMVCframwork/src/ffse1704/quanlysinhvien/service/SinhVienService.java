package ffse1704.quanlysinhvien.service;

import java.util.List;

import ffse1704.quanlysinhvien.entity.SinhVien;

public interface SinhVienService {
	public List<SinhVien> listSinhVien();

	public SinhVien findById(int id);

	public void delete(int id);

	public void edit(SinhVien sinhvien);

	public void add(SinhVien sinhvien);
	
	public List<SinhVien> findAllForPaging(int startPosition,int maxResult);
}