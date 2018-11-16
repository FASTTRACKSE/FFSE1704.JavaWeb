package controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dao.SinhVienDao;
import entity.SinhVien;
import entity.TinhThanh;

@Controller
public class SinhVienController {
	@Autowired
	SinhVienDao dao;

	// view SinhVien
	@RequestMapping("/view")
	public ModelAndView viewemp() {
		List<SinhVien> list = dao.getSinhVien();
		return new ModelAndView("view", "list", list);
	}

	// add SinhVien
	@ModelAttribute("countryList")
	public List<TinhThanh> getCountryList() {
		List<TinhThanh> countryList = dao.getListTinhThanh();
		return countryList;
	}

	@RequestMapping("/svform")
	public ModelAndView showform() {
		return new ModelAndView("svform", "command", new SinhVien());
	}

	// editSinhVien
	@RequestMapping(value = "/editsv/{id}")
	public ModelAndView edit(@PathVariable int id) {
		SinhVien sv = dao.getSVById(id);
		return new ModelAndView("sveditform", "command", sv);
	}
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public ModelAndView editAndSave(@ModelAttribute("sv") SinhVien sv, @RequestParam CommonsMultipartFile file,
			HttpSession session) {
		File fileImage = new File("C:\\img");
		
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
		dao.update(sv);
		return new ModelAndView("redirect:/view");// will redirect to viewemp request mapping
	}

	// delete SinhVien
	@RequestMapping(value = "/deletesv/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		dao.delete(id);
		return new ModelAndView("redirect:/view");
	}

	// upload file
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView uploadAndSave(@ModelAttribute("sv") SinhVien sv, @RequestParam CommonsMultipartFile file,
			HttpSession session) {
		File fileImage = new File("C:\\img");
		
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
		dao.addSV(sv);
		return new ModelAndView("redirect:/view");// will redirect to viewemp request mapping
	}
}