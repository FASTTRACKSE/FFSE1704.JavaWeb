package fasttrackse.ffse1704.fbms.controller.quanlytailieu.dung;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung.DanhMucDung;
import fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung.DocumentDung;
import fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung.IconDung;
import fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung.TrangThaiDung;
import fasttrackse.ffse1704.fbms.entity.security.PhongBan;
import fasttrackse.ffse1704.fbms.service.quanlytailieu.dung.DocumentService;

@Controller
@RequestMapping("/quanlytailieu")
@SessionAttributes({ "quyenTruyCap" })

public class DocumentController {
	private static final String UPLOAD_DIRECTORY = "/uploads";
	@Autowired
	private DocumentService documentService;

	// -------------- my document ----------//
	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String index(Model model, Integer offset, Integer maxResults) {

		List<DocumentDung> list = documentService.getAll();

		model.addAttribute("listDocument", list);
		return "quanlytailieu/dung/index";
	}
	//List tài liệu nháp
	@RequestMapping(value = { "/draft" }, method = RequestMethod.GET)
	public String draft(Model model) {
		model.addAttribute("listDocumentDraft", documentService.getDraft());
		return "quanlytailieu/dung/DocumentDraft";
	}
	//List tài liệu chờ phê duyệt
	@RequestMapping(value = { "/MyDocumentPendingApprove" }, method = RequestMethod.GET)
	public String MyDocumentPendingApprove(Model model) {
		model.addAttribute("listMyDocumentPendingApprove", documentService.getMyDocumentPendingApprove());
		return "quanlytailieu/dung/MyDocumentPendingApprove";
	}
	//List tài liệu đã chấp nhận
	@RequestMapping(value = { "/MyDocumentPendingAccept" }, method = RequestMethod.GET)
	public String MyDocumentAccept(Model model) {
		model.addAttribute("listMyDocumentAccept", documentService.getMyDocumentAccept());
		return "quanlytailieu/dung/MyDocumentAccept";
	}
	
	//Hiển thị theo phòng ban
	//phòng dự án 1
	@RequestMapping(value = { "/DocumentPDA1" }, method = RequestMethod.GET)
	public String DocumentPDA1(Model model) {
		model.addAttribute("listDocumentPDA1", documentService.getPDA1Document());
		return "quanlytailieu/dung/PDA1Document";
	}
	//phòng dự án 2
	@RequestMapping(value = { "/DocumentPDA2" }, method = RequestMethod.GET)
	public String DocumentPDA2(Model model) {
		model.addAttribute("listDocumentPDA2", documentService.getPDA2Document());
		return "quanlytailieu/dung/PDA2Document";
	}
	//phòng dự án 3
	@RequestMapping(value = { "/DocumentPDA3" }, method = RequestMethod.GET)
	public String DocumentPDA3(Model model) {
		model.addAttribute("listDocumentPDA3", documentService.getPDA3Document());
		return "quanlytailieu/dung/PDA3Document";
	}
	//phòng dự án 4
	@RequestMapping(value = { "/DocumentPDA4" }, method = RequestMethod.GET)
	public String DocumentPDA4(Model model) {
		model.addAttribute("listDocumentPDA4", documentService.getPDA4Document());
		return "quanlytailieu/dung/PDA4Document";
	}
	//phòng đào tạo
	@RequestMapping(value = { "/DocumentPDT" }, method = RequestMethod.GET)
	public String DocumentPDT(Model model) {
		model.addAttribute("listDocumentPDT", documentService.getPDTDocument());
		return "quanlytailieu/dung/PDTDocument";
	}
	//phòng giám đốc
	@RequestMapping(value = { "/DocumentPGD" }, method = RequestMethod.GET)
	public String DocumentPGD(Model model) {
		model.addAttribute("listDocumentPGD", documentService.getPGDDocument());
		return "quanlytailieu/dung/PGDDocument";
	}
	//phòng hànhh chính
	@RequestMapping(value = { "/DocumentPHC" }, method = RequestMethod.GET)
	public String DocumentPHC(Model model) {
		model.addAttribute("listDocumentPHC", documentService.getPHCDocument());
		return "quanlytailieu/dung/PHCDocument";
	}
	//phòng IT
	@RequestMapping(value = { "/DocumentPIT" }, method = RequestMethod.GET)
	public String DocumentPIT(Model model) {
		model.addAttribute("listDocumentPIT", documentService.getPITDocument());
		return "quanlytailieu/dung/PITDocument";
	}
	//PhòngKT
	@RequestMapping(value = { "/DocumentPKT" }, method = RequestMethod.GET)
	public String DocumentPKT(Model model) {
		model.addAttribute("listDocumentPKT", documentService.getPKTDocument());
		return "quanlytailieu/dung/PKTDocument";
	}
	//Phòng nhân sự
	@RequestMapping(value = { "/DocumentPNS" }, method = RequestMethod.GET)
	public String DocumentPNS(Model model) {
		model.addAttribute("listDocumentPNS", documentService.getPNSDocument());
		return "quanlytailieu/dung/PNSDocument";
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
		model.addAttribute("listQuyen", documentService.listQuyen());
		model.addAttribute("listCategory", documentService.listCategory());
		return "quanlytailieu/dung/documentInsert";
	}

