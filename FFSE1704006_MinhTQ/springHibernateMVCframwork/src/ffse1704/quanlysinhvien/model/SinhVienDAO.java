package ffse1704.quanlysinhvien.model;

import java.util.List;

import ffse1704.quanlysinhvien.entity.SinhVien;

public interface SinhVienDAO {
	public List<SinhVien> listSinhVien();

	public SinhVien findById(int id);

	public void delete(int id);

	public void edit(SinhVien sinhvien);

	public void add(SinhVien sinhvien);

	List<SinhVien> findAll(Integer offset, Integer maxResult);

	public int count();
}
