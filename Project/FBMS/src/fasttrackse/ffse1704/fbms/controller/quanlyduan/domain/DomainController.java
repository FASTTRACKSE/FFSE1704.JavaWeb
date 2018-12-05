package fasttrackse.ffse1704.fbms.controller.quanlyduan.domain;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fasttrackse.ffse1704.fbms.entity.quanlyduan.domain.Domain;
import fasttrackse.ffse1704.fbms.service.quanlyduan.domain.DomainService;

@Controller
@RequestMapping("/Quan_Ly_Du_An")
public class DomainController {
	private DomainService domainService;

	public DomainService getDomainService() {
		return domainService;
	}
	
	@Autowired(required=true)
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
		return "QuanLyDuAn/Domain/List";
	}
}
