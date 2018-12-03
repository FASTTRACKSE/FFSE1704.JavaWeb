package fasttrackse.ffse1704.fbms.controller.quanlyvangnghidv;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/QuanLyVangNghi/")
public class QuanLyVangNghiController {
	
	@RequestMapping(value = "/donxinnghi", method =  RequestMethod.GET)
	public String viewChucDanh(Model model) {
		
		return "QuanLyVangNghi/donxinnghi";
	}

}
