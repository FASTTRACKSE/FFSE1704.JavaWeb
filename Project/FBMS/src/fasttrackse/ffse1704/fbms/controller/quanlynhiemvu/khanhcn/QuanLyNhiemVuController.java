package fasttrackse.ffse1704.fbms.controller.quanlynhiemvu.khanhcn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn.CongViecKhanhCN;
import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn.DuAnKhanhCN;
import fasttrackse.ffse1704.fbms.service.quanlynhiemvu.khanhcn.QuanLyNhiemVuService;

@Controller
@RequestMapping
public class QuanLyNhiemVuController {

	@Autowired
	QuanLyNhiemVuService quanLyNhiemVuService;

	public void setQuanLyNhiemVuService(QuanLyNhiemVuService quanLyNhiemVuService) {
		this.quanLyNhiemVuService = quanLyNhiemVuService;
	}

	@RequestMapping(value = "/danhsachduan", method = RequestMethod.GET)
	public String da(Model model) {

		List<DuAnKhanhCN> danhSachDuAn = quanLyNhiemVuService.duAn();
		model.addAttribute("list", danhSachDuAn);
		return "QuanLyNhiemVu/KhanhCn/ListDuAn";

	}

	@RequestMapping(value = "/danhsachcongviec", method = RequestMethod.GET)
	public String cv(Model model) {

		List<CongViecKhanhCN> danhSachCongViec = quanLyNhiemVuService.congViec();
		model.addAttribute("list", danhSachCongViec);
		return "QuanLyNhiemVu/KhanhCn/ListCongViec";

	}

}
