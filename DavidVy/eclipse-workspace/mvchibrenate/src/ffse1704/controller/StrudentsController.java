package ffse1704.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ffse1704.entity.SinhVien;
import ffse1704.service.SinhVienService;

@Controller
public class StrudentsController {
	@Autowired
	SinhVienService sinhVienService;

	/*
	 * public SinhVienService getSinhVienService() { return sinhVienService; }
	 */

	public void setSinhVienService(SinhVienService sinhVienService) {
		this.sinhVienService = sinhVienService;
	}

	// view
	@RequestMapping("/view")
	public String showForm(Model model) {
		List<SinhVien> sinhvien = sinhVienService.getAllSinhVien();
		model.addAttribute("SinhVien", sinhvien);
		return "view";
	}

	// add
	@RequestMapping(value = "/add")
	public ModelAndView hihi() {
		return new ModelAndView("add", "sinhVien", new SinhVien());
	}

	// thêm sinh viên
	@RequestMapping(value = "/saveSV", method = RequestMethod.POST)
	public String  saveEmployee(@ModelAttribute("sinhVien")  SinhVien sinhVien, BindingResult result,
			@RequestParam("file") CommonsMultipartFile file, Model model) throws IllegalStateException, IOException {
		String fileName = upload(file);
		if (!fileName.equals("")) {
			sinhVien.setImages(fileName);
			sinhVienService.addSV(sinhVien);
		}else {
			System.out.println("chua co anh");
		}
		return "View";

	}

	public String upload(@RequestParam CommonsMultipartFile file) throws IllegalStateException, IOException {

		String fileName = file.getOriginalFilename();

		String path = "F:\\hinh";
		if (fileName.isEmpty()) {
			fileName = "8191.jpg";
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
