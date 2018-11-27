package com.javatpoint.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javatpoint.dao.EmpDao;
import com.javatpoint.entity.City;
import com.javatpoint.entity.Emp;
@Service
@Transactional
public class  EmpServiceImpl implements EmpService {
	@Autowired
	EmpDao empDao;

	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}
	
	//
	public void add(Emp emp) {
		empDao.add(emp);
	}
	public List<Emp> listStudent() {
		return empDao.listStudent();
	}
	public List<City> listTinhThanh() {
		return empDao.listTinhThanh();
	}
	
	public void edit(Emp emp) {
		empDao.edit(emp);
	}
	
	public Emp findById(int id) {
		return empDao.findById(id);
	}
	public void delete(int id) {
		empDao.delete(id);
	}
	public List<Emp> findAllForPaging(int startPosition, int maxResult) {
		return empDao.findAllForPaging(startPosition, maxResult);
	}
}