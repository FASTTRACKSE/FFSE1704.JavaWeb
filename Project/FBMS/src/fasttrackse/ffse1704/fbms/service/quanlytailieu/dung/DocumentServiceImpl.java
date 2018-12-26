package fasttrackse.ffse1704.fbms.service.quanlytailieu.dung;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1704.fbms.dao.quanlytailieu.dung.DocumentDAODung;
import fasttrackse.ffse1704.fbms.entity.quanlytailieu.Doanhnt.DanhMuc;
import fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung.DanhMucDung;
import fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung.DocumentDung;
import fasttrackse.ffse1704.fbms.entity.security.PhongBan;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentDAODung documentDAO;

	// list
	@Transactional
	public List<DocumentDung> getAll() {
		return documentDAO.getAll();
	}
	public List<DocumentDung> getAllPublicDocument(){
		return documentDAO.getAllPublicDocument();
	}
	
	public void saveDraft(DocumentDung documentDung) {
		documentDAO.saveDraft(documentDung);
	}
	
	//delete
	public void delete(int id) {
			documentDAO.delete(id);
		}
	//finbyid
	public DocumentDung findById(int id){
			return documentDAO.findById(id);
		}
	//update
		public void updateDocument(DocumentDung document) {
			documentDAO.updateDocument(document);
		}		
		// list pending approve
		public List<DocumentDung> getAllPendingApprove(){
			return documentDAO.getAllPendingApprove();
		}
		// list pending approve
				public List<DocumentDung> getDraft(){
					return documentDAO.getDraft();
				}
		// list pending approve
		public List<DocumentDung> getAllDocumentRefuse(){
			return documentDAO.getAllDocumentRefuse();
		}
	//accept
		public void accept(DocumentDung document) {
			documentDAO.accept(document);
		}
		
	//refuse 
		public void refuse(DocumentDung document) {
					documentDAO.refuse(document);
				}	
	@Override
	@Transactional
	public List<PhongBan> listQuyen(){
		return documentDAO.listQuyen();
	}
	
	public List<DanhMucDung> listCategory() {
		return documentDAO.listCategory();
	}
}
