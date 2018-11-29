package fasttrackse.ffse1704.fbms.dao.tuanpt.qlvn;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1704.fbms.entity.tuanpt.qlvn.DonNghi;
import fasttrackse.ffse1704.fbms.entity.tuanpt.qlvn.LyDo;
import fasttrackse.ffse1704.fbms.entity.tuanpt.qlvn.TinhTrang;
import fasttrackse.ffse1704.fbms.entity.security.UserAccount;

@Repository
public class QuanLyVangNghiDaoImpl implements QuanLyVangNghiDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addDon(DonNghi donnghi) {
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println(donnghi);
		session.save(donnghi);
	}


	@Override
	public UserAccount getThongTinUser(String username) {
		Session session = this.sessionFactory.openSession();
		UserAccount user = session.createQuery("from UserAccount where username='" + username + "'", UserAccount.class)
				.getSingleResult();
		session.close();
		return user;
	}

	@Override
	public TinhTrang getTinhTrang(int id_nhan_vien) {
		TinhTrang tinhTrang = null;
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			tinhTrang = session.createQuery("from TinhTrangNghi where id_nhan_vien=" + id_nhan_vien + "", TinhTrang.class).getSingleResult();
		}catch (Exception e) {
			tinhTrang= null;
		}
		
		session.close();
		return tinhTrang;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LyDo> listLyDo() {
		Session session = this.sessionFactory.openSession();
		List<LyDo> list = session.createQuery("from LyDo").list();
		session.close();
		return list;
	}

	@Override
	public List<DonNghi> listDonNghiNhap(int id_nhan_vien) {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<DonNghi> listDonNghi = session.createQuery("from DonNghi where id_nhan_vien ='"+id_nhan_vien+"' and tinh_trang = "+0+" ").list();
		session.close();
		return listDonNghi;
	}

	@Override
	public void insertTinhTrang(int id_nhan_vien, TinhTrang tinhtrang) {
		TinhTrang tinhTrang = new TinhTrang();
		Session session = null;
		tinhTrang = getTinhTrang(id_nhan_vien);
		session = this.sessionFactory.getCurrentSession();
		if(tinhTrang==null) {
			session.persist(tinhtrang);
		}else {
			session.update(tinhtrang);
		}
	}
	
	public void updateTinhTrang(TinhTrang tinhtrang) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(tinhtrang);
	}


	@Override
	public List<DonNghi> listDonNghiChoDuyet(int id_nhan_vien) {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<DonNghi> listDonNghi = session.createQuery("from DonNghi where id_nhan_vien ='"+id_nhan_vien+"' and ( tinh_trang = "+1+" or tinh_trang = "+2+")").list();
		session.close();
		return listDonNghi;
	}

	@Override
	public DonNghi getDonNghiNv(int id_don_nghi) {
		Session session = this.sessionFactory.openSession();
		DonNghi donNghi = new DonNghi();
		donNghi = session.createQuery("from DonNghi where id_don=" + id_don_nghi + "", DonNghi.class).getSingleResult();
		return donNghi;
	}

	@Override
	public void updateDon(DonNghi donnghi) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(donnghi);
	}

	@Override
	public void deleteDon(int id_don_nghi) {
		Session session = this.sessionFactory.getCurrentSession();
		DonNghi donNghi = (DonNghi) session.load(DonNghi.class, new Integer(id_don_nghi));
		if(null != donNghi){
			session.delete(donNghi);
		}
		
	}

	@Override
	public List<DonNghi> listDonNghiPheDuyet1(String tenPhongBan) {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<DonNghi> listDonNghi = session.createQuery("from DonNghi where tinh_trang = "+1+" and phong_ban ='"+tenPhongBan+"' ").list();
		session.close();
		return listDonNghi;
	}

	@Override
	public List<DonNghi> listDonNghiPheDuyet2() {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<DonNghi> listDonNghi = session.createQuery("from DonNghi where tinh_trang = "+2+" ").list();
		session.close();
		return listDonNghi;
	}

	@Override
	public List<DonNghi> listDonNghiBiTuChoi(int id_nhan_vien, int start, int end) {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<DonNghi> listDonNghi = session.createQuery("from DonNghi where id_nhan_vien ='"+id_nhan_vien+"' and  tinh_trang = "+4+" ").setFirstResult(start).setMaxResults(end).list();
		session.close();
		return listDonNghi;
	}

	@Override
	public List<DonNghi> listDanhSachPheDuyet(int id_nhan_vien,int start,int end) {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<DonNghi> listDonNghi = session.createQuery("from DonNghi where id_nhan_vien ='"+id_nhan_vien+"' and  tinh_trang = "+3+" ").setFirstResult(start).setMaxResults(end).list();
		session.close();
		return listDonNghi;
	}


	@Override
	public Long countListDaDuyet(int id_nhan_vien) {
		Session session = this.sessionFactory.getCurrentSession();
		Long count = session.createQuery("select count(*) from  DonNghi where id_nhan_vien ='"+id_nhan_vien+"' and  tinh_trang = "+3+" " ,Long.class).getSingleResult();
		return count;
	}


	@Override
	public Long countListTuChoi(int id_nhan_vien) {
		Session session = this.sessionFactory.getCurrentSession();
		Long count = session.createQuery("select count(*) from  DonNghi where id_nhan_vien ='"+id_nhan_vien+"' and  tinh_trang = "+4+" " ,Long.class).getSingleResult();
		return count;	}

	@Override
	public List<DonNghi> listdanhsachpheduyetcty() {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<DonNghi> listDonNghi = session.createQuery("from DonNghi where tinh_trang = "+3+" ").list();
		session.close();
		return listDonNghi;
	}

}
