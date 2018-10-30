package springmvc.form.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import springmvc.form.dao.UserDao;
import springmvc.form.entity.User;

@Controller
public class UserController {
	List<User> list;
	@Autowired
	UserDao dao ;

	@RequestMapping("/userform")
	public ModelAndView showForm() {

		return new ModelAndView("userform", "command", new User());

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("user") User user) {

		dao.add(user);
		return new ModelAndView("redirect:/viewuser");
	}

	@RequestMapping(value = "/edituser/{id}")
	public ModelAndView edituser(@PathVariable int id) {
		User user = dao.getUserById(id);
		return new ModelAndView("edituser", "command", user);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView edit(@ModelAttribute("user") User user) {
		dao.update(user);
		return new ModelAndView("redirect:/viewuser");
	}

	@RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.GET)
	public ModelAndView deluser(@PathVariable int id) {
		dao.delete(id);
		return new ModelAndView("redirect:/viewuser");
	}

	@RequestMapping("/viewuser")
	public ModelAndView viewUser() {
		List<User> list = dao.getAllSV();

		return new ModelAndView("viewuser", "list", list);
	}

}
