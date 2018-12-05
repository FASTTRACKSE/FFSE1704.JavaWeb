package fasttrackse.ffse1704.fbms.service.quanlytailieu.dung;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1704.fbms.dao.quanlytailieu.dung.DocumentDAODung;
import fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung.Document;
import fasttrackse.ffse1704.fbms.entity.security.PhongBan;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentDAODung documentDAO;

	// list
	@Transactional
	public List<Document> getAll() {
		return documentDAO.getAll();
	}
	public List<Document> getAllPublicDocument(){
		return documentDAO.getAllPublicDocument();
	}
	
	public void saveDraft(Document document) {
		documentDAO.saveDraft(document);
	}
	
	@Override
	@Transactional
	public List<PhongBan> listQuyen(){
		return documentDAO.listQuyen();
	}
}
