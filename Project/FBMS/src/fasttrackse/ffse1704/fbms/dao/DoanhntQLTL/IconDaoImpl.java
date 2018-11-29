package fasttrackse.ffse1704.fbms.dao.DoanhntQLTL;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1704.fbms.entity.DoanhntQLTL.Icon;

@Repository
public class IconDaoImpl implements IconDao {
	@Autowired
	private SessionFactory sessionFac;

	@SuppressWarnings("unchecked")
	@Override
	public List<Icon> listAllIconTaiLieu() {
		Session session = this.sessionFac.openSession();
		List<Icon> list = session.createQuery("from IconTaiLieu where isDelete = 0").list();
		session.close();
		return list;
	}

	@Override
	public void addIC(Icon ic) {
		Session session = this.sessionFac.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(ic);
		tx.commit();
		session.close();
	}

	@Override
	public void updateIC(Icon ic) {
		Session session = this.sessionFac.openSession();
		Transaction tx = session.beginTransaction();
		session.update(ic);
		tx.commit();
		session.close();
	}

	@Override
	public void deleteIC(String maIcon) {
		Session session = this.sessionFac.openSession();
		Transaction ts = session.beginTransaction();
		session.delete(session.get(Icon.class, maIcon));
		ts.commit();
		session.close();
	}

	@Override
	public Icon getICbyID(String maIcon) {
		Session session = this.sessionFac.openSession();
		Icon ic = session.get(Icon.class, maIcon);
		session.close();
		return ic;
	}
	
}