package fasttrack.com.javatpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fasttrack.dao.HocSinhDao;
import fasttrack.entity.HocSinh;

@Controller
public class HocSinhController {

	@Autowired
	HocSinhDao hsDao;

	public HocSinhDao getHsDao() {
		return hsDao;
	}

	public void setHsDao(HocSinhDao hsDao) {
		this.hsDao = hsDao;
	}

	@RequestMapping("/hocsinhform")
	public ModelAndView showform() {
		
		return new ModelAndView("hocsinhform", "command", new HocSinh());
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("hs") HocSinh hs) {

		hsDao.save(hs);
		return new ModelAndView("redirect:/viewhs");
	}

	@RequestMapping(value = "/editStudent/{id}")
	public ModelAndView edit(@PathVariable int id) {
		HocSinh hs = hsDao.getStudentById(id);
		return new ModelAndView("editForm", "command", hs);
	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("hs") HocSinh hs) {
		hsDao.update(hs);
		return new ModelAndView("redirect:/viewhs");
	}
	
	  @RequestMapping(value="/deleteStudent/{id}",method = RequestMethod.GET)  
	    public ModelAndView delete(@PathVariable int id){  
	        hsDao.delete(id);  
	        return new ModelAndView("redirect:/viewhs");  
	    }  

	@RequestMapping("/viewhs")
	public ModelAndView viewhocsinh() {
		
		List<HocSinh> list = hsDao.getStudent();
		return new ModelAndView("viewhs", "list", list);
	}
}
