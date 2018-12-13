package fasttrackse.ffse1704.fbms.controller.quanlytailieu.dung;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung.DanhMucDung;
import fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung.DocumentDung;
import fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung.TrangThaiDung;
import fasttrackse.ffse1704.fbms.entity.security.PhongBan;
import fasttrackse.ffse1704.fbms.service.quanlytailieu.dung.DocumentService;

@Controller
@RequestMapping("/quanlytailieu")
@SessionAttributes({"quyenTruyCap"})
public class DocumentController {

	@Autowired
	private DocumentService documentService;

	// -------------- my document ----------//
	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String index(Model model ,Integer offset, Integer maxResults) {
		
		List<DocumentDung> list =  documentService.getAll();
   
        model.addAttribute("listDocument", list);
		return "quanlytailieu/dung/index";		
	}
	// ----------- document public -------//
	@RequestMapping(value = "/documentPublic", method = RequestMethod.GET)
	public String documentPublic(Model model) {
		model.addAttribute("listPublicDocument", documentService.getAllPublicDocument());
		return "quanlytailieu/DocumentPublic";
	}
	
	
	// Thêm tài liệu
	@RequestMapping(value = "/documentInsert")
	public String documentInsert(Model model) {
		model.addAttribute("document", new DocumentDung());
		model.addAttribute("listQuyen",documentService.listQuyen());
		model.addAttribute("listCategory",documentService.listCategory());
		return "quanlytailieu/dung/documentInsert";
	}	
	@RequestMapping(value = "/documentSave", method = RequestMethod.POST)
	public String saveDocument(@ModelAttribute("document") DocumentDung documentDung, HttpSession session, BindingResult bindingResult) {
		
		// DocumentDung documentDung thêm biến vào dữ liệu		
		// RequestMethod.POST - 
		TrangThaiDung trangThai = new TrangThaiDung();
		trangThai.setMaTrangThai("cho_phe_duyet");
		documentDung.setMaTrangThai(trangThai);
		documentService.saveDraft(documentDung); 
		// Kiểu là document, Spring tự map
		
		
		return "redirect:/quanlytailieu/";
	}
	
	
	// Update tài liệu
	@RequestMapping(value = "/documentUpdateView/{id}")
	public String documentUpdateView(@PathVariable int id,Model model) {
		model.addAttribute("documentupdate",documentService.findById(id));
		return "quanlytailieu/dung/documentUpdate";
	}	
	@RequestMapping(value="/documentUpdate")
	public String documentUpdate(@ModelAttribute("documentupdate") DocumentDung document, HttpSession session, BindingResult bindingResult) {
		documentService.updateDocument(document);
		
		return "redirect:/quanlytailieu/";
	}
	
	// Delete tài liệu
	@RequestMapping(value = "/documentDelete/{id}", method = RequestMethod.GET)
	public String documentDelete(@PathVariable int id, Model model) {
		documentService.delete(id);
		return "redirect:/quanlytailieu/";
	}
	
	@ModelAttribute("listQuyen")
	public List<PhongBan> listQuyen() {
		return this.documentService.listQuyen();
	}

	@ModelAttribute("listCategory")
	public List<DanhMucDung> listCategory() {
		return this.documentService.listCategory();
	}
}


	
