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
	//Phòng dự án 2
	public List<DocumentDung> getPDA2Document();
	//phòng dự án 3
	public List<DocumentDung> getPDA3Document();
	//phòng dự án 4
	public List<DocumentDung> getPDA4Document();
	//phòng đạo tạo
	public List<DocumentDung> getPDTDocument();
	//phòng giám đốc
	public List<DocumentDung> getPGDDocument();
	//phòng hành chính
	public List<DocumentDung> getPHCDocument();
	//Phòng IT
	public List<DocumentDung> getPITDocument();
	//Phòng kế toán
	public List<DocumentDung> getPKTDocument();
	//phòng nhân sự
	public List<DocumentDung> getPNSDocument();
	//refuse
	public void refuse(DocumentDung document);
	//Chấp thuần tài liệu
	public void accept(DocumentDung document);
	//update
	public void updateDocument(DocumentDung document);
	// Tìm theo ID 
	public DocumentDung findById(int id); 
	
	
}
	
