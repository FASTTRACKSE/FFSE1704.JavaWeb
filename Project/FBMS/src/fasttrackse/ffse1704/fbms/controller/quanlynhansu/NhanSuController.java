package fasttrackse.ffse1704.fbms.controller.quanlynhansu;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.NhanSu;
import fasttrackse.ffse1704.fbms.service.quanlynhansu.NhanSuService;

@Controller
public class NhanSuController {
	@Autowired
	NhanSuService nhanSuService;
	
	

	public void setNhanSuService(NhanSuService nhanSuService) {
		this.nhanSuService = nhanSuService;
	}

	@RequestMapping("/allNhanSu")
	public String ShowList(Model model) {
		
		List<NhanSu> allNS = nhanSuService.allNS();
		model.addAttribute("nhansu", allNS);
		return "QuanTriNhanSu/nhanSu/allnhansu";

	}
	
	@RequestMapping("/addNS")
	public ModelAndView ShowViewADD() {
		
		return new ModelAndView("QuanTriNhanSu/nhanSu/ViewAddNhanSu","nhanSu", new NhanSu());

	}
	
	@RequestMapping(value="/saveNhanSu", method = RequestMethod.POST)
	public ModelAndView AddNhanSu(@ModelAttribute("nhanSu") NhanSu nhanSu) 
			throws IllegalStateException, IOException{

		nhanSuService.addNS(nhanSu);
		
		return new ModelAndView("redirect:/allNhanSu");

	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, 
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
	}
	
	public String upload(@RequestParam CommonsMultipartFile file) throws IllegalStateException, IOException {

		String fileName = file.getOriginalFilename();

		String path = "E:\\HOCT\\images";
		if (fileName.isEmpty()) {
			fileName = "default.jpg";
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
