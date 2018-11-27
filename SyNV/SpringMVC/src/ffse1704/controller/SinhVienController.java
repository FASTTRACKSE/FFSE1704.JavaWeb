package ffse1704.controller;

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

import ffse1704.entity.SinhVien;
import ffse1704.model.SinhVienDAO;

@Controller
public class SinhVienController {
	@Autowired
	SinhVienDAO sinhVienDAO;

	@RequestMapping("/empform")
	public ModelAndView showform() {
		return new ModelAndView("empform", "command", new SinhVien());
	}
	
	@RequestMapping(value="/save",method = RequestMethod.POST)
	
	public ModelAndView save(@ModelAttribute("sinhVien") SinhVien sinhVien) {
		sinhVienDAO.save(sinhVien);
		return new ModelAndView("redirect:/viewemp");
	}
	
	@RequestMapping("/viewemp")
	public ModelAndView viewSinhVien() {
		List<SinhVien> list =sinhVienDAO.getSinhVienloyees();
		return new ModelAndView("viewemp","list",list);
	}
	
	@RequestMapping(value="/editemp/{id}")
	public ModelAndView edit(@PathVariable int id) {
		SinhVien sinhVien = sinhVienDAO.getSinhVienById(id);
		return new ModelAndView("empeditform","command",sinhVien);
	}
	
	@RequestMapping(value="/editsave",method= RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("sinhVien") SinhVien sinhVien ) {
		sinhVienDAO.update(sinhVien);
		return new ModelAndView("redirect:/viewemp");
	}
	
	@RequestMapping(value="/deleteSV/{id}",method= RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		sinhVienDAO.delete(id);
		return new ModelAndView("redirect:/viewemp");
	}
	@RequestMapping(value="/viewemp/{pageid}")
	public ModelAndView hihi(@PathVariable int pageid) {
		int total=5;
		if(pageid==1) {}
		else {
			pageid=(pageid-1)*total+1;
		}
		List<SinhVien> list =sinhVienDAO.getEmployeesByPage(pageid, total);
		return new ModelAndView("viewemp","list",list);
	}
	// upload file
		@RequestMapping(value = "/save", method = RequestMethod.POST)
		public ModelAndView uploadAndSave(@ModelAttribute("sv") SinhVien sv, @RequestParam CommonsMultipartFile file,
				HttpSession session) {
			File fileImage = new File("D:\\img");
			
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
			sinhVienDAO.save(sv);
			return new ModelAndView("redirect:/viewemp");// will redirect to viewemp request mapping
		}
}
