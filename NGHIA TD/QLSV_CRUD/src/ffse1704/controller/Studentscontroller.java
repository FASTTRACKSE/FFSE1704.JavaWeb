package ffse1704.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ffse1704.entity.SinhVien;
import ffse1704.model.SinhVienDAO;

@Controller
public class Studentscontroller {
	
	@Autowired
	
	SinhVienDAO sinhVienDAO;
	@RequestMapping("/addSV")
	public ModelAndView ShowList() {
		return new ModelAndView("addSV","command",new SinhVien());
	}
	
	@RequestMapping("/ViewSinhVien")
	public ModelAndView viewSinhVien() {
		List<SinhVien> list  = sinhVienDAO.getAllSinhVien();
		return new ModelAndView("ViewSinhVien","list",list);
	}
	
	
	@RequestMapping(value="/saveSV",method = RequestMethod.POST)
	public ModelAndView addSV(@ModelAttribute("sinhVien") SinhVien sinhVien) {
		sinhVienDAO.addSV(sinhVien);
		return new ModelAndView("redirect:/ViewSinhVien");
		
	}
	
	@RequestMapping(value="/editSV/{id}")
	public ModelAndView edit(@PathVariable int id) {
		SinhVien sinhVien = sinhVienDAO.getSinhVienById(id);
		return new ModelAndView("editSV","command", sinhVien);
	}
	
	@RequestMapping(value="/editsave",method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("sinhVien") SinhVien sinhVien) {
		sinhVienDAO.update(sinhVien);
		return new ModelAndView("redirect:/ViewSinhVien");
		
	}
	
	// thực hiện lệnh xóa
	@RequestMapping(value="/delete/{id}")
	public ModelAndView delete(@PathVariable int id) {
		sinhVienDAO.delete(id);
		return new ModelAndView("redirect:/ViewSinhVien");
	}
	// gửi thông tin cần xóa ra trang khác
	@RequestMapping(value="/deleteSV/{id}",method = RequestMethod.GET)
	public ModelAndView deleteSVByID(@PathVariable int id) {
		SinhVien sinhVien = sinhVienDAO.getSinhVienById(id);
		return new ModelAndView("delSV","command", sinhVien);
	}
}