	@RequestMapping(value = "/documentSave", method = RequestMethod.POST)
	public String submitTL(@ModelAttribute("document") DocumentDung documentDung,
			@RequestParam("file") MultipartFile file, BindingResult result, HttpServletRequest request, Model model,
			final RedirectAttributes redirectAttributes) {
		try {
			if (result.hasErrors()) {
				return "quanlytailieu/dung/documentInsert";
			}
			String nameFile = file.getOriginalFilename();
			File fileDir = new File(request.getServletContext().getRealPath(UPLOAD_DIRECTORY));
			byte[] bytes = file.getBytes();
			if (!fileDir.exists()) {
				fileDir.mkdir();
			}
			File serverFile = new File(fileDir.getAbsolutePath() + File.separator + nameFile);
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.flush();
			stream.close();
			documentDung.setNameFile(nameFile);
			documentDung.setLinkFile(File.separator + "uploads" + File.separator + nameFile);
			String format = nameFile.substring(nameFile.lastIndexOf(".") + 1, nameFile.length());

			IconDung icon = new IconDung();
			icon.setMaIcon(format);
			documentDung.setMaIcon(icon);
			TrangThaiDung trangThai = new TrangThaiDung();
			trangThai.setMaTrangThai("cho_phe_duyet");
			documentDung.setMaTrangThai(trangThai);
			documentService.saveDraft(documentDung);
		} catch (Exception e) {
		}
		return "redirect:/quanlytailieu/MyDocumentPendingApprove";
	}

	// thêm vào nháp

	@RequestMapping(value = "/documentSaveDraft", method = RequestMethod.POST)
	public String addDraft(@ModelAttribute("document") DocumentDung documentDung,
			@RequestParam("file") MultipartFile file, BindingResult result, HttpServletRequest request, Model model) {
		try {
			String nameFile = file.getOriginalFilename();
			documentDung.setNameFile(nameFile);
			documentDung.setLinkFile(File.separator + "uploads" + File.separator + nameFile);
			String format = nameFile.substring(nameFile.lastIndexOf(".") + 1, nameFile.length());
			IconDung icon = new IconDung();
			icon.setMaIcon(format);
			documentDung.setMaIcon(icon);
			TrangThaiDung trangThai = new TrangThaiDung();
			trangThai.setMaTrangThai("nhap");
			documentDung.setMaTrangThai(trangThai);
			documentService.saveDraft(documentDung);
		} catch (Exception e) {
		}
		return "redirect:/quanlytailieu/draft";
	}

	// Update tài liệu bị từ chối
	@RequestMapping(value = "/documentUpdateViewRefuse/{id}")
	public String documentUpdateViewRefuse(@PathVariable int id, Model model) {
		model.addAttribute("documentupdateRefuse", documentService.findById(id));
		return "quanlytailieu/dung/documentUpdateRefuse";
	}

