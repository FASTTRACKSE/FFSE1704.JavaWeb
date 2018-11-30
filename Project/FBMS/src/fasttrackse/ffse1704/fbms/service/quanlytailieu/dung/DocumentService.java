package fasttrackse.ffse1704.fbms.service.quanlytailieu.dung;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung.Document;

public interface DocumentService  {
	
	//list
	public List<Document> getAll();
	
	public List<Document> getAllPublicDocument();
}
	
