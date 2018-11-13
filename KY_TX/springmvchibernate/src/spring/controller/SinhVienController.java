package spring.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

import spring.entity.TinhThanh;
import spring.entity.SinhVien;
import spring.service.SinhVienServiceHBN;

@Controller
public class SinhVienController {
	@Autowired
	SinhVienServiceHBN sinhVienServiceHBN;

	public void setStudentService(SinhVienServiceHBN sinhVienServiceHBN) {
		this.sinhVienServiceHBN = sinhVienServiceHBN;
	}

	@RequestMapping("/view")
	public String index(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
		int totalRecords = sinhVienServiceHBN.listSV().size();
		int recordsPerPage = 2;
		int totalPages = 0;
		if ((totalRecords / recordsPerPage) % 2 == 0) {
			totalPages = totalRecords / recordsPerPage;
		} else {
			totalPages = totalRecords / recordsPerPage + 1;
		}
		int startPosition = recordsPerPage * (currentPage - 1);

		model.addAttribute("listSV", sinhVienServiceHBN.findAllForPaging(startPosition, recordsPerPage));
		model.addAttribute("lastPage", totalPages);
		model.addAttribute("currentPage", currentPage);

		return "/view";
	}

	// add
	@RequestMapping(value = "/addsv", method = RequestMethod.GET)
	public String showForm(Model model) {
		model.addAttribute("sinhvien", new SinhVien());
		List<TinhThanh> listTT = sinhVienServiceHBN.listTT();
		model.addAttribute("countryList", listTT);
		model.addAttribute("listSV", sinhVienServiceHBN.listSV());
		return "addsv";
	}

	@RequestMapping(value = "/addsv", method = RequestMethod.POST)
	public String createStudent(Model model, @ModelAttribute("sinhvien") @Valid SinhVien sv, HttpSession session,
			MultipartFile file, BindingResult bindingResult) throws IllegalStateException, IOException {
		sv.setImage(uploadFile(file, session));
		if (bindingResult.hasErrors()) {
			return "addsv";
		}
		sinhVienServiceHBN.add(sv);
		return "redirect:/view";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, HttpSession session, Model model) {
		sinhVienServiceHBN.delete(id);
		return "redirect:/view";
	}

	// edit
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit_view(@PathVariable("id") int id, Model model) {
		List<TinhThanh> listTT = sinhVienServiceHBN.listTT();
		model.addAttribute("countryList", listTT);
		model.addAttribute("sinhvien", sinhVienServiceHBN.fintByTd(id));
		return "editsv";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editStudent(Model model, @ModelAttribute("sinhvien") @Valid SinhVien sv, HttpSession session,
			MultipartFile file, BindingResult bindingResult) throws IllegalStateException, IOException {
		sv.setImage(uploadFile(file, session));
		if (bindingResult.hasErrors()) {
			return "editsv";
		}
		sinhVienServiceHBN.edit(sv);;
		return "redirect:/view";
	}
	public String uploadFile(MultipartFile file, HttpSession session) throws IllegalStateException, IOException {
		Date date = new Date();
		SimpleDateFormat fm = new SimpleDateFormat("hhmmssddMMyyyy");
		String fileName = fm.format(date) + "_" + file.getOriginalFilename();
		String path = session.getServletContext().getRealPath("/") + "\\resources\\upload\\";
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
		String path = session.getServletContext().getRealPath("/") + "\\resources\\upload\\";
		File file = new File(path, fileName);
		boolean result = file.delete();
		return result;
	}
}
