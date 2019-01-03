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

	// list toàn bộ tài liệu(test)
	@Transactional
	public List<DocumentDung> getAll() {
		return documentDAO.getAll();
	}
	//list tài liệu không cần cấp quyền
	public List<DocumentDung> getAllPublicDocument(){
		return documentDAO.getAllPublicDocument();
	}
	// lưu tài liệu nháp
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
		//list my document accept
		public List<DocumentDung> getMyDocumentAccept() {
			return documentDAO.getMyDocumentAccept();
		}
		//list tài liệu chờ phê duyệt
		public List<DocumentDung> getMyDocumentPendingApprove(){
			return documentDAO.getMyDocumentPendingApprove();
		} 
		// list tài liệu nháp
				public List<DocumentDung> getDraft(){
					return documentDAO.getDraft();
				}
		// list tài liệu bị từ chối
		public List<DocumentDung> getAllDocumentRefuse(){
			return documentDAO.getAllDocumentRefuse();
		}
		// List tài liệu theo phòng ban
		// phòng dự án 1
		public List<DocumentDung> getPDA1Document(){
			return documentDAO.getAllDocumentPDA1();
		}
		//phong dự án 2
		public List<DocumentDung> getPDA2Document(){
			return documentDAO.getAllDocumentPDA2();
		}
		//phòng dự án 3
		public List<DocumentDung> getPDA3Document(){
			return documentDAO.getAllDocumentPDA3();
		}
		//phòng dự án 4
		public List<DocumentDung> getPDA4Document(){
			return documentDAO.getAllDocumentPDA4();
		}
		//phòng đào tạo
		public List<DocumentDung> getPDTDocument(){
			return documentDAO.getAllDocumentPDT();
		}
		//phòng giám đốc
		public List<DocumentDung> getPGDDocument(){
			return documentDAO.getAllDocumentPGD();
		}
		//phòng hành chính
		public List<DocumentDung> getPHCDocument(){
			return documentDAO.getAllDocumentPHC();
		}
		//phòng IT
		public List<DocumentDung> getPITDocument(){
			return documentDAO.getAllDocumentPIT();
		}
		//phòng kế toán
		public List<DocumentDung> getPKTDocument(){
			return documentDAO.getAllDocumentPKT();
		}
		//phòng nhân sự
		public List<DocumentDung> getPNSDocument(){
			return documentDAO.getAllDocumentPNS();
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
	//List toàn bộ phòng ban (Quyền truy cập)
	public List<PhongBan> listQuyen(){
		return documentDAO.listQuyen();
	}
	//List toàn bộ danh mục
	public List<DanhMucDung> listCategory() {
		return documentDAO.listCategory();
	}
}
