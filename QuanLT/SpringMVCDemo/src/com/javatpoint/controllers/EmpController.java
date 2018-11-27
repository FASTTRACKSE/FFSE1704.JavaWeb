package com.javatpoint.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.javatpoint.beans.Emp;
import com.javatpoint.beans.ThanhPho;
import com.javatpoint.dao.EmpDao;

@Controller
public class EmpController {
	@Autowired

	EmpDao dao;

	@RequestMapping("/empform")
	public ModelAndView showform() {
		return new ModelAndView("empform", "command", new Emp());
	}

//HIỂM THỊ
	@RequestMapping("/viewemp/{pageid}")
	public ModelAndView viewemp(@PathVariable int pageid) {
		int total = 3;
		if (pageid == 1) {
		} else {
			pageid = (pageid - 1) * total + 1;
		}
		List<Emp> list = dao.getEmp(pageid, total);

		return new ModelAndView("viewemp", "list", list);
	}

//TÌM ĐỂ SỬA
	@RequestMapping(value = "/editemp/{id}")
	public ModelAndView edit(@PathVariable int id) {
		Emp emp = dao.getEmpById(id);
		return new ModelAndView("empeditform", "command", emp);
	}

//SỬA
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public ModelAndView editAndSave(@ModelAttribute("sv") Emp sv, @RequestParam("textFile") CommonsMultipartFile file,
			HttpSession session) {
		File fileImage = new File("C:\\Users\\quanh\\Desktop\\CND");

		if (!fileImage.exists()) {
			if (fileImage.mkdir()) {
				System.out.println("Directory is created!");
			} else {
				System.out.println("Failed to create directory!");
			}
		}
		String filename = file.getOriginalFilename();
		try {
			byte barr[] = file.getBytes();

			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(fileImage + "/" + filename));
			bout.write(barr);
			bout.flush();
			bout.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		
		if(filename==null || filename=="") {
		dao.update(sv);
		}else {
		sv.setImage(filename);
		dao.update(sv);
		}
		return new ModelAndView("redirect:/viewemp/1");// will redirect to viewemp request mapping
	}

//XÓA
	@RequestMapping(value = "/deleteemp/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		dao.delete(id);
		return new ModelAndView("redirect:/viewemp/1");
	}

//Them SV
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView uploadAndSave(@ModelAttribute("sv") Emp sv, @RequestParam("textFile") CommonsMultipartFile file,
			HttpSession session) {
		File fileImage = new File("D:\\abc");
		
		if (!fileImage.exists()) {
			if (fileImage.mkdir()) {
				System.out.println("Directory is created!");
			} else {
				System.out.println("Failed to create directory!");
			}
		}
		String filename = file.getOriginalFilename();
		try {
			byte barr[] = file.getBytes();

			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(fileImage + "/" + filename));
			bout.write(barr);
			bout.flush();
			bout.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		sv.setImage(filename);
		dao.add(sv);
		return new ModelAndView("redirect:/viewemp/1");// will redirect to viewemp request mapping
	}

	@ModelAttribute("countryList")
	public List<ThanhPho> getCountryList() {
		List<ThanhPho> countryList = dao.getListTinhThanh();
		return countryList;
	}
	
	

}
