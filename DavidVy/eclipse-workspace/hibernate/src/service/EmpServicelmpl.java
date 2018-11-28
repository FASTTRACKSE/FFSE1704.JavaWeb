package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.EmpDao;
import entity.Emp;

@Service
@Transactional
public class EmpServicelmpl implements EmpService{

	@Autowired
	EmpDao empDao;

	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}
	
	//
	public List<Emp> listStudent() {
		return empDao.listStudent();
	}

}
