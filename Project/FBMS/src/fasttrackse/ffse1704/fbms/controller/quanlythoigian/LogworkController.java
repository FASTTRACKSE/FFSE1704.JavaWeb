package fasttrackse.ffse1704.fbms.controller.quanlythoigian;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fasttrackse.ffse1704.fbms.entity.quanlythoigian.Logwork;
import fasttrackse.ffse1704.fbms.service.quanlythoigian.LogworkService;

@Controller
@RequestMapping("QuanLyThoiGian/Logwork")
public class LogworkController {
	@Autowired
	private LogworkService logworkService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String viewLogwork(Model model) {
		List<Logwork> allLogwork = logworkService.findAll();
		model.addAttribute("logwork", allLogwork);
		return "QuanLyThoiGian/logwork/list";
	}
	
}
