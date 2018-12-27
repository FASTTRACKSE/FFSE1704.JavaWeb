package fasttrackse.ffse1704.fbms.controller.quanlynhansu;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.BangCap;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.TrinhDo;
import fasttrackse.ffse1704.fbms.service.quanlynhansu.BangCapService;

@Controller
public class BangCapController {
	@Autowired
	BangCapService bangCapService;

	public void setBangCapService(BangCapService bangCapService) {
		this.bangCapService = bangCapService;
	}

	// mac dinh
	// @RequestMapping("/ViewBC/")
	// public String ShowList() {
	// return "redirect:/ViewBC/1";
	//
	// }
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
	}

	// danh sach bằng cấp
	@RequestMapping(value = "/ViewBC/{maNhanVien}", method = RequestMethod.GET)
	public String ViewBangCap(@PathVariable("maNhanVien") String maNhanVien, Model model) {

		model.addAttribute("bangCap", bangCapService.getBangCapByID(maNhanVien));

		return "QuanTriNhanSu/BangCap/ListBangCap";

	}
	
	@RequestMapping(value ="/addBC/{maNhanVien}")
	public String ShowViewADD(Model model,@PathVariable("maNhanVien") String maNhanVien) {
		model.addAttribute("bang",new BangCap());
		model.addAttribute("bangCap", bangCapService.getBangCapByID(maNhanVien));
		List<TrinhDo> listTrinhDo= bangCapService.listTrinhDo();
		model.addAttribute("listTrinhDo",listTrinhDo);
		return "QuanTriNhanSu/BangCap/view_addBC";

		

	}
	
	@RequestMapping(value="/saveBangCap",method = RequestMethod.POST)
	public ModelAndView addSave(@ModelAttribute("bang") BangCap bang) {
		
		bangCapService.addBangCap(bang);
		return new ModelAndView("redirect:/QuanTriNhanSu/danhsach_nhansu/1");
		
	}
	
	
	@RequestMapping(value = "/DeleteBC/{id}&{maNhanVien}", method = RequestMethod.GET)
	public String ViewDeleteBC(@PathVariable("id") int id,@PathVariable("maNhanVien") String maNhanVien, Model model) {

		model.addAttribute("bangCap", bangCapService.getBangCapByID(maNhanVien));
		model.addAttribute("bangCap2", bangCapService.getBangCapUpdate(id));

		return "QuanTriNhanSu/BangCap/deleteBangCap";

	}

	// danh sach edit
	@RequestMapping(value = "/editBC/{id}&{maNhanVien}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") int id,@PathVariable("maNhanVien") String maNhanVien, Model model) {

		model.addAttribute("bangCap", bangCapService.getBangCapByID(maNhanVien));
		model.addAttribute("bangCap2", bangCapService.getBangCapUpdate(id));
		return "QuanTriNhanSu/BangCap/editBangCap";

	}

	// UPDATE
	@RequestMapping(value = "/ViewBC/update", method = RequestMethod.POST)
	public String editSave(@ModelAttribute("bangCap2") BangCap bangCap, Model model) {

		bangCapService.update(bangCap);

		return "redirect:/QuanTriNhanSu/danhsach_nhansu/1";

	}
	
}
