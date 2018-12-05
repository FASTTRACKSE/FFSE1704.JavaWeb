package fasttrackse.ffse1704.fbms.controller.quanlytailieu.dung;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung.Document;
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
		
		List<Document> list =  documentService.getAll();
   
        model.addAttribute("listDocument", list);
		return "quanlytailieu/dung/index";		
	}
	// ----------- document public -------//
	@RequestMapping(value = "/documentPublic", method = RequestMethod.GET)
	public String documentPublic(Model model) {
		model.addAttribute("listPublicDocument", documentService.getAllPublicDocument());
		return "quanlytailieu/DocumentPublic";
	}
	
	@RequestMapping(value = "/documentInsert")
	public String documentInsert(Model model) {
		model.addAttribute("document", new Document());
		return "quanlytailieu/dung/documentInsert";
	}	

	public String saveDocument(Model model) {
		model.addAttribute("document", new Document());
		Document document = new Document();
		documentService.saveDraft(document);
		
		return "redirect:quanlytailieu/dung/";
	}
	
	@ModelAttribute("listQuyen")
	public List<PhongBan> listQuyen() {
		return this.documentService.listQuyen();
	}
}
	
