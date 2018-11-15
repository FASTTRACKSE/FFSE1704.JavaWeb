package fasttrackse.quanlysinhvien.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.springframework.web.multipart.MultipartFile;

import fasttrackse.quanlysinhvien.entity.SinhVien;
import fasttrackse.quanlysinhvien.service.SinhVienService;

@Controller
@RequestMapping("/")
public class SinhVienController {
	private int perPage = 2;
	private SinhVienService sinhVienService;

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

	@RequestMapping(value ="/list/{page}")
	public String list(Model model, @PathVariable("page") int page) {
		int start = (page - 1) * perPage;
		List<SinhVien> sinhvien = sinhVienService.findAll(start, perPage);
		model.addAttribute("list", sinhvien);
		model.addAttribute("total", totalPage(perPage));
		model.addAttribute("page", page);
		return "ListStudent";
	}

	public int totalPage(int perPage) {
		int totalPage = (int) Math.ceil((double) sinhVienService.count() / (double) perPage);
		return totalPage;
	}

	@Autowired
	public void setSinhVienService(SinhVienService sinhVienService) {
		this.sinhVienService = sinhVienService;
	}

	/*@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String list(Model model) {

		List<SinhVien> sinhvien = sinhVienService.listStudent();
		model.addAttribute("list", sinhvien);
		return "ListStudent";
	}*/

	@RequestMapping("/add")
	public String ShowForm(Model model) {
		model.addAttribute("command", new SinhVien());
		return "AddStudent";

	}

	@RequestMapping(value = { "/", "/add" }, method = RequestMethod.POST)
	public String addSV(@ModelAttribute("command") SinhVien sv, HttpServletRequest request, Model model,
			MultipartFile file, HttpSession session) throws IOException, InstantiationException {

		sv.setAvatar(uploadFile(file, session));
		sinhVienService.addStudent(sv);
		return "redirect:/list";

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

	@RequestMapping(value = { "/", "/edit" }, method = RequestMethod.POST)
	public String editSV(@ModelAttribute("command") SinhVien sv, HttpServletRequest request, Model model,
			HttpSession session, BindingResult bindingResult, String fileName, @RequestParam("file") MultipartFile file)
			throws IOException, InstantiationException, SQLException {

		if (bindingResult.hasErrors()) {

			return "edit";
		}
		sv.setAvatar(uploadFile(file, session));
		sinhVienService.updateStudent(sv);
		return "redirect:/list";
	}

	@RequestMapping(value = "/editStudent/{id}")
	public String edit(@PathVariable int id, Model model) {

		model.addAttribute("command", sinhVienService.getSinhVienById(id));
		return "EditStudent";

	}

	@RequestMapping(value = "/deleteStudent/{id}")
	public String delete(@PathVariable int id) {

		sinhVienService.deleteSinhVien(id);
		return "redirect:/list";

	}
}
