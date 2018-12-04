package fasttrackse.ffse1704.fbms.dao.quanlyduan.domain;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlyduan.domain.Domain;

public interface DomainDao {
public List<Domain> listDomain();
	
	public void addNew(Domain domain);
	
	public void update(Domain domain);
	
	public void delete(String maDomain);
	
	public Domain getDomainByIdDomain(String maDomain);
	
	public List<Domain> listDomain(int iDisPlayStart, int iDinPlayLength, String sql);
	
	public String getRecordsTotal();
	
	public String getRecordsFiltered(String sql);
}
