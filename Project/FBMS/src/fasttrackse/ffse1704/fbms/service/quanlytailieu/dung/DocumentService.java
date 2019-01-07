package fasttrackse.ffse1704.fbms.service.quanlytailieu.dung;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlytailieu.Doanhnt.DanhMuc;
import fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung.DanhMucDung;
import fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung.DocumentDung;
import fasttrackse.ffse1704.fbms.entity.security.PhongBan;

public interface DocumentService  {
	
	//list
	public List<DocumentDung> getAll();
	//Liệt kê tài liệu không cần cấp quyền
	public List<DocumentDung> getAllPublicDocument();
	//Lưu nháp
	public void saveDraft(DocumentDung documentDung);
	// List các phòng ban(Quyền truy cập)
	public List<PhongBan> listQuyen();
	//List danh mục
	public List<DanhMucDung> listCategory();
	// Xóa tài liệu
	public void delete(int id);
	
	//pending approve
	public List<DocumentDung> getAllPendingApprove();
	//DocumentRefure
	public List<DocumentDung> getAllDocumentRefuse();
	//list my document được phê duyệt
	public List<DocumentDung> getMyDocumentAccept();
	//list my document chờ phê duyệt
	public List<DocumentDung> getMyDocumentPendingApprove();
	//list tài liệu nháp
	public List<DocumentDung> getDraft();
	
	//List tài liệu theo phòng ban
	//Phòng dự án 1
	public List<DocumentDung> getPDA1Document();
	//refuse
	public void refuse(DocumentDung document);
	//Chấp thuần tài liệu
	public void accept(DocumentDung document);
	//update
	public void updateDocument(DocumentDung document);
	// Tìm theo ID 
	public DocumentDung findById(int id); 
	
	
}
	
