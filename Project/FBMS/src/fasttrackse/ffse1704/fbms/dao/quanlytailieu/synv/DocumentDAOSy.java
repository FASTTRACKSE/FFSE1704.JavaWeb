package fasttrackse.ffse1704.fbms.dao.quanlytailieu.synv;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlytailieu.synv.*;

public interface DocumentDAOSy {

	public List<DocumentSy> getAll();

	public void delete(int id);
//
//	public void addNew(DocumentSy document);
//
	public DocumentSy getById(int id);
//
	public void update(DocumentSy document);
//	
//	public List<DocumentSy> findAllForPaging(int startPosition,int maxResult);


	
//	public List<CategorySy> listCategory();
//	
//	public List<StatusSy> listStatus();
//
//	public List<DocumentSy> getAllPublicDocument();
//	
//	public List<Room> listRoom();

}