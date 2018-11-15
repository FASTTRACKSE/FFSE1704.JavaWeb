package ffse1702016.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ffse1702016.entity.SinhVien;
import ffse1702016.service.SinhVienService;

@Controller
public class StudentsController {

	@Autowired
	SinhVienService sinhVienService;

	public void setSinhVienService(SinhVienService sinhVienService) {
		this.sinhVienService = sinhVienService;
	}

	@RequestMapping("/ViewSinhVien")
	public String ShowList() {
		return "redirect:/1";

	}

	@RequestMapping("/addSV")
	public ModelAndView hihi() {
		return new ModelAndView("addSV", "command", new SinhVien());
	}

	// danh sách sinh viên có phân trang
	@RequestMapping(value = "/{page}")
	public ModelAndView viewSinhVien(@PathVariable int page, Model model) {
		long record = sinhVienService.countSV();

		int perpage = 2;
		int totalPage = (int) Math.ceil(record * 1.0 / perpage);

		if (page == 0) {
			page = 1;
		}
		int start = (page - 1) * perpage;

		List<SinhVien> list = sinhVienService.getEmployeesByPage(start, perpage);
		model.addAttribute("page", page);
		model.addAttribute("totalPage", totalPage);
		return new ModelAndView("ViewSinhVien", "list", list);
	}

	// Hàm thêm sinh viên
	@RequestMapping(value = "/saveSV", method = RequestMethod.POST)
	public ModelAndView addSV(@ModelAttribute("sinhVien") SinhVien sinhVien,
			@RequestParam("file") CommonsMultipartFile file) throws IllegalStateException, IOException {
		String fileName = upload(file);
		if (!fileName.equals("")) {
			sinhVien.setImages(fileName);
		}
		sinhVienService.addSV(sinhVien);
		return new ModelAndView("redirect:/ViewSinhVien");

	}

	// gét sinh viên theo id
	@RequestMapping(value = "/editSV/{id}")
	public String edit(@PathVariable int id,Model model) {
		SinhVien sinhVien = sinhVienService.getSinhVienById(id);
		model.addAttribute("students",sinhVien);
		return "editSV";
	}

	// thực hiện update sinh viên
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public ModelAndView  editsave(@ModelAttribute("students") SinhVien sinhVien,BindingResult bindingResult,
			@RequestParam("file") CommonsMultipartFile file) throws IllegalStateException, IOException {
		String fileName = upload(file);
		if (!fileName.equals("")) {
			sinhVien.setImages(fileName);
		}
		
		sinhVienService.update(sinhVien);
		return new ModelAndView("redirect:/ViewSinhVien");

	}

	// thực hiện lệnh xóa
	@RequestMapping(value = "/deleteSV/{id}", params = "delete")
	public ModelAndView del(@PathVariable int id) {
		sinhVienService.delete(id);
		return new ModelAndView("redirect:/ViewSinhVien");
	}

	// gửi thông tin cần xóa ra trang khác
	@RequestMapping(value = "/deleteSV/{id}", method = RequestMethod.GET)
	public ModelAndView deleteSVByID(@PathVariable int id) {
		SinhVien sinhVien = sinhVienService.getSinhVienById(id);
		return new ModelAndView("delSV", "command", sinhVien);
	}

	// hủy xóa
	@RequestMapping(value = "/deleteSV/{id}", params = "cancel", method = RequestMethod.POST)
	public String cancelUpdateUser(HttpServletRequest request) {
		return "redirect:/ViewSinhVien";
	}

	// tạo hàm upload
	public String upload(@RequestParam CommonsMultipartFile file) throws IllegalStateException, IOException {

		String fileName = file.getOriginalFilename();

		String path = "E:\\HOCT\\images";
		if (fileName.isEmpty()) {
			fileName = "19429854_1881702772094185_7021918982240180920_n.jpg";
		} else {
			File dir = new File(path);
			if (!dir.exists())
				dir.mkdirs();
			File fileSave = new File(dir, fileName);
			file.transferTo(fileSave);
		}
		return fileName;

	}

}