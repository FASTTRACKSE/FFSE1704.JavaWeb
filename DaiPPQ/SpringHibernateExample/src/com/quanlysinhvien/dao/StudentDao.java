package com.quanlysinhvien.dao;

import java.util.List;

import com.quanlysinhvien.entity.Student;

public interface StudentDao {
	/*public List<Student> listStudent();*/

	public List<Student> getStudentloyeesByPage(int pageid, int total);

	public long countStudent();

	public void addStudent(Student sv);

	public void update(Student sv);

	public void delete(int id);

	public Student getStudentById(int id);
}
