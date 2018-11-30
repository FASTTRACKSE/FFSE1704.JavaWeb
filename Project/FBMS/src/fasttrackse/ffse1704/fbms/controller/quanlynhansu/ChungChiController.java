package fasttrackse.ffse1704.fbms.controller.quanlynhansu;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ChungChi;
import fasttrackse.ffse1704.fbms.service.quanlynhansu.ChungChiService;

@Controller
public class ChungChiController {
	@Autowired
	ChungChiService chungChiService;

	@RequestMapping("/addCC")
	public ModelAndView chungchi() {
		return new ModelAndView("QuanTriNhanSu/chungChi/addCC", "chungChi", new ChungChi());
	}

	@RequestMapping("/allChungChi")
	public String ShowList(Model model) {

		List<ChungChi> allCC = chungChiService.allCC();
		model.addAttribute("chungchi", allCC);
		return "QuanTriNhanSu/chungChi/allchungchi";

	}

	@RequestMapping(value = "/addCC", method = RequestMethod.POST)
	public ModelAndView addCC(@ModelAttribute("chungChi") ChungChi chungChi) throws IllegalStateException, IOException {
		Date date = new Date();
		
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        
        String ngayCap = formatter.format(date);
        
		chungChiService.addCC(chungChi);
		
		return new ModelAndView("redirect:/allChungChi");
	}
}
