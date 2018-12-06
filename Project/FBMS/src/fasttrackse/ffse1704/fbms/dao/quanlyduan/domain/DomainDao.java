package fasttrackse.ffse1704.fbms.dao.quanlyduan.domain;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlyduan.domain.Domain;

public interface DomainDao {
	
	public void addNew(Domain domain);
	
	public void update(Domain domain);
	
	public void delete(String maDomain);
	
	public Domain getDomainByIdDomain(String maDomain);
	
	public List<Domain> listDomain(int iDisPlayStart, int iDinPlayLength);
	
	public int getRecordsTotal();
	
	public int getRecordsByIdDomain(String maDomain);
	
}
