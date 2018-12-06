package fasttrackse.ffse1704.fbms.controller.quanlyduan.domain;

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

import fasttrackse.ffse1704.fbms.entity.quanlyduan.domain.Domain;
import fasttrackse.ffse1704.fbms.service.quanlyduan.domain.DomainService;

@Controller
@RequestMapping("/Quan_Ly_Du_An")
public class DomainController {
	private DomainService domainService;

	public DomainService getDomainService() {
		return domainService;
	}

	@Autowired(required = true)
	@Qualifier(value = "domainServiceIPM")
	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}

	@RequestMapping("/List_Domain/{page}")
	public String list(@PathVariable int page, Model model) throws SQLException {
		int allItem = domainService.getRecordsTotal();
		int reCordInPage = 2;
		double pageTotal = allItem / reCordInPage + ((allItem % reCordInPage) == 0 ? 0 : 1);
		int total = (int) pageTotal;
		int start = (page * (int) reCordInPage) - (int) reCordInPage;
		List<Domain> list = domainService.listDomain(start, reCordInPage);
		model.addAttribute("list", list);
		model.addAttribute("indexPage", page);
		model.addAttribute("allPage", total);
		return "QuanLyDuAn/domain/list";
	}

	@RequestMapping("/Add_Domain")
	public ModelAndView viewAdd() {
		return new ModelAndView("QuanLyDuAn/domain/add", "command", new Domain());
	}

	@RequestMapping(value = "/Save_Domain", method = RequestMethod.POST)
	public String addDomain(@ModelAttribute("command") @Valid Domain domain, BindingResult result,
			HttpSession session,Model model) {
		if (result.hasErrors()) {
			return "QuanLyDuAn/domain/add";
		} else {
			int searchDomain = domainService.getRecordsByIdDomain(domain.getMaDomain());
			if(searchDomain==0) {
				if (domain.getGhiChu().isEmpty()) {
					domain.setGhiChu("");
					domainService.addNew(domain);
				} else {
					domainService.addNew(domain);
				}
			}else {
				String mess = "Mã Domain đã tồn tại";
				model.addAttribute("mess", mess);
				return "QuanLyDuAn/domain/add";
			}
			
		}

		return "redirect:/Quan_Ly_Du_An/List_Domain/1";// will redirect to viewemp request mapping
	}
	
	@RequestMapping(value = "/Edit_Domain/{idDomain}")
	public String viewEditDomain(@PathVariable String idDomain, Model model) {
		Domain domain = domainService.getDomainByIdDomain(idDomain);
		model.addAttribute("command", domain);
		return "QuanLyDuAn/domain/edit";
	}
	
	@RequestMapping(value = "/Edit_Save_Domain", method = RequestMethod.POST)
	public String editSave(@ModelAttribute("command") @Valid Domain domain, BindingResult result,
			HttpSession session) {
		if (result.hasErrors()) {
			return "QuanLyDuAn/domain/edit";
		} else {
			if (domain.getGhiChu().isEmpty()) {
				domain.setGhiChu("");
				domainService.update(domain);;
			} else {
				domainService.update(domain);
			}
		}

		return "redirect:/Quan_Ly_Du_An/List_Domain/1";// will redirect to viewemp request mapping
	}
	
	
	@RequestMapping(value = "/Delete_Domain/{idDomain}")
	public String viewDeleteDomain(@PathVariable String idDomain, Model model) {
		Domain domain = domainService.getDomainByIdDomain(idDomain);
		model.addAttribute("command", domain);
		return "QuanLyDuAn/domain/delete";
	}
	
	@RequestMapping(value = "/Submit_Delete_Domain", method = RequestMethod.POST)
	public String deleteSinhVien(@ModelAttribute("command") Domain domain) {
		domainService.delete(domain.getMaDomain());;
		return "redirect:/Quan_Ly_Du_An/List_Domain/1";
	}
}
