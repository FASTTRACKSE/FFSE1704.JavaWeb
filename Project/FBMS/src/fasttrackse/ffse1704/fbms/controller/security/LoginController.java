package fasttrackse.ffse1704.fbms.controller.security;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fasttrackse.ffse1704.fbms.entity.security.CustomUserDetail;
import fasttrackse.ffse1704.fbms.entity.security.HoSoNhanVien;

@Controller
public class LoginController {
	@RequestMapping(value = { "/login" })
	public String login(@RequestParam(value = "error", required = false) final String error, final Model model,
			final Principal pr) {
		if (error != null) {
			model.addAttribute("message", "Login Failed!");
		}
		if (pr != null) {
			return "redirect:/";
		}
		return "QuanTriHeThong/login";
	}
	
    @RequestMapping(value="/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
       Authentication auth = SecurityContextHolder.getContext().getAuthentication();
       if (auth != null){
          new SecurityContextLogoutHandler().logout(request, response, auth);
       }
       return "QuanTriHeThong/login";
    }

}