package fasttrackse.ffse1704.fbms.controller.quanlynhansu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fasttrackse.ffse1704.fbms.service.quanlynhansu.BangCapService;

@Controller
public class BangCapController {
	@Autowired
	BangCapService bangCapService;



	public void setBangCapService(BangCapService bangCapService) {
		this.bangCapService = bangCapService;
	}
	
}
