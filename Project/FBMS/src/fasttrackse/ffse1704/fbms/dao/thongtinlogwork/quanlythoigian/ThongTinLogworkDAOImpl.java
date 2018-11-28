package fasttrackse.ffse1704.fbms.dao.thongtinlogwork.quanlythoigian;


	import java.util.List;

	import javax.persistence.Query;

	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.Transaction;
	import org.springframework.beans.factory.annotation.Autowired;

	import fasttrackse.ffse1704.fbms.entity.quanlythoigian.Logwork;

	public class ThongTinLogworkDAOImpl implements ThongTinLogworkDAO  {
		@Autowired
		private SessionFactory sessionFactory;

		@SuppressWarnings("unchecked")
		@Override
		public List<Logwork> findAll() {
			Session session = this.sessionFactory.openSession();
			List<Logwork> list = session.createQuery("from Logwork").list();
			session.close();
			return list;
		}

		@Override
		public void addNew(Logwork logwork) {
			Session session = this.sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.persist(logwork);
			transaction.commit();
			session.close();

		}

		@Override
		public void update(Logwork logwork) {
			Session session = this.sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.update(logwork);
			;
			transaction.commit();
			session.close();

		}

		@Override
		public void delete(String id) {
			Session session = this.sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.delete(session.get(Logwork.class, id));
			transaction.commit();
			session.close();

		}

		@Override
		public Logwork findByIdLogwork(String id) {
			Session session = this.sessionFactory.openSession();
			Logwork logwork = session.get(Logwork.class, id);
			session.close();
			return logwork;

		}

		@Override
		@SuppressWarnings("unchecked")
		public List<Logwork> findAll(int iDisplayStart, int iDisplayLength, String sql) {
			Session session = this.sessionFactory.openSession();
			List<Logwork> listLogwork = session.createQuery(sql).setFirstResult(iDisplayStart).setMaxResults(iDisplayLength)
					.list();
			session.close();
			return listLogwork;
		}

		@Override
		public String getRecordsTotal() {
			Session session = this.sessionFactory.openSession();
			String sql = "SELECT COUNT(*) FROM 'qltg_logwork'";
			Query query = session.createSQLQuery(sql);
			String recordsTotal = query.getSingleResult().toString();
			session.close();
			return recordsTotal;
		}

		@Override
		public String getRecordsFiltered(String sql) {
			Session session = this.sessionFactory.openSession();
			Query query = session.createQuery(sql.replace("select logwork", "select count(*)"));
			String recordsFilterd = query.getSingleResult().toString();
			session.close();
	 		return recordsFilterd;
		}
	}
