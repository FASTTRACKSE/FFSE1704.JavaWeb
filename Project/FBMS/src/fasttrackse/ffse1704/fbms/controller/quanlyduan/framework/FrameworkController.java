/**
 * 
 */
package fasttrackse.ffse1704.fbms.controller.quanlyduan.framework;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fasttrackse.ffse1704.fbms.entity.quanlyduan.framework.Framework;
import fasttrackse.ffse1704.fbms.service.quanlyduan.framework.FrameworkService;

/**
 * @author QuangDai
 *
 */
@Controller
@RequestMapping("/Quan_Ly_Du_An")
public class FrameworkController {
	private FrameworkService frameworkService;

	public FrameworkService getFrameworkService() {
		return frameworkService;
	}

	@Autowired(required = true)
	@Qualifier(value = "frameworkServiceImpl")
	public void setFrameworkService(FrameworkService frameworkService) {
		this.frameworkService = frameworkService;
	}

	/* list framework */
	@RequestMapping("/List_Framework/{page}")
	public String list(@PathVariable int page, Model model) throws SQLException {
		int record = frameworkService.countFramework();

		int recordsPerPage = 2;

		int totalPage = (int) Math.ceil(record * 1.0 / recordsPerPage);

		if (page == 0) {
			page = 1;
		}
		if (page > totalPage) {
			page = totalPage;
		}
		int start = (page - 1) * recordsPerPage;

		List<Framework> list = frameworkService.listFramework(start, recordsPerPage);
		model.addAttribute("list", list);
		model.addAttribute("indexPage", page);
		model.addAttribute("allPage", totalPage);

		return "QuanLyDuAn/framework/list_framework_form";
	}

	/* add new Framework */
	@RequestMapping("/Add_Framework")
	public ModelAndView viewAddFramework() {
		return new ModelAndView("QuanLyDuAn/framework/add_framework_form", "command", new Framework());
	}

	@RequestMapping(value = "/Save_Framework", method = RequestMethod.POST)
	public String addNewFramework(@ModelAttribute("command") @Valid Framework framework, BindingResult result,
			HttpSession session, Model model) {
		if (result.hasErrors()) {
			return "QuanLyDuAn/framework/add_framework_form";
		} else {
			int searchFramework = frameworkService.getRecordsByMaFramework(framework.getMaFramework());
			if (searchFramework == 0) {
				if (framework.getGhiChu().isEmpty()) {
					framework.setGhiChu("");
					frameworkService.addNew(framework);
				} else {
					frameworkService.addNew(framework);
				}
			} else {
				String mess = "Mã Framework đã tồn tại";
				model.addAttribute("mess", mess);
				return "QuanLyDuAn/framework/add_framework_form";
			}

		}
		return "redirect:/Quan_Ly_Du_An/List_Framework/1";
	}

	/*
	 * edit Framework# 
	 * get Framework by maFramework# 
	 * update Framework by maFramework
	 */
	@RequestMapping(value = "/Edit_Framework/{idFramework}")
	public String viewEditFramework(@PathVariable String idFramework, Model model) {
		Framework framework = frameworkService.getFrameworkByMaFramework(idFramework);
		model.addAttribute("command", framework);
		return "QuanLyDuAn/framework/edit_framework_form";
	}
	@RequestMapping(value = "/Edit_Save_Framework", method = RequestMethod.POST)
	public String editSaveFramework(@ModelAttribute("command") @Valid Framework framework, BindingResult result,
			HttpSession session) {
		if (result.hasErrors()) {
			return "QuanLyDuAn/framework/edit_framework_form";
		} else {
			if (framework.getGhiChu().isEmpty()) {
				framework.setGhiChu("");
				frameworkService.update(framework);
			} else {
				frameworkService.update(framework);
			}
		}
		return "redirect:/Quan_Ly_Du_An/List_Framework/1";
	}
	
	/*
	 * delete Framework# 
	 * get Framework by maFramework# 
	 * delete Framework by maFramework
	 */
	@RequestMapping(value = "/Delete_Framework/{idFramework}")
	public String viewDeleteFramework(@PathVariable String idFramework, Model model) {
		Framework framework = frameworkService.getFrameworkByMaFramework(idFramework);
		model.addAttribute("command", framework);
		return "QuanLyDuAn/framework/delete_framework_form";
	}
	@RequestMapping(value = "/Submit_Delete_Framework", method = RequestMethod.POST)
	public String deleteFramework(@ModelAttribute("command") Framework framework) {
		frameworkService.delete(framework.getMaFramework());;
		return "redirect:/Quan_Ly_Du_An/List_Framework/1";
	}
}
