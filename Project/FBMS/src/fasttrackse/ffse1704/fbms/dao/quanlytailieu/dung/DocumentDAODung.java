package fasttrackse.ffse1704.fbms.dao.quanlytailieu.dung;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlytailieu.Doanhnt.DanhMuc;
import fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung.DanhMucDung;
import fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung.DocumentDung;
import fasttrackse.ffse1704.fbms.entity.security.PhongBan;

public interface DocumentDAODung  {
	// list toàn bộ tài liệu (test)
	public List<DocumentDung> getAll();
	// list tài liệu mọi người đều xem được
	public List<DocumentDung> getAllPublicDocument();
	// Tạo tài liệu nháp
	public void saveDraft(final DocumentDung documentDung);
	
	// List danh mục
	public List<PhongBan> listQuyen();
	// List danh mục
	public List<DanhMucDung> listCategory();
	
	//delete
	public void delete(final int id);
	
	
	//list pending approve
	public List<DocumentDung> getAllPendingApprove();
	// list my document accept
	public List<DocumentDung> getMyDocumentAccept() ;
	//list my pending approve
	public List<DocumentDung> getMyDocumentPendingApprove();
	//list document từ chối
	public List<DocumentDung> getAllDocumentRefuse();
	//list tài liệu nháp
	public List<DocumentDung> getDraft();
	
	//list Theo phòng ban
	//phòng dự án 1
	public List<DocumentDung> getAllDocumentPDA1();
	//phòng dự án 2
	public List<DocumentDung> getAllDocumentPDA2();
	//phòng dự án 3
	public List<DocumentDung> getAllDocumentPDA3();
	//phòng dự án 4
	public List<DocumentDung> getAllDocumentPDA4();
	// phòng đào tạo
	public List<DocumentDung> getAllDocumentPDT();
	//Phòng giám đốc
	public List<DocumentDung> getAllDocumentPGD();
	//phòng hành chính
	public List<DocumentDung> getAllDocumentPHC();
	//Phòng IT
	public List<DocumentDung> getAllDocumentPIT();
	//phòng kế toán
	public List<DocumentDung> getAllDocumentPKT();
	//phòng nhân sự
	public List<DocumentDung> getAllDocumentPNS();
	
	//accept document
	public void accept(final DocumentDung document);
	//refuse document
	public void refuse(final DocumentDung document);
	//find by id
	public DocumentDung findById(final int id);
	
	//update
	public void updateDocument(final DocumentDung document);
}

