/**
 * 
 */
package fasttrackse.ffse1704.fbms.service.quanlyduan.framework;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1704.fbms.dao.quanlyduan.framework.FrameworkDao;
import fasttrackse.ffse1704.fbms.entity.quanlyduan.framework.Framework;

/**
 * @author QuangDai
 *
 */
@Service
public class FrameworkServiceImpl implements FrameworkService {
	@Autowired
	private FrameworkDao frameworkDao;

	public FrameworkDao getFrameworkDao() {
		return frameworkDao;
	}

	public void setFrameworkDao(FrameworkDao frameworkDao) {
		this.frameworkDao = frameworkDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.service.quanlyduan.framework.FrameworkService#
	 * listFramework(int, int)
	 */
	@Override
	@Transactional
	public List<Framework> listFramework(int iDisPlayStart, int iDinPlayLength) {
		return this.frameworkDao.listFramework(iDisPlayStart, iDinPlayLength);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.service.quanlyduan.framework.FrameworkService#
	 * countFramework()
	 */
	@Override
	@Transactional
	public int countFramework() {
		return this.frameworkDao.countFramework();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.service.quanlyduan.framework.FrameworkService#
	 * addNew(fasttrackse.ffse1704.fbms.entity.quanlyduan.framework.Framework)
	 */
	@Override
	@Transactional
	public void addNew(Framework fw) {
		this.frameworkDao.addNew(fw);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.service.quanlyduan.framework.FrameworkService#
	 * update(fasttrackse.ffse1704.fbms.entity.quanlyduan.framework.Framework)
	 */
	@Override
	@Transactional
	public void update(Framework fw) {
		this.frameworkDao.update(fw);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.service.quanlyduan.framework.FrameworkService#
	 * delete(java.lang.String)
	 */
	@Override
	@Transactional
	public void delete(String maFramework) {
		this.frameworkDao.delete(maFramework);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.service.quanlyduan.framework.FrameworkService#
	 * getFrameworkByMaFramework(java.lang.String)
	 */
	@Override
	@Transactional
	public Framework getFrameworkByMaFramework(String maFramework) {
		return this.frameworkDao.getFrameworkByMaFramework(maFramework);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.service.quanlyduan.framework.FrameworkService#
	 * getRecordsByMaFramework(java.lang.String)
	 */
	@Override
	@Transactional
	public int getRecordsByMaFramework(String maFramework) {
		return this.frameworkDao.getRecordsByMaFramework(maFramework);
	}
}
