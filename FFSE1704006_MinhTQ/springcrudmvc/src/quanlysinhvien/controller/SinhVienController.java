package quanlysinhvien.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
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

import quanlysinhvien.entity.SinhVien;
import quanlysinhvien.model.SinhVienDAO;

@Controller  
public class SinhVienController {  
    @Autowired  
    SinhVienDAO dao;//will inject dao from xml file  
    private static final String UPLOAD_DIRECTORY ="/images";  
    
    
    
    @RequestMapping(value="savefile",method=RequestMethod.POST)  
    public void saveimage( @RequestParam CommonsMultipartFile file,  
           HttpSession session) throws Exception{  
  
    ServletContext context = session.getServletContext();  
    String path = context.getRealPath(UPLOAD_DIRECTORY);  
    String filename = file.getOriginalFilename();  
  
    System.out.println(path+" "+filename);        
  
    byte[] bytes = file.getBytes();  
    BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
         new File(path + File.separator + filename)));  
    stream.write(bytes);  
    stream.flush();  
    stream.close();  
           
   
    }  
    
    
    @ModelAttribute("countryList")
    public List<String> getWebFrameworkList() {
       List<String> webFrameworkList = new ArrayList<String>();
       webFrameworkList.add("Spring MVC");
       webFrameworkList.add("Struts 1");
       webFrameworkList.add("Struts 2");
       webFrameworkList.add("Apache Wicket");
       return webFrameworkList;
    }
    
    
    /*It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form 
     */  
    @RequestMapping("/addsinhvien")  
    public ModelAndView showform(){  
        return new ModelAndView("addsinhvien","command",new SinhVien());  
    }
    
    
    /*It saves object into database. The @ModelAttribute puts request data 
     *  into model object. You need to mention RequestMethod.POST method  
     *  because default request is GET*/  
    @RequestMapping(value="/themsinhvien",method = RequestMethod.POST)  
    public ModelAndView save(@ModelAttribute("sinhvien") SinhVien sinhvien){  
    	
    	sinhvien.setAvatar("filename");
        dao.add(sinhvien);  
        return new ModelAndView("redirect:/sinhvien");//will redirect to viewemp request mapping  
    }
    
    
    
    /* It provides list of employees in model object */  
    @RequestMapping("/sinhvien")  
    public ModelAndView viewSinhVien(){  
        List<SinhVien> list=dao.getSinhVien();  
        return new ModelAndView("sinhvien","list",list);  
    }
    
    
    
    /* It displays object data into form for the given id.  
     * The @PathVariable puts URL data into variable.*/  
    @RequestMapping(value="/editview/{id}")  
    public ModelAndView edit(@PathVariable int id){  
        SinhVien sinhvien=dao.getSVById(id);  
        return new ModelAndView("editsinhvien","command",sinhvien);  
    }  
    
    
   /* It updates model object. */  
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public ModelAndView editsave(@ModelAttribute("sinhvien") SinhVien sinhvien){  
        dao.update(sinhvien);  
        return new ModelAndView("redirect:/sinhvien");  
    }  
    
    
    //* It deletes record for the given id in URL and redirects to /viewemp */  
    @RequestMapping(value="/deletesinhvien/{id}",method = RequestMethod.GET)  
    public ModelAndView delete(@PathVariable int id){  
        dao.delete(id);  
        return new ModelAndView("redirect:/sinhvien");  
    }  
  
}  