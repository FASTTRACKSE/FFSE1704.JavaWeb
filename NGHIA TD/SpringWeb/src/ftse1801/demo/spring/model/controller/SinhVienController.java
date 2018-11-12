//package ftse1801.demo.spring.model.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import ftse1801.demo.spring.model.bean.students;
//import ftse1801.demo.spring.model.bean.User;
//import ftse1801.demo.spring.model.dao.ISinhVienDAO;
//
//@Controller
//public class SinhVienController {
//	@Autowired
//	private ISinhVienDAO sinhVienDao;
//
//	@RequestMapping(value = "/addSinhVien", method = RequestMethod.GET)
//	public ModelAndView addSinhVien() {
//		return new ModelAndView("addSinhVien", "sinhVien", new User());
//	}
//
//	@RequestMapping(value = "/listSinhVien", method = RequestMethod.GET)
//	public ModelAndView displayAllUser() {
//		List<students> listSinVien = sinhVienDao.getAllSinhVien();
//		return new ModelAndView("listSinhVien", "listSv", listSinVien);
//	}
//
//	@RequestMapping(value = "/editSinhVienView/{id}", method = RequestMethod.GET)
//	public ModelAndView editSinhVienView(@PathVariable String id) {
//		students sinhVien = sinhVienDao.getSinhVienByMaSinhVien(id);
//		return new ModelAndView("editSinhVien", "sinhVien", sinhVien);
//	}
//
//	@RequestMapping(value = "/editSinhVien", method = RequestMethod.POST)
//	public ModelAndView editSinhVienView(@ModelAttribute("sinhVien") students sinhVien) {
//		return null;
//	}
//}
