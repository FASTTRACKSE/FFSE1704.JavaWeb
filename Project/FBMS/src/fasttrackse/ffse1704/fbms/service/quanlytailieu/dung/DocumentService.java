package fasttrackse.ffse1704.fbms.service.quanlytailieu.dung;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung.Document;
import fasttrackse.ffse1704.fbms.entity.security.PhongBan;

public interface DocumentService  {
	
	//list
	public List<Document> getAll();
	
	public List<Document> getAllPublicDocument();
	
	public void saveDraft(Document document);
	
	public List<PhongBan> listQuyen();
}
	
