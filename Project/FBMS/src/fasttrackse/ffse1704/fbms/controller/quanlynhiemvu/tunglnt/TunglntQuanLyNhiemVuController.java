package fasttrackse.ffse1704.fbms.controller.quanlynhiemvu.tunglnt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.tunglnt.TunglntCongViec;
import fasttrackse.ffse1704.fbms.service.quanlynhiemvu.tunglnt.TunglntCongViecService;

@Controller
@RequestMapping("/TunglntQuanLyNhiemVu/CongViec")
public class TunglntQuanLyNhiemVuController {
	
	TunglntCongViecService tunglntCongViecService;
	
	@Autowired
	public void setTunglntCongViecService(TunglntCongViecService tunglntCongViecService) {
		this.tunglntCongViecService = tunglntCongViecService;
	}

	@RequestMapping(value =  "/ListCongViec" , method = RequestMethod.GET)
	public String listCV(Model model) {
		List<TunglntCongViec> listCV = tunglntCongViecService.AllCV();
		model.addAttribute("list", listCV);
		return "QuanLyNhiemVu/Tunglnt/congviec/listCV";
	
	}
}