	@RequestMapping(value = "/documentUpdateRefuse", method = RequestMethod.POST)
	public String updateTLRefuse(@ModelAttribute("documentupdateRefuse") DocumentDung document,
			@RequestParam("file") MultipartFile file, BindingResult result, HttpServletRequest request, Model model,
			final RedirectAttributes redirectAttributes) {
		try {
			String nameFile = file.getOriginalFilename();
			if (nameFile.equals("") || nameFile == null) {
				documentService.updateDocument(document);
			} else {
				document.setNameFile(nameFile);
				document.setLinkFile(File.separator + "uploads" + File.separator + nameFile);
				String format = nameFile.substring(nameFile.lastIndexOf(".") + 1, nameFile.length());
				IconDung icon = new IconDung();
				icon.setMaIcon(format);
				document.setMaIcon(icon);
				documentService.updateDocument(document);
			}
		} catch (Exception e) {
		}
		return "redirect:/quanlytailieu/documentRefuse";
	}
	
	// Update tài liệu nháp
		@RequestMapping(value = "/documentUpdateView/{id}")
		public String documentUpdateView(@PathVariable int id, Model model) {
			model.addAttribute("documentupdate", documentService.findById(id));
			return "quanlytailieu/dung/documentUpdate";
		}

		@RequestMapping(value = "/documentUpdate", method = RequestMethod.POST)
		public String updateTL(@ModelAttribute("documentupdate") DocumentDung document,
				@RequestParam("file") MultipartFile file, BindingResult result, HttpServletRequest request, Model model,
				final RedirectAttributes redirectAttributes) {
			try {
				String nameFile = file.getOriginalFilename();
				if (nameFile.equals("") || nameFile == null) {
					documentService.updateDocument(document);
				} else {
					document.setNameFile(nameFile);
					document.setLinkFile(File.separator + "uploads" + File.separator + nameFile);
					String format = nameFile.substring(nameFile.lastIndexOf(".") + 1, nameFile.length());
					IconDung icon = new IconDung();
					icon.setMaIcon(format);
					document.setMaIcon(icon);
					documentService.updateDocument(document);
				}
			} catch (Exception e) {
			}
			return "redirect:/quanlytailieu/draft";
		}
	
	// Delete tài liệu
	@RequestMapping(value = "/documentDelete/{id}", method = RequestMethod.GET)
	public String documentDelete(@PathVariable int id, Model model) {
		documentService.delete(id);
		return "redirect:/quanlytailieu/MyDocumentPendingApprove";
	}

	// ----------- document pending approve -------//
	@RequestMapping(value = "/pendingApprove", method = RequestMethod.GET)
	public String pendingApprove(Model model) {
		model.addAttribute("listPendingApprove", documentService.getAllPendingApprove());
		return "quanlytailieu/dung/pendingapprove";
	}

	// List những tài liệu bị từ chối
	@RequestMapping(value = "/documentRefuse", method = RequestMethod.GET)
	public String RefureDocument(Model model) {
		model.addAttribute("listRefuseDocument", documentService.getAllDocumentRefuse());
		return "quanlytailieu/dung/DocumentRefuse";
	}

	// View tài liệu để phê duyệt
	@RequestMapping(value = "/pendingApproveView/{id}", method = RequestMethod.GET)
	public String viewDocument(@PathVariable int id, Model model) {
		model.addAttribute("viewDocument", documentService.findById(id));
		return "quanlytailieu/dung/Documentview";
	}
	// Chấp thuận tài liệu

	@RequestMapping(value = "/documentAccept")
	public String documentAccept(@ModelAttribute("viewDocument") DocumentDung document, HttpSession session,
			BindingResult bindingResult) {
		documentService.accept(document);
		return "redirect:/quanlytailieu/pendingApprove";
	}

	// refuse document

	@RequestMapping(value = "/documentRefuse")
	public String documentRefuse(@ModelAttribute("viewDocument") DocumentDung document, HttpSession session,
			BindingResult bindingResult) {
		documentService.refuse(document);
		return "redirect:/quanlytailieu/pendingApprove";
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
