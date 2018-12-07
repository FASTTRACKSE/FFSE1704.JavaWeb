package fasttrackse.ffse1704.fbms.controller.quanlyduan.vaitrothanhvien;

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

import fasttrackse.ffse1704.fbms.entity.quanlyduan.vaitrothanhvien.VaiTroThanhVien;
import fasttrackse.ffse1704.fbms.service.quanlyduan.vaitrothanhvien.VaiTroThanhVienService;

@Controller
@RequestMapping("/Quan_Ly_Du_An")
public class VaiTroThanhVienController {
	private VaiTroThanhVienService vaiTroThanhVienService;

	public VaiTroThanhVienService getVaiTroThanhVienService() {
		return vaiTroThanhVienService;
	}

	@Autowired(required = true)
	@Qualifier(value = "vaiTroThanhVienServiceIPM")
	public void setVaiTroThanhVienService(VaiTroThanhVienService vaiTroThanhVienService) {
		this.vaiTroThanhVienService = vaiTroThanhVienService;
	}

	@RequestMapping("/List_VaiTroThanhVien/{page}")
	public String listVaiTroThanhVien(@PathVariable int page, Model model) throws SQLException {
		int allItem = vaiTroThanhVienService.getRecordsTotal();
		int reCordInPage = 2;
		double pageTotal = allItem / reCordInPage + ((allItem % reCordInPage) == 0 ? 0 : 1);
		int total = (int) pageTotal;
		int start = (page * (int) reCordInPage) - (int) reCordInPage;
		List<VaiTroThanhVien> list = vaiTroThanhVienService.listVaiTroThanhVien(start, reCordInPage);
		model.addAttribute("list", list);
		model.addAttribute("indexPage", page);
		model.addAttribute("allPage", total);
		return "QuanLyDuAn/vaitrothanhvien/list";
	}

	@RequestMapping("/Add_VaiTroThanhVien")
	public ModelAndView viewAdd() {
		return new ModelAndView("QuanLyDuAn/vaitrothanhvien/add", "command", new VaiTroThanhVien());
	}

	@RequestMapping(value = "/Save_VaiTroThanhVien", method = RequestMethod.POST)
	public String addVaiTroThanhVien(@ModelAttribute("command") @Valid VaiTroThanhVien vaiTroThanhVien,
			BindingResult result, HttpSession session, Model model) {
		if (result.hasErrors()) {
			return "QuanLyDuAn/vaitrothanhvien/add";
		} else {
			int searchDomain = vaiTroThanhVienService.getRecordsByIdVaiTroThanhVien(vaiTroThanhVien.getMaVaiTro());
			if (searchDomain == 0) {
				if (vaiTroThanhVien.getGhiChu().isEmpty()) {
					vaiTroThanhVien.setGhiChu("");
					vaiTroThanhVienService.addNew(vaiTroThanhVien);
				} else {
					vaiTroThanhVienService.addNew(vaiTroThanhVien);
				}
			} else {
				String mess = "Mã Vai Trò đã tồn tại";
				model.addAttribute("mess", mess);
				return "QuanLyDuAn/vaitrothanhvien/add";
			}

		}

		return "redirect:/Quan_Ly_Du_An/List_VaiTroThanhVien/1";// will redirect to viewemp request mapping
	}

	@RequestMapping(value = "/Edit_VaiTroThanhVien/{idVaiTroThanhVien}")
	public String viewEditVaiTroThanhVien(@PathVariable String idVaiTroThanhVien, Model model) {
		VaiTroThanhVien vaiTroThanhVien = vaiTroThanhVienService
				.getVaiTroThanhVienByIdVaiTroThanhVien(idVaiTroThanhVien);
		model.addAttribute("command", vaiTroThanhVien);
		return "QuanLyDuAn/vaitrothanhvien/edit";
	}

	@RequestMapping(value = "/Edit_Save_VaiTroThanhVien", method = RequestMethod.POST)
	public String editSaveVaiTroThanhVien(@ModelAttribute("command") @Valid VaiTroThanhVien vaiTroThanhVien,
			BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "QuanLyDuAn/vaitrothanhvien/edit";
		} else {
			if (vaiTroThanhVien.getGhiChu().isEmpty()) {
				vaiTroThanhVien.setGhiChu("");
				vaiTroThanhVienService.update(vaiTroThanhVien);
				;
			} else {
				vaiTroThanhVienService.update(vaiTroThanhVien);
			}
		}

		return "redirect:/Quan_Ly_Du_An/List_VaiTroThanhVien/1";// will redirect to viewemp request mapping
	}

	@RequestMapping(value = "/Delete_VaiTroThanhVien/{idVaiTroThanhVien}")
	public String viewDeleteVaiTroThanhVien(@PathVariable String idVaiTroThanhVien, Model model) {
		VaiTroThanhVien vaiTroThanhVien = vaiTroThanhVienService
				.getVaiTroThanhVienByIdVaiTroThanhVien(idVaiTroThanhVien);
		model.addAttribute("command", vaiTroThanhVien);
		return "QuanLyDuAn/vaitrothanhvien/delete";
	}

	@RequestMapping(value = "/Submit_Delete_VaiTroThanhVien", method = RequestMethod.POST)
	public String deleteVaiTroThanhVien(@ModelAttribute("command") VaiTroThanhVien vaiTroThanhVien) {
		vaiTroThanhVienService.delete(vaiTroThanhVien.getMaVaiTro());
		;
		return "redirect:/Quan_Ly_Du_An/List_VaiTroThanhVien/1";
	}
}
