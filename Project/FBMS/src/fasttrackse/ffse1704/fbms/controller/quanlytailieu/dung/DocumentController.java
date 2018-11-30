package fasttrackse.ffse1704.fbms.controller.quanlytailieu.dung;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung.Document;
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
        model.addAttribute("offset", offset);
        model.addAttribute("listDocument", list);
		return "quanlytailieu/index";		
	}
	// ----------- document public -------//
	@RequestMapping(value = "/documentPublic", method = RequestMethod.GET)
	public String documentPublic(Model model) {
		model.addAttribute("listPublicDocument", documentService.getAllPublicDocument());
		return "quanlytailieu/DocumentPublic";
	}
}
	
