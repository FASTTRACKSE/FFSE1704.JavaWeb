package controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;
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

import bean.Emp;
import dao.EmpDAO;

@Controller
public class EmpControLler {
	
	@Autowired

	EmpDAO dao;// will inject dao from xml file

	/*
	 * It displays a form to input data, here "command" is a reserved request
	 * attribute which is used to display object data into form
	 */

	@RequestMapping("uploadform")
	public ModelAndView uploadForm() {
		return new ModelAndView("uploadform");
	}

	

	@RequestMapping(value = "/viewemp/{pageid}")
	public ModelAndView edit1(@PathVariable int pageid) {
		int total = 5;
		if (pageid == 1) {
		} else {
			pageid = (pageid - 1) * total + 1;
		}
		List<Emp> list = dao.getEmployeesByPage(pageid, total);

		return new ModelAndView("viewemp", "list", list);
	}

	@RequestMapping("/empform")
	public ModelAndView showform() {
		return new ModelAndView("empform", "command", new Emp());
	}

	/*
	 * It saves object into database. The @ModelAttribute puts request data into
	 * model object. You need to mention RequestMethod.POST method because default
	 * request is GET
	 */

	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/x-www-from-urlencoded;charset=UTF-8")
	public ModelAndView save(@ModelAttribute("emp") Emp emp, @RequestParam CommonsMultipartFile file,HttpSession session) {
		String path=session.getServletContext().getRealPath("/");  
        String filename=file.getOriginalFilename();  
          
        System.out.println(path+" "+filename);  
        try{  
        byte barr[]=file.getBytes();  
          
        BufferedOutputStream bout=new BufferedOutputStream(  
                 new FileOutputStream(path+"/"+filename));  
        bout.write(barr);  
        bout.flush();  
        bout.close();  
          
        }catch(Exception e){System.out.println(e);} 
        emp.setImage(filename);
		dao.save(emp);
		return new ModelAndView("redirect:/viewemp/1");// will redirect to viewemp request mapping
	}

	/* It provides list of employees in model object */
	@RequestMapping("/viewemp")
	public ModelAndView viewemp() {
		List<Emp> list = dao.getEmployees();
		return new ModelAndView("viewemp", "list", list);
	}

	/*
	 * It displays object data into form for the given id. The @PathVariable puts
	 * URL data into variable.
	 */
	@RequestMapping(value = "/editemp/{id}")
	public ModelAndView edit(@PathVariable int id) {
		Emp emp = dao.getEmpbyid(id);
		return new ModelAndView("empeditform", "command", emp);

	}

	/* It updates model object. */
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("emp") Emp emp,@RequestParam CommonsMultipartFile file,HttpSession session) {
		
		String path=session.getServletContext().getRealPath("/");  
        String filename=file.getOriginalFilename();  
          
        System.out.println(path+" "+filename);  
        try{  
        byte barr[]=file.getBytes();  
          
        BufferedOutputStream bout=new BufferedOutputStream(  
                 new FileOutputStream(path+"/"+filename));  
        bout.write(barr);  
        bout.flush();  
        bout.close();  
          
        }catch(Exception e){System.out.println(e);} 
        emp.setImage(filename);
		dao.update(emp);
		return new ModelAndView("redirect:/viewemp/1");
	}

	/* It deletes record for the given id in URL and redirects to /viewemp */
	@RequestMapping(value = "/deleteemp/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		dao.delete(id);
		return new ModelAndView("redirect:/viewemp/1");
	}

	/*
	 * public static String getUploadDirectory() { return UPLOAD_DIRECTORY; }
	 */
}
