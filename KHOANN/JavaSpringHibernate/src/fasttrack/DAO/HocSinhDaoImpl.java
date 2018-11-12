package fasttrack.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fasttrack.entity.*;

@Repository
@Transactional(rollbackFor= Exception.class)
public  class HocSinhDaoImpl  implements HocSinhDao{
	@Autowired
	private SessionFactory sessionFactory;

	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}



	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<HocSinh> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		List<HocSinh> list= session.createQuery("from HocSinh").list();
		return list;
	}



	@Override
	public void addHS(HocSinh hs) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(hs);
	}



	@Override
	public void updatehs(HocSinh hs) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(hs);
	}



	@Override
	public HocSinh getHocSinhByID(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(HocSinh.class, id);
	}



	@Override
	public void delhs(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		HocSinh hs = (HocSinh) session.load(HocSinh.class, new Integer(id));
		session.delete(hs);
		
	}



	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<HocSinh> findAllForPaging(int startPosition, int maxResult) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query hs = session.createQuery("from HocSinh");
		hs.setFirstResult(startPosition);
		hs.setMaxResults(maxResult);
		
		return hs.list();	
	}


	

}
