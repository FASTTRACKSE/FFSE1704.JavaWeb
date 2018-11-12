package ffse1704.quanlysinhvien.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import ffse1704.quanlysinhvien.entity.SinhVien;
import ffse1704.quanlysinhvien.service.SinhVienService;

@Controller
public class SinhVienController {
	@Autowired
	SinhVienService sinhVienService;

	public void setStudentService(SinhVienService sinhVienService) {
		this.sinhVienService = sinhVienService;
	}

	@RequestMapping("/sinhvien")
	public String index(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
		int totalRecords = sinhVienService.listSinhVien().size();
		int recordsPerPage = 2;
		int totalPages = 0;
		if ((totalRecords / recordsPerPage) % 2 == 0) {
			totalPages = totalRecords / recordsPerPage;
		} else {
			totalPages = totalRecords / recordsPerPage + 1;
		}
		int startPosition = recordsPerPage * (currentPage - 1);

		model.addAttribute("listStudent", sinhVienService.findAllForPaging(startPosition, recordsPerPage));
		model.addAttribute("lastPage", totalPages);
		model.addAttribute("currentPage", currentPage);

		return "/ViewSinhVien";
	}

	@RequestMapping(value = "/addsinhvien", method = RequestMethod.GET)
	public String showForm(Model model) {
		model.addAttribute("sinhvien", new SinhVien());
		model.addAttribute("listSinhVien", sinhVienService.listSinhVien());
		return "AddSinhVien";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createStudent(Model model, @ModelAttribute("sinhvien") @Valid SinhVien sinhvien, HttpSession session,
			MultipartFile file, BindingResult bindingResult) throws IllegalStateException, IOException {
		sinhvien.setAvatar(uploadFile(file, session));
		if (bindingResult.hasErrors()) {
			return "AddSinhVien";
		}
		sinhVienService.add(sinhvien);
		return "redirect:/ViewSinhVien";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, HttpSession session, Model model) {
		sinhVienService.delete(id);
		return "redirect:/ViewSinhVien";
	}

	@RequestMapping(value = "/editview/{id}", method = RequestMethod.GET)
	public String edit_view(@PathVariable("id") int id, Model model) {
		model.addAttribute("student", sinhVienService.findById(id));
		return "EditSinhVien";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(Model model, @ModelAttribute("sinhvien") @Valid SinhVien sinhvien, BindingResult bindingResult,
			String fileName, HttpSession session, @RequestParam("file") MultipartFile file)
			throws SQLException, IllegalStateException, IOException {
		if (sinhvien.getAvatar() != null) {
			if (!file.isEmpty()) {
				deleteFile(sinhvien.getAvatar(), session);
				sinhvien.setAvatar(uploadFile(file, session));
			}
		}
		if (bindingResult.hasErrors()) {
			return "EditSinhVien";
		}
		sinhVienService.edit(sinhvien);
		return "redirect:/ViewSinhVien";
	}

	public String uploadFile(MultipartFile file, HttpSession session) throws IllegalStateException, IOException {
		Date date = new Date();
		SimpleDateFormat fm = new SimpleDateFormat("hhmmssddMMyyyy");
		String fileName = fm.format(date) + "_" + file.getOriginalFilename();
		String path = session.getServletContext().getRealPath("/") + "\\Image\\";
		if (fileName.isEmpty()) {
			fileName = "default.png";
		} else {
			File dir = new File(path);
			if (!dir.exists())
				dir.mkdirs();
			File fileSave = new File(dir, fileName);
			file.transferTo(fileSave);
		}
		return fileName;
	}

	public boolean deleteFile(String fileName, HttpSession session) {
		String path = session.getServletContext().getRealPath("/") + "\\Image\\";
		File file = new File(path, fileName);
		boolean result = file.delete();
		return result;
	}
}