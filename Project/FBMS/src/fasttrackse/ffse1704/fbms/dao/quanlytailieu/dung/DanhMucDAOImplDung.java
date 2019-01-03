package fasttrackse.ffse1704.fbms.dao.quanlytailieu.dung;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung.DanhMucDung;
import fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung.DocumentDung;
import fasttrackse.ffse1704.fbms.entity.security.PhongBan;

@Repository
@Transactional(rollbackFor = Exception.class)
// 2 cái này
public class DanhMucDAOImplDung implements DanhMucDAODung {
	@Autowired
	//cái này
	private SessionFactory sessionFactory;

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<DanhMucDung> getAll() {
		return sessionFactory.openSession().createCriteria(DanhMucDung.class).list();
	}

	public void addDanhMuc(DanhMucDung danhmuc) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(danhmuc);

	}

	public void updateDanhMuc(DanhMucDung danhmuc) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(danhmuc);

	}
	public void deleteDanhMuc(final int id) {
		Session session = this.sessionFactory.getCurrentSession();
		DanhMucDung danhmuc = findById(id);
		session.remove(danhmuc);
	}
	
	// find by id
	public DanhMucDung findById(final int id) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(DanhMucDung.class, id);
	}
	
	public List<PhongBan> listQuyen() {
		Session session = sessionFactory.getCurrentSession();
		Query<PhongBan> query = session.createQuery("from PhongBan", PhongBan.class);
		List<PhongBan> list = (List<PhongBan>) query.list();
		return list;
	}
}
