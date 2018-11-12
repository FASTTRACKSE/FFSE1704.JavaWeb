package fasttrack.controller;

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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import fasttrack.entity.HocSinh;
import fasttrack.service.HocSinhService;

@Controller
@RequestMapping("/")
public class HocSinhController {
	@Autowired
	HocSinhService hocsinhservice;

	@Autowired
	public void setHocSinhService(HocSinhService hocsinhservice) {
		this.hocsinhservice = hocsinhservice;
	}
	
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String index(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
		int totalRecords = hocsinhservice.getAll().size();
		int recordsPerPage = 3;
		int totalPages = 0;
		if ((totalRecords / recordsPerPage) % 2 == 0) {
			totalPages = totalRecords / recordsPerPage;
		} else {
			totalPages = totalRecords / recordsPerPage + 1;
		}
		int startPosition = recordsPerPage * (currentPage - 1);

		model.addAttribute("list", hocsinhservice.findAllForPaging(startPosition, recordsPerPage));
		model.addAttribute("lastPage", totalPages);
		model.addAttribute("currentPage", currentPage);

		return "/listhocsinh";
	}

	/* @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listhocsinh(Model model) {

		List<HocSinh> hs = hocsinhservice.getAll();

		model.addAttribute("list", hs);
		return "/listhocsinh";
	}*/

	@RequestMapping("/add")
	public String showForm(Model model) {
		model.addAttribute("command", new HocSinh());
		return "addhocsinh";
	}

	@RequestMapping(value = { "/", "/add" }, method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("command") HocSinh hs, HttpServletRequest request, Model model,
			HttpSession session, MultipartFile file) throws IllegalStateException, IOException {
		hs.setImage(uploadFile(file, session));
		hocsinhservice.addhs(hs);
		return "redirect:/list";

	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		hocsinhservice.delhs(id);
		return "redirect:/list";
	}

	@RequestMapping("/getID/{id}")
	public String getID(@PathVariable("id") int id, Model model) {
		model.addAttribute("command", hocsinhservice.getHocSinhByID(id));
		return "edithocsinh";
	}

	@RequestMapping(value = { "/", "/update" }, method = RequestMethod.POST)
	public String update(@ModelAttribute("command") HocSinh hs, Model model, String fileName, HttpSession session,BindingResult bindingResult,
			@RequestParam("file") MultipartFile file) throws SQLException, IllegalStateException, IOException {
		if (bindingResult.hasErrors()) {
			return "edit";
		}
		hs.setImage(uploadFile(file, session));
		hocsinhservice.updatehs(hs);
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

}
