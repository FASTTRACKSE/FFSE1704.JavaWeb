package fasttrackse.quanlysinhvien.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fasttrackse.quanlysinhvien.dao.SinhVienDAO;
@Controller
public class Controller {
	@Autowired
	SinhVienDAO dao;// will inject dao from xml file
	

	public void setStudentService(SinhVienService sinhVienService) {
		this.sinhVienService = sinhVienService;
	}

	@RequestMapping("/list")
	public String index(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
		int totalRecords = sinhVienService.listStudent().size();
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

		return "/list";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showForm(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("listSinhVien", sinhVienService.listStudent());
		return "create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createStudent(Model model, @ModelAttribute("student") @Valid Student sv, HttpSession session,
			MultipartFile file, BindingResult bindingResult) throws IllegalStateException, IOException {
		sv.setAvatar(uploadFile(file, session));
		if (bindingResult.hasErrors()) {
			return "create";
		}
		sinhVienService.create(sv);
		return "redirect:/list";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, HttpSession session, Model model) {
		sinhVienService.delete(id);
		return "redirect:/list";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit_view(@PathVariable("id") int id, Model model) {
		model.addAttribute("student", sinhVienService.findById(id));
		return "edit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String edit(Model model, @ModelAttribute("student") @Valid Student student, BindingResult bindingResult,
			String fileName, HttpSession session, @RequestParam("file") MultipartFile file)
			throws SQLException, IllegalStateException, IOException {
		if (student.getAvatar() != null) {
			if (!file.isEmpty()) {
				deleteFile(student.getAvatar(), session);
				student.setAvatar(uploadFile(file, session));
			}
		}
		if (bindingResult.hasErrors()) {
			return "edit";
		}
		sinhVienService.update(student);
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
