package fasttrackse.ffse1704.fbms.dao.quanlytailieu.synv;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1704.fbms.entity.quanlytailieu.synv.*;

@Repository
public class DocumentDAOImplSy implements DocumentDAOSy {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<DocumentSy> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Document",DocumentSy.class).list();

	}


	@Override
	public void addNew (DocumentSy document) {
		Session session=this.sessionFactory.getCurrentSession();
		session.save(document);
	}

	@Override
	public void update(DocumentSy document) {
		Session session=this.sessionFactory.getCurrentSession();
		session.update(document);
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		DocumentSy db=session.get(DocumentSy.class,id);	
		session.delete(db);	
	}


	@Override
	public DocumentSy getById(int id) {
		Session session=this.sessionFactory.getCurrentSession();
		return session.get(DocumentSy.class,id);	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DocumentSy> findAllForPaging(int startPosition, int maxResult) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Document").setFirstResult(startPosition).setMaxResults(maxResult).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CategorySy> listCategory() {
		Session session = this.sessionFactory.openSession();
		List<CategorySy> list = session.createQuery("from Category").list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StatusSy> listStatus() {
		Session session = this.sessionFactory.openSession();
		List<StatusSy> list = session.createQuery("from Status").list();
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
