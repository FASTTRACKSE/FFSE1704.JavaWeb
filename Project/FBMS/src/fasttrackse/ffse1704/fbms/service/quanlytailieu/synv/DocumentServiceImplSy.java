package fasttrackse.ffse1704.fbms.service.quanlytailieu.synv;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1704.fbms.entity.quanlytailieu.synv.*;
import fasttrackse.ffse1704.fbms.dao.quanlytailieu.synv.*;

@Service
@Transactional
public class DocumentServiceImplSy implements DocumentServiceSy {
	@Autowired
	private DocumentDAOSy documentDao;

	public DocumentDAOSy getDocumentDao() {
		return documentDao;
	}

	public void setDocumentDao(DocumentDAOSy documentDao) {
		this.documentDao = documentDao;
	}

	@Override
	public List<DocumentSy> getAll() {
		return documentDao.getAll();
	}
//	 @Override
//	 @Transactional
//	 public void addNew(DocumentSy document) {
//	 this.documentDao.addNew(document);
//	 }
	// @Override
	// @Transactional
	// public void update(DocumentSy document) {
	// this.documentDao.update(document);
	// }
	 @Override
	 @Transactional
	 public void delete(int id) {
	 this.documentDao.delete(id);
	 }
	 @Override
	 @Transactional
	 public DocumentSy getById(int id) {
	 return this.documentDao.getById(id);
	 }
	//
	// @Override
	// @Transactional
	// public List<DocumentSy> findAllForPaging(int startPosition, int maxResult) {
	// return this.documentDao.findAllForPaging(startPosition, maxResult);
	// }

	@Override
	public List<CategorySy> listCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StatusSy> listStatus() {
		// TODO Auto-generated method stub
		return null;
	}



	

	@Override
	public void updateDocument(DocumentSy document) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addNew(DocumentSy document) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accept(DocumentSy document) {
		// TODO Auto-generated method stub
		
	}

	
}



	// @Override
	// public List<Room> listRoom() {
	// return documentDao.listRoom();
	// }


