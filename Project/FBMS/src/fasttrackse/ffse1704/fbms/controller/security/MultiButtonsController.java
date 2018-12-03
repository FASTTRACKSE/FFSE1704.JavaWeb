package fasttrackse.ffse1704.fbms.controller.security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({"/demo/*","/demo"})
public class MultiButtonsController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String viewButtons(Model model) {
		model.addAttribute("button", "");
		return "QuanTriHeThong/buttonAction";
	}	

	@RequestMapping(value = "/buttons", method = RequestMethod.POST)
	public String viewMainDashBoard(Model model, @RequestParam String action){
		String msg = "";
	    if( action.equals("draft") ){
	    	msg = "Lưu nháp";
	    }
	    else if( action.equals("submit") ){
	    	msg = "Gửi phê duyệt";
	    }
	    else if( action.equals("approved") ){
	    	msg = "Phê duyệt";
	    }
	    else if( action.equals("rejected") ){
	    	msg = "Từ chối";
	    }

		model.addAttribute("button", msg);
		return "QuanTriHeThong/buttonAction";
	}	
}
