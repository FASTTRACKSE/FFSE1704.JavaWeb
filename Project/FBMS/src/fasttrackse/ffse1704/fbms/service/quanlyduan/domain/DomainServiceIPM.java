package fasttrackse.ffse1704.fbms.service.quanlyduan.domain;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1704.fbms.dao.quanlyduan.domain.DomainDao;
import fasttrackse.ffse1704.fbms.entity.quanlyduan.domain.Domain;
/**
 * @author Joker
 *
 */
@Service
public class DomainServiceIPM implements DomainService {

	@Autowired
	private DomainDao domainDao;

	public DomainDao getDomainDao() {
		return domainDao;
	}

	public void setDomainDao(DomainDao domainDao) {
		this.domainDao = domainDao;
	}

	@Override
	@Transactional
	public void addNew(Domain domain) {
		this.domainDao.addNew(domain);

	}

	@Override
	@Transactional
	public void update(Domain domain) {
		this.domainDao.update(domain);

	}

	@Override
	@Transactional
	public void delete(String maDomain) {
		this.domainDao.delete(maDomain);

	}

	@Override
	@Transactional
	public Domain getDomainByIdDomain(String maDomain) {
		return this.domainDao.getDomainByIdDomain(maDomain);
	}

	@Override
	@Transactional
	public List<Domain> listDomain(int iDisPlayStart, int iDinPlayLength) {
		return this.domainDao.listDomain(iDisPlayStart, iDinPlayLength);
	}

	@Override
	@Transactional
	public int getRecordsTotal() {
		return this.domainDao.getRecordsTotal();
	}

	@Override
	@Transactional
	public int getRecordsByIdDomain(String maDomain) {
		return this.domainDao.getRecordsByIdDomain(maDomain);
	}

}
