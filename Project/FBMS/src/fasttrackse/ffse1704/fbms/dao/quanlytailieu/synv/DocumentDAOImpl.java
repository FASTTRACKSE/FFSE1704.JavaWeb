package fasttrackse.ffse1704.fbms.dao.quanlytailieu.synv;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1704.fbms.entity.quanlytailieu.synv.*;

@Repository
public class DocumentDAOImpl implements DocumentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Document> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Document",Document.class).list();

	}


	@Override
	public void addNew (Document document) {
		Session session=this.sessionFactory.getCurrentSession();
		session.save(document);
	}

	@Override
	public void update(Document document) {
		Session session=this.sessionFactory.getCurrentSession();
		session.update(document);
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Document db=session.get(Document.class,id);	
		session.delete(db);	
	}


	@Override
	public Document getById(int id) {
		Session session=this.sessionFactory.getCurrentSession();
		return session.get(Document.class,id);	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Document> findAllForPaging(int startPosition, int maxResult) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Document").setFirstResult(startPosition).setMaxResults(maxResult).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> listCategory() {
		Session session = this.sessionFactory.openSession();
		List<Category> list = session.createQuery("from Category").list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Status> listStatus() {
		Session session = this.sessionFactory.openSession();
		List<Status> list = session.createQuery("from Status").list();
		session.close();
		return list;
	}
	
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Room> listRoom() {
//		Session session = this.sessionFactory.openSession();
//		List<Room> list = session.createQuery("from Room").list();
//		session.close();
//		return list;
//	}
	

}
