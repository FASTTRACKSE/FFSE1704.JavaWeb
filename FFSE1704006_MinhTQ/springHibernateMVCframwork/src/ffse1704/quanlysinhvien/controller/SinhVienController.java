package ffse1704.quanlysinhvien.controller;

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

import ffse1704.quanlysinhvien.entity.SinhVien;
import ffse1704.quanlysinhvien.service.SinhVienService;

@Controller
public class SinhVienController {
	@Autowired
	SinhVienService sinhVienService;

	public void setStudentService(SinhVienService sinhVienService) {
		this.sinhVienService = sinhVienService;
	}

	@RequestMapping("/sinhvien{pageid}")
	public String index(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
		double perPage = 1;
		double pageTotal = (int) Math.ceil(dao.count() / perPage);
		int start = (pageid - 1) * (int) perPage;
		List<SinhVien> list = dao.getSinhVien(start, (int) perPage);
		model.addAttribute("pageid", pageid);
		model.addAttribute("pagetotal", pageTotal);

		return "/ViewSinhVien";
	}


	@RequestMapping(value = "/addsinhvien", method = RequestMethod.GET)
	public String showForm(Model model) {
		model.addAttribute("command", new SinhVien());
		model.addAttribute("listSinhVien", sinhVienService.listSinhVien());
		return "/AddSinhVien";
	}

	@RequestMapping(value = "/addsinhvien", method = RequestMethod.POST)
	public String createStudent(Model model, @ModelAttribute("command") @Valid SinhVien sinhvien, HttpSession session,
			MultipartFile file, BindingResult bindingResult) throws IllegalStateException, IOException {
		sinhvien.setAvatar(uploadFile(file, session));
		if (bindingResult.hasErrors()) {
			return "/AddSinhVien";
		}
		sinhVienService.add(sinhvien);
		return "redirect:/sinhvien";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, HttpSession session, Model model) {
		sinhVienService.delete(id);
		return "redirect:/sinhvien";
	}

	@RequestMapping(value = "/editview/{id}", method = RequestMethod.GET)
	public String edit_view(@PathVariable("id") int id, Model model) {
		model.addAttribute("command", sinhVienService.findById(id));
		return "EditSinhVien";
	}

	@RequestMapping(value = "/editSinhVien", method = RequestMethod.POST)
	public String edit(Model model, @ModelAttribute("command") @Valid SinhVien sinhvien, BindingResult bindingResult,
			String fileName, HttpSession session, @RequestParam("file") MultipartFile file)
			throws SQLException, IllegalStateException, IOException {
		
		
		if (bindingResult.hasErrors()) {
			return "/EditSinhVien";
		}
		sinhvien.setAvatar(uploadFile(file, session));
		sinhVienService.edit(sinhvien);
		return "redirect:/sinhvien";
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