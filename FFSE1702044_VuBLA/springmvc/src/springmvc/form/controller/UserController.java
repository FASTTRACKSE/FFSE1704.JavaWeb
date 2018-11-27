package springmvc.form.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import springmvc.form.dao.UserDao;
import springmvc.form.entity.User;

@Controller
public class UserController {
	List<User> list;
	@Autowired
	UserDao dao;

	@RequestMapping("/userform")
	public ModelAndView showForm() {

		return new ModelAndView("userform", "command", new User());

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("user") User user, @RequestParam CommonsMultipartFile file,
			HttpSession session) {

		File fileImage = new File("D:\\Image");
		if (!fileImage.exists()) {
			fileImage.mkdirs();
		}
		String filename = file.getOriginalFilename();
		try {
			byte barr[] = file.getBytes();

			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(fileImage + "/" + filename));
			bout.write(barr);
			bout.flush();
			bout.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		user.setAvatar(filename);
		dao.add(user);
		return "redirect:/viewuser/1";

	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("user") User user, @RequestParam CommonsMultipartFile file,
			HttpSession session) {
		File fileImage = new File("D:\\Image");
		if (!fileImage.exists()) {
			fileImage.mkdirs();
		}
		String filename = file.getOriginalFilename();
		try {
			byte barr[] = file.getBytes();

			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(fileImage + "/" + filename));
			bout.write(barr);
			bout.flush();
			bout.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		user.setAvatar(filename);
		dao.update(user);
		return "redirect:/viewuser/1";

	}

	@RequestMapping(value = "viewuser/edituser/{id}")
	public ModelAndView edituser(@PathVariable int id) {
		User user = dao.getUserById(id);
		return new ModelAndView("edituser", "command", user);
	}

	@RequestMapping(value = "viewuser/deleteuser/{id}", method = RequestMethod.GET)
	public ModelAndView deluser(@PathVariable int id) {
		dao.delete(id);
		return new ModelAndView("redirect:/viewuser/1");
	}

	@RequestMapping("/viewuser/{pageid}")
	public ModelAndView viewUser(@PathVariable int pageid, Model model) throws SQLException {
		int perPage = 3;
		int pageTotal = (int) Math.ceil(dao.coutSV() * 1.0 / perPage);
		int start = (pageid - 1) * (int) perPage;

		List<User> list = dao.getAllSVByPage(start, (int) perPage);
		model.addAttribute("pageid", pageid);
		model.addAttribute("pagetotal", pageTotal);
		return new ModelAndView("viewuser", "list", list);
	}

}
