package fasttrackse.ffse1704.fbms.service.quanlyduan.programminglanguage;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1704.fbms.dao.quanlyduan.programminglanguage.ProgrammingLanguageDao;
import fasttrackse.ffse1704.fbms.entity.quanlyduan.programminglanguage.ProgrammingLanguage;

/**
 * @author Joker
 *
 */
@Service
public class ProgrammingLanguageServiveIPM implements ProgrammingLanguageServive {
	@Autowired
	private ProgrammingLanguageDao programmingLanguageDao;

	public ProgrammingLanguageDao getProgrammingLanguageDao() {
		return programmingLanguageDao;
	}

	public void setProgrammingLanguageDao(ProgrammingLanguageDao programmingLanguageDao) {
		this.programmingLanguageDao = programmingLanguageDao;
	}

	@Override
	@Transactional
	public void addNew(ProgrammingLanguage programmingLanguage) {
		this.programmingLanguageDao.addNew(programmingLanguage);

	}

	@Override
	@Transactional
	public void update(ProgrammingLanguage programmingLanguage) {
		this.programmingLanguageDao.update(programmingLanguage);

	}

	@Override
	@Transactional
	public void delete(String maProgrammingLanguage) {
		this.programmingLanguageDao.delete(maProgrammingLanguage);

	}

	@Override
	@Transactional
	public ProgrammingLanguage getProgrammingLanguageByIdProgrammingLanguage(String maProgrammingLanguage) {
		return this.programmingLanguageDao.getProgrammingLanguageByIdProgrammingLanguage(maProgrammingLanguage);
	}

	@Override
	@Transactional
	public List<ProgrammingLanguage> listProgrammingLanguage(int iDisPlayStart, int iDinPlayLength) {
		return this.programmingLanguageDao.listProgrammingLanguage(iDisPlayStart, iDinPlayLength);
	}

	@Override
	@Transactional
	public int getRecordsTotal() {
		return this.programmingLanguageDao.getRecordsTotal();
	}

	@Override
	@Transactional
	public int getRecordsByIdProgrammingLanguage(String maProgrammingLanguage) {
		return this.programmingLanguageDao.getRecordsByIdProgrammingLanguage(maProgrammingLanguage);
	}

}
