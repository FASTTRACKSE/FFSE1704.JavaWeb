package com.javatpoint.dao;
import java.util.List;

import com.javatpoint.entity.*;

public interface  EmpDao {
	public List<Emp> listStudent();
	public List<City> listTinhThanh();
	public Emp findById(int id);
	public void add(Emp sinhVien);
	public void edit(Emp sinhVien);
	public void delete(int id);
	public List<Emp> findAllForPaging(int startPosition,int maxResult);
}
