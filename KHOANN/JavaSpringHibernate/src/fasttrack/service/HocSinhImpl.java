package fasttrack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrack.DAO.HocSinhDao;
import fasttrack.entity.HocSinh;

@Service

@Transactional
public class HocSinhImpl implements HocSinhService {

	@Autowired
	private HocSinhDao hocsinhdao;

	public HocSinhDao getHocsinhdao() {
		return hocsinhdao;
	}

	public void setHocsinhdao(HocSinhDao hocsinhdao) {
		this.hocsinhdao = hocsinhdao;
	}

	@Override
	@Transactional
	public List<HocSinh> getAll() {
		// TODO Auto-generated method stub
		return hocsinhdao.getAll();
	}
	
	@Override
	@Transactional
	public void addhs(HocSinh hs) {
		hocsinhdao.addHS(hs);
	}

	@Override
	@Transactional
	public void updatehs(HocSinh hs) {
		// TODO Auto-generated method stub
		hocsinhdao.updatehs(hs);
	}

	@Override
	public HocSinh getHocSinhByID(int id) {
		// TODO Auto-generated method stub
		return hocsinhdao.getHocSinhByID(id);
	}

	@Override
	public void delhs(int id) {
		// TODO Auto-generated method stub
		hocsinhdao.delhs(id);
		
	}

	@Override
	public List<HocSinh> findAllForPaging(int startPosition, int maxResult) {
		// TODO Auto-generated method stub
		return hocsinhdao.findAllForPaging(startPosition, maxResult);
	}

}
