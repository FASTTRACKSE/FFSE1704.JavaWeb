package fasttrackse.ffse1704.fbms.dao.quanlytailieu.dung;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung.Document;
import fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung.TrangThai;
import fasttrackse.ffse1704.fbms.entity.security.PhongBan;

@Repository
@Transactional
public class DocumentDAOImplDung implements DocumentDAODung {
	@Autowired
	private SessionFactory sessionFactory;

	// list
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Document> getAll() {
		return sessionFactory.openSession().createCriteria(Document.class).list();	
	}

	public List<Document> getAllPublicDocument() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Document> cq = cb.createQuery(Document.class);
		Root<Document> root = cq.from(Document.class);
		Join<Document, TrangThai> MaTrangThaiJoin = root.join("ma_trang_thai");
		Join<Document, PhongBan> PhongBanJoin = root.join("ma_truy_cap");
		cq.select(root).where(cb.and(cb.equal(MaTrangThaiJoin.get("ma_trang_thai"), "da_phe_duyet"),
				cb.equal(PhongBanJoin.get("ma_truy_cap"), "all")));
		List<Document> listPublicDocument = session.createQuery(cq).getResultList();
		return listPublicDocument;
	}

	public void saveDraft(final Document document) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(document);
	}
	
	
	public List<PhongBan> listQuyen() {
		Session session = sessionFactory.getCurrentSession();
		Query<PhongBan> query = session.createQuery("from PhongBan", PhongBan.class);
		List<PhongBan> list = (List<PhongBan>) query.list();
		return list;
	}
}
