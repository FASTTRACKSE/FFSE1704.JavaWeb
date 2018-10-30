package fasttrack.com.javatpoint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fasttrack.entity.HocSinh;

public class HocSinhController {

	@RequestMapping("/hocsinh")
	public ModelAndView showform() {
		// command is a reserved request attribute name, now use <form> tag to show
		// object data
		return new ModelAndView("hocsinh", "command", new HocSinh());
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("hs") HocSinh hs) {
		// write code to save emp object
		// here, we are displaying emp object to prove emp has data
		System.out.println(hs.getNameStudent() + " " + hs.getClassStudent() + " " + hs.getGender());

		// return new ModelAndView("empform","command",emp);//will display object data
		return new ModelAndView("redirect:/viewhs");// will redirect to viewemp request mapping
	}

	@RequestMapping("/viewhocsinh")
	public ModelAndView viewhocsinh() {
		// write the code to get all employees from DAO
		// here, we are writing manual code of list for easy understanding
		List<HocSinh> list = new ArrayList<HocSinh>();
		list.add(new HocSinh(1,"Khánh", "FFSE1701","Nam"));
		list.add(new HocSinh(2, "Minh", "FFSE1704", "Nữ"));
		list.add(new HocSinh(3, "Kỳ", "FFSE1701", "3D"));

		return new ModelAndView("viewhocsinh", "list", list);
	}
}
