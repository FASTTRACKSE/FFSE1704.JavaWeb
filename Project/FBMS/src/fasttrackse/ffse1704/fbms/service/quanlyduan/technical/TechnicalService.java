package fasttrackse.ffse1704.fbms.service.quanlyduan.technical;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlyduan.technical.Technical;

public interface TechnicalService {
	public void addNew(Technical technical);

	public void update(Technical technical);

	public void delete(String matechnical);

	public Technical getTechnicalByIdTechnical(String matechnical);

	public List<Technical> listTechnical(int iDisPlayStart, int iDinPlayLength);

	public int getRecordsTotal();
	
	public int getRecordsByIdTechnical(String matechnical);
}
