package fasttrackse.ffse1704.fbms.service.quanlytailieu.synv;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlytailieu.synv.*;

public interface DocumentServiceSy {

	public List<DocumentSy> getAll();

	

	public void delete(int id);
//
	public void addNew(DocumentSy document);
//
//	public DocumentSy getById(int id);
//
//	public void update(DocumentSy document);
//	
//	public static List<DocumentSy> findAllForPaging(int startPosition,int maxResult) {
//		// TODO Auto-generated method stub
//		return null;
//	}



	public List<CategorySy> listCategory();



	public List<StatusSy> listStatus();



	public Object getById(int id);



	public void edit(int id);



	public void updateDocument(DocumentSy document);



	public void accept(DocumentSy document);
	
//	public List<Room> listRoom();
	
}
