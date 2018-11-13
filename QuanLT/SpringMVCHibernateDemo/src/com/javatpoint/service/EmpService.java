package com.javatpoint.service;
import java.util.List;

import java.util.List;

import com.javatpoint.entity.*;

public interface EmpService {
	public List<Emp> listSV();
	public List<City> listTT();

	public Emp fintByTd(int id);

	public void delete(int id);

	public void edit(Emp emp);

	public void add(Emp sinhVien);

	public List<Emp> findAllForPaging(int startPosition, int maxResult);
}
