package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.SinhVienDao;
import entity.SinhVien;

@Controller
public class SinhVienController {
	@Autowired
	SinhVienDao dao;// will inject dao from xml file

	/*
	 * It displays a form to input data, here "command" is a reserved request
	 * attribute which is used to display object data into form
	 */
	 @RequestMapping("/view")  
	    public ModelAndView view(){  
	        List<SinhVien> list=dao.getList();  
	        return new ModelAndView("view","list",list);  
	    }  

}
