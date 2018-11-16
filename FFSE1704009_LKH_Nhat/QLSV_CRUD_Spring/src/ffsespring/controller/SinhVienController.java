package ffsespring.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ffsespring.entity.DiemSinhVien;
import ffsespring.entity.SinhVien;
import ffsespring.service.SVService;

@Controller
public class SinhVienController {

	private SVService svService;

	public SVService getSvService() {
		return svService;
	}

	@Autowired(required=true)
	@Qualifier(value = "sinhVienServiceIPM")
	public void setSvService(SVService svService) {
		this.svService = svService;
	}

	@RequestMapping("/view/{page}")
	public String list(@PathVariable int page, Model model) throws SQLException {
		int allItem = svService.countSinhVien();
		int reCordInPage = 2;
		double pageTotal = allItem / reCordInPage + ((allItem % reCordInPage) == 0 ? 0 : 1);
		int total = (int) pageTotal;
		int start = (page * (int) reCordInPage) - (int) reCordInPage;
		List<SinhVien> list = svService.listSinhVien(start, reCordInPage);

		System.out.println("version: " + SpringVersion.getVersion());

		model.addAttribute("list", list);
		model.addAttribute("indexPage", page);
		model.addAttribute("allPage", total);
		return "view";
	}

	@RequestMapping("/add")
	public ModelAndView viewAdd() {
		return new ModelAndView("add", "command", new SinhVien());
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String addSinhVien(@ModelAttribute("command") @Valid SinhVien sinhVien, BindingResult result,
			@RequestParam CommonsMultipartFile file, HttpSession session) {

		File fileImage = new File("D:\\images_CRUD_sinhvien_Spring");
		if (result.hasErrors()) {
			return "add";
		} else {
			if (!fileImage.exists()) {
				if (fileImage.mkdir()) {
					System.out.println("Directory is created!");
				} else {
					System.out.println("Failed to create directory!");
				}
			}
			String filename = file.getOriginalFilename();
			try {
				byte barr[] = file.getBytes();

				BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(fileImage + "/" + filename));
				bout.write(barr);
				bout.flush();
				bout.close();

			} catch (Exception e) {
				System.out.println(e);
			}
			sinhVien.setAvatar(filename);
			svService.addSinhVien(sinhVien);
			return "redirect:/view/1";// will redirect to viewemp request mapping
		}
	}

	@RequestMapping(value = "/edit/{idSinhVien}")
	public String viewEdit(@PathVariable String idSinhVien, Model model) {
		SinhVien sinhVien = svService.getSinhVien(idSinhVien);
		model.addAttribute("command", sinhVien);
		return "edit";
	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editSinhVien(@ModelAttribute("command") @Valid SinhVien sinhVien, BindingResult result,
			@RequestParam CommonsMultipartFile file, HttpSession session) {

		File fileImage = new File("D:\\images_CRUD_sinhvien_Spring");
		if (result.hasErrors()) {
			return "edit";
		} else {
			if (!fileImage.exists()) {
				if (fileImage.mkdir()) {
					System.out.println("Directory is created!");
				} else {
					System.out.println("Failed to create directory!");
				}
			}
			String filename = file.getOriginalFilename();
			try {
				byte barr[] = file.getBytes();

				BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(fileImage + "/" + filename));
				bout.write(barr);
				bout.flush();
				bout.close();

			} catch (Exception e) {
				System.out.println(e);
			}
			sinhVien.setAvatar(filename);
			svService.updateSinhVien(sinhVien);
			return "redirect:/view/1";
		}
	}

	@RequestMapping(value = "/delete/{idSinhVien}")
	public String viewDelete(@PathVariable String idSinhVien, Model model) {
		SinhVien sinhVien = svService.getSinhVien(idSinhVien);
		model.addAttribute("command", sinhVien);
		return "delete";
	}

	@RequestMapping(value = "/deleteSinhVien", method = RequestMethod.POST)
	public String deleteSinhVien(@ModelAttribute("command") SinhVien sinhVien) {
		svService.deleteSinhVien(sinhVien.getId());
		return "redirect:/view/1";
	}
	
	
	
	@RequestMapping(value = "/search/{idSinhVien}")
	public String viewDiem(@PathVariable String idSinhVien, Model model) {
		List<DiemSinhVien> listDiemSV = svService.getDiemSinhVien(idSinhVien);
		model.addAttribute("listDiemSinhVien", listDiemSV);
		return "search";
	}

}
