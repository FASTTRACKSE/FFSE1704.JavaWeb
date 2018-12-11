package fasttrackse.ffse1704.fbms.dao.quanlynhansu;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import fasttrackse.ffse1704.fbms.entity.quanlynhansu.CheDoHuong;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.HopDong;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.NhanSu;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ThongTinHopDong;

@Repository
@Transactional(rollbackFor = Exception.class)
public class HopDongDaoImpl implements HopDongDao {
	
	NhanSu nhanSu;
	
	public NhanSu getNhanSu() {
		return nhanSu;
	}

	public void setNhanSu(NhanSu nhanSu) {
		this.nhanSu = nhanSu;
	}

	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<HopDong> listHopDong() {
		Session session = sessionFactory.getCurrentSession();
		List<HopDong> listHopDong = session.createQuery("from HopDong").getResultList();
		return listHopDong;
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<CheDoHuong> listCheDoHuong() {
		Session session = sessionFactory.getCurrentSession();
		List<CheDoHuong> listCheDoHuong = session.createQuery("from CheDoHuong").getResultList();
		return listCheDoHuong;
	}
	
	@Override
	public void saveHopDongCheDo(ThongTinHopDong thongtinhopdong) {
		Session session = sessionFactory.getCurrentSession();
		session.save(thongtinhopdong);
	}
	@Override
	public void editHopDong(ThongTinHopDong thongtinhopdong) {
		Session session = this.sessionFactory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		session.update(thongtinhopdong);
		tx.commit();
		session.close();
	}
	@Override
	public ThongTinHopDong findById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		ThongTinHopDong sv = (ThongTinHopDong) session.get(ThongTinHopDong.class, id);
		return sv;
	}
	
	@Override
	public void deleteHopDong(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		nhanSu.listHopDong.remove(findById(id));
		session.save(nhanSu);
	}
}
