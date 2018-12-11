package fasttrackse.ffse1704.fbms.dao.quanlynhansu;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ChungChi;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.NhanSu;

@Repository
@Transactional(rollbackFor = Exception.class)
public class ChungChiDaoImpl implements ChungChiDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


}
