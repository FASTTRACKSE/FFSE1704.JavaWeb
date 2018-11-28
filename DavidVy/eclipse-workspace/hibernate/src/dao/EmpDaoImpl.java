package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.Emp;

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
	@Override
	@SuppressWarnings("unchecked")
	public List<Emp> listStudent() {
		Session session = sessionFactory.getCurrentSession();
		List<Emp> list = session.createQuery("from Emp").getResultList();
		return list;
	}
	

	
	
}
