package fasttrackse.ffse1704.fbms.controller.security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/demo/components")
public class ComponentsController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String viewMainDashBoard(Model model) {
		return "QuanTriHeThong/components";
	}	
}
