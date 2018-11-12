package ffse1704.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ffse1704.entity.SinhVien;
import ffse1704.model.SinhVienDAO;

@Controller
public class StudentsController {

	@Autowired
	SinhVienDAO sinhVienDAO;

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
		int record = sinhVienDAO.countSV();

		int perpage = 2;
		int totalPage = (int) Math.ceil(record * 1.0 / perpage);

		if (page == 0) {
			page = 1;
		}
		int start = (page - 1) * perpage;

		List<SinhVien> list = sinhVienDAO.getEmployeesByPage(start, perpage);
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
		sinhVienDAO.addSV(sinhVien);
		return new ModelAndView("redirect:/ViewSinhVien");

	}

	// gét sinh viên theo id
	@RequestMapping(value = "/editSV/{id}")
	public ModelAndView edit(@PathVariable int id) {
		SinhVien sinhVien = sinhVienDAO.getSinhVienById(id);
		return new ModelAndView("editSV", "command", sinhVien);
	}

	// thực hiện update sinh viên
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("sinhVien") SinhVien sinhVien,@RequestParam("file") CommonsMultipartFile file) throws IllegalStateException, IOException {
		String fileName = upload(file);
		if (!fileName.equals("")) {
			sinhVien.setImages(fileName);
		}
		sinhVienDAO.update(sinhVien);
		return new ModelAndView("redirect:/ViewSinhVien");

	}

	// thực hiện lệnh xóa
	@RequestMapping(value = "/deleteSV/{id}", params = "delete")
	public ModelAndView del(@PathVariable int id) {
		sinhVienDAO.delete(id);
		return new ModelAndView("redirect:/ViewSinhVien");
	}

	// gửi thông tin cần xóa ra trang khác
	@RequestMapping(value = "/deleteSV/{id}", method = RequestMethod.GET)
	public ModelAndView deleteSVByID(@PathVariable int id) {
		SinhVien sinhVien = sinhVienDAO.getSinhVienById(id);
		return new ModelAndView("delSV", "command", sinhVien);
	}

	// hủy xóa
	@RequestMapping(value= "/deleteSV/{id}", params = "cancel", method = RequestMethod.POST)
	public String cancelUpdateUser(HttpServletRequest  request) {
		return "redirect:/ViewSinhVien";
	}

	// tạo hàm upload
	public String upload(@RequestParam CommonsMultipartFile file) throws IllegalStateException, IOException {

		String fileName = file.getOriginalFilename();

		String path = "E:\\HOCT\\images";
		byte[] bytes = file.getBytes();
		BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(new File(path + File.separator + fileName)));

		stream.write(bytes);
		stream.flush();
		stream.close();
		return fileName;

	}
}
