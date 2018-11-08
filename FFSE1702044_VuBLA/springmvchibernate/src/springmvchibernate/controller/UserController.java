package springmvchibernate.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import springmvchibernate.entity.User;
import springmvchibernate.service.UserService;

@Controller
public class UserController {
	UserService userService;

	public UserService getUserService() {
		return userService;
	}

	@Autowired
	@Qualifier(value = "UserServiceImplements")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String addUser(Model model, @ModelAttribute("user") @Valid User user, HttpServletRequest request,
			MultipartFile file, BindingResult bindingResult) throws IllegalStateException, IOException {
		if (bindingResult.hasErrors()) {
			return "index";
		}
		user.setAvatar(uploadFile(file, request));
		return "redirect:/viewuser";
	}

	public String uploadFile(MultipartFile file, HttpServletRequest request) throws IllegalStateException, IOException {

		String fileName = file.getOriginalFilename();
		String path = request.getSession().getServletContext().getRealPath("/") + "\\resources\\upload\\";
		if (fileName.isEmpty()) {
			fileName = "anhnull.png";
		} else {
			File dir = new File(path);
			if (!dir.exists())
				dir.mkdirs();
			File fileSave = new File(dir, fileName);
			file.transferTo(fileSave);
		}
		return fileName;
	}
}
