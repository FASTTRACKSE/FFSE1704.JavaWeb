package fasttrackse.ffse1704.fbms.controller.quanlyduan.programminglanguage;

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

import fasttrackse.ffse1704.fbms.entity.quanlyduan.programminglanguage.ProgrammingLanguage;
import fasttrackse.ffse1704.fbms.service.quanlyduan.programminglanguage.ProgrammingLanguageService;

@Controller
@RequestMapping("/Quan_Ly_Du_An")
public class ProgrammingLanguageController {
	private ProgrammingLanguageService programmingLanguageService;

	public ProgrammingLanguageService getProgrammingLanguageService() {
		return programmingLanguageService;
	}

	@Autowired(required = true)
	@Qualifier(value = "programmingLanguageServiceIPM")
	public void setProgrammingLanguageService(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}

	@RequestMapping("/List_ProgrammingLanguage/{page}")
	public String list(@PathVariable int page, Model model) throws SQLException {
		int allItem = programmingLanguageService.getRecordsTotal();
		int reCordInPage = 2;
		double pageTotal = allItem / reCordInPage + ((allItem % reCordInPage) == 0 ? 0 : 1);
		int total = (int) pageTotal;
		int start = (page * (int) reCordInPage) - (int) reCordInPage;
		List<ProgrammingLanguage> list = programmingLanguageService.listProgrammingLanguage(start, reCordInPage);
		model.addAttribute("list", list);
		model.addAttribute("indexPage", page);
		model.addAttribute("allPage", total);
		return "QuanLyDuAn/programminglanguage/list";
	}

	@RequestMapping("/Add_ProgrammingLanguage")
	public ModelAndView viewAdd() {
		return new ModelAndView("QuanLyDuAn/programminglanguage/add", "command", new ProgrammingLanguage());
	}

	@RequestMapping(value = "/Save_ProgrammingLanguage", method = RequestMethod.POST)
	public String addProgrammingLanguage(@ModelAttribute("command") @Valid ProgrammingLanguage programmingLanguage,
			BindingResult result, HttpSession session, Model model) {
		if (result.hasErrors()) {
			return "QuanLyDuAn/programminglanguage/add";
		} else {
			int searchDomain = programmingLanguageService
					.getRecordsByIdProgrammingLanguage(programmingLanguage.getMaProgrammingLanguage());
			if (searchDomain == 0) {
				if (programmingLanguage.getGhiChu().isEmpty()) {
					programmingLanguage.setGhiChu("");
					programmingLanguageService.addNew(programmingLanguage);
				} else {
					programmingLanguageService.addNew(programmingLanguage);
				}
			} else {
				String mess = "Mã Programming Language đã tồn tại";
				model.addAttribute("mess", mess);
				return "QuanLyDuAn/programminglanguage/add";
			}

		}

		return "redirect:/Quan_Ly_Du_An/List_ProgrammingLanguage/1";// will redirect to viewemp request mapping
	}

	@RequestMapping(value = "/Edit_ProgrammingLanguage/{idProgrammingLanguage}")
	public String viewEditProgrammingLanguage(@PathVariable String idProgrammingLanguage, Model model) {
		ProgrammingLanguage programmingLanguage = programmingLanguageService
				.getProgrammingLanguageByIdProgrammingLanguage(idProgrammingLanguage);
		model.addAttribute("command", programmingLanguage);
		return "QuanLyDuAn/programminglanguage/edit";
	}

	@RequestMapping(value = "/Edit_Save_ProgrammingLanguage", method = RequestMethod.POST)
	public String editSave(@ModelAttribute("command") @Valid ProgrammingLanguage programmingLanguage,
			BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "QuanLyDuAn/programminglanguage/edit";
		} else {
			if (programmingLanguage.getGhiChu().isEmpty()) {
				programmingLanguage.setGhiChu("");
				programmingLanguageService.update(programmingLanguage);
				;
			} else {
				programmingLanguageService.update(programmingLanguage);
			}
		}

		return "redirect:/Quan_Ly_Du_An/List_ProgrammingLanguage/1";// will redirect to viewemp request mapping
	}

	@RequestMapping(value = "/Delete_ProgrammingLanguage/{idProgrammingLanguage}")
	public String viewDeleteProgrammingLanguage(@PathVariable String idProgrammingLanguage, Model model) {
		ProgrammingLanguage programmingLanguage = programmingLanguageService
				.getProgrammingLanguageByIdProgrammingLanguage(idProgrammingLanguage);
		model.addAttribute("command", programmingLanguage);
		return "QuanLyDuAn/programminglanguage/delete";
	}

	@RequestMapping(value = "/Submit_Delete_ProgrammingLanguage", method = RequestMethod.POST)
	public String deleteProgrammingLanguage(@ModelAttribute("command") ProgrammingLanguage programmingLanguage) {
		programmingLanguageService.delete(programmingLanguage.getMaProgrammingLanguage());
		;
		return "redirect:/Quan_Ly_Du_An/List_ProgrammingLanguage/1";
	}
}
