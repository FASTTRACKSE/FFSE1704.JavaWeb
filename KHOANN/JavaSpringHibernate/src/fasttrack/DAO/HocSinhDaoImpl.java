package fasttrack.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fasttrack.entity.*;

@Repository
@Transactional(rollbackFor = Exception.class)
public class HocSinhDaoImpl implements HocSinhDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*@SuppressWarnings("unchecked")
	@Override
	public List<HocSinh> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		List<HocSinh> list = session.createQuery("from HocSinh").list();
		return list;
	}*/

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
	public HocSinh getHocSinhByID(String maSV) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<HocSinh> listSV = session.createQuery("from HocSinh where maSV = '" + maSV + "'", HocSinh.class).list();
		HocSinh sv = listSV.get(0);
		return sv;
	}

	@Override
	public void delhs(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		HocSinh hs = (HocSinh) session.load(HocSinh.class, new Integer(id));
		session.delete(hs);

	}

	@SuppressWarnings("unchecked")
	public List<HocSinh> findAll(Integer offset, Integer maxResult) {
		Session session = sessionFactory.getCurrentSession();

		List<HocSinh> students = session.createQuery("from HocSinh").setFirstResult(offset).setMaxResults(maxResult)
				.list();
		return students;
	}

	@Override
	public int count() {

		Session session = sessionFactory.getCurrentSession();
		int rowCount = session.createQuery("from HocSinh").list().size();
		return rowCount;

	}
	
	@Override
	public List<DiemHocSinh> getDiemHocSinh(String maSV) {
		Session session = sessionFactory.getCurrentSession();
		List<DiemHocSinh> listDiem = session.createQuery("from DiemHocSinh where maSV='"+ maSV +"'", DiemHocSinh.class).list();
		return listDiem;
	}

}
