package com.bushansirgur.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bushansirgur.dao.StudentDAO;
import com.bushansirgur.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDAO studentDAO;

	@Override
	@Transactional
	public void saveStudentObj(Student studentObj) {
		studentDAO.saveStudentObj(studentObj);
	}

	@Override
	@Transactional
	public List<Student> getAllStudents() {
		return studentDAO.getAllStudents();
	}

	@Override
	@Transactional
	public Student getStudentObj(int theId) {
		return studentDAO.getStudentObj(theId);
	}

	@Override
	@Transactional
	public void removeStudentObj(int theId) {
		studentDAO.removeStudentObj(theId);
	}

}