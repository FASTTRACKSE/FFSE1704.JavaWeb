package fasttrackse.ffse1704.fbms.controller.quanlyduan.technical;

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

import fasttrackse.ffse1704.fbms.entity.quanlyduan.technical.Technical;
import fasttrackse.ffse1704.fbms.service.quanlyduan.technical.TechnicalService;

@Controller
@RequestMapping("/Quan_Ly_Du_An")
public class TechnicalController {
	private TechnicalService technicalService;

	public TechnicalService getTechnicalService() {
		return technicalService;
	}

	@Autowired(required = true)
	@Qualifier(value = "technicalServiceIPM")
	public void setTechnicalService(TechnicalService technicalService) {
		this.technicalService = technicalService;
	}

	@RequestMapping("/List_Technical/{page}")
	public String list(@PathVariable int page, Model model) throws SQLException {
		int allItem = technicalService.getRecordsTotal();
		int reCordInPage = 2;
		double pageTotal = allItem / reCordInPage + ((allItem % reCordInPage) == 0 ? 0 : 1);
		int total = (int) pageTotal;
		int start = (page * (int) reCordInPage) - (int) reCordInPage;
		List<Technical> list = technicalService.listTechnical(start, reCordInPage);
		model.addAttribute("list", list);
		model.addAttribute("indexPage", page);
		model.addAttribute("allPage", total);
		return "QuanLyDuAn/technical/list";
	}

	@RequestMapping("/Add_Technical")
	public ModelAndView viewAdd() {
		return new ModelAndView("QuanLyDuAn/technical/add", "command", new Technical());
	}

	@RequestMapping(value = "/Save_Technical", method = RequestMethod.POST)
	public String addTechnical(@ModelAttribute("command") @Valid Technical technical, BindingResult result,
			HttpSession session, Model model) {
		if (result.hasErrors()) {
			return "QuanLyDuAn/technical/add";
		} else {
			int searchTechnical = technicalService.getRecordsByIdTechnical(technical.getMaTechnical());
			if (searchTechnical == 0) {
				if (technical.getGhiChu().isEmpty()) {
					technical.setGhiChu("");
					technicalService.addNew(technical);
				} else {
					technicalService.addNew(technical);
				}
			} else {
				String mess = "Mã Technical đã tồn tại";
				model.addAttribute("mess", mess);
				return "QuanLyDuAn/technical/add";
			}

		}

		return "redirect:/Quan_Ly_Du_An/List_Technical/1";// will redirect to viewemp request mapping
	}

	@RequestMapping(value = "/Edit_Technical/{idTechnical}")
	public String viewEditTechnical(@PathVariable String idTechnical, Model model) {
		Technical technical = technicalService.getTechnicalByIdTechnical(idTechnical);
		model.addAttribute("command", technical);
		return "QuanLyDuAn/technical/edit";
	}

	@RequestMapping(value = "/Edit_Save_Technical", method = RequestMethod.POST)
	public String editSave(@ModelAttribute("command") @Valid Technical technical, BindingResult result,
			HttpSession session) {
		if (result.hasErrors()) {
			return "QuanLyDuAn/technical/edit";
		} else {
			if (technical.getGhiChu().isEmpty()) {
				technical.setGhiChu("");
				technicalService.update(technical);
				;
			} else {
				technicalService.update(technical);
			}
		}

		return "redirect:/Quan_Ly_Du_An/List_Technical/1";// will redirect to viewemp request mapping
	}

	@RequestMapping(value = "/Delete_Technical/{idTechnical}")
	public String viewDeleteTechnical(@PathVariable String idTechnical, Model model) {
		Technical technical = technicalService.getTechnicalByIdTechnical(idTechnical);
		model.addAttribute("command", technical);
		return "QuanLyDuAn/technical/delete";
	}

	@RequestMapping(value = "/Submit_Delete_Technical", method = RequestMethod.POST)
	public String deleteTechnical(@ModelAttribute("command") Technical technical) {
		technicalService.delete(technical.getMaTechnical());
		;
		return "redirect:/Quan_Ly_Du_An/List_Technical/1";
	}
}
