package com.quanlysinhvien.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quanlysinhvien.dao.StudentDao;
import com.quanlysinhvien.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	@Transactional
	public List<Student> getStudentloyeesByPage(int pageid, int total) {
		return this.studentDao.getStudentloyeesByPage(pageid, total);
	}

	@Override
	@Transactional
	public long countStudent() {
		return this.studentDao.countStudent();
	}

	@Override
	@Transactional
	public void addStudent(Student sv) {
		this.studentDao.addStudent(sv);
	}

	@Override
	@Transactional
	public void update(Student sv) {
		this.studentDao.update(sv);
	}

	@Override
	@Transactional
	public void delete(int id) {
		this.studentDao.delete(id);
	}

	@Override
	@Transactional
	public Student getStudentById(int id) {
		return this.studentDao.getStudentById(id);
	}
}