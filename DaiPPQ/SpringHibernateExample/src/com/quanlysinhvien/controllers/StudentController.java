package com.quanlysinhvien.controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;

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

import com.quanlysinhvien.entity.Student;
import com.quanlysinhvien.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	StudentService studentService;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	//@RequestMapping("/viewStudent")
	@RequestMapping(value = {"/"})
	public String ShowList() {
		return "redirect:/1";
	}

	// DS SV
	@RequestMapping(value = "/{page}")
	public ModelAndView viewStudent(@PathVariable int page, Model model) {
		long record = studentService.countStudent();

		int recordsPerPage = 5;

		int totalPage = (int) Math.ceil(record * 1.0 / recordsPerPage);

		if (page == 0) {
			page = 1;
		}
		if (page > totalPage) {
			page = totalPage;
		}
		int start = (page - 1) * recordsPerPage;

		List<Student> list = studentService.getStudentloyeesByPage(start, recordsPerPage);
		model.addAttribute("page", page);
		model.addAttribute("totalPage", totalPage);
		return new ModelAndView("viewStudent", "list", list);
	}

	@RequestMapping("/addStudent")
	public ModelAndView add() {
		return new ModelAndView("addStudent", "command", new Student());
	}

	// Hàm thêm sinh viên
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView addSV(@ModelAttribute("sinhVien") Student student,
			@RequestParam("file") CommonsMultipartFile file) throws IllegalStateException, IOException {
		String fileName = upload(file);
		if (!fileName.equals("")) {
			student.setImage(fileName);
		}
		studentService.addStudent(student);
		return new ModelAndView("redirect:/viewStudent");

	}

	// get sinh viên theo id
	@RequestMapping(value = "/editStudent/{id}")
	public String edit(@PathVariable int id, Model model) {
		Student student = studentService.getStudentById(id);
		model.addAttribute("student", student);
		return "editStudent";
	}

	// thực hiện update sinh viên
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("student") Student student, BindingResult bindingResult,
			@RequestParam("file") CommonsMultipartFile file) throws IllegalStateException, IOException {
		String fileName = upload(file);
		if (!fileName.equals("")) {
			student.setImage(fileName);
		}

		studentService.update(student);
		return new ModelAndView("redirect:/viewStudent");

	}

	// tạo hàm upload
	public String upload(@RequestParam CommonsMultipartFile file) throws IllegalStateException, IOException {

		String fileName = file.getOriginalFilename();

		String path = "D:\\Images";
		if (fileName.isEmpty()) {
			fileName = "14188648_185604215193789_3488328019094711375_o.jpg";
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