package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import entity.SinhVien;


public class SinhVienDaoImlp implements SinhVienDao {
@Autowired
SessionFactory sessionFactory;

@Override
public List<SinhVien> getAllSinhVien() {
	// TODO Auto-generated method stub
	Session currentSession = sessionFactory.getCurrentSession();
	List<SinhVien> theQuery = currentSession.createQuery("form sinhvien").list();
	return theQuery;
}
}
