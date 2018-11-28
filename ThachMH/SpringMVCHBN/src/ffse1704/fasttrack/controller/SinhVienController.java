package ffse1704.fasttrack.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

import ffse1704.fasttrack.entity.SinhVien;
import ffse1704.fasttrack.service.SinhVienService;

@Controller
public class SinhVienController {

	private int perPage = 2;
	private SinhVienService sinhVienService;

	@Autowired
	public void setSinhVienService(SinhVienService sinhVienService) {
		this.sinhVienService = sinhVienService;
	}

	@RequestMapping("/")
	public String view(HttpSession session) {
		int currentPage;
		if (session.getAttribute("page") == null) {
			currentPage = 1;
		} else {
			currentPage = (int) session.getAttribute("page");
		}
		return "redirect:/list/" + currentPage;
	}

	@RequestMapping(value = "/list/{page}")
	public String listCustomer(Model model, @PathVariable("page") int page) {
		int start = (page - 1) * perPage;
		List<SinhVien> list = sinhVienService.findAll(start, perPage);
		model.addAttribute("list", list);
		model.addAttribute("total", totalPage(perPage));
		model.addAttribute("page", page);
		return "list-sinhvien";
	}

	public int totalPage(int perPage) {
		int totalPage = (int) Math.ceil((double) sinhVienService.count() / (double) perPage);
		return totalPage;
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("command") @Valid SinhVien v, BindingResult rs, HttpServletRequest request,
			Model model, HttpSession session, @RequestParam("myFile") MultipartFile myFile) {
		if (rs.hasErrors()) {
			return "add-sinhvien";
		} else {
			String nameFile = myFile.getOriginalFilename();
			System.out.println(nameFile);

			if (!"".equals(nameFile)) {
				String dirFile = request.getServletContext().getRealPath("image");
				System.out.println(dirFile);
				File fileDir = new File(dirFile);
				if (!fileDir.exists()) {
					fileDir.mkdir();
				}
				try {
					myFile.transferTo(new File(fileDir + File.separator + nameFile));
					System.out.println("Upload file thành công!");
					System.out.println(nameFile);
					v.setNameFile(nameFile);

					model.addAttribute("filename", nameFile);
				} catch (Exception e) {
					System.out.println(e.getMessage());
					System.out.println("Upload file thất bại!");
				}
				sinhVienService.addSV(v);
			}
		}

		return "redirect:/";
	}

	@RequestMapping("/showAdd")
	public String showForm(Model model) {
		model.addAttribute("command", new SinhVien());
		return "add-sinhvien";
	}

	@RequestMapping("/update")
	public String saveSV(@ModelAttribute("command") SinhVien v, Model model) {
		sinhVienService.saveSV(v);
		return "redirect:/list/1";
	}
	
	

	@RequestMapping("/getID/{id}")
	public String getID(@PathVariable("sinhVienID") int theId, Model model) {
		model.addAttribute("command", sinhVienService.getSinhVien(theId));
		return "edit";
	}

	@RequestMapping("/delete")
	public String deleteSV(@RequestParam("sinhVienID") int theId, Model model) {
		sinhVienService.deleteSV(theId);
		return "redirect:/list/1";
	}
}