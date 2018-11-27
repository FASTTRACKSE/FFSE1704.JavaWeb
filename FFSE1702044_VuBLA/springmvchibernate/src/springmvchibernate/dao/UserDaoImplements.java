package springmvchibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmvchibernate.entity.User;

@Repository("userDao")
@Transactional(rollbackFor= Exception.class)
public class UserDaoImplements implements UserDao {
	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void create(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println(user.getMaSV());
		session.persist(user);

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> listUser() {
		Session session = sessionFactory.getCurrentSession();
		List<User> list = session.createQuery("from User").getResultList();
		return list;
	}

	@Override
	public User findById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User u = (User) session.get(User.class, id);
		return u;
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(findById(id));
	}

	@Override
	public void update(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(user);
	}
	
	
/*	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllForPaging() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from User").setFirstResult(startPosition).setMaxResults(maxResult).list();
	}*/
}
