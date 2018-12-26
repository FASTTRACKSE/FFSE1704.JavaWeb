package fasttrackse.ffse1704.fbms.dao.quanlytailieu.dung;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlytailieu.Doanhnt.DanhMuc;
import fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung.DanhMucDung;
import fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung.DocumentDung;
import fasttrackse.ffse1704.fbms.entity.security.PhongBan;

public interface DocumentDAODung  {
	// list
	public List<DocumentDung> getAll();
	
	public List<DocumentDung> getAllPublicDocument();
	
	public void saveDraft(final DocumentDung documentDung);
	

	public List<PhongBan> listQuyen();
	
	public List<DanhMucDung> listCategory();
	
	//delete
	public void delete(final int id);
	
	//list pending approve
	public List<DocumentDung> getAllPendingApprove();
	
	public List<DocumentDung> getAllDocumentRefuse();
	
	public List<DocumentDung> getDraft();
	//accept
	public void accept(final DocumentDung document);
	//refuse
	public void refuse(final DocumentDung document);
	//find by id
	public DocumentDung findById(final int id);
	
	//update
	public void updateDocument(final DocumentDung document);
}

