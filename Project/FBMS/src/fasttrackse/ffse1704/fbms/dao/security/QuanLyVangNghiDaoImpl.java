package fasttrackse.ffse1704.fbms.dao.security;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1704.fbms.entity.security.DonNghi;
import fasttrackse.ffse1704.fbms.entity.security.LoaiNghi;
import fasttrackse.ffse1704.fbms.entity.security.TinhTrangNghi;
import fasttrackse.ffse1704.fbms.entity.security.UserAccount;

@Repository
public class QuanLyVangNghiDaoImpl implements QuanLyVangNghiDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void adddon(DonNghi dn) {
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println(dn);
		session.save(dn);
	}

	@Override
	public List<DonNghi> listDonNghiNhap(int idnv) {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<DonNghi> listDn = session.createQuery("from DonNghi where id_nv ='"+idnv+"' and tinh_trang = "+0+" ").list();
		session.close();
		return listDn;
	}

	@Override
	public UserAccount getthongtinuser(String username) {
		
		Session session = this.sessionFactory.openSession();
		UserAccount user = session.createQuery("from UserAccount where username='" + username + "'", UserAccount.class)
				.getSingleResult();
		session.close();
		return user;
	}

	@Override
	public TinhTrangNghi getTinhTrang(int idnv) {
		TinhTrangNghi tinhTrang = null;
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			tinhTrang = session.createQuery("from TinhTrangNghi where id_nv=" + idnv + "", TinhTrangNghi.class).getSingleResult();
		}catch (Exception e) {
			tinhTrang= null;
		}
		
		session.close();
		return tinhTrang;
	}

	@Override
	public List<LoaiNghi> listLoaiNghi() {
		Session session = this.sessionFactory.openSession();
		List<LoaiNghi> list = session.createQuery("from LoaiNghi").list();
		session.close();
		return list;
	}

	@Override
	public void insertTinhTrang(int idnv, TinhTrangNghi tt) {
		
		TinhTrangNghi tinhTrang = new TinhTrangNghi();
		Session session = null;
		tinhTrang = getTinhTrang(idnv);
		session = this.sessionFactory.getCurrentSession();
		if(tinhTrang==null) {
			session.persist(tt);
		}else {
			session.update(tt);
		}
		
	}

	@Override
	public List<DonNghi> listDonNghiChoDuyet(int idnv) {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<DonNghi> listDn = session.createQuery("from DonNghi where idnv ='"+idnv+"' and ( tinhtrang = "+1+" or tinhtrang = "+2+")").list();
		session.close();
		return listDn;
	}

	@Override
	public DonNghi getDonNghinv(int iddon) {
		Session session = this.sessionFactory.openSession();
		DonNghi donNghi = new DonNghi();
		donNghi = session.createQuery("from DonNghi where id_don=" + iddon + "", DonNghi.class).getSingleResult();
		return donNghi;
	}

	@Override
	public void updateDon(DonNghi dn) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(dn);
	}

	@Override
	public void deleteDon(int iddon) {
		Session session = this.sessionFactory.getCurrentSession();
		DonNghi donNghi = (DonNghi) session.load(DonNghi.class, new Integer(iddon));
		if(null != donNghi){
			session.delete(donNghi);
		}
	}

	@Override
	public List<DonNghi> listDonNghiPheDuyet1(String tenPhongBan) {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<DonNghi> listDn = session.createQuery("from DonNghi where tinhtrang = "+1+" and phongban ='"+tenPhongBan+"' ").list();
		session.close();
		return listDn;
	}

	@Override
	public List<DonNghi> listDonNghiPheDuyet2() {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<DonNghi> listDn = session.createQuery("from DonNghi where tinhtrang = "+2+" ").list();
		session.close();
		return listDn;
	}

	@Override
	public List<DonNghi> listDonNghiPheDuyet(int idnv, int start, int end) {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<DonNghi> listDn = session.createQuery("from DonNghi where idnv ='"+idnv+"' and  tinhtrang = "+3+" ").setFirstResult(start).setMaxResults(end).list();
		session.close();
		return listDn;
	}

	@Override
	public List<DonNghi> listDonNghiBiTuChoi(int idnv, int start, int end) {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<DonNghi> listDn = session.createQuery("from DonNghi where idnv ='"+idnv+"' and  tinhtrang = "+4+" ").setFirstResult(start).setMaxResults(end).list();
		session.close();
		return listDn;
	}

	@Override
	public void updateTinhTrang(TinhTrangNghi tt) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(tt);
	}

	@Override
	public Long countListDaDuyet(int idnv) {
		Session session = this.sessionFactory.getCurrentSession();
		Long count = session.createQuery("select count(*) from  DonNghi where idnv ='"+idnv+"' and  tinhtrang = "+3+" " ,Long.class).getSingleResult();
		return count;
	}

	@Override
	public Long countListTuChoi(int idnv) {
		Session session = this.sessionFactory.getCurrentSession();
		Long count = session.createQuery("select count(*) from  DonNghi where idnv ='"+idnv+"' and  tinhtrang = "+4+" " ,Long.class).getSingleResult();
		return count;
	}

	@Override
	public List<DonNghi> listdanhsachpheduyetcty() {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<DonNghi> listDn = session.createQuery("from DonNghi where tinhtrang = "+3+" ").list();
		session.close();
		return listDn;
	}

}
