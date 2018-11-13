package com.javatpoint.controller;
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
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.javatpoint.entity.*;
import com.javatpoint.service.*;

@Controller
public class EmpController {
@Autowired
EmpService empService;

public EmpService getEmpService() {
	return empService;
}
public void setEmpService(EmpService empService) {
	this.empService = empService;
}
//view
@RequestMapping(value = "/view")
public String index(ModelMap emp) {
	 
    List<Emp> employees = empService.listStudent();
    emp.addAttribute("employees", employees);
	return "redirect:/view";
}
//add
@RequestMapping(value = "/addsv", method = RequestMethod.GET)
public String showForm(Model model) {
	model.addAttribute("sinhvien", new Emp());
	List<City> listTT = empService.listTinhThanh();
	model.addAttribute("countryList", listTT);
	model.addAttribute("listSV", empService.listTinhThanh());
	return "addsv";
}
@RequestMapping(value = "/addsv", method = RequestMethod.POST)
public String createStudent(Model model, @ModelAttribute("sinhvien") @Valid Emp sv, HttpSession session,
		MultipartFile file, BindingResult bindingResult) throws IllegalStateException, IOException {
	sv.setImage(uploadFile(file, session));
	if (bindingResult.hasErrors()) {
		return "addsv";
	}
	empService.add(sv);
	return "redirect:/view";
}

@RequestMapping("/delete/{id}")
public String delete(@PathVariable int id, HttpSession session, Model model) {
	empService.delete(id);
	return "redirect:/view";
}

//edit
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit_view(@PathVariable("id") int id, Model model) {
		List<City> listTT = empService.listTinhThanh();
		model.addAttribute("countryList", listTT);
		model.addAttribute("sinhvien", empService.findById(id));
		return "editsv";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editStudent(Model model, @ModelAttribute("sinhvien") @Valid Emp sv, HttpSession session,
			MultipartFile file, BindingResult bindingResult) throws IllegalStateException, IOException {
		sv.setImage(uploadFile(file, session));
		if (bindingResult.hasErrors()) {
			return "editsv";
		}
		empService.edit(sv);;
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
