package fasttrackse.ffse1704.fbms.dao.quanlyduan.programminglanguage;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1704.fbms.entity.quanlyduan.programminglanguage.ProgrammingLanguage;

/**
 * @author Joker
 *
 */
@Repository
public class ProgrammingLanguageDaoIPM implements ProgrammingLanguageDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addNew(ProgrammingLanguage programmingLanguage) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(programmingLanguage);
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(programmingLanguage);

	}

	@Override
	public void delete(String maProgrammingLanguage) {
		Session session = this.sessionFactory.openSession();
		Transaction pd = session.beginTransaction();
		session.update(session.get(ProgrammingLanguage.class, maProgrammingLanguage));
		pd.commit();
		session.close();

	}

	@Override
	public ProgrammingLanguage getProgrammingLanguageByIdProgrammingLanguage(String maProgrammingLanguage) {
		Session session = this.sessionFactory.openSession();
		ProgrammingLanguage programmingLanguage = session.get(ProgrammingLanguage.class, maProgrammingLanguage);
		session.close();
		return programmingLanguage;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProgrammingLanguage> listProgrammingLanguage(int iDisPlayStart, int iDinPlayLength) {
		Session session = this.sessionFactory.getCurrentSession();
		List<ProgrammingLanguage> programmingLanguageList = session.createQuery("from ProgrammingLanguage")
				.setFirstResult(iDisPlayStart).setMaxResults(iDinPlayLength).list();
		return programmingLanguageList;
	}

	@Override
	public int getRecordsTotal() {
		Session session = sessionFactory.getCurrentSession();
		int rowCount = session.createQuery("from ProgrammingLanguage").list().size();
		return rowCount;
	}

}
