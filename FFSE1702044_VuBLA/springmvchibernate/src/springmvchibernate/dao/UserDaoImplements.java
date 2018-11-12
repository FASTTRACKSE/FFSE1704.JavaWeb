package springmvchibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springmvchibernate.entity.User;

@Repository("userDao")
public class UserDaoImplements implements UserDao{
	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void addUser(User user) {
		Session session= this.sessionFactory.getCurrentSession();
		session.persist(user);
	}
}
