package fasttrackse.ffse1704.fbms.controller.quanlynhansu;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.NhanSu;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.QuanHuyen;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ThanhPho;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.XaPhuong;
import fasttrackse.ffse1704.fbms.entity.security.ChucDanh;
import fasttrackse.ffse1704.fbms.entity.security.PhongBan;
import fasttrackse.ffse1704.fbms.service.quanlynhansu.NhanSuService;

@Controller
public class NhanSuController {
	@Autowired
	NhanSuService nhanSuService;

	public void setNhanSuService(NhanSuService nhanSuService) {
		this.nhanSuService = nhanSuService;
	}

	// @RequestMapping("/QuanTriNhanSu/nhanSu/allNhanSu")
	// public String ShowList(Model model) {
	//
	// List<NhanSu> allNS = nhanSuService.allNS();
	// model.addAttribute("nhansu", allNS);
	// return "QuanTriNhanSu/nhanSu/allnhansu";
	//
	// }
	// mac dinh
	@RequestMapping("/QuanTriNhanSu/danhsach_nhansu")
	public String ShowList() {
		return "redirect:/QuanTriNhanSu/danhsach_nhansu/1";

	}

	// danh sach nhan su phan trang
	@RequestMapping(value = "/QuanTriNhanSu/danhsach_nhansu/{page}")
	public ModelAndView ViewNhanSuPage(@PathVariable int page, Model model) {

		long record = nhanSuService.CountNhanSu();
		int perpage = 3;
		int totalPage = (int) Math.ceil(record * 1.0 / perpage);

		if (page == 0) {
			page = 1;
		}
		int start = (page - 1) * perpage;
		List<NhanSu> nhansu = nhanSuService.GetListNhanSuByPage(start, perpage);
		model.addAttribute("page", page);
		model.addAttribute("totalPage", totalPage);

		return new ModelAndView("QuanTriNhanSu/nhanSu/allnhansu", "nhansu", nhansu);

	}

	@RequestMapping("/QuanTriNhanSu/danhsach_nhansu/addNS")
	public String ShowViewADD(Model model) {

		model.addAttribute("nhanSu", new NhanSu());

		model.addAttribute("listChucDanh",nhanSuService.listChucDanh());
		
		model.addAttribute("listPhongBan",nhanSuService.listPhongBan());
		
		model.addAttribute("listTinhThanh",nhanSuService.listTinhThanhPho());
		
//		List<QuanHuyen> listQuanHuyen= nhanSuService.listQuanHuyen();
//		model.addAttribute("listQuanHuyen",listQuanHuyen);
//		
//		List<XaPhuong> listXaPhuong= nhanSuService.listXaPhuong();
//		model.addAttribute("listXaPhuong",listXaPhuong);
		
		return "QuanTriNhanSu/nhanSu/ViewAddNhanSu";

	}

