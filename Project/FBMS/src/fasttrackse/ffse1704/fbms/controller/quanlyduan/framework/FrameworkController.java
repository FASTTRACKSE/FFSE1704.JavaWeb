/**
 * 
 */
package fasttrackse.ffse1704.fbms.controller.quanlyduan.framework;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	@Autowired(required=true)
	@Qualifier(value = "frameworkServiceImpl")
	public void setFrameworkService(FrameworkService frameworkService) {
		this.frameworkService = frameworkService;
	}
	
	/*list framework*/
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
		
		return "QuanLyDuAn/framework/list";
	}
	
}
