package fasttrack.dao;

import java.util.List;

import fasttrack.entity.SinhVien;
import fasttrack.entity.TinhThanh;

public interface SinhVienDao {
	public List<SinhVien> listStudent();
	public List<TinhThanh> listTinhThanh();
	public SinhVien findById(int id);
	public void add(SinhVien sinhVien);
	public void edit(SinhVien sinhVien);
	public void delete(int id);
	public List<SinhVien> findAllForPaging(int startPosition,int maxResult);
}