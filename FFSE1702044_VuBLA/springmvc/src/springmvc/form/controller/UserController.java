package springmvc.form.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import springmvc.form.entity.User;

@Controller
public class UserController {
	List<User> list = new ArrayList<User>();

	@RequestMapping("/userform")
	public ModelAndView showForm() {

		return new ModelAndView("userform", "command", new User());

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("user") User user) {

		list.add(new User(user.getId(), user.getName(), user.getMonhoc()));
		return new ModelAndView("redirect:/viewuser");
	}
	@RequestMapping(value = "/edituser/{id}")
	public ModelAndView edituser(@PathVariable int id) {
		for (int i = 0; i < list.size(); i++) {
			id = i;
			list.get(i);
		}
		return new ModelAndView("redirect:/edituser");
	}
	@RequestMapping(value = "/deleteuser/{id}",method = RequestMethod.GET)
	public ModelAndView deluser(@PathVariable int id){
		for (int i = 1; i < list.size(); i++) {
			id = i;
			list.remove(i);
		}
		return new ModelAndView("redirect:/viewuser");
	}
	@RequestMapping("/viewuser")
	public ModelAndView viewUser() {
		return new ModelAndView("viewuser", "list", list);
	}

}
