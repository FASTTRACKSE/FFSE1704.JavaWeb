package springmvchibernate.controller;

import java.beans.PropertyEditorSupport;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import springmvchibernate.entity.User;
import springmvchibernate.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;

	@Autowired
	@Qualifier(value = "userServiceImplements")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/list")
	public String listDuAn(@PathVariable int pageid, Model model, HttpServletRequest request) {
		int perPage = 3;
		
		model.addAttribute("list", userService.listUser());
		return "list";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showForm(Model model) {
		model.addAttribute("user", new User());
		return "create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createStudent(Model model, @ModelAttribute("sinhvien") @Valid User sv, HttpServletRequest request,
			MultipartFile file, BindingResult bindingResult) throws IllegalStateException, IOException {
		if (bindingResult.hasErrors()) {
			return "create";
		}
		System.out.println(sv.getMaSV());
		sv.setAvatar(uploadFile(file, request));
		userService.add(sv);
		;
		return "redirect:/list";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, HttpServletRequest request, Model model) {
		userService.delete(id);
		return "redirect:/list";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit_view(@PathVariable("id") int id, Model model) {
		model.addAttribute("user", userService.findById(id));
		return "edit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String edit(Model model, @ModelAttribute("user") @Valid User user, HttpServletRequest request,
			@RequestParam("file") MultipartFile file, BindingResult bindingResult)
			throws IllegalStateException, IOException {
		if (bindingResult.hasErrors()) {
			return "edit";
		}
		user.setAvatar(uploadFile(file, request));
		userService.update(user);
		return "redirect:/list";
	}

	public String uploadFile(MultipartFile file, HttpServletRequest request) throws IllegalStateException, IOException {
		File fileImage = new File("D:\\Image");
		if (!fileImage.exists()) {
			fileImage.mkdirs();
		}
		String fileName = file.getOriginalFilename();
		try {
			byte barr[] = file.getBytes();

			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(fileImage + "/" + fileName));
			bout.write(barr);
			bout.flush();
			bout.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return fileName;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {

		binder.registerCustomEditor(User.class, "User", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				setValue(userService.listUser());
			}
		});
	}

}
