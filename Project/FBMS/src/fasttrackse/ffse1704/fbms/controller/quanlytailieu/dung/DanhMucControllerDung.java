package fasttrackse.ffse1704.fbms.controller.quanlytailieu.dung;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung.DanhMucDung;
import fasttrackse.ffse1704.fbms.service.quanlytailieu.dung.DanhMucServiceDung;

@Controller
@RequestMapping("/quanlytailieu")

public class DanhMucControllerDung {
	@Autowired
	DanhMucServiceDung danhMucService;

	public DanhMucServiceDung getDanhMucService() {
		return danhMucService;
	}

	public void setDanhMucService(DanhMucServiceDung danhMucService) {
		this.danhMucService = danhMucService;
	}

	@RequestMapping(value = "/danhmuc", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("listDanhMuc", danhMucService.getAll());
		return "quanlytailieu/dung/danhmucDung";
	}
	
	@RequestMapping(value = "/addDanhMucView", method = RequestMethod.GET)
	public String addDanhMucView(Model model) {
		model.addAttribute("danhmuc", new DanhMucDung());
		model.addAttribute("listQuyen", danhMucService.listQuyen());
		return "quanlytailieu/dung/AddDanhMuc";
	}
	@RequestMapping(value = "/addDanhMuc", method = RequestMethod.POST)
	public String addDanhMuc(@ModelAttribute("danhmuc") DanhMucDung danhmuc,
			@RequestParam("file") MultipartFile file, BindingResult result, HttpServletRequest request, Model model,
			final RedirectAttributes redirectAttributes) {
		try {
			if (result.hasErrors()) {
				return "quanlytailieu/dung/AddDanhMuc";
			}
			String nameFile = file.getOriginalFilename();
			File fileDir = new File("E:\\HOCT/images/");
			byte[] bytes = file.getBytes();
			if (!fileDir.exists()) {
				fileDir.mkdir();
			}
			File serverFile = new File(fileDir.getAbsolutePath() + File.separator + nameFile);
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.flush();
			stream.close();
			danhmuc.setHinhAnh(File.separator+"FBMS"+File.separator + "uploads" + File.separator + nameFile);
			
			if (danhmuc.getMaPhongBan().getMaPhongBan().isEmpty()) {
				danhmuc.setMaPhongBan(null);
			}
			danhMucService.addDanhMuc(danhmuc);
		} catch (Exception e) {
		}
		return "redirect:/quanlytailieu/danhmuc";
	}
	@RequestMapping(value = "/danhMucDelete/{id}", method = RequestMethod.GET)
	public String documentDelete(@PathVariable int id, Model model) {
		danhMucService.deleteDanhMuc(id);
		return "redirect:/quanlytailieu/danhmuc";
	}
	
	
	@RequestMapping(value = "/updateDanhMucView/{id}", method = RequestMethod.GET)
	public String updateDanhMucView(@PathVariable int id, Model model) {
		model.addAttribute("danhmucUpdate", danhMucService.findById(id));
		model.addAttribute("listQuyen", danhMucService.listQuyen());

		return "quanlytailieu/dung/UpdateDanhMuc";
	}
	@RequestMapping(value = "/updateDanhMuc", method = RequestMethod.POST)
	public String updateDanhMuc(@ModelAttribute("danhmuc") DanhMucDung danhmuc,
			@RequestParam("file") MultipartFile file, BindingResult result, HttpServletRequest request, Model model,
			final RedirectAttributes redirectAttributes) {
		try {
			String nameFile = file.getOriginalFilename();
			if (nameFile.equals("") || nameFile == null) {
				danhMucService.updateDanhMuc(danhmuc);
			} else {
				File fileDir = new File("E:\\HOCT/images/");
				byte[] bytes = file.getBytes();
				File serverFile = new File(fileDir.getAbsolutePath() + File.separator + nameFile);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.flush();
				stream.close();
				danhmuc.setHinhAnh(File.separator+"FBMS"+File.separator + "uploads" + File.separator + nameFile);
				danhMucService.updateDanhMuc(danhmuc);
			}
		} catch (Exception e) {
		}
		return "redirect:/quanlytailieu/danhmuc";
	}
	public String updateDanhMuc(@ModelAttribute("danhmuc") DanhMucDung danhmuc ) {
		danhMucService.updateDanhMuc(danhmuc);
		return "quanlytailieu/dung/danhmuc";
	}
}
