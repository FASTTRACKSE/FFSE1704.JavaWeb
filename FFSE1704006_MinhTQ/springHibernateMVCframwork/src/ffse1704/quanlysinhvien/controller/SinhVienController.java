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
	private int perPage = 2;
	
	
	public void setSinhVientService(SinhVienService sinhVienService) {
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
	
	public int totalPage(int perPage) {
		int totalPage = (int) Math.ceil((double) sinhVienService.count() / (double) perPage);
		return totalPage;
	}
	
	@RequestMapping("/list/{page}")
	public String index(Model model,@PathVariable("page") int page) {
		int start = (page - 1) * perPage;
		List<SinhVien> list = sinhVienService.findAll(start, perPage);
		model.addAttribute("list", list);
		model.addAttribute("total", totalPage(perPage));
		model.addAttribute("page", page);

		return "ViewSinhVien";
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
		return "redirect:/list/1";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, HttpSession session, Model model) {
		sinhVienService.delete(id);
		return "redirect:/list/1";
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
		return "redirect:/list/1";
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