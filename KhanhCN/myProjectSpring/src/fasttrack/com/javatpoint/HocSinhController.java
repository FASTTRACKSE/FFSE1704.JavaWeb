package fasttrack.com.javatpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		// command is a reserved request attribute name, now use <form> tag to show
		// object data
		return new ModelAndView("hocsinhform", "command", new HocSinh());
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("hs") HocSinh hs) {
		// write code to save emp object
		// here, we are displaying emp object to prove emp has data
		hsDao.save(hs);

		// return new ModelAndView("empform","command",emp);//will display object data
		return new ModelAndView("redirect:/viewhs");// will redirect to viewemp request mapping
	}

	@RequestMapping("/viewhs")
	public ModelAndView viewhocsinh() {
		// write the code to get all employees from DAO
		// here, we are writing manual code of list for easy understanding
		List<HocSinh> list = hsDao.getStudent();
		return new ModelAndView("viewhs", "list", list);
	}
}
