package fasttrackse.ffse1704.fbms.dao.quanlytailieu.dung;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung.Document;
import fasttrackse.ffse1704.fbms.entity.security.PhongBan;

public interface DocumentDAODung  {
	// list
	public List<Document> getAll();
	
	public List<Document> getAllPublicDocument();
	
	public void saveDraft(final Document document);
	
	public List<PhongBan> listQuyen();
}
