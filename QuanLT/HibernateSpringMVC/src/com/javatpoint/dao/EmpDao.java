package com.javatpoint.dao;
import java.util.List;

import com.javatpoint.entity.*;

public interface  EmpDao {
	public List<Emp> listStudent();
	public void add(Emp emp);
	public List<City> listTinhThanh();
	public Emp findById(int id);
	public void edit(Emp emp);
	public void delete(int id);
	public List<Emp> findAllForPaging(int startPosition,int maxResult);
}
