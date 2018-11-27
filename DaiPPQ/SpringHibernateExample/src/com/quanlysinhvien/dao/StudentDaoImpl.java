package com.quanlysinhvien.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quanlysinhvien.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	@SuppressWarnings("unchecked")
	public List<Student> listStudent() {
		Session session = sessionFactory.getCurrentSession();
		List<Student> list = session.createQuery("from sinhvien ").getResultList();
		return list;
	}
	*/

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getStudentloyeesByPage(int pageid, int total) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		List<Student> listStudent = session.createQuery("FROM Student").setFirstResult(pageid).setMaxResults(total).list();
		return listStudent;
	}

	@Override
	public long countStudent() {
		return (Long) sessionFactory.getCurrentSession().createCriteria(Student.class)
				.setProjection(Projections.rowCount()).uniqueResult();
		/*
		 * Session session = sessionFactory.getCurrentSession(); int rowCount =
		 * session.createQuery("from sinhvien").list().size(); return rowCount;
		 */
	}

	@Override
	public void addStudent(Student sv) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		session.persist(sv);
	}
	
	@Override
	public void update(Student sv) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		session.update(sv);
	}
	
	@Override
	public void delete(int id) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		Student sv = session.load(Student.class, id);
		if(null != sv) {
			session.delete(sv);
		}
	}
	
	@Override
	public Student getStudentById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Student sv = (Student) session.get(Student.class, id);
		return sv;
	}
}
