package fasttrackse.ffse1704.fbms.controller.quanlytailieu.synv;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung.DocumentDung;
import fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung.IconDung;
import fasttrackse.ffse1704.fbms.entity.quanlytailieu.synv.DocumentSy;
import fasttrackse.ffse1704.fbms.entity.quanlytailieu.synv.IconSy;
import fasttrackse.ffse1704.fbms.service.quanlytailieu.synv.DocumentServiceSy;

@Controller
public class DocumentControllerSy {

	// private static final String UPLOAD_DIRECTORY = "/upload";
	// private static final int THRESHOLD_SIZE = 1024 * 1024 * 3;

	private static final String UPLOAD_DIRECTORY = null;
	@Autowired
	DocumentServiceSy documentService;

	public void setDocumentService(DocumentServiceSy documentService) {
		this.documentService = documentService;
	}

	@RequestMapping("/quanlytailieu")
	public ModelAndView ShowPhongBan(HttpServletRequest req, HttpServletResponse res) {
		// int totalRecords = documentService.getAll().size();
		// int recordsPerPage = 3;
		// int totalPages = 0;
		// if ((totalRecords / recordsPerPage) % 2 == 0) {
		// totalPages = totalRecords / recordsPerPage;
		// } else {
		// totalPages = totalRecords / recordsPerPage + 1;
		// }
		// int startPosition = recordsPerPage * (currentPage - 1);
		//
		// model.addAttribute("list", documentService.findAllForPaging(startPosition,
		// recordsPerPage));
		// model.addAttribute("lastPage", totalPages);
		// model.addAttribute("currentPage", currentPage);

		List<DocumentSy> allDocument = documentService.getAll();
		return new ModelAndView("quanlytailieu/synv/Document/listDocument", "list", allDocument);
	}
////////////////Add tài liệu //////////////////
		@RequestMapping(value = "/add/")
		public String add(Model model) {
			model.addAttribute("document", new DocumentSy());
			
			model.addAttribute("listCategory", documentService.listCategory());
			return "quanlytailieu/synv/Document/addDocument";
		}

////////////////Edit tài liệu //////////////////	
	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable int id,Model model) {
		model.addAttribute("documentupdate",documentService.getById(id));
		return "quanlytailieu/synv/Document/editDocument";
	}
	
	
	
	
////////////////Delete tài liệu //////////////////
	 @RequestMapping(value = "/delete/{id}")
	 public String delete(Model model, @PathVariable("id") int id) {
	 documentService.delete(id);
	 return "redirect:/quanlytailieu";
	
	 }
////////////////Accept tài liệu //////////////////
	 @RequestMapping(value = "/acceptDocument")
		public String documentAccept(@ModelAttribute("viewDocument") DocumentSy document, HttpSession session,
				BindingResult bindingResult) {
			documentService.accept(document);
			return "redirect:/quanlytailieu/";
		}

}