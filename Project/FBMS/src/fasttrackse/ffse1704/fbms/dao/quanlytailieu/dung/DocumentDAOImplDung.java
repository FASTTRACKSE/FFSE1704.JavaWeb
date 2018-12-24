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

import fasttrackse.ffse1704.fbms.entity.quanlytailieu.Doanhnt.DanhMuc;
import fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung.DanhMucDung;
import fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung.DocumentDung;
import fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung.TrangThaiDung;
import fasttrackse.ffse1704.fbms.entity.security.PhongBan;

@Repository
@Transactional
public class DocumentDAOImplDung implements DocumentDAODung {
	@Autowired
	private SessionFactory sessionFactory;

	// list
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<DocumentDung> getAll() {
		return sessionFactory.openSession().createCriteria(DocumentDung.class).list();	
	}

	public List<DocumentDung> getAllPublicDocument() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<DocumentDung> cq = cb.createQuery(DocumentDung.class);
		Root<DocumentDung> root = cq.from(DocumentDung.class);
		Join<DocumentDung, TrangThaiDung> MaTrangThaiJoin = root.join("ma_trang_thai");
		Join<DocumentDung, PhongBan> PhongBanJoin = root.join("ma_truy_cap");
		cq.select(root).where(cb.and(cb.equal(MaTrangThaiJoin.get("ma_trang_thai"), "da_phe_duyet"),
				cb.equal(PhongBanJoin.get("ma_truy_cap"), "all")));
		List<DocumentDung> listPublicDocument = session.createQuery(cq).getResultList();
		return listPublicDocument;
	}
	// list pending approve
		public List<DocumentDung> getAllPendingApprove() {
			Session session = sessionFactory.getCurrentSession();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<DocumentDung> cq = cb.createQuery(DocumentDung.class);
			Root<DocumentDung> root = cq.from(DocumentDung.class);
			Join<DocumentDung, TrangThaiDung> MaTrangThaiJoin = root.join("maTrangThai");
			cq.select(root).where(cb.equal(MaTrangThaiJoin.get("maTrangThai"), "cho_phe_duyet"));
			List<DocumentDung> listPendingApprove = session.createQuery(cq).getResultList();
			return listPendingApprove;
		}
	// list refure document	
		public List<DocumentDung> getAllDocumentRefuse() {
			Session session = sessionFactory.getCurrentSession();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<DocumentDung> cq = cb.createQuery(DocumentDung.class);
			Root<DocumentDung> root = cq.from(DocumentDung.class);
			Join<DocumentDung, TrangThaiDung> MaTrangThaiJoin = root.join("maTrangThai");
			cq.select(root).where(cb.equal(MaTrangThaiJoin.get("maTrangThai"), "tu_choi"));
			List<DocumentDung> listRefuseDocument = session.createQuery(cq).getResultList();
			return listRefuseDocument;
		}
	public void saveDraft(final DocumentDung documentDung) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(documentDung);
	}
	
	// delete
		public void delete(final int id) {
			Session session = this.sessionFactory.getCurrentSession();
			DocumentDung document = findById(id);
			session.remove(document);
		}
		
		// update
		public void updateDocument(final DocumentDung document) {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(document);
			;
		}
		// find by id
				public DocumentDung findById(final int id) {
					Session session = this.sessionFactory.getCurrentSession();
					return session.get(DocumentDung.class, id);
				}
				
		// accept
				public void accept( final DocumentDung document) {
					Session session = this.sessionFactory.getCurrentSession();
					TrangThaiDung st = new TrangThaiDung();
					st.setMaTrangThai("da_phe_duyet");
					document.setMaTrangThai(st);
					session.update(document);

				}
		// refuse
				public void refuse(final DocumentDung document) {
					Session session = this.sessionFactory.getCurrentSession();
					TrangThaiDung st = new TrangThaiDung();
					st.setMaTrangThai("tu_choi");
					document.setMaTrangThai(st);
					session.update(document);
				}
	
	public List<PhongBan> listQuyen() {
		Session session = sessionFactory.getCurrentSession();
		Query<PhongBan> query = session.createQuery("from PhongBan", PhongBan.class);
		List<PhongBan> list = (List<PhongBan>) query.list();
		return list;
	}
	
	public List<DanhMucDung> listCategory() {
		Session session = sessionFactory.getCurrentSession();
		Query<DanhMucDung> query = session.createQuery("from DanhMucDung", DanhMucDung.class);
		List<DanhMucDung> listCategory = (List<DanhMucDung>) query.list();
		return listCategory;
	}
}
