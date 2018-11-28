package controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

/*import entity.City;*/
import entity.Emp;
import service.EmpService;

@Controller
public class EmpController {
	
	@Autowired
	EmpService empService;


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
	
}
