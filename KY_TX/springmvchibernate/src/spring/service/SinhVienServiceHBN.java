package spring.service;

import java.util.List;

import spring.entity.SinhVien;
import spring.entity.TinhThanh;

public interface SinhVienServiceHBN {
	public List<SinhVien> listSV();
	public List<TinhThanh> listTT();

	public SinhVien fintByTd(int id);

	public void delete(int id);

	public void edit(SinhVien sinhVien);

	public void add(SinhVien sinhVien);

	public List<SinhVien> findAllForPaging(int startPosition, int maxResult);
}
