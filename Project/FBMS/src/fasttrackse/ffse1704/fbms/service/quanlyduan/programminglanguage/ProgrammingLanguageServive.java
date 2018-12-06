package fasttrackse.ffse1704.fbms.service.quanlyduan.programminglanguage;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlyduan.programminglanguage.ProgrammingLanguage;

public interface ProgrammingLanguageServive {
	
	public void addNew(ProgrammingLanguage programmingLanguage);

	public void update(ProgrammingLanguage programmingLanguage);

	public void delete(String maProgrammingLanguage);

	public ProgrammingLanguage getProgrammingLanguageByIdProgrammingLanguage(String maProgrammingLanguage);

	public List<ProgrammingLanguage> listProgrammingLanguage(int iDisPlayStart, int iDinPlayLength);

	public int getRecordsTotal();
	
	public int getRecordsByIdProgrammingLanguage(String maProgrammingLanguage);
}
