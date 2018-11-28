package com.javatpoint.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.javatpoint.entity.*;

@Repository
@Transactional(rollbackFor = Exception.class)
public class EmpDaoImpl implements EmpDao {
	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void add(Emp sinhVien) {
		Session session = sessionFactory.getCurrentSession();
		session.save(sinhVien);
	}

	@SuppressWarnings("unchecked")
	public List<Emp> listStudent() {
		Session session = sessionFactory.getCurrentSession();
		List<Emp> list = session.createQuery("from Emp").getResultList();
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<City> listTinhThanh() {
		Session session = sessionFactory.getCurrentSession();
		List<City> listTinhThanh = session.createQuery("from City").getResultList();
		return listTinhThanh;
	}

	@Override
	public Emp findById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Emp sv = (Emp) session.get(Emp.class, id);
		return sv;
	}

	@Override
	public void edit(Emp emp) {
		Session session = this.sessionFactory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		session.update(emp);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(findById(id));
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Emp> findAllForPaging(int startPosition,int maxResult){
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Emp");
		q.setFirstResult(startPosition);
		q.setMaxResults(maxResult);
		
		return q.list();		
	}
}
