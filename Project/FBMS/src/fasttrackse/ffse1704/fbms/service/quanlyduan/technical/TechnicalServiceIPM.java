package fasttrackse.ffse1704.fbms.service.quanlyduan.technical;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1704.fbms.dao.quanlyduan.technical.TechnicalDao;
import fasttrackse.ffse1704.fbms.entity.quanlyduan.technical.Technical;

/**
 * @author Joker
 *
 */
@Service
public class TechnicalServiceIPM implements TechnicalService {
	@Autowired
	private TechnicalDao technicalDao;

	public TechnicalDao getTechnicalDao() {
		return technicalDao;
	}

	public void setTechnicalDao(TechnicalDao technicalDao) {
		this.technicalDao = technicalDao;
	}

	@Override
	@Transactional
	public void addNew(Technical technical) {
		this.technicalDao.addNew(technical);

	}

	@Override
	@Transactional
	public void update(Technical technical) {
		this.technicalDao.update(technical);

	}

	@Override
	@Transactional
	public void delete(String matechnical) {
		this.technicalDao.delete(matechnical);

	}

	@Override
	@Transactional
	public Technical getTechnicalByIdTechnical(String matechnical) {
		return this.technicalDao.getTechnicalByIdTechnical(matechnical);
	}

	@Override
	@Transactional
	public List<Technical> listTechnical(int iDisPlayStart, int iDinPlayLength) {
		return this.technicalDao.listTechnical(iDisPlayStart, iDinPlayLength);
	}

	@Override
	@Transactional
	public int getRecordsTotal() {
		return this.technicalDao.getRecordsTotal();
	}

	@Override
	@Transactional
	public int getRecordsByIdTechnical(String matechnical) {
		return this.technicalDao.getRecordsByIdTechnical(matechnical);
	}

}