	@RequestMapping(value = "/QuanTriNhanSu/danhsach_nhansu/saveNhanSu", method = RequestMethod.POST)
	public ModelAndView AddNhanSu(Model model,@ModelAttribute("nhanSu") @Valid NhanSu nhanSu, BindingResult bindingResult,
			@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {

		
		String fileName = upload(file);
		if (!fileName.equals("")) {
			nhanSu.setAnhDaiDien(fileName);
		}
		if (bindingResult.hasErrors()) {
			return new ModelAndView("QuanTriNhanSu/nhanSu/ViewAddNhanSu");
		}
//		boolean checkMaNhanSu = nhanSuService.checkExistMa(nhanSu.getMaNhanVien());
//		if(checkMaNhanSu==true) {
//			nhanSuService.addNS(nhanSu);
//			
//		}else {
//			model.addAttribute("attenion", "Mã nhân viên đã tồn tại");
//			
//		}
		nhanSuService.addNS(nhanSu);
		return new ModelAndView("redirect:/QuanTriNhanSu/danhsach_nhansu");

	}

	@RequestMapping(value = "/QuanTriNhanSu/danhsach_nhansu/editNS/{id}")
	public String editNhanSuByID(@PathVariable int id,Model model) {
		
		NhanSu nhanSu = nhanSuService.getNhanSuByID(id);
		model.addAttribute("nhanSu",nhanSu);
		//model.addAttribute("nhanSu", new NhanSu());
		List<ChucDanh> listChucDanh = nhanSuService.listChucDanh();
		model.addAttribute("listChucDanh",listChucDanh);
		
		List<PhongBan> listPhongBan = nhanSuService.listPhongBan();
		model.addAttribute("listPhongBan",listPhongBan);
		
		List<ThanhPho> listTinhThanh = nhanSuService.listTinhThanhPho();
		model.addAttribute("listTinhThanh",listTinhThanh);
//		
//		List<QuanHuyen> listQuanHuyen= nhanSuService.listQuanHuyen();
//		model.addAttribute("listQuanHuyen",listQuanHuyen);
//		
//		List<XaPhuong> listXaPhuong= nhanSuService.listXaPhuong();
//		model.addAttribute("listXaPhuong",listXaPhuong);
		return "QuanTriNhanSu/nhanSu/edit_nhansu";
		
	}
	
	@RequestMapping(value = "/QuanTriNhanSu/danhsach_nhansu/update",method = RequestMethod.POST)
	public String editNhanSuSave(@ModelAttribute("nhanSu") NhanSu nhanSu,Model model,BindingResult bindingResult,
			@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		String fileName = upload(file);
		if (!fileName.equals("")) {
			nhanSu.setAnhDaiDien(fileName);
		}
		nhanSuService.update(nhanSu);
		
		return "redirect:/QuanTriNhanSu/danhsach_nhansu";
		
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
	}

	@RequestMapping(value="/QuanTriNhanSu/danhsach_nhansu/DeleteNS/{id}",method = RequestMethod.GET)
	public ModelAndView getdeleteNhanSuByID(@PathVariable int id,Model model) {
		
		NhanSu nhanSu = nhanSuService.getNhanSuByID(id);
		model.addAttribute("nhanSu",nhanSu);
		List<ChucDanh> listChucDanh = nhanSuService.listChucDanh();
		model.addAttribute("listChucDanh",listChucDanh);
		
		List<PhongBan> listPhongBan = nhanSuService.listPhongBan();
		model.addAttribute("listPhongBan",listPhongBan);
		
		List<ThanhPho> listTinhThanh = nhanSuService.listTinhThanhPho();
		model.addAttribute("listTinhThanh",listTinhThanh);
		


		return new ModelAndView("QuanTriNhanSu/nhanSu/deleteNhanSu");
	}
	
	// thực hiện lệnh xóa
		@RequestMapping(value = "/QuanTriNhanSu/danhsach_nhansu/DeleteNS/{id}", params = "delete")
		public ModelAndView doDel(@PathVariable int id) {
			nhanSuService.delete(id);
			return new ModelAndView("redirect:/QuanTriNhanSu/danhsach_nhansu");
		}
		// hủy xóa
		@RequestMapping(value = "/QuanTriNhanSu/danhsach_nhansu/DeleteNS/{id}", params = "cancel", method = RequestMethod.POST)
		public String cancelUpdateUser(HttpServletRequest request) {
			return "redirect:/QuanTriNhanSu/danhsach_nhansu";
		}
	
	public String upload(@RequestParam MultipartFile file) throws IllegalStateException, IOException {

		String fileName = file.getOriginalFilename();

		String path = "E:\\HOCT\\images";
		if (fileName.isEmpty()) {
			fileName = "default.jpg";
		} else {
			File dir = new File(path);
			if (!dir.exists())
				dir.mkdirs();
			File fileSave = new File(dir, fileName);
			file.transferTo(fileSave);
		}
		return fileName;

	}
	
	@RequestMapping(value = "/QuanTriNhanSu/chonquan/{maTinhThanh}", method = RequestMethod.GET,produces ="text/plain;charset=UTF-8")
	public @ResponseBody String chonQuanHuyen(@PathVariable String maTinhThanh,Model model) {
		List<QuanHuyen> listQuanHuyen = nhanSuService.listQuanHuyenbyID(maTinhThanh);
		//model.addAttribute("listQuanHuyen",listQuanHuyen);
		String json = "[";
		for (int i=0;i<=listQuanHuyen.size()-1;i++) {
			if(i==listQuanHuyen.size()-1) {
				json+="{\"maQuanHuyen\":" + "\""+listQuanHuyen.get(i).getMaqh()+"\"," +"\"tenQuanHuyen\":" 
			+"\""+listQuanHuyen.get(i).getName()+"\"}";
			}else {
				json+="{\"maQuanHuyen\":" +"\""+listQuanHuyen.get(i).getMaqh()+"\"," +"\"tenQuanHuyen\":"
			+"\""+listQuanHuyen.get(i).getName()+"\"},";
			}
		}
		json+="]";
		return json;
		//return listQuanHuyen.get(0).getName();
		
	}
	
	@RequestMapping(value = "/QuanTriNhanSu/chonXaPhuong/{maQuanHuyen}", method = RequestMethod.GET,produces ="text/plain;charset=UTF-8")
	public @ResponseBody String chonXaPhuong(@PathVariable String maQuanHuyen,Model model) {
		List<XaPhuong> listXaPhuong = nhanSuService.listPhuongXabyID(maQuanHuyen);
		//model.addAttribute("listQuanHuyen",listQuanHuyen);
		String json = "[";
		for (int i=0;i<=listXaPhuong.size()-1;i++) {
			if(i==listXaPhuong.size()-1) {
				json+="{\"maXaPhuong\":" + "\""+listXaPhuong.get(i).getXaid()+"\"," +"\"tenXaPhuong\":" 
			+"\""+listXaPhuong.get(i).getName()+"\"}";
			}else {
				json+="{\"maXaPhuong\":" +"\""+listXaPhuong.get(i).getXaid()+"\"," +"\"tenXaPhuong\":"
			+"\""+listXaPhuong.get(i).getName()+"\"},";
			}
		}
		json+="]";
		return json;
		//return listQuanHuyen.get(0).getName();
		
	}
		
}
