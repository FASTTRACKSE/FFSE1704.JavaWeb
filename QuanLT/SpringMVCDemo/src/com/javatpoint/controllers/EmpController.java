package com.javatpoint.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javatpoint.beans.Emp;
import com.javatpoint.dao.EmpDao;

@Controller  
public class EmpController {
	@Autowired  
	
EmpDao dao;
@RequestMapping("/empform")
public ModelAndView showform() {
	return new ModelAndView("empform","commad", new Emp());
}
//THÊM
@RequestMapping(value="/save", method= RequestMethod.POST)
public ModelAndView save(@ModelAttribute("emp") Emp emp){  
    dao.add(emp);  
    return new ModelAndView("redirect:/viewemp"); 
}
//HIỂM THỊ
@RequestMapping("/viewemp")  
public ModelAndView viewemp(){  
    List<Emp> list=dao.getEmployees();  
    return new ModelAndView("viewemp","list",list);  
}
//TÌM ĐỂ SỬA
@RequestMapping(value="/editemp/{id}")  
public ModelAndView edit(@PathVariable int id){  
    Emp emp=dao.getEmpById(id);  
    return new ModelAndView("empeditform","command",emp);  
} 
//SỬA
@RequestMapping(value="/editsave",method = RequestMethod.POST)  
public ModelAndView editsave(@ModelAttribute("emp") Emp emp){  
    dao.update(emp);  
    return new ModelAndView("redirect:/viewemp");  
}
//XÓA
@RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)  
public ModelAndView delete(@PathVariable int id){  
    dao.delete(id);  
    return new ModelAndView("redirect:/viewemp");  
}  
}
