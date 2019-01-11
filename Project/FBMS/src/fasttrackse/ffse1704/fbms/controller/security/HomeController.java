package fasttrackse.ffse1704.fbms.controller.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fasttrackse.ffse1704.fbms.entity.security.CustomUserDetail;
import fasttrackse.ffse1704.fbms.entity.security.HoSoNhanVien;

@Controller
@RequestMapping({ "/home/*", "/home" })
public class HomeController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String viewMainDashBoard(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		HoSoNhanVien userLogin = ((CustomUserDetail) auth.getPrincipal()).getUser().getNhanVien();
		
		model.addAttribute("userLogin", userLogin);
		String maPhongBan = userLogin.getPhongBan().getMaPhongBan();

		return "dashboard";
	}
}
