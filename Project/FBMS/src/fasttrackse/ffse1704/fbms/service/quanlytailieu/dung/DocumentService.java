package fasttrackse.ffse1704.fbms.service.quanlytailieu.dung;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlytailieu.Doanhnt.DanhMuc;
import fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung.DanhMucDung;
import fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung.DocumentDung;
import fasttrackse.ffse1704.fbms.entity.security.PhongBan;

public interface DocumentService  {
	
	//list
	public List<DocumentDung> getAll();
	
	public List<DocumentDung> getAllPublicDocument();
	
	public void saveDraft(DocumentDung documentDung);
	
	public List<PhongBan> listQuyen();
	
	public List<DanhMucDung> listCategory();
	
	public void delete(int id);
	
	//pending approve
	public List<DocumentDung> getAllPendingApprove();
	//DocumentRefure
	public List<DocumentDung> getAllDocumentRefuse();
	
	public List<DocumentDung> getDraft();
	//refuse
	public void refuse(DocumentDung document);
	
	
	public void accept(DocumentDung document);
	
	//update
	public void updateDocument(DocumentDung document);
	
	public DocumentDung findById(int id); 
	
	
}
	
